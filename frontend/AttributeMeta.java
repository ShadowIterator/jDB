public class AttributeMeta {
    public String attributeName;
    public SQLDataType dataType;
    public Boolean isNotNull;

    public AttributeMeta(String _attributeName, SQLDataType _dataType, Boolean _isNotNull) {
        this.attributeName = _attributeName;
        this.dataType = _dataType;
        this.isNotNull = _isNotNull;
    }
}