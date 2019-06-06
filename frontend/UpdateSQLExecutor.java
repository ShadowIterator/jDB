import javafx.util.Pair;

public class UpdateSQLExecutor extends SQLExecutor {
    private String tableName;
    private String attributeName;
    private String newValue;
    private WhereCondition whereCondition;

    public UpdateSQLExecutor(String _tableName, String _attributeName, String _newValue, WhereCondition _whereCondition) {
        this.type = sqlType.UPDATE;
        this.tableName = _tableName;
        this.attributeName = _attributeName;
        this.newValue = _newValue;
        this.whereCondition = _whereCondition;
    }

    @Override
    public void printExecutor() {
        System.out.println("Update Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
        System.out.println("\tTarget Attribute: "+this.attributeName);
        System.out.println("\tTarget New Value: "+this.newValue);
        System.out.println("\tWhere List:");
        System.out.println("\t\t"+this.whereCondition.toString());
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        if(!this.whereCondition.isLegal()) {
            return new SQLResult(-1, "Delete: Some Where Condition Error.");
        }
        try {
            BPlusTree table;
            try {
                table = mgr.getTableBPlusTreeByName(this.tableName);
            } catch (Exception e) {
                return new SQLResult(-1, "Delete: Cannot find table " + this.tableName);
            }
            AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
            int pkId = desc.getPrimary_key_id();
            int changeId;
            try {
                changeId = desc.getIDByName(this.attributeName);
            } catch (Exception e) {
                return new SQLResult(-1, "Delete: Table " + this.tableName + " does not have attribute " + this.attributeName);
            }
            Object changeExample = desc.getAttr_example(changeId);
            Object newObj;
            try {
                if (changeExample.getClass() == Integer.class) {
                    newObj = Integer.parseInt(this.newValue);
                } else if (changeExample.getClass() == Long.class) {
                    newObj = Long.parseLong(this.newValue);
                } else if (changeExample.getClass() == Float.class) {
                    newObj = Float.parseFloat(this.newValue);
                } else if (changeExample.getClass() == Double.class) {
                    newObj = Double.parseDouble(this.newValue);
                } else {
                    newObj = this.newValue;
                }
            } catch (Exception e) {
                return new SQLResult(-1, "Update: New value's type does not match the expected data type.");
            }
            BPlusTree.CursorRange crange = table.new CursorRange();
            String pkName = desc.getAttr_name(pkId);
            Object pkExample = desc.getAttr_example(pkId);
            Pair<Comparable, Comparable> pkRange = this.whereCondition.findPKRange(tableName, pkName, pkExample);
            if (pkRange == null) {
                return new SQLResult(0);
            }
            crange.setRange(pkRange.getKey(), pkRange.getValue());
            for(; !crange.isEnd(); crange.moveNext()) {
                AbstractTuple tuple = crange.getTuple();
                if(this.whereCondition.NaiveJudge(tuple, desc, mgr)) {
                    tuple.setAttr(changeId, newObj);
                    Object obj = tuple.getAttr(pkId);
                    if(pkId == changeId) {
                        table.removeTuple((Comparable)obj);
                        table.insertTuple(tuple);
                    } else {
                        table.setTuple((Comparable)obj, tuple);
                    }
                }
            }
            return new SQLResult(0);
        } catch (Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Update: " + errMsg);
        }
    }
}
