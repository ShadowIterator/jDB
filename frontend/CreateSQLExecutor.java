import java.util.ArrayList;

public class CreateSQLExecutor extends SQLExecutor {
    private String tableName;
    private ArrayList<AttributeMeta> attributeList;
    private String pkName;

    public CreateSQLExecutor(String _tableName, ArrayList<AttributeMeta> _attributeList, String _pkName) {
        this.type = sqlType.CREATE;
        this.tableName = _tableName;
        this.attributeList = _attributeList;
        this.pkName = _pkName;
    }

    @Override
    public void printExecutor() {
        System.out.println("Create Expression:");
        System.out.println("\tNew Table Name: "+this.tableName);
        System.out.println("\tAttribute List:");
        for(AttributeMeta attr: this.attributeList) {
            String attrString = "\t\t" + attr.attributeName + " ";
            attrString += attr.dataType.type.toString();
            if(attr.dataType.type == SQLDataType.Type.STRING) {
                attrString += ("("+attr.dataType.length+")");
            }
            if(attr.isNotNull) {
                attrString += " not null";
            }
            System.out.println(attrString);
        }
        if(this.pkName != null) {
            System.out.println("\tPrimary Key: "+this.pkName);
        }
    }
}