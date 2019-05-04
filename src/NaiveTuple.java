import java.io.*;

public final class NaiveTuple extends AbstractTuple implements java.io.Serializable {
    static int TUPLE_SIZE = (Integer.SIZE + Double.SIZE) / Byte.SIZE;
    int id;
    double gpa;

    NaiveTuple(int id, double gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    NaiveTuple() {
        this.id = 0;
        this.gpa = 0;
    }

    void print() {
        System.out.println("id:" + id + " ,gpa: " + gpa);
    }

    byte[] serialize() throws Exception {
//        byte[] b = new byte[TUPLE_SIZE];
//        b[0] = (byte)(id & 0xff);
//        b[1] = (byte)((id >> 8) & 0xff);
//        b[2] = (byte)((id >> 16) & 0xff);
//        b[3] = (byte)((id >> 24) & 0xff);
//        long gpa_value = Double.doubleToRawLongBits(gpa);
//        b[4] = (byte)((gpa_value) & 0xff);
//        b[5] = (byte)((gpa_value >> 8) & 0xff);
//        b[6] = (byte)((gpa_value >> 16) & 0xff);
//        b[7] = (byte)((gpa_value >> 24) & 0xff);
//        b[8] = (byte)((gpa_value >> 32) & 0xff);
//        b[9] = (byte)((gpa_value >> 40) & 0xff);
//        b[10] = (byte)((gpa_value >> 48) & 0xff);
//        b[11] = (byte)((gpa_value >> 56) & 0xff);
//        return b;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.writeObject(this);
        oout.flush();
        byte[] b = bout.toByteArray();
        return b;
    }
//
//4623170197477182669
//4622887618677033933
    void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception
    {
//        id = b[0] + ((int)b[1] << 8) + ((int)b[2] << 16) + ((int)b[3] << 24);
//        long gpa_value = (long)(b[4] & 0xff) + ((long)(b[5] & 0xff) << 8) + ((long)(b[6] & 0xff) << 16) + ((long)(b[7] & 0xff) << 24)
//                + ((long)(b[8] & 0xff) << 32) + ((long)(b[9] & 0xff) << 40) + ((long)(b[10] & 0xff) << 48) + ((long)(b[11] & 0xff) << 56);
//        gpa = Double.longBitsToDouble(gpa_value);
        ByteArrayInputStream bin = new ByteArrayInputStream(b);
        ObjectInput oin = new ObjectInputStream(bin);
        Object nt = oin.readObject();
        this.id = ((NaiveTuple) nt).id;
        this.gpa = ((NaiveTuple) nt).gpa;
    }

    public static class NaiveTupleDesc extends AbstractTupleDesc{
        byte[] serialize() throws  Exception {
            return new byte[2];
        }
        void deserialize(byte[] b) throws  Exception {

        }
    }

}
