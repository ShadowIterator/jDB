public class UpdateSQLExecutor extends SQLExecutor {
    private String tableName;
    private String attributeName;
    private String newValue;
    private WhereCondition whereCondition;

    public UpdateSQLExecutor(String _tableName, String _attributeName, String _newValue, WhereCondition _whereCondition) {
        this.type = sqlType.UPDATE;
        this.tableName = _tableName;
        this.attributeName = _attributeName;
        this.newValue = _newValue;
        this.whereCondition = _whereCondition;
    }

    @Override
    public void printExecutor() {
        System.out.println("Update Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
        System.out.println("\tTarget Attribute: "+this.attributeName);
        System.out.println("\tTarget New Value: "+this.newValue);
        System.out.println("\tWhere List:");
        System.out.println("\t\t"+this.whereCondition.toString());
    }
}
