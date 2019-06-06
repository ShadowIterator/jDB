public class TableJoin {
    public boolean isSub;
    public boolean isJoin;
    public String firstTableName;
    public String secondTableName;
    public WhereCondition onCondition;
    public int joinType;
    // 1: right outer
    // 0: left outer
    // -1: inner

    public void setJoinType(int type) {
        this.joinType = type;
    }

    public TableJoin() {
        this.isSub = false;
        this.isJoin = false;
        this.firstTableName = null;
        this.secondTableName = null;
        this.onCondition = null;
        this.joinType = -1;
    }
}
