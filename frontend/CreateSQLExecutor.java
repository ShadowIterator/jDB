import javax.management.Attribute;
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

    public String getNewPkName() {
        String newpk = "pkId";
        while(true) {
            boolean flag = false;
            for(AttributeMeta attr: this.attributeList) {
                if(attr.attributeName.equals(newpk)) {
                    newpk = "_" + newpk;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                break;
            }
        }
        return newpk;
    }

    @Override
    public SQLResult execute(MetadataManager mgr) throws Exception {
        int attr_count = this.attributeList.size();
        if(this.pkName == null) {
            attr_count += 1;
        }
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        int idx = 0;
        if(this.pkName == null) {
            attr_example[0] = 0;
            attr_name[0] = getNewPkName();
            constraint_list[0] = AbstractTuple.Constraints.IS_INC;
            idx = 1;
        }

        int pk_id = -1;

        for(int i = idx; i < attr_count; ++i) {
            AttributeMeta attr = this.attributeList.get(i-idx);
            if(attr.attributeName.equals(this.pkName)) {
                pk_id = i;
            }
            attr_name[i] = attr.attributeName;
            attr_example[i] = attr.getDefaultValue();
            constraint_list[i] = 0;
            if(attr.isNotNull) {
                constraint_list[i] |= AbstractTuple.Constraints.NOT_NULL;
            }
        }

        if(this.pkName != null && pk_id == -1) {
            return new SQLResult(-1, "No attribute named " + pkName);
        }
        if(this.pkName == null) {
            pk_id = 0;
        }
        try {
            SITuple.SITupleDesc table_desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list, pk_id);
            mgr.createTable(this.tableName, table_desc);
        } catch(Exception e) {
            e.printStackTrace();
            String errMsg = "Some Storage Error.";
            if(e.getMessage() != null) {
                errMsg = e.getMessage();
            }
            return new SQLResult(-1, "Create: " + errMsg);
        }

        return new SQLResult(0);
    }
}