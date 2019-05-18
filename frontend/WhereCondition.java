import sun.jvm.hotspot.memory.OneContigSpaceCardGeneration;

import java.util.ArrayList;

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

        public SQLValue(String _directValue) {
            this.directValue = _directValue;
            this.type = SQLValueType.DIRECT;
        }

        public SQLValue(String _tableName, String _attributeName) {
            this.tableName = _tableName;
            this.attributeName = _attributeName;
            this.type = SQLValueType.ATTRIBUTE;
        }

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
    public class OneCondition {
        public SQLValue leftValue;
        public SQLValue rightValue;
        public Operator operator;

        public OneCondition(SQLValue _leftValue, SQLValue _rightValue, Operator _operator) {
            this.leftValue = _leftValue;
            this.rightValue = _rightValue;
            this.operator = _operator;
        }

        public String toString() {
            return leftValue.toString() + " " + operator.toString() + " " + rightValue.toString();
        }
    }
    public enum LogicConnection {
        AND("AND"), OR("OR");
        private String name;
        LogicConnection(String name) {this.name = name;}
    }

    public ArrayList<OneCondition> conditions;
    public ArrayList<LogicConnection> connections;

    public WhereCondition() {
        this.conditions = new ArrayList<OneCondition>();
        this.connections = new ArrayList<LogicConnection>();
    }

    public void AddCondition(OneCondition condition, LogicConnection logic) {
        this.conditions.add(0, condition);
        this.connections.add(0, logic);
    }

    public String toString() {
        assert this.conditions.size() == this.connections.size()-1 : "WhereCondition Attribute illegal";
        int conditionSize = this.conditions.size();
        if(conditionSize == 0) {
            return "<No Condition>";
        }
        String returnString = "";
        for(int i = 0; i < conditionSize - 1; i += 1) {
            returnString += this.conditions.get(i).toString();
            returnString += " <";
            returnString += this.connections.get(i).toString();
            returnString += "> ";
        }
        returnString += this.conditions.get(conditionSize-1).toString();
        return returnString;
    }
}
