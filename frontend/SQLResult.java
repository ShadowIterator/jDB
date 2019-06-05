import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

// resultType:
//  -2: parse error
//  -1: error
//   0: non-select
//   1: select
//   2: join on
public class SQLResult implements Serializable {
    private ArrayList<AbstractTuple> tuples;
    private ArrayList<AbstractTuple> secondTuples;
    private ArrayList<String> attributeName;
    private ArrayList<Integer> attributeId;
    private ArrayList<String> secondAttributeName;
    private ArrayList<Integer> secondAttributeId;
    private String firstTableName;
    private String secondTableName;

    private int resultType;
    private String resultInfo = "";

    private double costTime;

    public SQLResult(int _resultType) {
        this.resultType = _resultType;
        if(_resultType == -1) {
            this.resultInfo = "Some Unknown Error.";
            return;
        } else if(_resultType == 0) {
            return;
        } else if(_resultType == -2) {
            this.resultInfo = "Some Parse Error.";
        }
        this.tuples = new ArrayList<AbstractTuple>();
        this.attributeName = new ArrayList<String>();
        this.attributeId = new ArrayList<Integer>();
        if(_resultType == 2) {
            this.secondTuples = new ArrayList<AbstractTuple>();
            this.secondAttributeId = new ArrayList<Integer>();
            this.secondAttributeName = new ArrayList<String>();
        }
    }
    public SQLResult(int _resultType, String _resultInfo) {
        this.resultType = _resultType;
        this.resultInfo = _resultInfo;
        if(_resultType == 0 || _resultType == -1 || _resultType == -2) { return; }
        this.tuples = new ArrayList<AbstractTuple>();
        this.attributeName = new ArrayList<String>();
        this.attributeId = new ArrayList<Integer>();
        if(_resultType == 2) {
            this.secondTuples = new ArrayList<AbstractTuple>();
            this.secondAttributeId = new ArrayList<Integer>();
            this.secondAttributeName = new ArrayList<String>();
        }
    }

    public int getResultType() {
        return this.resultType;
    }
    public String getResultInfo() {
        return this.resultInfo;
    }

    public void addAttributeInfo(int which, String name, Integer id) {
        if(which == 0) {
            this.attributeName.add(name);
            this.attributeId.add(id);
        } else if(which == 1) {
            this.secondAttributeName.add(name);
            this.secondAttributeId.add(id);
        }
    }

    public void setTableName(int which, String name) {
        if(which == 0) {
            this.firstTableName = name;
        } else if(which == 1) {
            this.secondTableName = name;
        }
    }

    public boolean addTuple(AbstractTuple tup) { return this.tuples.add(tup); }
    public boolean addSecondTuple(AbstractTuple tup) { return this.secondTuples.add(tup); }

    public ArrayList<AbstractTuple> getTuples() { return this.tuples; }
    public ArrayList<AbstractTuple> getSecondTuples() { return this.secondTuples; }
    public ArrayList<String> getAttributeName() { return this.attributeName; }
    public ArrayList<String> getSecondAttributeName() { return this.secondAttributeName; }
    public String getFirstTableName() { return this.firstTableName; }
    public String getSecondTableName() { return this.secondTableName; }
    public ArrayList<Integer> getAttributeId() { return this.attributeId; }
    public ArrayList<Integer> getSecondAttributeId() { return this.secondAttributeId; }

    public void setCostTime(double time) { this.costTime = time; }
    public double getCostTime() { return this.costTime; }

    private static void printResultTuple(AbstractTuple tuple, ArrayList<Integer> ids) {
        for(int id: ids) {
            System.out.print(tuple.getAttr(id));
            System.out.print("\t");
        }
    }

    public void print() throws Exception {
//        System.out.println(" ");
        String result = "Result Type: " + this.resultType;
        if(this.resultType == -1 || this.resultType == -2) {
            result += "\n" + this.resultInfo;
        }

        System.out.println(result);
        if(this.resultType == 1) {
            for(String attrName: this.attributeName) {
                System.out.print(attrName + "\t");
            }
            System.out.print("\n");
            for(AbstractTuple tuple: this.tuples) {
                this.printResultTuple(tuple, this.attributeId);
                System.out.print("\n");
            }
        } else if(this.resultType == 2) {
            for(String attrName: this.attributeName) {
                System.out.print(this.firstTableName + "." + attrName + "\t");
            }
            for(String attrName: this.secondAttributeName) {
                System.out.print(this.secondTableName + "." + attrName + "\t");
            }
            System.out.print("\n");
            int tupleNum = this.tuples.size();
            for(int i = 0; i < tupleNum; ++i) {
                AbstractTuple firstTuple = this.tuples.get(i);
                AbstractTuple secondTuple = this.secondTuples.get(i);
                this.printResultTuple(firstTuple, this.attributeId);
                this.printResultTuple(secondTuple, this.secondAttributeId);
                System.out.print("\n");
            }
        }
    }
}
