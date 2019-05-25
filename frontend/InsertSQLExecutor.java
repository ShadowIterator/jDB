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

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        try {
            BPlusTree table = mgr.getTableBPlusTreeByName(this.tableName);
            AbstractTuple.AbstractTupleDesc desc = table.getTupleDesc();
            SITuple tuple = new SITuple(desc);
            //TODO: constraint check
            if(this.attributeList == null || (this.attributeList != null && this.attributeList.size() == 0)) {
                if(this.valueList.size() != desc.getAttr_count()) {
                    return new SQLResult(-1, "Not enough value provided.");
                }
                int valueSize = this.valueList.size();
                for(int i = 0; i < valueSize; ++i) {
                    Object obj = desc.getAttr_example(i);
                    String value = this.valueList.get(i);
                    if (obj.getClass() == Integer.class) {
                        try {
                            int intValue = Integer.parseInt(value);
                            tuple.setAttr(i, intValue);
                        } catch(Exception e) {
                            return new SQLResult(-1, "The "+i+"th value's type is wrong. Expecting INT.");
                        }
                    } else if (obj.getClass() == Long.class) {
                        try {
                            long longValue = Long.parseLong(value);
                            tuple.setAttr(i, longValue);
                        } catch(Exception e) {
                            return new SQLResult(-1, "The "+i+"th value's type is wrong. Expecting LONG.");
                        }
                    } else if (obj.getClass() == Float.class) {
                        try{
                            float floatValue = Float.parseFloat(value);
                            tuple.setAttr(i, floatValue);
                        } catch(Exception e) {
                            return new SQLResult(-1, "The "+i+"th value's type is wrong. Expecting FLOAT.");
                        }
                    } else if (obj.getClass() == Double.class) {
                        try {
                            double doubleValue = Double.parseDouble(value);
                            tuple.setAttr(i, doubleValue);
                        } catch(Exception e) {
                            return new SQLResult(-1, "The "+i+"th value's type is wrong. Expecting DOUBLE.");
                        }
                    } else /* if(obj.getClass() == String.class) */ {
                        tuple.setAttr(i, value);
                    }
                }
                table.insertTuple(tuple);
            } else {
                //TODO: specify attributeList
                if(this.attributeList.size() != this.valueList.size()) {
                    return new SQLResult(-1, "Attribute list size does not match value list size.");
                }
                return new SQLResult(-1, "Specify attributeList is not implemented.");
            }
            return new SQLResult(0);
        } catch (Exception e) {
            return new SQLResult(-1, "Some Storage Error.");
        }
    }
}
