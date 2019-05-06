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
}
