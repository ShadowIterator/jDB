public class BPlusTree extends  AbstractRecordManager{
    protected Integer order;
    protected Integer head;
    protected Integer infoPageId;
    protected BPTNode root;
    protected AbstractPager pager;
    protected SITuple.SITupleDesc desc;

    //TODO:
    public BPlusTree(Integer order, AbstractTuple.AbstractTupleDesc desc, AbstractPager pager) {

    }

    //TODO:
    public BPlusTree(AbstractPager pager, int info_page_id) {

    }

    // TODO: add it to the upper class
    AbstractTuple.AbstractTupleDesc getTupleDesc() {
        return desc;
    }

    //TODO:init()

    public BPlusTree(Integer order, SITuple.SITupleDesc desc)
    {
        this.desc = desc;
        this.order = order;
        pager = new NaivePager();
    }

    public void setRoot(BPTNode root)
    {
        this.root=root;
    }

    public Integer getOrder()
    {
        return order;
    }

    public void setHead(Integer head)
    {
        this.head = head;
    }

    public void init(String db_file_name) throws Exception
    {
        pager.open(db_file_name);
        AbstractPage infoPage = pager.newPage();
        infoPageId = infoPage.getPageID();
        Integer writePos = 0;
        byte[] infoBuffer = infoPage.getContent();
        byte[] descPart = desc.serialize();
        Integer infoLength = descPart.length;
        byte[] part = SITuple.intToBytes(infoLength);
        System.arraycopy(part, 0, infoBuffer, writePos, Integer.BYTES);
        writePos+=Integer.BYTES;
        System.arraycopy(descPart, 0, infoBuffer, writePos, infoLength);
        writePos+=infoLength;

        Class keyClass = desc.getAttr_example(desc.primary_key_id).getClass();
        Integer keyType;
        if(keyClass == Integer.class)
        {
            keyType = BPTConfig.TYPE_INT;
        }
        else if(keyClass == Double.class)
        {
            keyType = BPTConfig.TYPE_DOUBLE;
        }
        else if(keyClass == Long.class)
        {
            keyType = BPTConfig.TYPE_LONG;
        }
        else if(keyClass == Float.class)
        {
            keyType = BPTConfig.TYPE_FLOAT;
        }
        else
        {
            keyType = BPTConfig.TYPE_STR;
        }
        root = new BPTNode(true, true, keyType, pager);
        head = root.getId();
    }

    //TODO: no longer acquired
    public void open(String db_file_name) throws Exception
    {

    }

    public void close() throws Exception
    {
        pager.close();
    }

    public AbstractTuple getTuple(Comparable key) throws Exception
    {
        return root.get(key, pager, desc);
    }

    public void insertTuple(AbstractTuple tuple) throws Exception
    {
        Comparable key = (Comparable) tuple.getAttr(desc.primary_key_id);
        root.insertOrUpdate(key, tuple, this, pager, desc);
    }

    public void setTuple(Comparable key, AbstractTuple tuple) throws Exception
    {
        root.insertOrUpdate(key, tuple, this, pager, desc);
    }

    public void removeTuple(Comparable key) throws Exception
    {
        root.remove(key, this, pager, desc);
    }

    public static void main(String[] args) throws Exception
    {
        int attr_count = 2;
        Object[] attr_example = new Object[attr_count];
        String[] attr_name = new String[attr_count];
        byte[] constraint_list = new byte[attr_count];
        attr_example[0] = (int) 1;
        attr_example[1] = (double) 2.3;
        attr_name[0] = "int_value";
        attr_name[1] = "double_value";

        for(int i = 0; i < attr_count; ++i)
            constraint_list[i] = 0;
        SITuple.SITupleDesc desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list,0);

        SITuple[] tuples = new SITuple[16];
        for(int i=0; i<16; i++)
        {
            tuples[i] = new SITuple(desc);
            tuples[i].setAttr(0, i+13);
            tuples[i].setAttr(1, (double)(i*0.5));
        }

        BPlusTree testTree = new BPlusTree(3, desc);
        testTree.init("test.data");
        for(int i=0; i<10; i+=2)
        {
            testTree.insertTuple(tuples[i]);
        }
        tuples[2].setAttr(1, 1.7);
        testTree.setTuple(15, tuples[2]);
        AbstractTuple sampleTuple = testTree.getTuple(15);
        testTree.removeTuple(19);
        sampleTuple = testTree.getTuple(19);
        testTree.close();
    }

    public class Cursor extends AbstractRecordManager.AbstractCursor
    {
        int rank;

        Cursor() {
            rank = 0;
        }

        Cursor(int k)  {
            rank = k;
        }

        void moveNext() throws Exception {

        }

        void movePrev() throws Exception {

        }

        boolean setPosition(int pos) throws Exception {

            return true;
        }

        boolean isEnd() throws Exception {
            return true;
        }

        boolean isrEnd() throws Exception {
            return true;
        }


        AbstractTuple getTuple() throws Exception {
            return null;
        }
    }
}
