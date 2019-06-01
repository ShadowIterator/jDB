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
        if(!this.whereCondition.isLegal()) {
            return new SQLResult(-1, "Delete: Some Where Condition Error.");
        }
        try {
            BPlusTree table = mgr.getTableBPlusTreeByName(this.tableName);
            AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
            int pkId = desc.getPrimary_key_id();
            for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
                AbstractTuple tuple = it.getTuple();
                if(this.whereCondition.NaiveJudge(tuple, desc)) {
                    Object obj = tuple.getAttr(pkId);
                    table.removeTuple((Comparable)obj);
                }
            }
            return new SQLResult(0);
        } catch (Exception e) {
            return new SQLResult(-1, "Delete: Some Storage Error.");
        }
    }
}
