public class DropSQLExecutor extends SQLExecutor {
    private String tableName;

    public DropSQLExecutor(String _tableName) {
        this.type = sqlType.DROP;
        this.tableName = _tableName;
    }

    @Override
    public void printExecutor() {
        System.out.println("Drop Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
    }
}
