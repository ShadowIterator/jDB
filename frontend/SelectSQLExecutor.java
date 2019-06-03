import java.util.ArrayList;
import javafx.util.Pair;

public class SelectSQLExecutor extends SQLExecutor {
    private ArrayList<Pair<String, String> > attributeList;
    private TableJoin tableJoin;
    private WhereCondition whereCondition;
    private boolean isSelectAll;

    public SelectSQLExecutor() {
        this.type = sqlType.SELECT;
        this.attributeList = new ArrayList<Pair<String, String> >();
        this.tableJoin = null;
        this.whereCondition = null;
        this.isSelectAll = false;
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
        result &= this.tableJoin.firstTableName != null;
        if (this.tableJoin.secondTableName != null) {
            result &= this.tableJoin.onCondition != null;
            result &= this.tableJoin.onCondition.isLegal();
        }
        if(!this.isSelectAll) {
            result &= this.attributeList.size() != 0;
            for (Pair<String, String> attrPair : this.attributeList) {
                String tableName = attrPair.getKey();
                if (tableName != null) {
                    result &= (tableName.equals(this.tableJoin.firstTableName) || tableName.equals(this.tableJoin.secondTableName));
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

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        if(!this.isLegal()) {
            return new SQLResult(-1, "Illegal Select Expression.");
        }
        try {
            if (tableJoin.secondTableName == null) {
                // no JOIN
                SQLResult sqlResult = new SQLResult(1);
                String tableName = this.tableJoin.firstTableName;
                BPlusTree table;
                try {
                    table = mgr.getTableBPlusTreeByName(tableName);
                } catch(Exception e) {
                    return new SQLResult(-1, "Cannot find the table " + tableName);
                }
                AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
                for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
                    AbstractTuple tuple = it.getTuple();
                    if(this.whereCondition != null) {
                        if (this.whereCondition.NaiveJudge(tuple, desc)) {
                            sqlResult.addTuple(tuple);
                        }
                    } else {
                        sqlResult.addTuple(tuple);
                    }
                }
                if(this.isSelectAll) {
                    int attrCount = desc.getAttr_count();
                    for(int i = 0; i < attrCount; ++i) {
                        sqlResult.addAttributeInfo(0, desc.getAttr_name(i), i);
                    }
                } else {
                    for (Pair<String, String> attrPair : this.attributeList) {
                        sqlResult.addAttributeInfo(0, attrPair.getValue(), desc.getIDByName(attrPair.getValue()));
                    }
                }
                return sqlResult;
            } else {
                // case of JOIN..ON..
                SQLResult sqlResult = new SQLResult(2);
                String firstTableName = this.tableJoin.firstTableName;
                String secondTableName = this.tableJoin.secondTableName;
                BPlusTree firstTable;
                try {
                    firstTable = mgr.getTableBPlusTreeByName(firstTableName);
                } catch(Exception e) {
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
                for(BPlusTree.Cursor firstIt = firstTable.new Cursor(); !firstIt.isEnd(); firstIt.moveNext()) {
                    for(BPlusTree.Cursor secondIt = secondTable.new Cursor(); !secondIt.isEnd(); secondIt.moveNext()) {
                        ArrayList<AbstractTuple> tuples = new ArrayList<AbstractTuple>();
                        tuples.add(firstIt.getTuple());
                        tuples.add(secondIt.getTuple());
                        if(this.tableJoin.onCondition != null) {
                            if(!this.tableJoin.onCondition.JoinNaiveJudge(tuples, descs, tableNames)) {
                                continue;
                            }
                        }
                        if(this.whereCondition != null) {
                            if(this.whereCondition.JoinNaiveJudge(tuples, descs, tableNames)) {
                                sqlResult.addTuple(firstIt.getTuple());
                                sqlResult.addSecondTuple(secondIt.getTuple());
                            }
                        } else {
                            sqlResult.addTuple(firstIt.getTuple());
                            sqlResult.addSecondTuple(secondIt.getTuple());
                        }

                    }
                }
                this.fillInTableName(descs, tableNames);
                sqlResult.setTableName(0, firstTableName);
                sqlResult.setTableName(1, secondTableName);
                if(this.isSelectAll) {
                    int firstAttrCount = firstDesc.getAttr_count();
                    int secondAttrCount = secondDesc.getAttr_count();
                    for(int i = 0; i < firstAttrCount; ++i) {
                        sqlResult.addAttributeInfo(0, firstDesc.getAttr_name(i), i);
                    }
                    for(int i = 0; i < secondAttrCount; ++i) {
                        sqlResult.addAttributeInfo(1, secondDesc.getAttr_name(i), i);
                    }
                } else {
                    for (Pair<String, String> attrPair : this.attributeList) {
                        int tableIdx = attrPair.getKey().equals(firstTableName) ? 0 : 1;
                        sqlResult.addAttributeInfo(tableIdx, attrPair.getValue(), descs.get(tableIdx).getIDByName(attrPair.getValue()));
                    }
                }
                return sqlResult;
            }
        } catch (Exception e) {
            return new SQLResult(-1, "Some Storage Error.");
        }
    }
}
