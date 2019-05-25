import java.util.ArrayList;
import java.util.Comparator;

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

        public boolean isLegal() {
            if(this.leftValue.type == SQLValueType.DIRECT && this.rightValue.type == SQLValueType.DIRECT) {
                return false;
            }
            return true;
        }

        public Object getObjFromStr(String str, Object targetObj) throws Exception {
            try {
                if (targetObj.getClass() == Integer.class) {
                    return Integer.parseInt(str);
                } else if (targetObj.getClass() == Long.class) {
                    return Long.parseLong(str);
                } else if (targetObj.getClass() == Float.class) {
                    return Float.parseFloat(str);
                } else if (targetObj.getClass() == Double.class) {
                    return Double.parseDouble(str);
                } else {
                    return str;
                }
            } catch (Exception e) {
                throw new Exception("Wrong Data Type.");
            }
        }

        public int getRelation(Object left, Object right) {
            //-1: LT
            //0: EQ
            //1: GT
            if(left.getClass() == Integer.class) {
                int ileft = (int)left;
                int iright = (int)right;
                return Integer.compare(ileft, iright);
            } else if(left.getClass() == Long.class) {
                long lleft = (long)left;
                long lright = (long)right;
                return Long.compare(lleft, lright);
            } else if(left.getClass() == Float.class) {
                float fleft = (float)left;
                float fright = (float)right;
                return Float.compare(fleft, fright);
            } else if(left.getClass() == Double.class) {
                double dleft = (double)left;
                double dright = (double)right;
                return Double.compare(dleft, dright);
            } else {
                String sleft = (String)left;
                String sright = (String)right;
                int result = sleft.compareTo(sright);
                return Integer.compare(result, 0);
            }
        }

        public boolean NaiveJudgeCondition(AbstractTuple tuple, AbstractTuple.AbstractTupleDesc desc) throws Exception {
            if(this.leftValue.type == SQLValueType.DIRECT) {
                SQLValue tmp = this.leftValue;
                this.leftValue = this.rightValue;
                this.rightValue = tmp;
            }
            String leftAttrName = this.leftValue.attributeName;
            int leftAttrID = desc.getIDByName(leftAttrName);
            if(leftAttrID == -1) {
                throw new Exception("Invalid Attribute Name "+leftAttrName);
            }
            Object leftValue = tuple.getAttr(leftAttrID);
            Object rightValue;
            if(this.rightValue.type == SQLValueType.DIRECT) {
                String rightValueStr = this.rightValue.directValue;
                try {
                    rightValue = getObjFromStr(rightValueStr, leftValue);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                String rightAttrName = this.rightValue.attributeName;
                int rightAttrID = desc.getIDByName(rightAttrName);
                if(rightAttrID == -1) {
                    throw new Exception("Invalue Attribute Name " + rightAttrName);
                }
                rightValue = tuple.getAttr(rightAttrID);
            }
            int relation = this.getRelation(leftValue, rightValue);
            if(this.operator == Operator.EQ) {
                return relation == 0;
            } else if(this.operator == Operator.GT) {
                return relation == 1;
            } else if(this.operator == Operator.GEQ) {
                return relation >= 0;
            } else if(this.operator == Operator.LT) {
                return relation == -1;
            } else /* if(this.operator == Operator.LEQ) */ {
                return relation <= 0;
            }
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

    public boolean isLegal() {
        boolean result = true;
        result &= (this.conditions.size() == this.connections.size()+1);
        for(OneCondition condition: this.conditions) {
            result &= condition.isLegal();
        }
        return result;
    }

    public boolean NaiveJudge(AbstractTuple tuple, AbstractTuple.AbstractTupleDesc desc) throws Exception {
        boolean result = this.conditions.get(0).NaiveJudgeCondition(tuple, desc);
        int connectionSize = this.connections.size();
        for(int i = 0; i < connectionSize; ++i) {
            if(this.connections.get(i) == LogicConnection.AND) {
                result &= this.conditions.get(i+1).NaiveJudgeCondition(tuple, desc);
            } else {
                result |= this.conditions.get(i+1).NaiveJudgeCondition(tuple, desc);
            }
        }
        return result;
    }

}
