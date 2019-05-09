abstract public class AbstractTuple {
    //Object[] attrs
    abstract byte[] serialize(AbstractTupleDesc desc) throws Exception;
    abstract void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception;

//    void deSerialize(byte[] b, AbstractTupleDesc desc, int id) throws Exception {
//
//    }
//    abstract byte[] serialize(int id,) throws Exception;

    //abstract Object getAttr(int id) throws Exception;
    //abstract boolean setAttr(int id, Object obj) throw Exception;
    //abstract Object getPrimaryKey() throw Exception;
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

    }

    void print() {
        System.out.println("please implement print first");
    }
}
