public class ShowSQLExecutor extends SQLExecutor {
    private String tableName;

    public ShowSQLExecutor(String _tableName) {
        this.type = sqlType.SHOW;
        this.tableName = _tableName;
    }

    @Override
    public void printExecutor() {
        System.out.println("Show Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
    }
}
