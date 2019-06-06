public class DropDBExecutor extends SQLExecutor {
    private String dbName;

    public DropDBExecutor(String _dbName) {
        this.dbName = _dbName;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.deleteDatabase(this.dbName);
            return new SQLResult(0);
        } catch(Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Drop Database: " + errMsg);
        }
    }
}
