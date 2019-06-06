public class SQLValue {
    public WhereCondition.SQLValueType type;
    public String directValue;
    public String tableName;
    public String attributeName;
    public boolean isOuter;

    public SQLValue(String _directValue) {
        this.directValue = _directValue;
        this.type = WhereCondition.SQLValueType.DIRECT;
        this.isOuter = false;
    }

    public SQLValue(String _tableName, String _attributeName) {
        this.tableName = _tableName;
        this.attributeName = _attributeName;
        this.type = WhereCondition.SQLValueType.ATTRIBUTE;
        this.isOuter = false;
    }

    public String toString() {
        String result = "";
        if(this.type == WhereCondition.SQLValueType.DIRECT) {
            result += this.directValue;
        } else {
            if(this.tableName == null) {
                result += "<null>.";
            } else {
                result += (this.tableName + ".");
            }
            result += this.attributeName;
        }
        return result;
    }
}