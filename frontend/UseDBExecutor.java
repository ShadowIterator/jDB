public class UseDBExecutor extends SQLExecutor {
    private String dbName;

    public UseDBExecutor(String _dbName) {
        this.dbName = _dbName;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.checkoutDatabase(this.dbName);
        } catch (Exception e) {
            e.printStackTrace();
            return new SQLResult(-1, "Use database " + this.dbName + " failed.");
        }
        return new SQLResult(0);
    }
}
