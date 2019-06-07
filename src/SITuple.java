import java.io.*;
import java.lang.*;
import java.util.Arrays;


public class SITuple extends AbstractTuple implements Serializable {
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
            System.out.print("" + attrs[i] + "\t");
        }
        System.out.println("");
    }

    byte[] serialize(AbstractTupleDesc desc) throws Exception {
//        return new byte[1];
//        for()
        byte[] b = new byte[desc.tupleSize()];
//        for (int k = attrs.length - 1; k >= 0; --k) {
        for(int k = 0; k < attrs.length; ++k) {
            byte[] tb;
            if (attrs[k] != null)
                SerializeInplaceUtil.objectToBytes(attrs[k], b, desc.getOffset(k));
            else {
//                tb = new byte[1];
                b[k / 8] |= (byte) (1 << (k % 8));
            }
//            System.arraycopy(tb, 0, b, desc.getOffset(k), tb.length);
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
                attrs[k] = SerializeUtil.bytesToObject(tb, sidesc.getAttr_example(k).getClass());
            }
        }
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
                offset_list[i + 1] = offset_list[i] + SerializeUtil.objectToBytes(attr_example[i]).length;
            }
            desc_size = serialize().length;
        }

        int getIDByName(String attrName) { //TODO: optimize time complexity
            int attrSize = this.attr_name.length;
            for(int i = 0; i < attrSize; ++i) {
                if(this.attr_name[i].equals(attrName)) {
                    return i;
                }
            }
            return -1;
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

        Object getAttr_default(int k) {
            Object obj = attr_example[k];
            if(obj.getClass() == String.class) {
//                String str = (String) obj;
//                obj = str.substring(0, str.indexOf(0));
                obj = SerializeUtil.stringShrink((String) obj);
            }
            return obj;
        }

        String getAttr_name(int k) {
            return attr_name[k];
        }

        byte getAttr_constraint(int k) {
            return constraint_list[k];
        }

        // added by zjl
        int getPrimary_key_id()
        {
            return primary_key_id;
        }

    }


    public static void main(String[] args) throws Exception {
        System.out.println("SITuple.main:");
        int attr_count = 6;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = (int) 12;
        attr_example[1] = (long) 13;
        attr_example[2] = (float) 2.1;
        attr_example[3] = (double) 3.3;
        attr_example[4] = (String) "string_value";
        attr_example[5] = (String) "string2";

        attr_name[0] = "int_value";
        attr_name[1] = "long_value";
        attr_name[2] = "float_value";
        attr_name[3] = "double_value";
        attr_name[4] = "string_value";
        attr_name[5] = "string2";

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
        tuple1.setAttr(1, (long)4591870180066957722l);
        tuple1.setAttr(2, (float)-0.872);
        tuple1.setAttr(3, (double)-0.1);
        tuple1.setAttr(4, (String)"strivalue");
        tuple1.setAttr(5, "stri");
        tuple1.print();
        byte[] b = tuple1.serialize(desc);
        tuple2.deSerialize(b, desc);
        tuple2.print();
//        desc.attr_example[4] = tuple2.getAttr(4);
//        System.out.println(desc.getAttr_example(4) + " : " + desc.getAttr_default(4));
//        System.out.println((double)tuple2.getAttr(3));
//        long la = 4591870180066957722l;
//        int alow =(int) (la & 0xffffffffl);
//        int ahigh = (int) ((la >> 32) & 0xffffffffl);
//        long pa = (((long)alow) & 0xffffffffl) | ((((long)ahigh) & 0xffffffffl) << 32);
//        System.out.println(la + " " + alow + " " + ahigh + " " + pa + " " + (long)(0xffffffff));

    }
}
