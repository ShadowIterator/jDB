import java.util.ArrayList;

public class OneCondition {
    public SQLValue leftValue;
    public SQLValue rightValue;
    public WhereCondition.Operator operator;

    public OneCondition(SQLValue _leftValue, SQLValue _rightValue, WhereCondition.Operator _operator) {
        this.leftValue = _leftValue;
        this.rightValue = _rightValue;
        this.operator = _operator;
    }

    public String toString() {
        return leftValue.toString() + " " + operator.toString() + " " + rightValue.toString();
    }

    public boolean isLegal() {
        if(this.leftValue.type == WhereCondition.SQLValueType.DIRECT && this.rightValue.type == WhereCondition.SQLValueType.DIRECT) {
            return false;
        }
        if(this.leftValue.type == WhereCondition.SQLValueType.DIRECT) {
            SQLValue tmp = this.leftValue;
            this.leftValue = this.rightValue;
            this.rightValue = tmp;
            if(this.operator == WhereCondition.Operator.LEQ) this.operator = WhereCondition.Operator.GEQ;
            else if(this.operator == WhereCondition.Operator.LT) this.operator = WhereCondition.Operator.GT;
            else if(this.operator == WhereCondition.Operator.GEQ) this.operator = WhereCondition.Operator.LEQ;
            else if(this.operator == WhereCondition.Operator.GT) this.operator = WhereCondition.Operator.LT;
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
        if(this.leftValue.type == WhereCondition.SQLValueType.DIRECT) {
            SQLValue tmp = this.leftValue;
            this.leftValue = this.rightValue;
            this.rightValue = tmp;
            if(this.operator == WhereCondition.Operator.LEQ) this.operator = WhereCondition.Operator.GEQ;
            else if(this.operator == WhereCondition.Operator.LT) this.operator = WhereCondition.Operator.GT;
            else if(this.operator == WhereCondition.Operator.GEQ) this.operator = WhereCondition.Operator.LEQ;
            else if(this.operator == WhereCondition.Operator.GT) this.operator = WhereCondition.Operator.LT;
        }
        String leftAttrName = this.leftValue.attributeName;
        int leftAttrID = desc.getIDByName(leftAttrName);
        if(leftAttrID == -1) {
            throw new Exception("Invalid Attribute Name "+leftAttrName);
        }
        Object leftValue = tuple.getAttr(leftAttrID);
        Object rightValue;
        if(this.rightValue.type == WhereCondition.SQLValueType.DIRECT) {
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
        if(this.operator == WhereCondition.Operator.EQ) {
            return relation == 0;
        } else if(this.operator == WhereCondition.Operator.GT) {
            return relation == 1;
        } else if(this.operator == WhereCondition.Operator.GEQ) {
            return relation >= 0;
        } else if(this.operator == WhereCondition.Operator.LT) {
            return relation == -1;
        } else /* if(this.operator == Operator.LEQ) */ {
            return relation <= 0;
        }
    }

    public Object findObject(String targetTableName, String targetAttributeName, ArrayList<AbstractTuple> tuples, ArrayList<AbstractTuple.AbstractTupleDesc> descs, ArrayList<String> tableNames) throws Exception {
        // TODO: optimize time complexity -> fill up unknown table name once called
        int tableNum = tableNames.size();
        Object returnValue = null;
        if(targetTableName != null) {
            for (int i = 0; i < tableNum; ++i) {
                String tableName = tableNames.get(i);
                if (tableName.equals(targetTableName)) {
                    AbstractTuple tuple = tuples.get(i);
                    AbstractTuple.AbstractTupleDesc desc = descs.get(i);
                    int attributeId = desc.getIDByName(targetAttributeName);
                    if (attributeId == -1) {
                        throw new Exception("Could not find attribute " + targetAttributeName + " in table " + tableName);
                    }
                    returnValue = tuple.getAttr(attributeId);
                    break;
                }
            }
        }
        else {
            for(int i = 0; i < tableNum; ++i) {
                AbstractTuple.AbstractTupleDesc desc = descs.get(i);
                int attributeId = desc.getIDByName(targetAttributeName);
                if(attributeId == -1) {
                    continue;
                }
                AbstractTuple tuple = tuples.get(i);
                returnValue = tuple.getAttr(attributeId);
                break;
            }
        }
        return returnValue;
    }

    public boolean JoinNaiveJudgeCondition(ArrayList<AbstractTuple> tuples, ArrayList<AbstractTuple.AbstractTupleDesc> descs, ArrayList<String> tableNames) throws Exception {
        if(this.leftValue.type == WhereCondition.SQLValueType.DIRECT) {
            SQLValue tmp = this.leftValue;
            this.leftValue = this.rightValue;
            this.rightValue = tmp;
            if(this.operator == WhereCondition.Operator.LEQ) this.operator = WhereCondition.Operator.GEQ;
            else if(this.operator == WhereCondition.Operator.LT) this.operator = WhereCondition.Operator.GT;
            else if(this.operator == WhereCondition.Operator.GEQ) this.operator = WhereCondition.Operator.LEQ;
            else if(this.operator == WhereCondition.Operator.GT) this.operator = WhereCondition.Operator.LT;
        }
        String leftTableName = this.leftValue.tableName;
        String leftAttrName = this.leftValue.attributeName;
        String rightTableName = this.rightValue.tableName;
        String rightAttrName = this.rightValue.attributeName;
        Object leftValue = this.findObject(leftTableName, leftAttrName, tuples, descs, tableNames);
        Object rightValue = null;
        if(this.rightValue.type == WhereCondition.SQLValueType.DIRECT) {
            String rightValueStr = this.rightValue.directValue;
            try {
                rightValue = getObjFromStr(rightValueStr, leftValue);
            } catch (Exception e) {
                throw e;
            }
        } else {
            rightValue = this.findObject(rightTableName, rightAttrName, tuples, descs, tableNames);
        }
        if(leftValue == null) {
            throw new Exception("Cannot find attribute " + leftTableName + "." + leftAttrName);
        }
        if(rightValue == null) {
            throw new Exception("Cannot find attribute " + rightTableName + "." + rightAttrName);
        }
        int relation = this.getRelation(leftValue, rightValue);
        if(this.operator == WhereCondition.Operator.EQ) {
            return relation == 0;
        } else if(this.operator == WhereCondition.Operator.GT) {
            return relation == 1;
        } else if(this.operator == WhereCondition.Operator.GEQ) {
            return relation >= 0;
        } else if(this.operator == WhereCondition.Operator.LT) {
            return relation == -1;
        } else /* if(this.operator == Operator.LEQ) */ {
            return relation <= 0;
        }
    }
}