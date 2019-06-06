import java.util.ArrayList;
import javafx.util.Pair;

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

    public boolean NaiveJudge(AbstractTuple tuple, AbstractTuple.AbstractTupleDesc desc, MetadataManager mgr) throws Exception {
        ArrayList<AbstractTuple> tuples = new ArrayList<>();
        tuples.add(tuple);
        ArrayList<AbstractTuple.AbstractTupleDesc> descs = new ArrayList<>();
        descs.add(desc);
        boolean result;
        if(this.conditions.get(0).isNotExist()) {
            result = ((NotExistCondition)(this.conditions.get(0))).JudgeCondition(tuples, descs, mgr);
        } else {
            result = this.conditions.get(0).NaiveJudgeCondition(tuple, desc);
        }
        int connectionSize = this.connections.size();
        for(int i = 0; i < connectionSize; ++i) {
            boolean tmpResult;
            if(this.conditions.get(i+1).isNotExist()) {
                tmpResult = ((NotExistCondition)(this.conditions.get(i+1))).JudgeCondition(tuples, descs, mgr);
            } else {
                tmpResult = this.conditions.get(i+1).NaiveJudgeCondition(tuple, desc);
            }
            if(this.connections.get(i) == LogicConnection.AND) {
                result &= tmpResult;
            } else {
                result |= tmpResult;
            }
        }
        return result;
    }

    public boolean JoinNaiveJudge(ArrayList<AbstractTuple> tuples, ArrayList<AbstractTuple.AbstractTupleDesc> descs, ArrayList<String> tableNames, MetadataManager mgr) throws Exception {
        boolean result;
        if(this.conditions.get(0).isNotExist()) {
            result = ((NotExistCondition)(this.conditions.get(0))).JudgeCondition(tuples, descs, mgr);
        } else {
            result = this.conditions.get(0).JoinNaiveJudgeCondition(tuples, descs, tableNames);
        }
        int connectionSize = this.connections.size();
        for(int i = 0; i < connectionSize; ++i) {
            boolean tmpResult;
            if(this.conditions.get(i+1).isNotExist()) {
                tmpResult = ((NotExistCondition)(this.conditions.get(i+1))).JudgeCondition(tuples, descs, mgr);
            } else {
                tmpResult = this.conditions.get(i+1).JoinNaiveJudgeCondition(tuples, descs, tableNames);
            }
            if(this.connections.get(i) == LogicConnection.AND) {
                result &= tmpResult;
            } else {
                result |= tmpResult;
            }
        }
        return result;
    }

    public void pureInference(String tableName, AbstractTuple.AbstractTupleDesc desc) {
        for (OneCondition cond : this.conditions) {
            if (cond.isNotExist()) {
                continue;
            }
            if (cond.leftValue.type == SQLValueType.ATTRIBUTE) {
                if (cond.leftValue.tableName == null && desc.getIDByName(cond.leftValue.attributeName) != -1) {
                    cond.leftValue.tableName = tableName;
                }
            }
            if (cond.rightValue.type == SQLValueType.ATTRIBUTE) {
                if (cond.rightValue.tableName == null && desc.getIDByName(cond.rightValue.attributeName) != -1) {
                    cond.rightValue.tableName = tableName;
                }
            }
        }
    }

    public void pureInference(ArrayList<String> tableNames, ArrayList<AbstractTuple.AbstractTupleDesc> descs){
        for(OneCondition cond: this.conditions) {
            if(cond.isNotExist()) {
                continue;
            }
            int tableCount = tableNames.size();
            for(int i = 0; i < tableCount; ++i) {
                String tableName = tableNames.get(i);
                AbstractTuple.AbstractTupleDesc desc = descs.get(i);
                if(cond.leftValue.type == SQLValueType.ATTRIBUTE) {
                    if(cond.leftValue.tableName == null) {
                        if(desc.getIDByName(cond.leftValue.attributeName) != -1) {
                            cond.leftValue.tableName = tableName;
                        }
                    }
                }
                if(cond.rightValue.type == SQLValueType.ATTRIBUTE) {
                    if(cond.rightValue.tableName == null) {
                        if(desc.getIDByName(cond.rightValue.attributeName) != -1) {
                            cond.rightValue.tableName = tableName;
                        }
                    }
                }
            }
        }
    }

    public void inference(String tableName, AbstractTuple.AbstractTupleDesc desc) throws Exception {
        for(OneCondition cond: this.conditions) {
            if(cond.isNotExist()) {
                continue;
            }
            if(cond.leftValue.type == SQLValueType.ATTRIBUTE) {
                if(desc.getIDByName(cond.leftValue.attributeName) != -1) {
                    cond.leftValue.tableName = tableName;
                } else {
                    throw new Exception("No attribute " + cond.leftValue.attributeName + " in table " + tableName);
                }
            }
            if(cond.rightValue.type == SQLValueType.ATTRIBUTE) {
                if(desc.getIDByName(cond.rightValue.attributeName) != -1) {
                    cond.rightValue.tableName = tableName;
                } else {
                    throw new Exception("No attribute " + cond.rightValue.attributeName + " in table " + tableName);
                }
            }
        }
    }

    public void inference(ArrayList<String> tableNames, ArrayList<AbstractTuple.AbstractTupleDesc> descs) throws Exception {
        for(OneCondition cond: this.conditions) {
            if(cond.isNotExist()) {
                continue;
            }
            int tableCount = tableNames.size();
            for(int i = 0; i < tableCount; ++i) {
                String tableName = tableNames.get(i);
                AbstractTuple.AbstractTupleDesc desc = descs.get(i);
                if(cond.leftValue.type == SQLValueType.ATTRIBUTE) {
                    if(cond.leftValue.tableName == null) {
                        if(desc.getIDByName(cond.leftValue.attributeName) != -1) {
                            cond.leftValue.tableName = tableName;
                        } else {
                            if(i == tableCount - 1) {
                                throw new Exception("No attribute " + cond.leftValue.attributeName + " in all related tables");
                            }
                        }
                    } else {
                        if (cond.leftValue.tableName.equals(tableName)) {
                            if (desc.getIDByName(cond.leftValue.attributeName) == -1) {
                                throw new Exception("No attribute " + cond.leftValue.attributeName + " in table " + tableName);
                            }
                        }
                    }
                }
                if(cond.rightValue.type == SQLValueType.ATTRIBUTE) {
                    if(cond.rightValue.tableName == null) {
                        if(desc.getIDByName(cond.rightValue.attributeName) != -1) {
                            cond.rightValue.tableName = tableName;
                        } else {
                            if(i == tableCount - 1) {
                                throw new Exception("No attribute " + cond.rightValue.attributeName + " in all related tables");
                            }
                        }
                    } else {
                        if (cond.rightValue.tableName.equals(tableName)) {
                            if (desc.getIDByName(cond.rightValue.attributeName) == -1) {
                                throw new Exception("No attribute " + cond.rightValue.attributeName + " in table " + tableName);
                            }
                        }
                    }
                }
            }
        }
    }

    private String isPKCondition(OneCondition cond, String tableName, String pkName) {
        if(cond.isNotExist()) {
            return null;
        }
        if(cond.rightValue.type == SQLValueType.ATTRIBUTE) {
            SQLValue tmp = cond.leftValue;
            cond.leftValue = cond.rightValue;
            cond.rightValue = tmp;
            if(cond.operator == Operator.LEQ) cond.operator = Operator.GEQ;
            else if(cond.operator == Operator.LT) cond.operator = Operator.GT;
            else if(cond.operator == Operator.GEQ) cond.operator = Operator.LEQ;
            else if(cond.operator == Operator.GT) cond.operator = Operator.LT;
        }
        if(cond.rightValue.type == SQLValueType.ATTRIBUTE) {
            return null;
        }
        if(tableName != null && cond.leftValue.tableName != null) {
            if(tableName != cond.leftValue.tableName) {
                return null;
            }
        }
        if(cond.leftValue.attributeName == pkName) {
            return cond.rightValue.directValue;
        } else {
            return null;
        }
    }

    private Comparable getComparableFromStr(String str, Object example) {
        if(example.getClass() == Integer.class) {
            return Integer.parseInt(str);
        } else if(example.getClass() == Float.class) {
            return Float.parseFloat(str);
        } else if(example.getClass() == Double.class) {
            return Double.parseDouble(str);
        } else if(example.getClass() == Long.class) {
            return Long.parseLong(str);
        } else {
            return str;
        }
    }

    public Pair<Comparable, Comparable> findPKRange(String tableName, String pkName, Object pkExample) {
        Comparable start = null;
        Comparable end = null;
        OneCondition firstCond = this.conditions.get(0);
        String firstStr = isPKCondition(firstCond, tableName, pkName);
        if(firstStr != null) {
            Comparable firstVal = getComparableFromStr(firstStr, pkExample);
            Operator op = firstCond.operator;
            if(op == Operator.EQ) {
                start = firstVal;
                end = firstVal;
            } else if(op == Operator.GEQ || op == Operator.GT) {
                start = firstVal;
            } else {
                end = firstVal;
            }
        }
        int connCount = this.connections.size();
        for(int i = 0; i < connCount; ++i) {
            OneCondition cond = this.conditions.get(i+1);
            String comStr = isPKCondition(cond, tableName, pkName);
            if(comStr == null) {
                continue;
            }
            Comparable comVal = getComparableFromStr(comStr, pkExample);
            LogicConnection conn = this.connections.get(i);
            Operator op = cond.operator;
            if(conn == LogicConnection.AND) {
                if(op == Operator.EQ) {
                    if(start == null) {
                        if(end == null) {
                            start = comVal;
                            end = comVal;
                        } else {
                            if(end.compareTo(comVal) == -1) {
                                return null;
                            } else {
                                start = comVal;
                                end = comVal;
                            }
                        }
                    } else {
                        if(end == null) {
                            if(start.compareTo(comVal) == 1) {
                                return null;
                            } else {
                                start = comVal;
                                end = comVal;
                            }
                        } else {
                            if(start.compareTo(comVal) == 1 || end.compareTo(comVal) == -1) {
                                return null;
                            }
                            start = comVal;
                            end = comVal;
                        }
                    }
                } else if(op == Operator.GEQ || op == Operator.GT) {
                    if(start == null) {
                        if(end == null) {
                            start = comVal;
                        } else {
                            if(end.compareTo(comVal) == -1) {
                                return null;
                            } else {
                                start = comVal;
//                                if(op == Operator.GT && end.compareTo(comVal) == 0) {
//                                    return null;
//                                } else {
//                                    start = comVal;
//                                }
                            }
                        }
                    } else {
                        if(end == null) {
                            if(start.compareTo(comVal) == -1) {
                                start = comVal;
                            }
                        } else {
                            if(start.compareTo(comVal) == -1) {
                                if(end.compareTo(comVal) == -1) {
                                    return null;
                                } else {
                                    start = comVal;
                                }
                            }
                        }
                    }
                } else /* if(op == Operator.LEQ || op == Operator.LT) */ {
                    if(start == null) {
                        if(end == null) {
                            end = comVal;
                        } else {
                            if(end.compareTo(comVal) == 1) {
                                end = comVal;
                            }
                        }
                    } else {
                        if(end == null) {
                            if(start.compareTo(comVal) == 1) {
                                return null;
                            } else {
                                end = comVal;
                            }
                        } else {
                            if(end.compareTo(comVal) == 1) {
                                if(start.compareTo(comVal) == 1) {
                                    return null;
                                } else {
                                    end = comVal;
                                }
                            }
                        }
                    }
                }
            } else /* if (conn == LogicConnection.OR) */ {
                if(op == Operator.EQ) {
                    if(start == null) {
                        if(end != null) {
                            if(end.compareTo(comVal) == -1) {
                                end = comVal;
                            }
                        }
                    } else {
                        if(end == null) {
                            if(start.compareTo(comVal) == 1) {
                                start = comVal;
                            }
                        } else {
                            if(start.compareTo(comVal) == 1) {
                                start = comVal;
                            }
                            if(end.compareTo(comVal) == -1) {
                                end = comVal;
                            }
                        }
                    }
                } else if(op == Operator.GEQ || op == Operator.GT) {
                    if(start == null) {
                        if(end != null) {
                            end = null;
                        }
                    } else {
                        if(end == null) {
                            if(start.compareTo(comVal) == 1) {
                                start = comVal;
                            }
                        } else {
                            if(start.compareTo(comVal) == 1) {
                                start = comVal;
                            }
                            end = null;
                        }
                    }
                } else {
                    if(start == null) {
                        if(end != null) {
                            if(end.compareTo(comVal) == -1) {
                                end = comVal;
                            }
                        }
                    } else {
                        if(end == null) {
                            start = null;
                        } else {
                            if(end.compareTo(comVal) == -1) {
                                end = comVal;
                            }
                            start = null;
                        }
                    }
                }
            }
        }
        return new Pair<Comparable, Comparable>(start, end);
    }
}
