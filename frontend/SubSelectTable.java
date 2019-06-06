public class SubSelectTable extends TableJoin {
    public boolean isSub;
    public SelectSQLExecutor selectSQLExec;
    public String tmpName;
    public SubSelectTable(SelectSQLExecutor sqlExec) {
        this.isSub = true;
        this.selectSQLExec = sqlExec;
    }
}
