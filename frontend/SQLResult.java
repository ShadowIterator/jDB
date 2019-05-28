import java.util.ArrayList;
import java.util.Hashtable;

// resultType:
//   -1: error
//   0: non-select
//   1: select
public class SQLResult {
    private ArrayList<AbstractTuple> tuples;

    private int resultType;
    private String resultInfo = "";

    public SQLResult(int _resultType) {
        this.resultType = _resultType;
        if(_resultType == -1) {
            this.resultInfo = "Some Unknown Error.";
            return;
        } else if(_resultType == 0) {
            return;
        }
        this.tuples = new ArrayList<AbstractTuple>();
    }
    public SQLResult(int _resultType, String _resultInfo) {
        this.resultType = _resultType;
        this.resultInfo = _resultInfo;
        if(_resultType == 0 || _resultType == -1) { return; }
        this.tuples = new ArrayList<AbstractTuple>();
    }
    public int getResultType() {
        return this.resultType;
    }
    public String getResultInfo() {
        return this.resultInfo;
    }

    public boolean addTuple(AbstractTuple tup) { return this.tuples.add(tup); }
    public ArrayList<AbstractTuple> getTuples() { return this.tuples; }

    public void print() throws Exception {
        String result = "Result Type: " + this.resultType;
        if(this.resultType == -1) {
            result += "\n" + this.resultInfo;
        }
        System.out.println(result);
        if(this.resultType == 1) {
            for(AbstractTuple tuple: this.tuples) {
                tuple.print();
            }
        }
    }
}
