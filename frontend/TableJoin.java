public class TableJoin {
    public boolean isJoin;
    public String firstTableName;
    public String secondTableName;
    public WhereCondition onCondition;
    public TableJoin() {
        this.isJoin = false;
        this.firstTableName = null;
        this.secondTableName = null;
        this.onCondition = null;
    }
}