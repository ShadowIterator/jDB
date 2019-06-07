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
        byte[] b = new byte[desc.tupleSize()];
//        for(int k = 0; k < attrs.length; ++k) {
//            if (attrs[k] != null)
//                SerializeInplaceUtil.objectToBytes(attrs[k], b, desc.getOffset(k));
//            else {
//                b[k / 8] |= (byte) (1 << (k % 8));
//            }
//        }
        serializeInplace(desc, b, 0);
        return b;
    }


    void serializeInplace(AbstractTupleDesc desc, byte[] dest, int index) throws Exception {
        for(int k = 0; k < attrs.length; ++k) {
            if (attrs[k] != null)
                SerializeInplaceUtil.objectToBytes(attrs[k], dest, index + desc.getOffset(k));
            else {
                dest[index + (k / 8)] |= (byte) (1 << (k % 8));
            }
        }
    }


    void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception {
//        int offk = desc.getOffset(0);
//        for(int k = 0; k < attrs.length; ++k) {
//            if(((b[k / 8] >> (k % 8)) & 1) == 1) {
//                attrs[k] = null;
//            }
//            else {
//                int offkp1 = desc.getOffset(k+1);
//                attrs[k] = SerializeInplaceUtil.bytesToObject(b, offk, offkp1 - offk, desc.getAttr_example(k).getClass());//SerializeUtil.bytesToObject(tb, sidesc.getAttr_example(k).getClass());
//                offk = offkp1;
//            }
//        }
        deSerializeInplace(b, 0, desc);
    }

    void deSerializeInplace(byte[] b, int index, AbstractTupleDesc desc) throws Exception {
        int offk = desc.getOffset(0) + index;
        for(int k = 0; k < attrs.length; ++k) {
            int offkp1 = desc.getOffset(k+1) + index;
            if(((b[index + (k / 8)] >> (k % 8)) & 1) == 1) {
                attrs[k] = null;
            }
            else {
                attrs[k] = SerializeInplaceUtil.bytesToObject(b, offk, offkp1 - offk, desc.getAttr_example(k).getClass());//SerializeUtil.bytesToObject(tb, sidesc.getAttr_example(k).getClass());
            }
            offk = offkp1;
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
        int key_size;

        int getKeySize() {
            return key_size;
        }

        void print() {
            String out_str = "";
            for(int i = 0; i < attr_count; ++i) {
                System.out.print(attr_example[i]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }

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
            key_size = SerializeUtil.objectToBytes(attr_example[primary_key_id]).length;
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
        int attr_count = 19;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = (int) 12;
        attr_example[1] = (long) 13;
        attr_example[2] = (float) 2.1;
        attr_example[3] = (double) 3.3;
        attr_example[4] = (String) "string_value";
        attr_example[5] = (String) "string2";
        attr_example[6] = (int) 12;
        attr_example[7] = (long) 13;
        attr_example[8] = (float) 2.1;
        attr_example[9] = (double) 3.3;
        attr_example[10] = (String) "string_value";
        attr_example[11] = (String) "string2";
        attr_example[12] = (float) 2.1;
        attr_example[13] = (double) 3.3;
        attr_example[14] = (String) "string_value";
        attr_example[15] = (String) "string2";
        attr_example[16] = (int) 12;
        attr_example[17] = (long) 13;
        attr_example[18] = (float) 2.1;


        attr_name[0] = "1int_value";
        attr_name[1] = "2long_value";
        attr_name[2] = "3float_value";
        attr_name[3] = "4double_value";
        attr_name[4] = "5string_value";
        attr_name[5] = "6string2";
        attr_name[6] = "7int_value";
        attr_name[7] = "8long_value";
        attr_name[8] = "9float_value";
        attr_name[9] = "10double_value";
        attr_name[10] = "11string_value";
        attr_name[11] = "12string2";
        attr_name[12] = "13float_value";
        attr_name[13] = "14double_value";
        attr_name[14] = "15string_value";
        attr_name[15] = "16string2";
        attr_name[16] = "17int_value";
        attr_name[17] = "18long_value";
        attr_name[18] = "19float_value";

        for(int i = 0; i < attr_count; ++i)
             constraint_list[i] = 0;
        SITupleDesc desc = new SITupleDesc(attr_example, attr_name, constraint_list,1);
        byte[] b_desc = desc.serialize();
        SITupleDesc desc_2 = new SITupleDesc();
        desc_2.deSerialize(b_desc);
        for(int i = 0; i < attr_count; ++i){

        }
//        System.out.println((int)desc_2.attr_example[0] + " " + (long)desc_2.attr_example[1] + " " +
//                (float) desc_2.attr_example[2] + " " + desc_2.attr_example[3] + " " + desc_2.attr_example[4]);
        desc_2.print();

        SITuple tuple1 = new SITuple(desc);
        SITuple tuple2 = new SITuple(desc);
        tuple1.setAttr(0, (int)-2);
        tuple1.setAttr(1, (long)4591870180066957722l);
        tuple1.setAttr(2, (float)-0.872);
        tuple1.setAttr(3, (double)-0.1);
        tuple1.setAttr(4, (String)"strivalue");
        tuple1.setAttr(5, "strix");
        tuple1.setAttr(15, "attr15");
        tuple1.setAttr(18, (float)1.24);
        tuple1.print();
        byte[] b = tuple1.serialize(desc);
        tuple2.deSerialize(b, desc);
        tuple2.print();
        desc.attr_example[4] = tuple2.getAttr(4);
        System.out.println(desc.getAttr_example(4) + " : " + desc.getAttr_default(4));
        System.out.println((double)tuple2.getAttr(3));
        long la = 4591870180066957722l;
        int alow =(int) (la & 0xffffffffl);
        int ahigh = (int) ((la >> 32) & 0xffffffffl);
        long pa = (((long)alow) & 0xffffffffl) | ((((long)ahigh) & 0xffffffffl) << 32);
        System.out.println(la + " " + alow + " " + ahigh + " " + pa + " " + (long)(0xffffffff));

    }
}
