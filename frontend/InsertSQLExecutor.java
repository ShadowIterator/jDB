import com.sun.tools.javac.file.SymbolArchive;

import java.util.ArrayList;

public class InsertSQLExecutor extends SQLExecutor {
    private String tableName;
    private ArrayList<String> attributeList;
    private ArrayList<String> valueList;

    public InsertSQLExecutor(String _tableName, ArrayList<String> _attributeList, ArrayList<String> _valueList) {
        this.type = sqlType.INSERT;
        this.tableName = _tableName;
        this.attributeList = _attributeList;
        this.valueList = _valueList;
    }

    @Override
    public void printExecutor() {
        System.out.println("Insert Expression:");
        System.out.println("\tTarget Table: "+this.tableName);
        if(this.attributeList != null) {
            System.out.println("\tTarget Attributes:");
            String attrString = "";
            for(String attr: this.attributeList) {
                attrString += (attr + ", ");
            }
            int len = attrString.length();
            attrString = attrString.substring(0, len-2);
            System.out.println("\t\t"+attrString);
        }
        System.out.println("\tValues to Insert:");
        String valueString = "";
        for(String v: this.valueList) {
            if(v == null) {
                v = "<null>";
            }
            valueString += (v + ", ");
        }
        int len = valueString.length();
        valueString = valueString.substring(0, len-2);
        System.out.println("\t\t"+valueString);
    }
}
