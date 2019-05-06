abstract public class AbstractTuple {
    abstract byte[] serialize() throws Exception;
    abstract void deSerialize(byte[] b, AbstractTupleDesc desc) throws Exception;
//    void deSerialize(byte[] b, AbstractTupleDesc desc, int id) throws Exception {
//
//    }
//    abstract byte[] serialize(int id,) throws Exception;


    abstract public static class AbstractTupleDesc{
//        String[] attr_name_list;
//        String[] attr_type_list;
//        byte[] constraint_list;
//        int[] offset_list;
//        int primary_key_id;
//        int attr_count;
//        byte[] default_value;

        abstract byte[] serialize() throws  Exception;
        abstract void deserialize(byte[] b) throws  Exception;

    }

    void print() {
        System.out.println("please implement print first");
    }
}
