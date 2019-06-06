public class SubSelectTable extends TableJoin {
    public boolean isSub;
    public SelectSQLExecutor selectSQLExec;
    public String tmpName;
    public SubSelectTable(SelectSQLExecutor sqlExec, String _tmpName) {
        this.isSub = true;
        this.selectSQLExec = sqlExec;
        this.tmpName = _tmpName;
    }
}
