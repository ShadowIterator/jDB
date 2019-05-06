import java.util.ArrayList;
import java.util.Hashtable;

public class SQLResult {
    private int resultType;
    private String resultInfo = "";
    private ArrayList<Integer> tupleIntList;
    private ArrayList<Long> tupleLongList;
    private ArrayList<Float> tupleFloatList;
    private ArrayList<Double> tupleDoubleList;
    private ArrayList<String> tupleStringList;
    private Hashtable<String, sqlDataType> attributes = new Hashtable<>();
    private int[] typeCount;

    public enum sqlDataType {
        INT, LONG, FLOAT, DOUBLE, STRING
    };

    public SQLResult(int _resultType) {
        this.resultType = _resultType;
        typeCount = new int[5];
        for(int i=0;i<5;++i) {
            typeCount[i] = 0;
        }
    }
    public SQLResult(int _resultType, String _resultInfo) {
        this.resultType = _resultType;
        this.resultInfo = _resultInfo;
        typeCount = new int[5];
        for(int i=0;i<5;++i) {
            typeCount[i] = 0;
        }
    }
    public int getResultType() {
        return this.resultType;
    }
    public String getResultInfo() {
        return this.resultInfo;
    }
    public boolean addInteger(Integer x) {
        return tupleIntList.add(x);
    }
    public boolean addLong(Long x) {
        return tupleLongList.add(x);
    }
    public boolean addFloat(Float x) {
        return tupleFloatList.add(x);
    }
    public boolean addDouble(Double x) {
        return tupleDoubleList.add(x);
    }
    public boolean addString(String x) {
        return tupleStringList.add(x);
    }
    public sqlDataType addAttribute(String name, sqlDataType typeID) {
        sqlDataType putResult = attributes.put(name, typeID);
        typeCount[typeID.ordinal()] += 1;
        return putResult;
    }
}
