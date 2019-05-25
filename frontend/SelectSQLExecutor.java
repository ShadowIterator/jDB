import java.util.ArrayList;
import javafx.util.Pair;

public class SelectSQLExecutor extends SQLExecutor {
    private ArrayList<Pair<String, String> > attributeList;
    private TableJoin tableJoin;
    private WhereCondition whereCondition;

    public SelectSQLExecutor() {
        this.type = sqlType.SELECT;
        attributeList = null;
        tableJoin = null;
        whereCondition = null;
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
        result &= this.attributeList.size() != 0;
        result &= this.tableJoin.firstTableName != null;
        if(this.tableJoin.secondTableName != null) {
            result &= this.tableJoin.onCondition != null;
        }
        result &= this.whereCondition.isLegal();
        return result;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        if(!this.isLegal()) {
            return new SQLResult(-1, "Illegal Select Expression.");
        }
//        try {
            SQLResult sqlResult = new SQLResult(1);
            if (tableJoin.secondTableName == null) {
                String tableName = this.tableJoin.firstTableName;
                BPlusTree table = mgr.getTableBPlusTreeByName(tableName);
                AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
                for(BPlusTree.Cursor it = table.new Cursor(); !it.isEnd(); it.moveNext()) {
                    AbstractTuple tuple = it.getTuple();
                    if(this.whereCondition.NaiveJudge(tuple, desc)) {
                        sqlResult.addTuple(tuple);
                    }
                }
                return sqlResult;
            } else {
                //TODO: case of JOIN..ON
                return new SQLResult(-1, "JOIN..ON is not implemented.");
            }
//        } catch (Exception e) {
//            return new SQLResult(-1, "Some Storage Error.");
//        }
    }
}
