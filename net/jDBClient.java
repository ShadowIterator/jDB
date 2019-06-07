import java.net.*;
import java.io.*;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;

public class jDBClient {
    private String ip;
    private int port;
    public jDBClient(String _ip, int _port) {
        this.ip = _ip;
        this.port = _port;
    }

    public void tryConnection() throws Exception {
        Socket s = new Socket(this.ip, this.port);
        s.close();
    }

    public ArrayList<SQLResult> query(String sql) throws Exception {
        Socket s = new Socket(this.ip, this.port);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF(sql);
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ArrayList<SQLResult> results = (ArrayList<SQLResult>)(ois.readObject());
        dos.close();
        ois.close();
        s.close();
        return results;
    }
    public static void main(String[] arg) throws Exception {
        jDBClient client = new jDBClient("127.0.0.1", 10086);

//        String sql =
//                "create table defaulttable2 (id long, name string(8), grade int, primary key(id))\n" +
//                "show databases\n" +
//                "show database default\n" +
//                "create database DB1\n" +
//                "create database DB2\n" +
//                "use database DB1 \n" +
//                "create table tablepp (id long, name string(8), grade int)\n" +
//                "show database DB1\n" +
//                "show databases\n" +

//                "show table defaulttable2\n" +
//                "insert into defaulttable2 values (2000, 'laoshi01', 6)\n" +
//                "insert into defaulttable2 values (2001, 'laoshi02', 3)\n" +
//                "insert into defaulttable2 values (2002, 'laoshi03', 3)\n" +
//                "insert into defaulttable2 values (2003, 'laoshi04', 4)\n" +
//                "insert into tablepp values (2000, 'laoshi01', 6)\n" +
//                "insert into tablepp values (2001, 'laoshi02', 3)\n" +
//                "insert into tablepp values (2002, 'laoshi03', 0)\n" +
//                "insert into tablepp values (2003, 'laoshi04', 4)\n" +
//                "select id, name, grade from tablepp" +
//                " ";
        String file_prefix = "test-doc/sql-gen/";
        String file_name = file_prefix + "test_10000-2.schema";
        String out_file_name = file_name + ".result";
        PrintStream ps=new PrintStream(new FileOutputStream(out_file_name));
//        System.setOut(ps);

        File file = new File(file_name);
        InputStreamReader inputreader= new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(inputreader);
        String sql;
//        try {
//            ArrayList<SQLResult> sqlResults = client.query(sql);
//            for (SQLResult sqlResult : sqlResults) {
//                sqlResult.print();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int cnt = 0;
        while((sql = bf.readLine()) != null) {
//            System.out.println("\n" + sql + ": ");

            ArrayList<SQLResult> sqlResults = client.query(sql);
//            for(SQLResult res : sqlResults) {
//                res.print();
//            }
            if((cnt++) % 1 == 0) {
                System.out.println("\n" + cnt);
                System.out.println("\n" + sql + ": ");
                for(SQLResult res : sqlResults) {
                    res.print();
                }
            }
        }
    }
}
