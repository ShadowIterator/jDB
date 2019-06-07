import javafx.util.Pair;

import java.util.ArrayList;

public class DeleteSQLExecutor extends SQLExecutor {
    private String tableName;
    private WhereCondition whereCondition;

    public DeleteSQLExecutor(String _tableName, WhereCondition _whereCondition) {
        this.type = sqlType.DELETE;
        this.tableName = _tableName;
        this.whereCondition = _whereCondition;
    }

    @Override
    public void printExecutor() {
        System.out.println("Delete Expression:");
        System.out.println("\tTarget Table: " + this.tableName);
        System.out.println("\tWhere List: ");
        System.out.println("\t\t"+this.whereCondition.toString());
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        if(this.whereCondition != null && !this.whereCondition.isLegal()) {
            return new SQLResult(-1, "Delete: Some Where Condition Error.");
        }
        try {
            BPlusTree table = mgr.getTableBPlusTreeByName(this.tableName);
            AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
            int pkId = desc.getPrimary_key_id();
            BPlusTree.CursorRange crange = table.new CursorRange();
            if(this.whereCondition != null) {
                String pkName = desc.getAttr_name(pkId);
                Object pkExample = desc.getAttr_example(pkId);
                Pair<Comparable, Comparable> pkRange = this.whereCondition.findPKRange(tableName, pkName, pkExample);
                if (pkRange == null) {
                    return new SQLResult(0);
                }
                crange.setRange(pkRange.getKey(), pkRange.getValue());
            }
            ArrayList<Object> keyList = new ArrayList<>();
            for(; !crange.isEnd(); crange.moveNext()) {
                AbstractTuple tuple = crange.getTuple();
//            for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
//                AbstractTuple tuple = it.getTuple();
                if(this.whereCondition!= null && this.whereCondition.NaiveJudge(tuple, desc, mgr)) {
                    Object obj = tuple.getAttr(pkId);
                    keyList.add(obj);
//                    table.removeTuple((Comparable)obj);
                } else if(this.whereCondition == null) {
                    Object obj = tuple.getAttr(pkId);
                    keyList.add(obj);
//                    table.removeTuple((Comparable)obj);
                }
            }
            for(Object obj: keyList) {
                table.removeTuple((Comparable)obj);
            }
            return new SQLResult(0);
        } catch (Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Delete: " + errMsg);
        }
    }
}
