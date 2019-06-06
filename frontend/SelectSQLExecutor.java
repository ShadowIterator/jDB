import java.lang.reflect.Array;
import java.util.ArrayList;
import javafx.util.Pair;

public class SelectSQLExecutor extends SQLExecutor {
    private ArrayList<Pair<String, String> > attributeList;
    private TableJoin tableJoin;
    private WhereCondition whereCondition;
    private boolean isSelectAll;
    private boolean inferenced;

    public SelectSQLExecutor() {
        this.type = sqlType.SELECT;
        this.attributeList = new ArrayList<Pair<String, String> >();
        this.tableJoin = null;
        this.whereCondition = null;
        this.isSelectAll = false;
        this.inferenced = false;
    }

    public void setAttributeList(ArrayList<Pair<String, String>> attributeList) {
        this.attributeList = attributeList;
    }
    public void setTableJoin(TableJoin tableJoin) {
        this.tableJoin = tableJoin;
    }
    public void setWhereCondition(WhereCondition whereCondition) {
        this.whereCondition = whereCondition;
    }
    public void setSelectAll(boolean isAll) { this.isSelectAll = isAll; }

    @Override
    public void printExecutor() {
        System.out.println("Select Expression:");
        System.out.println("\tAttribute List:");
        for(Pair<String, String> attr: attributeList) {
            if(attr.getKey() == null) {
                System.out.println("\t\t<null>." + attr.getValue());
            } else {
                System.out.println("\t\t" + attr.getKey() + "." + attr.getValue());
            }
        }
        System.out.println("\tFrom List:");
        System.out.println("\t\t"+this.tableJoin.firstTableName);
        if(this.tableJoin.isJoin) {
            System.out.println("\t\t\tJOIN");
            System.out.println("\t\t"+this.tableJoin.secondTableName);
            if(this.tableJoin.onCondition != null) {
                System.out.println("\t\t\tON");
                System.out.println("\t\t"+this.tableJoin.onCondition.toString());
            }
        }
        if(whereCondition != null) {
            System.out.println("\tWhere List:");
            System.out.println("\t\t"+whereCondition.toString());
        }
    }

    public boolean isLegal() {
        boolean result = true;
        if(!(this.tableJoin.isSub())) {
            result &= this.tableJoin.firstTableName != null;
            if (this.tableJoin.secondTableName != null) {
                result &= this.tableJoin.onCondition != null;
                result &= this.tableJoin.onCondition.isLegal();
            }
            if (!this.isSelectAll) {
                result &= this.attributeList.size() != 0;
                for (Pair<String, String> attrPair : this.attributeList) {
                    String tableName = attrPair.getKey();
                    if (tableName != null) {
                        result &= (tableName.equals(this.tableJoin.firstTableName) || tableName.equals(this.tableJoin.secondTableName));
                    }
                }
            }
        }
        result &= this.whereCondition == null ? true : this.whereCondition.isLegal();
        return result;
    }

    public void fillInTableName(ArrayList<AbstractTuple.AbstractTupleDesc> descs, ArrayList<String> tableNames) {
        int tableNum = tableNames.size();
        int selectAttrNum = this.attributeList.size();
        for(int i = 0; i < tableNum; ++i) {
            String tableName = tableNames.get(i);
            AbstractTuple.AbstractTupleDesc desc = descs.get(i);
            for(int j = 0; j < selectAttrNum; ++j) {
                Pair<String, String> attrPair = this.attributeList.get(j);
                if(attrPair.getKey() == null) {
                    if(desc.getIDByName(attrPair.getValue()) != -1) {
                        this.attributeList.set(j, new Pair<String, String>(tableName, attrPair.getValue()));
                    }
                }
            }
        }
    }

    private SQLResult ExecSubSelect(MetadataManager mgr) throws Exception {
        SQLResult subResult = ((SubSelectTable)(this.tableJoin)).selectSQLExec.execute(mgr);
        String tmpName = ((SubSelectTable)(this.tableJoin)).tmpName;
        if(subResult.getResultType() != 1 && subResult.getResultType() != 2) {
            throw new Exception("Subquery should be a select query.");
        }
        SQLResult result = new SQLResult(1);
        int attr_count = -1;
        Object[] attr_example;
        String[] attr_name;
        byte[] constraint_list;
        int pk_id = 0;
        if(subResult.getResultType() == 1) {
            attr_count = subResult.getAttributeName().size();
        } else {
            attr_count = subResult.getAttributeName().size() + subResult.getSecondAttributeName().size();
        }
        attr_example = new Object[attr_count];
        attr_name = new String[attr_count];
        constraint_list = new byte[attr_count];
        if(subResult.getResultType() == 1) {
//            BPlusTree table = mgr.getTableBPlusTreeByName(subResult.getFirstTableName());
//            AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
            AbstractTuple.AbstractTupleDesc desc = subResult.getFirstDesc();
            ArrayList<Integer> attrIds = subResult.getAttributeId();
            int count = 0;
            for(Integer i: attrIds) {
                attr_example[count] = desc.getAttr_example(i);
                attr_name[count] = desc.getAttr_name(i);
                constraint_list[count] = desc.getAttr_constraint(i);
                if(this.isSelectAll) {
                    result.addAttributeInfo(0, desc.getAttr_name(i), count);
                }
                count += 1;
            }
        } else {
//            BPlusTree firstTable = mgr.getTableBPlusTreeByName(subResult.getFirstTableName());
//            BPlusTree secondTable = mgr.getTableBPlusTreeByName(subResult.getSecondTableName());
//            AbstractTuple.AbstractTupleDesc firstDesc = firstTable.getTupleDesc();
//            AbstractTuple.AbstractTupleDesc secondDesc = secondTable.getTupleDesc();
            AbstractTuple.AbstractTupleDesc firstDesc = subResult.getFirstDesc();
            AbstractTuple.AbstractTupleDesc secondDesc = subResult.getSecondDesc();
            ArrayList<Integer> firstAttrIds = subResult.getAttributeId();
            ArrayList<Integer> secondAttrIds = subResult.getSecondAttributeId();
            int count = 0;
            for(Integer i: firstAttrIds) {
                attr_example[count] = firstDesc.getAttr_example(i);
                attr_name[count] = firstDesc.getAttr_name(i);
                constraint_list[count] = firstDesc.getAttr_constraint(i);
                if(this.isSelectAll) {
                    result.addAttributeInfo(0, firstDesc.getAttr_name(i), count);
                }
                count += 1;
            }
            for(Integer i: secondAttrIds) {
                attr_example[count] = secondDesc.getAttr_example(i);
                attr_name[count] = secondDesc.getAttr_name(i);
                constraint_list[count] = secondDesc.getAttr_constraint(i);
                if(this.isSelectAll) {
                    result.addAttributeInfo(0, secondDesc.getAttr_name(i), count);
                }
                count += 1;
            }
        }

        if(!this.isSelectAll) {
            for(Pair<String, String> attr: this.attributeList) {
                if(attr.getKey() != null && !attr.getKey().equals(tmpName)) {
                    return new SQLResult(-1, "Select: no relation named " + attr.getValue());
                }
                for (int i = 0; i < attr_count; ++i) {
                    if (attr_name[i].equals(attr.getValue())) {
                        result.addAttributeInfo(0, attr_name[i], i);
                    }
                }
            }
        }

        AbstractTuple.AbstractTupleDesc newDesc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, pk_id);

        result.setTableName(0, tmpName);
        result.setFirstDesc(newDesc);

        int tupleCount = subResult.getTuples().size();
        ArrayList<AbstractTuple> firstTuples = subResult.getTuples();
        ArrayList<AbstractTuple> secondTuples = subResult.getSecondTuples();
        ArrayList<Integer> firstAttrIds = subResult.getAttributeId();
        ArrayList<Integer> secondAttrIds = subResult.getSecondAttributeId();
        for(int i = 0; i < tupleCount; ++i) {
            SITuple tuple = new SITuple(newDesc);
            if(subResult.getResultType() == 1) {
                AbstractTuple firstTuple = firstTuples.get(i);
                for(int j = 0; j < attr_count; ++j) {
                    tuple.setAttr(j, firstTuple.getAttr(firstAttrIds.get(j)));
                }
            } else {
                AbstractTuple firstTuple = firstTuples.get(i);
                AbstractTuple secondTuple = secondTuples.get(i);
                int firstCount = firstAttrIds.size();
                int secondCount = secondAttrIds.size();
                int j = 0;
                for(; j < firstCount; ++j) {
                    tuple.setAttr(j, firstTuple.getAttr(firstAttrIds.get(j)));
                }
                for(; j < firstCount + secondCount; ++j) {
                    tuple.setAttr(j, secondTuple.getAttr(secondAttrIds.get(j - firstCount)));
                }
            }
            if (this.whereCondition != null) {
                if (this.whereCondition.NaiveJudge(tuple, newDesc, mgr)) {
                    result.addTuple(tuple);
                }
            } else {
                result.addTuple(tuple);
            }
        }
        return result;
    }

    public SQLResult ContextExecute(ArrayList<AbstractTuple> tuples, ArrayList<AbstractTuple.AbstractTupleDesc> descs, MetadataManager mgr) throws Exception {
        if(this.tableJoin.isSub() || this.whereCondition == null) {
            return this.execute(mgr);
        }
        if(!this.inferenced) {
            if (tableJoin.secondTableName == null) {
                String tableName = this.tableJoin.firstTableName;
                BPlusTree table;
                try {
                    table = mgr.getTableBPlusTreeByName(tableName);
                } catch (Exception e) {
                    return new SQLResult(-1, "Cannot find the table " + tableName);
                }
                AbstractTuple.AbstractTupleDesc firstDesc = table.getTupleDesc();
                this.whereCondition.pureInference(tableName, firstDesc);
            } else {
                String firstTableName = this.tableJoin.firstTableName;
                String secondTableName = this.tableJoin.secondTableName;
                BPlusTree firstTable;
                try {
                    firstTable = mgr.getTableBPlusTreeByName(firstTableName);
                } catch (Exception e) {
                    return new SQLResult(-1, "Cannot find the table " + firstTableName);
                }
                BPlusTree secondTable;
                try {
                    secondTable = mgr.getTableBPlusTreeByName(secondTableName);
                } catch (Exception e) {
                    return new SQLResult(-1, "Cannot find the table " + secondTableName);
                }
                AbstractTuple.AbstractTupleDesc firstDesc = firstTable.getTupleDesc();
                AbstractTuple.AbstractTupleDesc secondDesc = secondTable.getTupleDesc();
                ArrayList<AbstractTuple.AbstractTupleDesc> _descs = new ArrayList<AbstractTuple.AbstractTupleDesc>();
                _descs.add(firstDesc);
                _descs.add(secondDesc);
                ArrayList<String> tableNames = new ArrayList<String>();
                tableNames.add(firstTableName);
                tableNames.add(secondTableName);
                this.whereCondition.pureInference(tableNames, _descs);
            }
        }
        this.inferenced = true;
        int tupleCount = tuples.size();
        for(int i = 0; i < tupleCount; ++i) {
            AbstractTuple tuple = tuples.get(i);
            AbstractTuple.AbstractTupleDesc desc = descs.get(i);
            for (OneCondition cond : this.whereCondition.conditions) {
                if (cond.leftValue.type == WhereCondition.SQLValueType.ATTRIBUTE && cond.leftValue.tableName == null) {
                    String attrName = cond.leftValue.attributeName;
                    int id = desc.getIDByName(attrName);
                    if (id == -1) {
                        return new SQLResult(-1, "No attribute named " + attrName);
                    }
                    String newValue = tuple.getAttr(id).toString();
                    cond.leftValue.isOuter = true;
                    cond.leftValue.type = WhereCondition.SQLValueType.DIRECT;
                    cond.leftValue.directValue = newValue;
                }
                if (cond.rightValue.type == WhereCondition.SQLValueType.ATTRIBUTE && cond.rightValue.tableName == null) {
                    String attrName = cond.rightValue.attributeName;
                    int id = desc.getIDByName(attrName);
                    if (id == -1) {
                        return new SQLResult(-1, "No attribute named " + attrName);
                    }
                    String newValue = tuple.getAttr(id).toString();
                    cond.rightValue.isOuter = true;
                    cond.rightValue.type = WhereCondition.SQLValueType.DIRECT;
                    cond.rightValue.directValue = newValue;
                }
            }
        }
        SQLResult result = this.execute(mgr);
        for(OneCondition cond: this.whereCondition.conditions) {
            if(cond.leftValue.isOuter = true) {
                cond.leftValue.type = WhereCondition.SQLValueType.ATTRIBUTE;
                cond.leftValue.isOuter = false;
            }
            if(cond.rightValue.isOuter = true) {
                cond.rightValue.type = WhereCondition.SQLValueType.ATTRIBUTE;
                cond.rightValue.isOuter = false;
            }
        }
        return result;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        if(!this.isLegal()) {
            return new SQLResult(-1, "Illegal Select Expression.");
        }
        try {
            if(this.tableJoin.isSub()) {
                return this.ExecSubSelect(mgr);
            } else {
                if (tableJoin.secondTableName == null) {
                    // no JOIN
                    SQLResult sqlResult = new SQLResult(1);
                    String tableName = this.tableJoin.firstTableName;
                    BPlusTree table;
                    try {
                        table = mgr.getTableBPlusTreeByName(tableName);
                    } catch (Exception e) {
                        return new SQLResult(-1, "Cannot find the table " + tableName);
                    }
                    AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
                    if (this.whereCondition != null) {
                        try {
                            this.whereCondition.inference(tableName, desc);
                        } catch (Exception e) {
                            return new SQLResult(-1, e.getMessage());
                        }
                    }

                    if (this.isSelectAll) {
                        int attrCount = desc.getAttr_count();
                        for (int i = 0; i < attrCount; ++i) {
                            sqlResult.addAttributeInfo(0, desc.getAttr_name(i), i);
                        }
                    } else {
                        for (Pair<String, String> attrPair : this.attributeList) {
                            sqlResult.addAttributeInfo(0, attrPair.getValue(), desc.getIDByName(attrPair.getValue()));
                        }
                    }
                    sqlResult.setTableName(0, tableName);
                    sqlResult.setFirstDesc(desc);

//                BPlusTree.Cursor rit = table.new Cursor();
                    BPlusTree.CursorRange crange = table.new CursorRange();
                    if (this.whereCondition != null) {
                        int pkId = desc.getPrimary_key_id();
                        String pkName = desc.getAttr_name(pkId);
                        Object pkExample = desc.getAttr_example(pkId);
                        Pair<Comparable, Comparable> pkRange = this.whereCondition.findPKRange(tableName, pkName, pkExample);
                        if (pkRange == null) {
                            return sqlResult;
                        }
                        crange.setRange(pkRange.getKey(), pkRange.getValue());
//                    if (pkRange.getKey() != null) {
//                        rit.setRange(pkRange.getKey(), pkRange.getValue());
//                    } else {
//                        rit.keyEnd = pkRange.getValue();
//                    }
                    }
//                for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
//                for(; !rit.isEnd(); rit.moveNext()) {
//                    AbstractTuple tuple = it.getTuple();
                    for (; !crange.isEnd(); crange.moveNext()) {
//                    AbstractTuple tuple = rit.getTuple();
                        AbstractTuple tuple = crange.getTuple();
                        if (this.whereCondition != null) {
                            if (this.whereCondition.NaiveJudge(tuple, desc, mgr)) {
                                sqlResult.addTuple(tuple);
                            }
                        } else {
                            sqlResult.addTuple(tuple);
                        }
                    }
                    return sqlResult;
                } else {
                    // case of JOIN..ON..
                    SQLResult sqlResult = new SQLResult(2);
                    if (this.tableJoin.joinType == 1) {
                        String tmp = this.tableJoin.firstTableName;
                        this.tableJoin.firstTableName = this.tableJoin.secondTableName;
                        this.tableJoin.secondTableName = tmp;
                    }
                    String firstTableName = this.tableJoin.firstTableName;
                    String secondTableName = this.tableJoin.secondTableName;
                    BPlusTree firstTable;
                    try {
                        firstTable = mgr.getTableBPlusTreeByName(firstTableName);
                    } catch (Exception e) {
                        return new SQLResult(-1, "Cannot find the table " + firstTableName);
                    }
                    BPlusTree secondTable;
                    try {
                        secondTable = mgr.getTableBPlusTreeByName(secondTableName);
                    } catch (Exception e) {
                        return new SQLResult(-1, "Cannot find the table " + secondTableName);
                    }
                    AbstractTuple.AbstractTupleDesc firstDesc = firstTable.getTupleDesc();
                    AbstractTuple.AbstractTupleDesc secondDesc = secondTable.getTupleDesc();
                    ArrayList<AbstractTuple.AbstractTupleDesc> descs = new ArrayList<AbstractTuple.AbstractTupleDesc>();
                    descs.add(firstDesc);
                    descs.add(secondDesc);
                    ArrayList<String> tableNames = new ArrayList<String>();
                    tableNames.add(firstTableName);
                    tableNames.add(secondTableName);

                    if (this.whereCondition != null) {
                        try {
                            this.whereCondition.inference(tableNames, descs);
                        } catch (Exception e) {
                            return new SQLResult(-1, e.getMessage());
                        }
                    }

                    this.fillInTableName(descs, tableNames);
                    sqlResult.setTableName(0, firstTableName);
                    sqlResult.setTableName(1, secondTableName);
                    if (this.isSelectAll) {
                        int firstAttrCount = firstDesc.getAttr_count();
                        int secondAttrCount = secondDesc.getAttr_count();
                        for (int i = 0; i < firstAttrCount; ++i) {
                            sqlResult.addAttributeInfo(0, firstDesc.getAttr_name(i), i);
                        }
                        for (int i = 0; i < secondAttrCount; ++i) {
                            sqlResult.addAttributeInfo(1, secondDesc.getAttr_name(i), i);
                        }
                    } else {
                        for (Pair<String, String> attrPair : this.attributeList) {
                            int tableIdx = attrPair.getKey().equals(firstTableName) ? 0 : 1;
                            sqlResult.addAttributeInfo(tableIdx, attrPair.getValue(), descs.get(tableIdx).getIDByName(attrPair.getValue()));
                        }
                    }
                    sqlResult.setFirstDesc(firstDesc);
                    sqlResult.setSecondDesc(secondDesc);

                    BPlusTree.CursorRange firstRangeIt = firstTable.new CursorRange();
                    if (this.whereCondition != null) {
                        int firstPkId = firstDesc.getPrimary_key_id();
                        String firstPkName = firstDesc.getAttr_name(firstPkId);
                        Object firstPkExample = firstDesc.getAttr_example(firstPkId);
                        Pair<Comparable, Comparable> firstPkRange = whereCondition.findPKRange(firstTableName, firstPkName, firstPkExample);
                        if (firstPkRange == null) {
                            return sqlResult;
                        }
                        firstRangeIt.setRange(firstPkRange.getKey(), firstPkRange.getValue());
                    }

                    int secondPkId = secondDesc.getPrimary_key_id();
                    String secondPkName = secondDesc.getAttr_name(secondPkId);
                    Object secondPkExample = secondDesc.getAttr_example(secondPkId);
                    Pair<Comparable, Comparable> secondPkRange = null;
                    if (this.whereCondition != null) {
                        secondPkRange = whereCondition.findPKRange(secondTableName, secondPkName, secondPkExample);
                    }

                    if (this.tableJoin.joinType == -1) {
                        for (; !firstRangeIt.isEnd(); firstRangeIt.moveNext()) {
                            BPlusTree.CursorRange secondRangeIt = secondTable.new CursorRange();
                            if (secondPkRange != null) {
                                secondRangeIt.setRange(secondPkRange.getKey(), secondPkRange.getValue());
                            }
                            for (; !secondRangeIt.isEnd(); secondRangeIt.moveNext()) {
                                ArrayList<AbstractTuple> tuples = new ArrayList<AbstractTuple>();
                                tuples.add(firstRangeIt.getTuple());
                                tuples.add(secondRangeIt.getTuple());
                                if (this.tableJoin.onCondition != null) {
                                    if (!this.tableJoin.onCondition.JoinNaiveJudge(tuples, descs, tableNames, mgr)) {
                                        continue;
                                    }
                                }
                                if (this.whereCondition != null) {
                                    if (this.whereCondition.JoinNaiveJudge(tuples, descs, tableNames, mgr)) {
                                        sqlResult.addTuple(firstRangeIt.getTuple());
                                        sqlResult.addSecondTuple(secondRangeIt.getTuple());
                                    }
                                } else {
                                    sqlResult.addTuple(firstRangeIt.getTuple());
                                    sqlResult.addSecondTuple(secondRangeIt.getTuple());
                                }
                            }
                        }
                    } else {
                        for (; !firstRangeIt.isEnd(); firstRangeIt.moveNext()) {
                            BPlusTree.CursorRange secondRangeIt = secondTable.new CursorRange();
                            if (secondPkRange != null) {
                                secondRangeIt.setRange(secondPkRange.getKey(), secondPkRange.getValue());
                            }
                            boolean hasMatch = false;
                            for (; !secondRangeIt.isEnd(); secondRangeIt.moveNext()) {
                                ArrayList<AbstractTuple> tuples = new ArrayList<AbstractTuple>();
                                tuples.add(firstRangeIt.getTuple());
                                tuples.add(secondRangeIt.getTuple());
                                if (this.tableJoin.onCondition != null) {
                                    if (!this.tableJoin.onCondition.JoinNaiveJudge(tuples, descs, tableNames, mgr)) {
                                        continue;
                                    }
                                }
                                hasMatch = true;
                                if (this.whereCondition != null) {
                                    if (this.whereCondition.JoinNaiveJudge(tuples, descs, tableNames, mgr)) {
                                        sqlResult.addTuple(firstRangeIt.getTuple());
                                        sqlResult.addSecondTuple(secondRangeIt.getTuple());
                                    }
                                } else {
                                    sqlResult.addTuple(firstRangeIt.getTuple());
                                    sqlResult.addSecondTuple(secondRangeIt.getTuple());
                                }
                            }
                            if (!hasMatch) {
                                sqlResult.addTuple(firstRangeIt.getTuple());
                                SITuple secondNullTuple = new SITuple(secondDesc);
                                int secondAttrCount = secondDesc.getAttr_count();
                                for (int i = 0; i < secondAttrCount; ++i) {
                                    secondNullTuple.setAttr(i, null);
                                }
                                sqlResult.addSecondTuple(secondNullTuple);
                            }
                        }
                    }
                    return sqlResult;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Select: " + errMsg);
        }
    }
}
