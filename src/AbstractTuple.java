abstract public class AbstractTuple {
    //Object[] attrs
    abstract byte[] serialize(AbstractTupleDesc desc) throws Exception;
    abstract void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception;
    abstract Object getAttr(int k);

//    void deSerialize(byte[] b, AbstractTupleDesc desc, int id) throws Exception {
//
//    }
//    abstract byte[] serialize(int id,) throws Exception;

    //abstract Object getAttr(int id) throws Exception;
    //abstract boolean setAttr(int id, Object obj) throw Exception;
    //abstract Object getPrimaryKey() throw Exception;

    public static class Constraints {
        public static byte NOT_NULL = 1;
    }

    abstract public static class AbstractTupleDesc{
//        String[] attr_name_list;
//        String[] attr_type_list;
//        byte[] constraint_list;
//        int[] offset_list;
//        int primary_key_id;
//        int attr_count;
//        byte[] default_value;

    //one implementation:
        //Object[] attrs //types,default_value
        //String[] attr_name
        //byte[] constraint_list
        //int[] offset_list
        //int primary_key_id
        //int attr_count


        abstract byte[] serialize() throws  Exception;
        abstract void deSerialize(byte[] b) throws  Exception;
        abstract int tupleSize() throws Exception;
        abstract int descSize() throws Exception;
        abstract int getOffset(int k) throws Exception;
        abstract int getAttr_count();
        abstract Object getAttr_example(int k);
        abstract String getAttr_name(int k);
        abstract byte getAttr_constraint(int k);

        // added by hfz
        abstract int getIDByName(String attrName);

        // added by zjl
        abstract int getPrimary_key_id();
    }

    void print() {
        System.out.println("please implement print first");
    }
}
