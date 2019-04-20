public abstract class AbstractPager {
    abstract void open(String db_file_name) throws Exception;
    abstract void close() throws Exception;
    abstract AbstractPage get(int page_id) throws Exception;
    abstract boolean write(AbstractPage page) throws Exception;
    abstract AbstractPage newPage() throws Exception;
    abstract boolean delPage(int id) throws Exception;
}

//interface APager {
//    abstract int toInt(char a);
//    abstract char toChar(int a);
//}
//
//public class AbstractPager implements APager {
//    public int toInt(char a) {
//        return 1;
//    }
//
//    public char toChar(int a) {
//        return '1';
//    }
//
//    public static void main(String[] args) {
////        System.out.println("Hello World"); //comments
//        HelloWorld.main(args);
//        HelloWorld h = new HelloWorld();
//        h.setA(10);
//        System.out.println("h is," + h.a);
//        AbstractPager p = new AbstractPager();
//        System.out.println(p.toInt('1'));
//
//
//    }
//}