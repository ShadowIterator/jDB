import java.util.ArrayList;

public class NotExistCondition extends OneCondition {
    public boolean isExist;
    public SelectSQLExecutor selectSQLExec;

    public NotExistCondition(SelectSQLExecutor selectExec, boolean isExist) {
        this.isExist = isExist;
        this.selectSQLExec = selectExec;
    }

    @Override
    public boolean isNotExist() {
        return true;
    }

    @Override
    public boolean isLegal() {
        return this.selectSQLExec.isLegal();
    }

    public boolean JudgeCondition(ArrayList<AbstractTuple> tuples, ArrayList<AbstractTuple.AbstractTupleDesc> descs, MetadataManager mgr) throws Exception {
        SQLResult subResult = this.selectSQLExec.ContextExecute(tuples, descs, mgr);
        if(subResult.getResultType() == -1) {
            throw new Exception(subResult.getResultInfo());
        }
        if(subResult.getResultType() != 1 && subResult.getResultType() != 2) {
            throw new Exception("Subquery should be a select query.");
        }
        if(this.isExist) {
            return subResult.getTuples().size() != 0;
        } else {
            return subResult.getTuples().size() == 0;
        }
    }
}
