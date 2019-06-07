public class ShutdownExecutor extends SQLExecutor {
    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            mgr.close();
            return new SQLResult(0);
        } catch(Exception e) {
            e.printStackTrace();
            return new SQLResult(-1, "Shutdown Error.");
        }
    }
}
