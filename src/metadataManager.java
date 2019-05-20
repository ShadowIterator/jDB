import sun.plugin.services.AxBridgeBrowserService;

import java.io.File;

public class MetadataManager {

    static int bpt_order = 3;
    BPlusTree database_meta;
    BPlusTree table_meta;
    BPlusTree[] tables;

    String getDBFileName(String db_name) {
        return db_name + "xx.jDB";
    }

    void clear(String file_name) throws Exception {
        FileUtils.delFile(file_name);
    }

    void init(String file_name) throws Exception {
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
        SITuple.SITupleDesc desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, 1);
        database_meta = new BPlusTree(bpt_order, desc, pager);

    }

    void open(String file_name) throws Exception {
        NaivePager pager = new NaivePager();
        pager.open(file_name);

        database_meta = new BPlusTree(pager, 0);
    }

    boolean create_database(String db_name) throws Exception{
        AbstractTuple.AbstractTupleDesc desc = database_meta.getTupleDesc();
        if(db_name.length() != ((String) desc.getAttr_example(0)).length())
            return false;
        String db_file_name = getDBFileName(db_name);
        SITuple newTuple = new SITuple(desc);
        newTuple.setAttr(0, db_name);
        newTuple.setAttr(1, db_file_name);
        database_meta.insertTuple(newTuple);

        //create table_metadata_tree
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

    void delete_database(String db_name) throws Exception {
//        AbstractTuple tuple = database_meta.getTuple(db_name);
        database_meta.removeTuple(db_name);
        FileUtils.delFile(getDBFileName(db_name));
    }

    void checkout_database(String db_name) throws Exception {
        AbstractTuple tuple = database_meta.getTuple(db_name);
        if(tuple == null) return ;
        String db_filename = (String) tuple.getAttr(1);
        NaivePager pager = new NaivePager();
        pager.open(db_filename);
        table_meta = new BPlusTree(pager, 0);

    }

}
