import java.io.*;
import java.lang.*;
import java.util.Arrays;


public class SITuple extends AbstractTuple {
    Object[] attrs;


    SITuple(AbstractTupleDesc desc) {
        SITupleDesc sidesc = (SITupleDesc) desc;
        int attr_count = sidesc.getAttr_count();
//        for(int i = attr_count; i >= 0; --i)
//            attrs[i] = new Object(sidesc.getAttr_example(i));
        attrs = new Object[attr_count];
    }

    void setAttr(int k, Object obj) {
        attrs[k] = obj;
    }

    Object getAttr(int k) {
        return attrs[k];
    }

    void print() {
        for(int i = 0; i < attrs.length; ++i) {
            System.out.println(attrs[i]);
        }
    }

    byte[] serialize(AbstractTupleDesc desc) throws Exception {
//        return new byte[1];
//        for()
        byte[] b = new byte[desc.tupleSize()];
//        for (int k = attrs.length - 1; k >= 0; --k) {
        for(int k = 0; k < attrs.length; ++k) {
            byte[] tb;
            if (attrs[k] != null)
                tb = objectToBytes(attrs[k]);
            else {
                tb = new byte[1];
                b[k / 8] |= (byte) (1 << (k % 8));
            }
            System.arraycopy(tb, 0, b, desc.getOffset(k), tb.length);
        }
        return b;
    }

    void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception {
//        for (int k = attrs.length; k >= 0; --k)
        SITupleDesc sidesc = (SITupleDesc) desc;
        for(int k = 0; k < attrs.length; ++k) {
            if(((b[k / 8] >> (k % 8)) & 1) == 1) {
                attrs[k] = null;
            }
            else {
                byte[] tb = new byte[desc.getOffset(k + 1) - desc.getOffset(k)];
                System.arraycopy(b, desc.getOffset(k), tb, 0, tb.length);
                attrs[k] = bytesToObject(tb, sidesc.getAttr_example(k).getClass());
            }
        }
    }

    static int bytesToInt(byte[] b) {
//        int int_value;
        return b[0] | ((int) b[1] << 8) | ((int) b[2] << 16) | ((int) b[3] << 24);
    }

    static long bytesToLong(byte[] b) {
        byte[] b_low = Arrays.copyOfRange(b, 0, 4);
        byte[] b_high = Arrays.copyOfRange(b, 4, 8);
        return (long) bytesToInt(b_low) | ((long) bytesToInt(b_high) << 32);
    }

    static float bytesToFloat(byte[] b) {
        int float_int_value = bytesToInt(b);
        return Float.intBitsToFloat(float_int_value);
    }

    static double bytesToDouble(byte[] b) {
        long double_long_value = bytesToLong(b);
        return Double.longBitsToDouble(double_long_value);
    }

    static String bytesToString(byte[] b) {
        return new String(b);
    }

    static Object bytesToObject(byte[] b, Class cls) {
        Object obj;
        if (cls == Integer.class) {
            obj = bytesToInt(b);
//            obj = int_value;
        } else if (cls == Long.class) {
            obj = bytesToLong(b);
        } else if (cls == Float.class) {
            obj = bytesToFloat(b);
        } else if (cls == Double.class) {
            obj = bytesToDouble(b);
        } else /* if(cls == String.class) */ {
            obj = bytesToString(b);
        }
        return obj;
    }

    static byte[] intToBytes(int int_value) {
        byte[] b = new byte[4];
        b[0] = (byte) (int_value & 0xff);
        b[1] = (byte) ((int_value >> 8) & 0xff);
        b[2] = (byte) ((int_value >> 16) & 0xff);
        b[3] = (byte) ((int_value >> 24) & 0xff);
        return b;
    }

    static byte[] longToBytes(long long_value) {
        byte[] b = new byte[8];
//        b[0] = (byte)(long_value & 0xff);
//        b[1] = (byte)((long_value >> 8) & 0xff);
//        b[2] = (byte)((long_value >> 16) & 0xff);
//        b[3] = (byte)((long_value >> 24) & 0xff);
//        b[4] = (byte)((long_value >> 32 & 0xff);
//        b[5] = (byte)((long_value >> 40) & 0xff);
//        b[6] = (byte)((long_value >> 48) & 0xff);
//        b[7] = (byte)((long_value >> 56) & 0xff);
        byte[] b_low = intToBytes((int) (long_value));
        byte[] b_high = intToBytes((int) (long_value >> 32));
        System.arraycopy(b_low, 0, b, 0, b_low.length);
        System.arraycopy(b_high, 0, b, b_low.length, b_high.length);
        return b;
    }

    static byte[] floatToBytes(float float_value) {
        int float_int_value = Float.floatToRawIntBits(float_value);
        return intToBytes(float_int_value);
    }

    static byte[] doubleToBytes(double double_value) {
        long double_long_value = Double.doubleToRawLongBits(double_value);
        return longToBytes(double_long_value);
    }

    static byte[] stringToBytes(String string_value) {
        return string_value.getBytes();
    }

    static byte[] objectToBytes(Object obj) throws Exception  {

        byte[] b;

        if (obj.getClass() == Integer.class) {
            int int_obj = (int) obj;
            b = intToBytes(int_obj);
        } else if (obj.getClass() == Long.class) {
            long long_obj = (long) obj;
            b = longToBytes(long_obj);
        } else if (obj.getClass() == Float.class) {
            float float_obj = (float) obj;
            b = floatToBytes(float_obj);
        } else if (obj.getClass() == Double.class) {
            double double_obj = (double) obj;
            b = doubleToBytes(double_obj);
        } else /* if(obj.getClass() == String.class) */ {
            String string_obj = (String) obj;
            b = stringToBytes(string_obj);
        }
        return b;
    }

    public static class SITupleDesc extends AbstractTupleDesc implements java.io.Serializable {
        Object[] attr_example; //types,default_value
        String[] attr_name;
        byte[] constraint_list;
        int[] offset_list;
        int primary_key_id;
        int attr_count;
        int desc_size;

        SITupleDesc() {

        }

        SITupleDesc(Object[] t_attr_example, String[] t_attr_name, byte[] t_constraint_list, int t_primary_key_id) throws Exception {
            attr_example = t_attr_example;
            attr_name = t_attr_name;
            constraint_list = t_constraint_list;
            primary_key_id = t_primary_key_id;
            attr_count = t_attr_example.length;
            offset_list = new int[attr_count + 1];
            offset_list[0] = (attr_count + 7) / 8;
            for (int i = 0; i < attr_count; ++i) {
                offset_list[i + 1] = offset_list[i] + SITuple.objectToBytes(attr_example[i]).length;
            }
            desc_size = serialize().length;
        }

        int getAttr_count() {
            return attr_count;
        }

        byte[] serialize() throws Exception {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(bout);
            oout.writeObject(this);
            oout.flush();
            byte[] b = bout.toByteArray();
            return b;
//            return new byte[1];
        }

        void deSerialize(byte[] b) throws Exception {
            ByteArrayInputStream bin = new ByteArrayInputStream(b);
            ObjectInput oin = new ObjectInputStream(bin);
            Object nt = oin.readObject();
            SITupleDesc nthis = (SITupleDesc) nt;
            this.attr_example = nthis.attr_example;
            this.attr_name = nthis.attr_name;
            this.constraint_list = nthis.constraint_list;
            this.offset_list = nthis.offset_list;
            this.primary_key_id = nthis.primary_key_id;
            this.attr_count = nthis.attr_count;
        }

        int tupleSize() throws Exception {
            return offset_list[attr_count];
        }

        int descSize() throws Exception {
            return desc_size;
        }

        int getOffset(int k) throws Exception {
            return offset_list[k];
        }

        Object getAttr_example(int k) {
            return attr_example[k];
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("SITuple.main:");
        int attr_count = 5;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = (int) 12;
        attr_example[1] = (long) 13;
        attr_example[2] = (float) 2.1;
        attr_example[3] = (double) 3.3;
        attr_example[4] = (String) "string_value";

        attr_name[0] = "int_value";
        attr_name[1] = "long_value";
        attr_name[2] = "float_value";
        attr_name[3] = "double_value";
        attr_name[4] = "string_value";

        for(int i = 0; i < attr_count; ++i)
             constraint_list[i] = 0;
        SITupleDesc desc = new SITupleDesc(attr_example, attr_name, constraint_list,1);
        byte[] b_desc = desc.serialize();
        SITupleDesc desc_2 = new SITupleDesc();
        desc_2.deSerialize(b_desc);
        for(int i = 0; i < attr_count; ++i){

        }
        System.out.println((int)desc_2.attr_example[0] + " " + (long)desc_2.attr_example[1] + " " +
                (float) desc_2.attr_example[2] + " " + desc_2.attr_example[3] + " " + desc_2.attr_example[4]);

        SITuple tuple1 = new SITuple(desc);
        SITuple tuple2 = new SITuple(desc);
        tuple1.setAttr(0, (int)-2);
        tuple1.setAttr(1, (long)23);
        tuple1.setAttr(2, (float)2.2);
        tuple1.setAttr(3, null);
        tuple1.setAttr(4, "stringdvalue");
        tuple1.print();
        byte[] b = tuple1.serialize(desc);
        tuple2.deSerialize(b, desc);
        tuple2.print();

    }
}
