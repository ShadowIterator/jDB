import javafx.util.Pair;

import java.util.ArrayList;

public class SubSelectTable extends TableJoin {
    public SelectSQLExecutor selectSQLExec;
    public String tmpName;
    public SubSelectTable(SelectSQLExecutor sqlExec, String _tmpName) {
        this.selectSQLExec = sqlExec;
        this.tmpName = _tmpName;
    }

    public String secondTableName;
    public WhereCondition onCondition;
    public SubSelectTable(SelectSQLExecutor sqlExecutor, String _tmpName, String secondTable, WhereCondition whereCondition) {
        this.selectSQLExec = sqlExecutor;
        this.tmpName = _tmpName;
        this.secondTableName = secondTable;
        this.onCondition = whereCondition;
    }

    public ArrayList<SITuple> subTuples;
    public AbstractTuple.AbstractTupleDesc subDesc;

    public void inferenceSubSelect(MetadataManager mgr) throws Exception {
        if(selectSQLExec == null) {
            return;
        }
        SQLResult subResult = selectSQLExec.execute(mgr);
        if(subResult.getResultType() != 1 && subResult.getResultType() != 2) {
            throw new Exception("Subquery should be a select query.");
        }
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
                count += 1;
            }
            for(Integer i: secondAttrIds) {
                attr_example[count] = secondDesc.getAttr_example(i);
                attr_name[count] = secondDesc.getAttr_name(i);
                constraint_list[count] = secondDesc.getAttr_constraint(i);
                count += 1;
            }
        }

        AbstractTuple.AbstractTupleDesc newDesc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, pk_id);

        int tupleCount = subResult.getTuples().size();
        ArrayList<AbstractTuple> firstTuples = subResult.getTuples();
        ArrayList<AbstractTuple> secondTuples = subResult.getSecondTuples();
        ArrayList<Integer> firstAttrIds = subResult.getAttributeId();
        ArrayList<Integer> secondAttrIds = subResult.getSecondAttributeId();
        this.subTuples = new ArrayList<>();
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
            this.subTuples.add(tuple);
        }

        this.subDesc = newDesc;
    }

    @Override
    public boolean isSub() {
        return true;
    }
}
