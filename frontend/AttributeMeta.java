import java.util.Arrays;

public class AttributeMeta {
    public String attributeName;
    public SQLDataType dataType;
    public Boolean isNotNull;

    public AttributeMeta(String _attributeName, SQLDataType _dataType, Boolean _isNotNull) {
        this.attributeName = _attributeName;
        this.dataType = _dataType;
        this.isNotNull = _isNotNull;
    }

    public Object getDefaultValue() {
        if(this.dataType.type == SQLDataType.Type.INT) {
            return (int)0;
        } else if(this.dataType.type == SQLDataType.Type.STRING) {
            char[] charArray = new char[this.dataType.length];
            Arrays.fill(charArray, '-');
            return new String(charArray);
        } else if(this.dataType.type == SQLDataType.Type.DOUBLE) {
            return (double)0;
        } else if(this.dataType.type == SQLDataType.Type.FLOAT) {
            return (float)0;
        } else if(this.dataType.type == SQLDataType.Type.LONG) {
            return (long)0;
        } else {
            return (int)-1;
        }
    }
}