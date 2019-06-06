public class CreateDBExecutor extends SQLExecutor {
    private String dbName;

    public CreateDBExecutor(String _dbName) {
        this.dbName = _dbName;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.createDatabase(dbName);
        } catch (Exception e) {
            e.printStackTrace();
            return new SQLResult(-1, "Create database " + this.dbName + " failed.");
        }
        return new SQLResult(0);
    }
}
