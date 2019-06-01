import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class jDBClient {
    private String ip;
    private int port;
    public jDBClient(String _ip, int _port) {
        this.ip = _ip;
        this.port = _port;
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
    public static void main(String[] arg) {
        jDBClient client = new jDBClient("127.0.0.1", 10086);
        String sql =
                "creat table defaulttable2 (id long, name string(8), grade int, primary key(id))\n" +
                "show table defaulttable2\n" +
                "insert into defaulttable2 values (2000, 'laoshi01', 2)\n" +
                "insert into defaulttable2 values (2001, 'laoshi02', 3)\n" +
                "insert into defaulttable2 values (2002, 'laoshi03', 3)\n" +
                "insert into defaulttable2 values (2003, 'laoshi04', 4)\n" +
                "select id, name, grade from defaulttable2";
        try {
            ArrayList<SQLResult> sqlResults = client.query(sql);
            for (SQLResult sqlResult : sqlResults) {
                sqlResult.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
