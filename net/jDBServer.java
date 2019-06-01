import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class jDBServer extends Thread{
    private Socket soc;
    private static MetadataManager mgr;

    private jDBServer(Socket s) {
        this.soc = s;
    }

    public static void main(String[] args) throws Exception {
        int port = 10086;
        server(port);
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
                sql = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Query: " + sql);
            ArrayList<SQLResult> sqlResults = null;
            try {
                sqlResults = this.executeSql(sql);
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
                ObjectOutputStream oos = new ObjectOutputStream(os);
                sqlResults = new ArrayList<>();
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
            SQLResult sqlResult = sqlExecutor.execute(jDBServer.mgr);
            results.add(sqlResult);
        }
        return results;
    }

    private static void server(int port) {
        try {
            jDBServer.mgr = new MetadataManager();
            jDBServer.mgr.init("data_meta.jDB");
            jDBServer.mgr.createDatabase("defaultdb1");
            jDBServer.mgr.checkoutDatabase("defaultdb1");
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
