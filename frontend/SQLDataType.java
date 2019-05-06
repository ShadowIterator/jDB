public class SQLDataType {
    public enum Type {
        INT("INT"), LONG("LONG"), FLOAT("FLOAT"), DOUBLE("DOUBLE"), STRING("STRING");
        private String name;
        Type(String name) {
            this.name = name;
        }
    }
    public int length;
    public Type type;
    public SQLDataType(int _length, Type _type) {
        this.length = _length;
        this.type = _type;
    }
}