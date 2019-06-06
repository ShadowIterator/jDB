public class CreateDBExecutor extends SQLExecutor {
    private String dbName;

    public CreateDBExecutor(String _dbName) {
        this.dbName = _dbName;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.createDatabase(dbName);
            return new SQLResult(0);
        } catch (Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Create Database: " + errMsg);
        }
    }
}
