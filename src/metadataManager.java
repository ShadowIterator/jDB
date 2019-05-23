import sun.plugin.services.AxBridgeBrowserService;

import java.io.File;

public class MetadataManager {

    static int bpt_order = 3;
    BPlusTree database_meta;
    BPlusTree table_meta;
    public BPlusTree[] tables;
    NaivePager cur_db_pager;
    SITuple.SITupleDesc database_meta_desc;
    SITuple.SITupleDesc table_meta_desc;

    String getDBFileName(String db_name) {
        return db_name + "xx.jDB";
    }

    void clear(String file_name) throws Exception {
        FileUtils.delFile(file_name);
    }

    void init(String file_name) throws Exception {
        FileUtils.delFile(file_name);
        NaivePager pager = new NaivePager();
        pager.open(file_name);
        //hardcoding metadata desc.
        int attr_count = 2;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = "default_db";
        attr_example[1] = "default_filename";
        attr_name[0] = "db_name";
        attr_name[1] = "db_file_name";
        SITuple.SITupleDesc desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, 0);
        database_meta = new BPlusTree(bpt_order, desc, pager);

    }

    void open(String file_name) throws Exception {
        NaivePager pager = new NaivePager();
        pager.open(file_name);

        database_meta = new BPlusTree(pager, 0);
    }

    boolean createDatabase(String db_name) throws Exception{
        AbstractTuple.AbstractTupleDesc desc = database_meta.getTupleDesc();
        if(db_name.length() != ((String) desc.getAttr_example(0)).length())
            return false;
        String db_file_name = getDBFileName(db_name);

        System.out.println(desc.getAttr_example(0) + " " + desc.getAttr_example(1));
        System.out.println(db_name + " " + db_file_name);



        SITuple newTuple = new SITuple(desc);

        newTuple.setAttr(0, db_name);
        newTuple.setAttr(1, db_file_name);
        database_meta.insertTuple(newTuple);

        SITuple getTuple = (SITuple) database_meta.getTuple(db_name);

        //create table_metadata_tree
        /***
         *  table_name info_id
         */
        FileUtils.delFile(db_file_name);
        NaivePager pager = new NaivePager();
        pager.open(db_file_name);

        int attr_count = 2;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = "default_table";
        attr_example[1] = (int)-1;
        attr_name[0] = "table_name";
        attr_name[1] = "info_page_id";

        SITuple.SITupleDesc table_meta_desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, 0);


        BPlusTree new_table_metadata = new BPlusTree(bpt_order, table_meta_desc, pager);

        new_table_metadata.close();

        return true;
    }

    void deleteDatabase(String db_name) throws Exception {
//        AbstractTuple tuple = database_meta.getTuple(db_name);
        database_meta.removeTuple(db_name);
        FileUtils.delFile(getDBFileName(db_name));
    }

    void loadTables() throws Exception {
        table_meta = new BPlusTree(cur_db_pager, 0);
        tables = new BPlusTree[table_meta.getCount()];

        int i = 0;
        // to create all b-tree and add it in a list
        for(BPlusTree.Cursor it = table_meta.new Cursor(); !it.isEnd(); it.moveNext(), ++i) {
            tables[i] = new BPlusTree(cur_db_pager, (int)it.getTuple().getAttr(1));
        }
    }

    void checkoutDatabase(String db_name) throws Exception {
        AbstractTuple tuple = database_meta.getTuple(db_name);
        if(tuple == null) return ;
        if(cur_db_pager != null)
            cur_db_pager.close();
        String db_filename = (String) tuple.getAttr(1);
        NaivePager pager = new NaivePager();
        pager.open(db_filename);
        cur_db_pager = pager;

        loadTables();

    }

    void createTable(String table_name, AbstractTuple.AbstractTupleDesc desc) throws Exception{
        BPlusTree newTableTree = new BPlusTree(bpt_order, desc, cur_db_pager);
        SITuple tuple = new SITuple(table_meta.getTupleDesc());
        tuple.setAttr(0, table_name);
        tuple.setAttr(1, newTableTree.getInfoPageID());
        table_meta.insertTuple(tuple);

        loadTables();
    }

    boolean dropTable(String table_name) throws Exception {

        table_meta.removeTuple(table_name);
        loadTables();

        return true;
    }


    public static void main(String[] args) throws Exception {
        MetadataManager mgr = new MetadataManager();
        mgr.init("data_meta.jDB");
        mgr.createDatabase("defaultdb1");
        mgr.checkoutDatabase("defaultdb1");

        int attr_count = 3;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = "kurapika";
        attr_example[1] = (long)16;
        attr_example[2] = (float)14.4;
        attr_name[0] = "attr1";
        attr_name[1] = "attr2";
        attr_name[2] = "attr3";

        SITuple.SITupleDesc table1_desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, 0);

        mgr.createTable("defaulttable1", table1_desc);

        SITuple tuple1 = new SITuple(table1_desc);
        tuple1.setAttr(0, "gonnnnnn");
        tuple1.setAttr(1, (long)13);
        tuple1.setAttr(2, (float)14.8);

        BPlusTree table = mgr.tables[0];
        table.insertTuple(tuple1);

        SITuple tuple2 = new SITuple(table1_desc);
        tuple1.setAttr(0, "killuaaa");
        tuple1.setAttr(1, (long)13);
        tuple1.setAttr(2, (float)13.2);
        table.insertTuple(tuple2);

        SITuple tuple3 = new SITuple(table1_desc);
        tuple1.setAttr(0, "reoriooo");
        tuple1.setAttr(1, (long)18);
        tuple1.setAttr(2, (float)17.8);
        table.insertTuple(tuple3);

        for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
            it.getTuple().print();
        }

    }

}
