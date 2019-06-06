import java.util.Arrays;

public class BPlusTree extends  AbstractRecordManager{
    protected Integer order;
    protected Integer head;
    protected Integer infoPageId;
    protected Integer count;
    protected BPTNode root;
    protected AbstractPager pager;
    protected AbstractTuple.AbstractTupleDesc desc;


    //TODO: a method returning the tot tuple number of this tree
    public int getCount() {
        return count;
    }

    public BPlusTree(Integer order, AbstractTuple.AbstractTupleDesc desc, AbstractPager pager) throws Exception
    {
        this.desc = desc;
        this.order = order;
        this.pager = pager;
        this.count = 0;
        AbstractPage infoPage = pager.newPage();
        this.infoPageId = infoPage.getPageID();
        init();
    }

    // used for hardcode meta-data bptree
    public BPlusTree(Integer order, AbstractTuple.AbstractTupleDesc desc, AbstractPager pager, Integer infoPageId) throws Exception
    {
        this.desc = desc;
        this.order = order;
        this.pager = pager;
        this.infoPageId = infoPageId;
        this.count = 0;
        init();
    }

    public BPlusTree(AbstractPager pager, int info_page_id) throws Exception
    {
        this.infoPageId = info_page_id;
        this.pager = pager;
        AbstractPage infoPage = pager.get(infoPageId);
        byte[] info = infoPage.getContent();
        Integer readPos = 0;
        Integer[] intInfo = new Integer[6];
        for(int i=0; i<intInfo.length; i++)
        {
            intInfo[i] = SITuple.bytesToInt(Arrays.copyOfRange(info, readPos, readPos+Integer.BYTES));
            readPos+=Integer.BYTES;
        }
        order = intInfo[0];
        head = intInfo[2];
        count = intInfo[4];
        Integer descLength = intInfo[5];
        desc = new SITuple.SITupleDesc();
        desc.deSerialize(Arrays.copyOfRange(info, readPos, readPos+descLength));
        this.root = new BPTNode(pager, desc, intInfo[1]);

    }

    public int getInfoPageID() {
        return infoPageId;
    }

    // TODO: add it to the upper class
    AbstractTuple.AbstractTupleDesc getTupleDesc() {
        return desc;
    }

    public BPlusTree(Integer order)
    {
        this.order = order;
        pager = new NaivePager();
    }

    public BPlusTree(Integer order, SITuple.SITupleDesc desc)
    {
        this.desc = desc;
        this.order = order;
        pager = new NaivePager();
    }

    public void setRoot(BPTNode root) throws Exception
    {
        this.root=root;

        writeInfoPage();
    }

    public Integer getOrder()
    {
        return order;
    }

    public void setHead(Integer head) throws Exception
    {
        this.head = head;
        writeInfoPage();
    }

    public void incCount()
    {
        count++;
    }

    public void decCount()
    {
        count--;
    }

    public void init() throws Exception
    {
//        AbstractPage infoPage = pager.newPage();
//        infoPageId = infoPage.getPageID();

        Class keyClass = desc.getAttr_example(desc.getPrimary_key_id()).getClass();
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
        root.writeToPage(pager, desc);
        head = root.getId();

        writeInfoPage();
    }

    public void writeInfoPage() throws Exception
    {
        AbstractPage infoPage = pager.get(infoPageId);
        Integer writePos = 0;
        byte[] infoBuffer = infoPage.getContent();
        byte[] descPart = desc.serialize();
        Integer infoLength = descPart.length;
        Integer[] infoInt = {order, root.getId(), head, infoPageId, count, infoLength};
        byte[] part;
        for(int i=0; i<infoInt.length; i++)
        {
            part = SITuple.intToBytes(infoInt[i]);
            System.arraycopy(part, 0, infoBuffer, writePos, Integer.BYTES);
            writePos+=Integer.BYTES;
        }
        System.arraycopy(descPart, 0, infoBuffer, writePos, infoLength);
        writePos+=infoLength;
        pager.write(infoPage);
    }

    public void open(Integer infoPageId) throws Exception
    {

    }

    public void close() throws Exception
    {
        writeInfoPage();
        pager.close();
    }

    public AbstractTuple getTuple(Comparable key) throws Exception
    {
        return root.get(key, pager, desc);
    }

    public boolean insertTuple(AbstractTuple tuple) throws Exception
    {
//        System.out.println("insert tuple  ");
//        tuple.print();
        Comparable key = (Comparable) tuple.getAttr(desc.getPrimary_key_id());
//<<<<<<< HEAD
        return root.insertOrUpdate(key, tuple, this, pager, desc);
//=======
//        root.insertOrUpdate(key, tuple, true,this, pager, desc);
//>>>>>>> executor
    }

    public boolean setTuple(Comparable key, AbstractTuple tuple) throws Exception
    {
//<<<<<<< HEAD
        Comparable keyInTuple = (Comparable) tuple.getAttr(desc.getPrimary_key_id());
        if(keyInTuple.compareTo(key) == 0)
            return root.insertOrUpdate(key, tuple, this, pager, desc);
        else
            return false;
//=======
//        root.insertOrUpdate(key, tuple, false, this, pager, desc);
//>>>>>>> executor
    }

    public boolean removeTuple(Comparable key) throws Exception
    {
        return root.remove(key, this, pager, desc);
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
        for(int i=0; i<10; i+=2)
        {
            testTree.insertTuple(tuples[i]);
        }
        tuples[2].setAttr(1, 1.7);
        testTree.setTuple(15, tuples[2]);
        AbstractTuple sampleTuple = testTree.getTuple(15);
        testTree.removeTuple(3);
        sampleTuple = testTree.getTuple(19);
        testTree.close();
    }

    public class Cursor extends AbstractRecordManager.AbstractCursor
    {
        Comparable keyStart;
        Comparable keyEnd;
//        BPTNode currentNode;
        Integer nodeId;
        Integer idInNode;
        Integer entryNum;
        Integer nextId;
        Integer prevId;

        Cursor() throws Exception
        {
//            currentNode = new BPTNode(pager, desc, head);
            nodeId = -1;
            nextId = -1;
            prevId = -1;
            idInNode = 0;
            entryNum = 0;
            keyStart = null;
            keyEnd = null;
        }

//        public void setRange(Comparable start, Comparable end) throws Exception
//        {
//            keyStart = start;
//            keyEnd = end;
//            int[] info = root.getKeyPos(start, pager, desc);
////            currentNode = new BPTNode(pager, desc, info[0]);
//            nodeId = info[0];
//            idInNode = info[1];
//            entryNum = info[2];
//            prevId = info[3];
//            nextId = info[4];
//        }
        public void setKey(Comparable initKey) throws Exception
        {
            int[] info = root.getKeyPos(initKey, pager, desc);
            nodeId = info[0];
            idInNode = info[1];
            entryNum = info[2];
            prevId = info[3];
            nextId = info[4];
        }

        void moveNext() throws Exception {
            if(idInNode<entryNum-1)
            {
                idInNode++;
            }
            else if(nextId>=0)
            {
                BPTNode nextNode = new BPTNode(pager, desc, nextId);
                prevId = nodeId;
                nodeId = nextId;
                nextId = nextNode.getNext();
                idInNode = 0;
                entryNum = nextNode.getEntries().size();
            }
            else
            {
                idInNode++;
            }
        }

        void movePrev() throws Exception {
            if(idInNode>0)
            {
                idInNode--;
            }
            else if(prevId>=0)
            {
                BPTNode prevNode = new BPTNode(pager, desc, prevId);
                nextId = nodeId;
                nodeId = prevId;
                prevId = prevNode.getPrevious();
                idInNode = prevNode.getEntries().size()-1;
                entryNum = prevNode.getEntries().size();
            }
            else
            {
                idInNode--;
            }
        }

        public boolean isEqual(Cursor another)
        {
            if(nodeId.intValue() == another.nodeId.intValue() && idInNode.intValue() == another.idInNode.intValue())
                return true;
            return false;
        }

        boolean isEnd() throws Exception {
            return idInNode >= entryNum && nextId < 0;
        }

        boolean isrEnd() throws Exception {
            return idInNode < 0 && prevId < 0;
        }

        AbstractTuple getTuple() throws Exception {
            BPTNode currentNode = new BPTNode(pager, desc, nodeId);
            return currentNode.getEntries().get(idInNode).getValue();
        }
    }
}
