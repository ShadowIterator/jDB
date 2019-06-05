import java.util.Arrays;

public class ShowSQLExecutor extends SQLExecutor {
    private String tableName;
    private SITuple.SITupleDesc show_desc;
    private int show_attr_count;
    private Object[] show_attr_example;
    private String[] show_attr_name;
    private byte[] show_constraint_list;

    public ShowSQLExecutor(String _tableName) {
        this.type = sqlType.SHOW;
        this.tableName = _tableName;

        this.show_attr_count = 5;
        this.show_attr_example = new Object[show_attr_count];
        this.show_attr_name = new String[show_attr_count];
        this.show_constraint_list = new byte[show_attr_count];
        show_attr_example[0] = (int)0;
        show_attr_example[1] = "thisisthenameoftheattranditslengthis38";
        show_attr_example[2] = "thisisthetypeofthedataanditslengthis38";
        show_attr_example[3] = (int)0;
        show_attr_example[4] = (int)0;
        show_attr_name[0] = "Attribute ID";
        show_attr_name[1] = "Attribute Name";
        show_attr_name[2] = "Data Type";
        show_attr_name[3] = "Is Primary Key";
        show_attr_name[4] = "Is Not Null";
    }

    @Override
    public void printExecutor() {
        System.out.println("Show Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
    }

    /*
    | Attribute ID | Attribute Name | Data Type | is Primary Key | is Not Null |
     */

    private String fillString(String str, int targetLen) {
        int strLen = str.length();
        int restLen = targetLen - strLen;
        if(restLen <= 0) return str;
        char[] emptyCharList = new char[restLen];
        Arrays.fill(emptyCharList, '\0');
        String restStr = new String(emptyCharList);
        return str + restStr;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            this.show_desc = new SITuple.SITupleDesc(this.show_attr_example, this.show_attr_name, this.show_constraint_list, 0);
            SQLResult result = new SQLResult(1);
            for(int i = 0; i < this.show_attr_count; ++i) {
                result.addAttributeInfo(0, this.show_attr_name[i], i);
            }
            BPlusTree table;
            try {
                table = mgr.getTableBPlusTreeByName(this.tableName);
            } catch (Exception e) {
                return new SQLResult(-1, "Show: Cannot find table " + this.tableName);
            }
            AbstractTuple.AbstractTupleDesc table_desc = table.getTupleDesc();
            int attribute_num = table_desc.getAttr_count();
            int pk_id = table_desc.getPrimary_key_id();
            for (int i = 0; i < attribute_num; ++i) {
                SITuple tuple = new SITuple(this.show_desc);
                String attribute_name = table_desc.getAttr_name(i);
                Object attribute_example = table_desc.getAttr_example(i);
                int not_null = table_desc.getAttr_constraint(i) & AbstractTuple.Constraints.NOT_NULL;
                int is_pk = pk_id == i ? 1 : 0;
                String data_type = "";
                if (attribute_example.getClass() == Integer.class) {
                    data_type = "INT";
                } else if (attribute_example.getClass() == Long.class) {
                    data_type = "LONG";
                } else if (attribute_example.getClass() == Double.class) {
                    data_type = "DOUBLE";
                } else if (attribute_example.getClass() == Float.class) {
                    data_type = "FLOAT";
                } else {
                    data_type = "STRING(" + ((String)attribute_example).length() + ")";
                }
//                attribute_name = this.fillString(attribute_name, 22);
//                data_type = this.fillString(data_type, 22);
                tuple.setAttr(0, i);
                tuple.setAttr(1, attribute_name);
                tuple.setAttr(2, data_type);
                tuple.setAttr(3, is_pk);
                tuple.setAttr(4, not_null);
                result.addTuple(tuple);
            }
            return result;
        } catch (Exception e) {
            return new SQLResult(-1, "Show: Some Storage Error.");
        }
    }
}
