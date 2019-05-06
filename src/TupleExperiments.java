import java.lang.*;

public class TupleExperiments extends AbstractTuple {

    Object[] objs;

    void setattr(int k, Object item) {
        objs[k] = item;
    }

    Object getattr(int k) {
        return objs[k];
    }

    TupleExperiments(int k) {
        objs = new Object[k];
    }

    byte[] serialize() throws Exception {
//        byte[] b;
        return new byte[12];
    }

    void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        TupleExperiments tuple = new TupleExperiments(3);
        double db = 0.12345678901;
        float ft = 0.12345678901f;
        tuple.setattr(0, 12);
        tuple.setattr(1, ft);
        tuple.setattr(2, "234521daddfdsf234");
        Class[] cls = new Class[3];
        cls[0] = tuple.getattr(0).getClass();
        cls[1] = tuple.getattr(1).getClass();
        cls[2] = tuple.getattr(2).getClass();

        System.out.println(cls[0].toString() + "  " + (cls[0] == Integer.class) + "  " + tuple.getattr(0));
        System.out.println(cls[1].toString() + "  " + (cls[1] == Integer.class) + "  " + tuple.getattr(1));
        System.out.println(cls[2].toString() + "  " + (cls[2] == Integer.class) + "  " + tuple.getattr(2));

//        System.out.println((String) tuple.getattr(2));
//        System.out.println(db);
//        System.out.println(ft);


    }
}