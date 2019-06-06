public class SubSelectTable extends TableJoin {
    public SelectSQLExecutor selectSQLExec;
    public String tmpName;
    public SubSelectTable(SelectSQLExecutor sqlExec, String _tmpName) {
        this.selectSQLExec = sqlExec;
        this.tmpName = _tmpName;
    }
    @Override
    public boolean isSub() {
        return true;
    }
}
