import java.util.ArrayList;

public class ShowAllDBExecutor extends SQLExecutor {
    private int show_attr_count;
    private SITuple.SITupleDesc show_desc;
    private Object[] show_attr_example;
    private String[] show_attr_name;
    private byte[] show_constraint_list;

    public ShowAllDBExecutor() {
        this.show_attr_count = 1;
        this.show_attr_example = new Object[show_attr_count];
        this.show_attr_name = new String[show_attr_count];
        this.show_constraint_list = new byte[show_attr_count];
        show_attr_example[0] = "thisisthenameofthedabaanditslengthis38";
        show_attr_name[0] = "dbName";
    }
    // | dbName |
    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            this.show_desc = new SITuple.SITupleDesc(this.show_attr_example, this.show_attr_name, this.show_constraint_list, 0);
            SQLResult result = new SQLResult(1);
            for(int i = 0; i < this.show_attr_count; ++i) {
                result.addAttributeInfo(0, this.show_attr_name[i], i);
            }
            ArrayList<String> dbNames = new ArrayList<>();
            // TODO: get all database names
            for(String dbName: dbNames) {
                SITuple tuple = new SITuple(this.show_desc);
                tuple.setAttr(0, dbName);
                result.addTuple(tuple);
            }
            return result;
        } catch(Exception e) {
            return new SQLResult(-1, "Show Databases: Some storage error.");
        }
    }
}
