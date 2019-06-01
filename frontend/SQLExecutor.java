public class SQLExecutor {
    public enum sqlType {
        CREATE, DROP, SHOW, INSERT, DELETE, UPDATE, SELECT
    };
    public sqlType type;
    public void printExecutor() {
        System.out.println("Base class SQLExecutor");
    }
    public SQLResult execute(MetadataManager mgr) throws Exception {
        System.out.println("Need to be implemented!");
        return new SQLResult(-1, "Not implemented!");
    }
}