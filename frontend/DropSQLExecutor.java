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
    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.dropTable(this.tableName);
            return new SQLResult(0);
        } catch (Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Drop: " + errMsg);
        }
    }
}
