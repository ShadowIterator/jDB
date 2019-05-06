public class WhereCondition {
    public enum Operator {
        EQ("="), GT(">"), GEQ(">="), LT("<"), LEQ("<="), NQ("<>");
        private String name;
        Operator(String name) {
            this.name = name;
        }
    }
    public enum SQLValueType {
        DIRECT, ATTRIBUTE
    }
    public class SQLValue {
        public SQLValueType type;
        public String directValue;
        public String tableName;
        public String attributeName;

        public String toString() {
            String result = "";
            if(this.type == SQLValueType.DIRECT) {
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
    public SQLValue leftValue;
    public SQLValue rightValue;
    public Operator operator;

    public String toString() {
        return leftValue.toString() + " " + operator.toString() + " " + rightValue.toString();
    }
}
