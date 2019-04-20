import java.io.*;
import java.util.Arrays;

public class HelloWorld {
//    public int a;
//    HelloWorld() {
//        a = 1;
//    }
//    public void setA(int x){a = x;}
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World"); //comments
        File file = new File("hello.txt");
//        try {
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        String str = "helloabcdefghijklmn";
        String overwriteStr = "xx";
        byte[] b = overwriteStr.getBytes();

        writer.write(str);
        writer.flush();
        writer.close();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(3);
        raf.write(b);
//        raf.close();
        byte[] c = new byte[4];
        raf.seek(4);
        raf.read(c);
        System.out.println(new String(c) + Arrays.toString(c));
//        }
//        finally {
//
//        }
    }

}