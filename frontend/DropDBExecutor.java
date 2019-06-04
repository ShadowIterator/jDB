public class DropDBExecutor extends SQLExecutor {
    private String dbName;

    public DropDBExecutor(String _dbName) {
        this.dbName = _dbName;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.deleteDatabase(this.dbName);
        } catch(Exception e) {
            e.printStackTrace();
            return new SQLResult(-1, "Drop database " + this.dbName + " failed.");
        }
        return new SQLResult(0);
    }
}
