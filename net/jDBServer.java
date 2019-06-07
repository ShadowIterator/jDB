import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class Shutdown {
    private Thread thread = null;

    public Shutdown() {
        thread = new Thread("Sample thread") {
            public void run() {
                while (true) {
                    System.out.println("[Sample thread] Sample thread speaking...");
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ie) {
                        break;
                    }
                }
                System.out.println("[Sample thread] Stopped");
            }
        };
        thread.start();
    }

    public void stopThread() {
        thread.interrupt();
    }
}


// The ShutdownThread is the thread we pass to the
// addShutdownHook method
class ShutdownThread extends Thread {

    public ShutdownThread() {
        super();
    }

    public void run() {
        System.out.println("[Shutdown thread] Shutting down");
        try {
            jDBServer.mgr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[Shutdown thread] Shutdown complete");
    }
}

public class jDBServer extends Thread{
    private Socket soc;
    public static MetadataManager mgr;

    private jDBServer(Socket s) {
        this.soc = s;
    }

    public static void main(String[] args) throws Exception {
//        Shutdown shutdown = new Shutdown();
        jDBServer.mgr = new MetadataManager();
        try {
            Runtime.getRuntime().addShutdownHook(new ShutdownThread());
            System.out.println("[Main thread] Shutdown hook added");
        } catch (Throwable t) {
            // we get here when the program is run with java
            // version 1.2.2 or older
            System.out.println("[Main thread] Could not add Shutdown hook");
        }

        int port = 10086;
        server(port);
//        System.exit(0);
    }

    @Override
    public void run() {
        try {
            OutputStream os = this.soc.getOutputStream();
            InputStream is = this.soc.getInputStream();
            //TODO: authorisation process
            String sql = "";
            try {
                DataInputStream dis = new DataInputStream(is);
                while(true) {
                    try {
                        String tmp = dis.readUTF();
//                        System.out.println(tmp);
                        if(tmp.equals("<END>")) {
                            break;
                        }
                        sql += tmp;
                    } catch (Exception e) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                os.close();
                is.close();
                this.soc.close();
                return;
            }
            System.out.println("Query: " + sql);
            ArrayList<SQLResult> sqlResults = null;
            try {
                sqlResults = this.executeSql(sql);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                sqlResults = new ArrayList<SQLResult>();
                sqlResults.add(new SQLResult(-2, e.getMessage()));
            }
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(os);
                oos.writeObject(sqlResults);
                oos.flush();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                os.close();
                is.close();
                this.soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<SQLResult> executeSql(String sql) throws Exception {
        CharStream stream = new ANTLRInputStream(sql);
        SimpleSQLLexer lexer = new SimpleSQLLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleSQLParser parser = new SimpleSQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.commands();

        ArrayList<SQLExecutor> sqlExecutorList = ((SimpleSQLParser.CommandsContext)tree).sqlExecutorList;
        ArrayList<SQLResult> results = new ArrayList<>();
        for(SQLExecutor sqlExecutor: sqlExecutorList) {
            long beginTime = System.nanoTime();
            SQLResult sqlResult = sqlExecutor.execute(jDBServer.mgr);
            long endTime = System.nanoTime();
            double costTime = (endTime - beginTime) / 1000000.0;
            sqlResult.setCostTime(costTime);
            results.add(sqlResult);
            if(sqlResult.getResultType() == -1) {
                sqlExecutor.printExecutor();
                break;
            }
        }
        return results;
    }

    private static void server(int port) {
        try {
//            // should not init every time, test if reopen is right
            File file = new File("data_meta.jDB");
            if(file.exists()) {
                jDBServer.mgr.open("data_meta.jDB");

                jDBServer.mgr.checkoutDatabase("default");
            } else {
                jDBServer.mgr.init("data_meta.jDB");
                jDBServer.mgr.createDatabase("default");
                jDBServer.mgr.checkoutDatabase("default");
            }
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("JDB Server running on port " + port);
            while(true) {
                Socket s = serverSocket.accept();
                Thread t = new jDBServer(s);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
