import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.*;

public class BPTNode {
    protected boolean isLeaf;
    protected boolean isRoot;
    protected Integer parent;
    protected Integer previous;
    protected Integer next;
    protected Integer selfPageId;
    protected Integer keyType;

    protected List<Map.Entry<Comparable, AbstractTuple>> entries;
    protected List<Integer> children;

    public BPTNode(boolean isLeaf, boolean isRoot, Integer keyType, AbstractPager pager) throws Exception
    {
        this.isLeaf=isLeaf;
        this.isRoot=isRoot;
        this.parent = -1;
        this.previous = -1;
        this.next = -1;
        this.keyType = keyType;
        entries = new ArrayList<Map.Entry<Comparable, AbstractTuple>>();
        if(!isLeaf)
        {
            children = new ArrayList<Integer>();
        }
        this.selfPageId = pager.newPage().getPageID();
    }

    public BPTNode(AbstractPager pager, AbstractTuple.AbstractTupleDesc desc, Integer pageId) throws Exception
    {
        this.selfPageId = pageId;
        AbstractPage page = pager.get(pageId);
        byte[] info = page.getContent();
        Integer readPos = 0;
//        byte[] part = Arrays.copyOfRange(info, readPos, readPos+1);
        isRoot = SerializeInplaceUtil.bytesToBoolean(info, readPos);
//        isRoot = deserializeBool(part);
        readPos++;
//        part = Arrays.copyOfRange(info, readPos, readPos+1);
//        isLeaf = deserializeBool(part);
        isLeaf = SerializeInplaceUtil.bytesToBoolean(info, readPos);
        readPos++;

        entries = new ArrayList<Map.Entry<Comparable, AbstractTuple>>();
        if(!isLeaf)
        {
            children = new ArrayList<Integer>();
        }

        Integer[] intInfo = new Integer[7];
        for(int i=0; i<7; i++)
        {
//            intInfo[i] = SerializeUtil.bytesToInt(Arrays.copyOfRange(info, readPos, readPos+Integer.BYTES));
            intInfo[i] = SerializeInplaceUtil.bytesToInt(info, readPos);
            readPos+=Integer.BYTES;
        }
        parent = intInfo[1];
        previous = intInfo[2];
        next = intInfo[3];
        keyType = intInfo[4];
        Integer keySize = intInfo[5];
        Integer keyNum = intInfo[6];
        Integer tupleSize = desc.tupleSize();
        Class keyClass = null;
        switch (keyType)
        {
            case BPTConfig.TYPE_INT:
                keyClass = Integer.class;
                break;
            case BPTConfig.TYPE_DOUBLE:
                keyClass = Double.class;
                break;
            case BPTConfig.TYPE_STR:
                keyClass = String.class;
                break;
            case BPTConfig.TYPE_LONG:
                keyClass = Long.class;
                break;
            case BPTConfig.TYPE_FLOAT:
                keyClass = Float.class;
                break;
        }
        for(int i=0; i<keyNum; i++)
        {
//            byte[] keyPart = Arrays.copyOfRange(info, readPos, readPos+keySize);
//            Comparable key = (Comparable) SerializeUtil.bytesToObject(keyPart, keyClass);
            Comparable key = (Comparable) SerializeInplaceUtil.bytesToObject(info, readPos, keySize, keyClass);
            readPos+=keySize;
            if(isLeaf)
            {
//                byte[] tuplePart = Arrays.copyOfRange(info, readPos, readPos+tupleSize);
//                readPos+=tupleSize;
                SITuple valTuple = new SITuple(desc);
                valTuple.deSerializeInplace(info, readPos, desc);
                readPos += tupleSize;
                entries.add(new AbstractMap.SimpleEntry<Comparable, AbstractTuple>(key, valTuple));
            }
            else
            {
//                byte[] childPart = Arrays.copyOfRange(info, readPos, readPos+Integer.BYTES);
                entries.add(new AbstractMap.SimpleEntry(key, null));
//                children.add(SerializeUtil.bytesToInt(childPart));
                children.add(SerializeInplaceUtil.bytesToInt(info, readPos));
                readPos += Integer.BYTES;
            }
        }
    }

    public void writeToPage(AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        AbstractPage page = pager.get(selfPageId);
        byte[] originContent = page.getContent();
        Integer keyNum = entries.size();
        Integer keySize=0;
        switch (keyType)
        {
            case BPTConfig.TYPE_INT:
                keySize = Integer.BYTES;
                break;
            case BPTConfig.TYPE_DOUBLE:
                keySize = Double.BYTES;
                break;
            case BPTConfig.TYPE_STR:
//                keySize = BPTConfig.CUNSTOMIZED_SIZE;
                String keyExample =(String) desc.getAttr_example(desc.getPrimary_key_id());
                keySize = SerializeUtil.stringToBytes(keyExample).length;
                break;
            case BPTConfig.TYPE_LONG:
                keySize = Long.BYTES;
                break;
            case BPTConfig.TYPE_FLOAT:
                keySize = Float.BYTES;
                break;
            default:
                keySize = BPTConfig.CUNSTOMIZED_SIZE;
                break;
        }
        Integer writePos = 0;

        byte[] part = serializeBool(isRoot);
//        System.arraycopy(part, 0, originContent, 0, 1);
        writePos += SerializeInplaceUtil.booleanToBytes(isRoot, originContent, writePos);
//        part = serializeBool(isLeaf);
//        System.arraycopy(part, 0, originContent, 1, 1);
        writePos += SerializeInplaceUtil.booleanToBytes(isLeaf, originContent, writePos);
        writePos = 2;
        Integer[] infoInt = {selfPageId, parent, previous, next, keyType, keySize, keyNum};
        for(int i=0; i<infoInt.length; i++)
        {
//            part = SerializeUtil.intToBytes(infoInt[i]);
//            System.arraycopy(part, 0, originContent, 2+i*Integer.BYTES, Integer.BYTES);
            writePos += SerializeInplaceUtil.objectToBytes(infoInt[i], originContent, writePos);
        }
//        Integer infoSize = 2+7*Integer.BYTES;
//        writePos = infoSize;
        Integer tupleSize = desc.tupleSize();
        if(isLeaf)
        {
            for(int i=0; i<entries.size(); i++)
            {
//                part = SerializeUtil.objectToBytes(entries.get(i).getKey());
//                System.arraycopy(part, 0, originContent, writePos, part.length);
//                writePos += keySize;
                writePos += SerializeInplaceUtil.objectToBytes(entries.get(i).getKey(), originContent, writePos);
                AbstractTuple tup = entries.get(i).getValue();
//                part = tup.serialize(desc);
//                writePos += tupleSize;
//                System.arraycopy(part, 0, originContent, writePos, tupleSize);
                tup.serializeInplace(desc, originContent, writePos);
                writePos += tupleSize;
            }
        }
        else
        {
            for(int i=0; i<entries.size(); i++)
            {
//                part = SerializeUtil.objectToBytes(entries.get(i).getKey());
//                System.arraycopy(part, 0, originContent, writePos, part.length);
//                writePos += keySize;
                writePos += SerializeInplaceUtil.objectToBytes(entries.get(i).getKey(), originContent, writePos);
//                part = SerializeUtil.objectToBytes(children.get(i));
//                System.arraycopy(part, 0, originContent, writePos, Integer.BYTES);
//                writePos += Integer.BYTES;
                writePos += SerializeInplaceUtil.objectToBytes(children.get(i), originContent, writePos);
            }
        }
        pager.write(page);
    }


    public Integer getId()
    {
        return selfPageId;
    }


    protected byte[] serializeBool(boolean ori)
    {
        byte[] res = new byte[1];
        res[0] = (byte) (ori ? 0x01 : 0x00);
        return res;
    }

    protected boolean deserializeBool(byte[] ori)
    {
        return (ori[0] != 0x00);
    }


    public Integer getPrevious()
    {
        return previous;
    }

    public void setPrevious(Integer previous)
    {
        this.previous=previous;
    }

    public Integer getNext()
    {
        return next;
    }

    public void setNext(Integer next)
    {
        this.next = next;
    }

    public boolean isLeaf()
    {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf)
    {
        this.isLeaf = isLeaf;
    }

//    public BPTNode getParent(AbstractPager pager) throws Exception
//    {
//        AbstractPage parPage = pager.get(parent);
//        BPTNode parNode = fromPage(parPage);
//        return parNode;
//    }
    public Integer getParent()
    {
        return parent;
    }

    public void setParent(Integer parent)
    {
        this.parent = parent;
    }

    public List<Map.Entry<Comparable, AbstractTuple>> getEntries()
    {
        return entries;
    }

    public void setEntries(List<Map.Entry<Comparable, AbstractTuple>> entries)
    {
        this.entries = entries;
    }

    public List<Integer> getChildren()
    {
        return children;
    }

    public void setChildren(List<BPTNode> children)
    {
//        this.children = children;
    }

    public boolean isRoot()
    {
        return this.isRoot;
    }

    public void setRoot(boolean isRoot)
    {
        this.isRoot = isRoot;
    }


    public AbstractTuple get(Comparable key, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        if(isLeaf)
        {
//            for(Map.Entry<Comparable, AbstractTuple> item:entries)
//            {
////                System.out.println("--From BPTNode: " + item.getKey() + " : " + key + " : " + item.getKey().compareTo(key));
//                if(item.getKey().compareTo(key) == 0)
//                {
//                    return item.getValue();
//                }
//            }
            int keyPos = keyPosInEntries(key);
            if(key.compareTo(entries.get(keyPos).getKey())==0)
            {
                return entries.get(keyPos).getValue();
            }
            return null;
        }
        else
        {
//            if(key.compareTo(entries.get(0).getKey()) <= 0)
//            {
//                BPTNode child = new BPTNode(pager, desc, children.get(0));
//                return child.get(key, pager, desc);
//            }
//            else if(key.compareTo(entries.get(entries.size()-1).getKey()) >= 0)
//            {
//                BPTNode child = new BPTNode(pager, desc, children.get(entries.size()-1));
//                return child.get(key, pager, desc);
//            }
//            else
//            {
//                for(int i=0; i<entries.size(); i++)
//                {
//                    if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i + 1).getKey().compareTo(key) > 0)
//                    {
//                        BPTNode child = new BPTNode(pager, desc, children.get(i));
//                        return child.get(key, pager, desc);
//                    }
//                }
//            }
            int nodePos = keyPosInEntries(key);
            BPTNode child = new BPTNode(pager, desc, children.get(nodePos));
            return child.get(key, pager, desc);
        }
    }

    public int[] getKeyPos(Comparable key, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
    // return [nodeId, keyPosInNode]
        if(isLeaf)
        {
            int[] infoRes = new int[5];
            infoRes[0] = selfPageId;
            infoRes[2] = entries.size();
            infoRes[3] = previous;
            infoRes[4] = next;
            for(int i=0; i<entries.size(); i++)
            {
                if(key.compareTo(entries.get(i).getKey())<=0)
                {
                    infoRes[1] = i;
                    return infoRes;
                }
            }
            infoRes[1] = entries.size();

            return infoRes;
        }
        else
        {
            if(key.compareTo(entries.get(0).getKey()) <= 0)
            {
                BPTNode child = new BPTNode(pager, desc, children.get(0));
                return child.getKeyPos(key, pager, desc);
            }
            else if(key.compareTo(entries.get(entries.size()-1).getKey()) >= 0)
            {
                BPTNode child = new BPTNode(pager, desc, children.get(entries.size()-1));
                return child.getKeyPos(key, pager, desc);
            }
            else
            {
                for(int i=0; i<entries.size(); i++)
                {
                    if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i + 1).getKey().compareTo(key) > 0)
                    {
                        BPTNode child = new BPTNode(pager, desc, children.get(i));
                        return child.getKeyPos(key, pager, desc);
                    }
                }
            }
        }
        return null;
    }

    protected void parentAdjust(BPlusTree tree, BPTNode left, BPTNode right, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        BPTNode parNode = null;
        if(parent>=0)
        {
            //自身不是根节点
            // BPTNode parNode = fromPage(pager.get(parent));
            parNode = new BPTNode(pager, desc, parent);
            int idInPar = parNode.getChildren().indexOf(getId());
            parNode.getChildren().remove(getId());
            left.setParent(parent);
            right.setParent(parent);
            parNode.getChildren().add(idInPar, left.getId());
            parNode.getChildren().add(idInPar+1, right.getId());
            setEntries(null);
            setChildren(null);

            setParent(-1);
        }
        else
        {
            isRoot = false;
            // BPTNode parNode = new BPTNode(false, true);
            parNode = new BPTNode(false, true, keyType, pager);
            tree.setRoot(parNode);
            left.setParent(parNode.getId());
            right.setParent(parNode.getId());
            parNode.getChildren().add(left.getId());
            parNode.getChildren().add(right.getId());
            setEntries(null);
            setChildren(null);

        }
        //新的左右节点持久化存储
        left.writeToPage(pager, desc);
        right.writeToPage(pager, desc);
        parNode.insertRelatedUpdate(tree, pager, desc);
        // 次节点已被分裂，删除该节点page
        pager.delPage(selfPageId);
    }

    public boolean insertOrUpdate(Comparable key, AbstractTuple tuple, boolean isInsert, BPlusTree tree, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
//        Integer order = tree.getOrder();
        Integer innerOrder = tree.getInnerOrder();
        Integer leafOrder = tree.getLeafOrder();
        boolean succeed = false;
        if(isLeaf)
        {
            // 叶子节点直接插入或更新
            boolean keyExisted = contain(key);
            if((!keyExisted) && isInsert)
            {
                tree.incCount();
            }
            else if(keyExisted && isInsert)
            {
                throw new Exception("Insert an existed key");
            }
            else if(!keyExisted)
            {
                throw new Exception("No tuple with matched key to update");
            }
//            if(contain(key)||entries.size()<order)
            if(contain(key)||entries.size()<leafOrder)
            {
                // 还有空间直接插入
                succeed = insertOrUpdateItem(key, tuple, pager);
                if(parent>=0)
                {
                    // BPTNode parNode = fromPage(pager.get(parent));
                    BPTNode parNode = new BPTNode(pager, desc, parent);
                    parNode.insertRelatedUpdate(tree, pager, desc);
                }
                writeToPage(pager, desc);
            }
            else
            {
                // BPTNode left = new BPTNode(true, false);
                // BPTNode right = new BPTNode(true, false);
                BPTNode left = new BPTNode(true, false, keyType, pager);
                BPTNode right = new BPTNode(true, false, keyType, pager);
                if(previous>=0)
                {
                    // BPTNode preNode = fromPage(pager.get(previous));
                    BPTNode preNode = new BPTNode(pager, desc, previous);
                    preNode.setNext(left.getId());
                    left.setPrevious(previous);

                    preNode.writeToPage(pager, desc);
                }
                if(next>=0)
                {
                    // BPTNode nextNode = fromPage(pager.get(next));
                    BPTNode nextNode = new BPTNode(pager, desc, next);
                    nextNode.setPrevious(right.getId());
                    right.setNext(next);

                    nextNode.writeToPage(pager, desc);
                }
                if(previous<0)
                {
                    tree.setHead(left.getId());
                }
                left.setNext(right.getId());
                right.setPrevious(left.getId());
                previous=-1;
                next=-1;
                // 原本数据分到两个节点中
//                Integer leftSize = (order+1)/2+(order+1)%2;
//                Integer rightSize = (order+1)/2;
                Integer leftSize = (leafOrder+1)/2+(leafOrder+1)%2;
                Integer rightSize = (leafOrder+1)/2;
                succeed = insertOrUpdateItem(key, tuple, pager);
                for(int i=0; i<leftSize; i++)
                {
                    left.getEntries().add(entries.get(i));
                }
                for(int i=0; i<rightSize; i++)
                {
                    right.getEntries().add(entries.get(leftSize+i));
                }
                parentAdjust(tree, left, right, pager, desc);
            }

        }
        else
        {
//            if(key.compareTo(entries.get(0).getKey())<=0)
//            {
//                BPTNode chNode = new BPTNode(pager, desc, children.get(0));
//                succeed = chNode.insertOrUpdate(key, tuple, isInsert, tree, pager, desc);
//            }
//            else if(key.compareTo(entries.get(entries.size()-1).getKey())>=0)
//            {
//                BPTNode chNode = new BPTNode(pager, desc, children.get(children.size()-1));
//                succeed = chNode.insertOrUpdate(key, tuple, isInsert, tree, pager, desc);
//
//            }
//            else
//            {
//                for(int i=0; i<entries.size(); i++)
//                {
//                    if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i+1).getKey().compareTo(key) > 0)
//                    {
//                        BPTNode chNode = new BPTNode(pager, desc, children.get(i));
//                        succeed = chNode.insertOrUpdate(key, tuple, isInsert, tree, pager, desc);
//
//                        break;
//                    }
//                }
//            }
            if(key.compareTo((long)1161) == 0)
            {
                System.out.println("here");
            }
            int nodePos = keyPosInEntries(key);
            BPTNode chNode = new BPTNode(pager, desc, children.get(nodePos));
            succeed = chNode.insertOrUpdate(key, tuple, isInsert, tree, pager, desc);
        }
        return succeed;
    }

    protected void insertRelatedUpdate(BPlusTree tree, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
//        Integer order = tree.getOrder();
        Integer innerOrder = tree.getInnerOrder();
        Integer leafOrder = tree.getLeafOrder();
//        validate(this, order, pager, desc);
        validate(this, innerOrder, pager, desc);

//        if(children.size()>order)
        if(children.size()>innerOrder)
        {
            // 需要分裂
            // BPTNode left = new BPTNode(true, false);
            // BPTNode right = new BPTNode(true, false);
            BPTNode left = new BPTNode(false, false, keyType, pager);
            BPTNode right = new BPTNode(false, false, keyType, pager);
//            Integer leftSize = (order+1)/2+(order+1)%2;
//            Integer rightSize = (order+1)/2;
            Integer leftSize = (innerOrder+1)/2+(innerOrder+1)%2;
            Integer rightSize = (innerOrder+1)/2;
            for(int i=0; i<leftSize; i++)
            {
                // BPTNode chNode = fromPage(pager.get(children.get(i)));
                BPTNode chNode = new BPTNode(pager, desc, children.get(i));
                left.getChildren().add(children.get(i));
                //为新的内部结点添加查找索引
                left.getEntries().add(new AbstractMap.SimpleEntry(chNode.getEntries().get(0).getKey(), null));
                chNode.setParent(left.getId());

                chNode.writeToPage(pager, desc);
            }
            for(int i=0; i<rightSize; i++)
            {
                // BPTNode chNode = fromPage(pager.get(children.get(leftSize+i)));
                BPTNode chNode = new BPTNode(pager, desc, children.get(leftSize+i));
                right.getChildren().add(children.get(leftSize+i));
                right.getEntries().add(new AbstractMap.SimpleEntry(chNode.getEntries().get(0).getKey(), null));
                chNode.setParent(right.getId());

                chNode.writeToPage(pager, desc);
            }

            parentAdjust(tree, left, right, pager, desc);
        }
    }

    protected static void validate(BPTNode node, Integer order, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        boolean entriesChanged = false;
        if(node.getEntries().size()==node.getChildren().size())
        {
            for(int i=0; i<node.getEntries().size(); i++)
            {
                // BPTNode chNode = fromPage(pager.get(node.getChildren().get(i)));
                BPTNode chNode = new BPTNode(pager, desc, node.getChildren().get(i));
                Comparable key = chNode.getEntries().get(0).getKey();
                if(node.getEntries().get(i).getKey().compareTo(key)!=0)
                {
                    node.getEntries().remove(i);
                    node.getEntries().add(i, new AbstractMap.SimpleEntry(key, null));
                    entriesChanged = true;
                }
            }
        }
        else if(node.isRoot() && node.getChildren().size()>=2
        || node.getChildren().size()>=order/2 && node.getChildren().size()<=order && node.getChildren().size()>=2)
        {
            entriesChanged = true;
            node.getEntries().clear();
            for(int i=0; i<node.getChildren().size(); i++)
            {
                // BPTNode chNode = fromPage(pager.get(node.getChildren().get(i)));
                BPTNode chNode = new BPTNode(pager, desc, node.getChildren().get(i));
                Comparable key = chNode.getEntries().get(0).getKey();
                node.getEntries().add(i, new AbstractMap.SimpleEntry(key, null));

            }
        }
        node.writeToPage(pager, desc);
        if(entriesChanged && (!node.isRoot))
        {
            // BPTNode nodePar = fromPage(pager.get(node.getParent()));
            BPTNode nodePar = new BPTNode(pager, desc, node.getParent());
            validate(nodePar, order, pager, desc);
        }
    }

    protected void removeRelatedUpdate(BPlusTree tree, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
//        Integer order = tree.getOrder();
        Integer innerOrder = tree.getInnerOrder();
//        validate(this, order, pager, desc);
        validate(this, innerOrder, pager, desc);

//        if(children.size()<order/2 || children.size()<2)
        if(children.size()<innerOrder/2 || children.size()<2)
        {
            if(isRoot)
            {
                if(children.size()>=2)
                    return;
                else
                {
                    // BPTNode root = fromPage(pager.get(children.get(0)));
                    BPTNode root = new BPTNode(pager, desc, children.get(0));
                    tree.setRoot(root);
                    root.setParent(null);
                    root.setRoot(true);
                    setEntries(null);
                    setChildren(null);

                    root.writeToPage(pager, desc);
                    pager.delPage(selfPageId);
                }
            }
            else
            {
                // BPTNode parNode = fromPage(pager.get(parent));
                BPTNode parNode = new BPTNode(pager, desc, parent);
                Integer currId = parNode.getChildren().indexOf(selfPageId);
                Integer prevId = currId - 1;
                Integer nextId = currId + 1;
                BPTNode prevNode = null, nextNode = null;
                if(prevId>=0)
                {
                    // prevNode = fromPage(pager.get(parNode.getChildren().get(prevId)));
                    prevNode = new BPTNode(pager, desc, parNode.getChildren().get(prevId));
                }
                if(nextId<parNode.getChildren().size())
                {
                    // nextNode = fromPage(pager.get(parNode.getChildren().get(nextId)));
                    nextNode = new BPTNode(pager, desc, parNode.getChildren().get(nextId));
                }

//                if(prevNode!=null && prevNode.getChildren().size()>order/2 && prevNode.getChildren().size()>2)
                if(prevNode!=null && prevNode.getChildren().size()>innerOrder/2 && prevNode.getChildren().size()>2)
                {
                    int idx = prevNode.getChildren().size()-1;
                    // BPTNode borrowed = fromPage(pager.get(prevNode.getChildren().get(idx)));
                    BPTNode borrowed = new BPTNode(pager, desc, prevNode.getChildren().get(idx));
                    prevNode.getChildren().remove(idx);
                    borrowed.setParent(selfPageId);

                    borrowed.writeToPage(pager, desc);

                    children.add(0, borrowed.getId());
//                    validate(prevNode, order, pager, desc);
//                    validate(this, order, pager, desc);
                    validate(prevNode, innerOrder, pager, desc);
                    validate(this, innerOrder, pager, desc);
                    parNode.removeRelatedUpdate(tree, pager, desc);
                }
//                else if(nextNode!=null && nextNode.getChildren().size()>order/2 && nextNode.getChildren().size()>2)
                else if(nextNode!=null && nextNode.getChildren().size()>innerOrder/2 && nextNode.getChildren().size()>2)
                {
                    // BPTNode borrowed = fromPage(pager.get(nextNode.getChildren().get(0)));
                    BPTNode borrowed = new BPTNode(pager, desc, nextNode.getChildren().get(0));
                    nextNode.getChildren().remove(0);
                    borrowed.setParent(selfPageId);

                    borrowed.writeToPage(pager, desc);

                    children.add(borrowed.getId());
//                    validate(nextNode, order, pager, desc);
//                    validate(this, order, pager, desc);
                    validate(nextNode, innerOrder, pager, desc);
                    validate(this, innerOrder, pager, desc);
                    parNode.removeRelatedUpdate(tree, pager, desc);
                }
                else
                {
//                    if(prevNode!=null && (prevNode.getChildren().size()<order/2 || prevNode.getChildren().size()<=2))
                    if(prevNode!=null && (prevNode.getChildren().size()<innerOrder/2 || prevNode.getChildren().size()<=2))
                    {
                        for(int i=prevNode.getChildren().size()-1; i>=0; i--)
                        {
                            // BPTNode child = fromPage(pager.get(prevNode.getChildren().get(i)));
                            BPTNode child = new BPTNode(pager, desc, prevNode.getChildren().get(i));
                            children.add(0, child.getId());
                            child.setParent(selfPageId);

                            child.writeToPage(pager, desc);
                        }
                        prevNode.setChildren(null);
                        prevNode.setEntries(null);
                        prevNode.setParent(null);

                        pager.delPage(prevNode.getId());

                        parNode.getChildren().remove(prevNode);
//                        validate(this, order, pager, desc);
                        validate(this, innerOrder, pager, desc);
                        parNode.removeRelatedUpdate(tree, pager, desc);
                    }
//                    else if(nextNode!=null && (nextNode.getChildren().size()<order/2 || nextNode.getChildren().size()<=2))
                    else if(nextNode!=null && (nextNode.getChildren().size()<innerOrder/2 || nextNode.getChildren().size()<=2))
                    {
                        for(int i=0; i<nextNode.getChildren().size(); i++)
                        {
                            // BPTNode child = fromPage(pager.get(nextNode.getChildren().get(i)));
                            BPTNode child = new BPTNode(pager, desc, nextNode.getChildren().get(i));
                            children.add(0, child.getId());
                            child.setParent(selfPageId);

                            child.writeToPage(pager, desc);
                        }
                        nextNode.setChildren(null);
                        nextNode.setEntries(null);
                        nextNode.setParent(null);

                        pager.delPage(nextNode.getId());

                        parNode.getChildren().remove(nextNode);
//                        validate(this, order, pager, desc);
                        validate(this, innerOrder, pager, desc);
                        parNode.removeRelatedUpdate(tree, pager, desc);
                    }
                }
            }
        }
    }

    public boolean remove(Comparable key, BPlusTree tree, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        //        Integer order = tree.getOrder();
        Integer innerOrder = tree.getInnerOrder();
        Integer leafOrder = tree.getLeafOrder();
        boolean succeed = false;
        if(isLeaf)
        {
            if(!contain(key)) {
                throw new Exception("No tuple with matched key to delete");
            }
            tree.decCount();
            if(isRoot)
            {
                return removeItem(key, pager, desc);
            }
            else
            {
                // BPTNode parNode = fromPage(pager.get(parent));
                BPTNode parNode = new BPTNode(pager, desc, parent);
//                if(entries.size()>order/2 && entries.size()>2)
                if(entries.size()>leafOrder/2 && entries.size()>2)
                {
                    succeed = removeItem(key, pager, desc);
                }
                else
                {
                    BPTNode prevNode = null;
                    BPTNode nextNode = null;
                    if(previous>=0)
                    {
                        // prevNode = fromPage(pager.get(previous));
                        prevNode = new BPTNode(pager, desc, previous);
                    }
                    if(next>=0)
                        // nextNode = fromPage(pager.get(next));
                        nextNode = new BPTNode(pager, desc, next);

//                    if(prevNode!=null && prevNode.getEntries().size()>order/2
                    if(prevNode!=null && prevNode.getEntries().size()>leafOrder/2
                    && prevNode.getEntries().size()>2 && prevNode.getParent()==parent)
                    {
                        Integer size = prevNode.getEntries().size();
                        Map.Entry<Comparable, AbstractTuple> item = prevNode.getEntries().get(size-1);
                        prevNode.getEntries().remove(size-1);
                        entries.add(0,item);
                        removeItem(key, pager, desc);

                        prevNode.writeToPage(pager, desc);
                    }
//                    else if(nextNode!=null && nextNode.getEntries().size()>order/2
                    else if(nextNode!=null && nextNode.getEntries().size()>leafOrder/2
                    && nextNode.getEntries().size()>2 && nextNode.getParent()==parent)
                    {
                        Map.Entry<Comparable, AbstractTuple> item = nextNode.getEntries().get(0);
                        nextNode.getEntries().remove(0);
                        entries.add(item);
                        removeItem(key, pager, desc);

                        nextNode.writeToPage(pager, desc);
                    }
                    else
                    {
//                        if(prevNode!=null && (prevNode.getEntries().size()<=order/2 || prevNode.getEntries().size()<=2)
                        if(prevNode!=null && (prevNode.getEntries().size()<=leafOrder/2 || prevNode.getEntries().size()<=2)
                        && prevNode.getParent()==parent)
                        {
                            for(int i=prevNode.getEntries().size()-1; i>=0; i--)
                            {
                                entries.add(0, prevNode.getEntries().get(i));
                            }
                            removeItem(key, pager, desc);
                            prevNode.setParent(-1);
                            prevNode.setEntries(null);
                            parNode.getChildren().remove(previous);
                            if(prevNode.getPrevious()>=0)
                            {
                                // 更前的Node
                                // BPTNode morePrev=fromPage(pager.get(prevNode.getPrevious()));
                                BPTNode morePrev = new BPTNode(pager, desc, prevNode.getPrevious());
                                morePrev.setNext(selfPageId);
                                prevNode.setPrevious(-1);
                                prevNode.setNext(-1);

                                morePrev.writeToPage(pager, desc);
                            }
                            else
                            {
                                tree.setHead(selfPageId);
                                prevNode.setNext(-1);
                            }
                            pager.delPage(previous);
                        }
//                        else if(nextNode!=null && (nextNode.getEntries().size()<=order/2 || nextNode.getEntries().size()<=1)
                        else if(nextNode!=null && (nextNode.getEntries().size()<=leafOrder/2 || nextNode.getEntries().size()<=1)
                        && nextNode.getParent()==parent)
                        {
                            for(int i=0; i<nextNode.getEntries().size(); i++)
                            {
                                entries.add(nextNode.getEntries().get(i));
                            }
                            removeItem(key, pager, desc);
                            nextNode.setParent(-1);
                            nextNode.setEntries(null);
                            parNode.getChildren().remove(next);
                            if(nextNode.getNext()>=0)
                            {
                                // BPTNode moreNext = fromPage(pager.get(nextNode.getNext()));
                                BPTNode moreNext = new BPTNode(pager, desc, nextNode.getNext());
                                moreNext.setPrevious(selfPageId);
                                nextNode.setPrevious(-1);
                                nextNode.setNext(-1);
                                moreNext.writeToPage(pager, desc);
                            }
                            else
                            {
                                nextNode.setPrevious(-1);
                            }
                            pager.delPage(next);
                        }
                    }
                }
                parNode.removeRelatedUpdate(tree, pager, desc);
            }
        }
        else
        {
            BPTNode child = null;
//            if(key.compareTo(entries.get(0).getKey())<=0)
//            {
//                // child = fromPage(pager.get(children.get(0)));
//                child = new BPTNode(pager, desc, children.get(0));
//                succeed = child.remove(key, tree, pager, desc);
//            }
//            else if(key.compareTo(entries.get(entries.size()-1).getKey())>=0)
//            {
//                // child = fromPage(pager.get(children.get(children.size()-1)));
//                child = new BPTNode(pager, desc, children.get(children.size()-1));
//                succeed = child.remove(key, tree, pager, desc);
//            }
//            else
//            {
//                for(int i=0; i<entries.size(); i++)
//                {
//                    if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i+1).getKey().compareTo(key) > 0)
//                    {
//                        // child = fromPage(pager.get(children.get(i)));
//                        child = new BPTNode(pager, desc, children.get(i));
//                        succeed = child.remove(key, tree, pager, desc);
//                        break;
//                    }
//                }
//            }
            int nodePos = keyPosInEntries(key);
            child = new BPTNode(pager, desc, children.get(nodePos));
            succeed = child.remove(key, tree, pager, desc);
        }
        return succeed;
    }
    protected int keyPosInEntries(Comparable key)
    {
        int endPos = entries.size();
        int startPos = 0;
        int middlePos = 0;
        while (startPos !=  endPos)
        {
            middlePos = (endPos + startPos)/2;
            if(entries.get(middlePos).getKey().compareTo(key) == 0 || endPos-startPos<=1)
            {
                break;
            }
            else if (key.compareTo(entries.get(middlePos).getKey())<0)
            {
                endPos = middlePos;
            }
            else
            {
                startPos = middlePos;
            }
        }
        return middlePos;
    }

    protected boolean insertOrUpdateItem(Comparable key, AbstractTuple info, AbstractPager pager)
    {
        Map.Entry<Comparable, AbstractTuple> toAdd = new AbstractMap.SimpleEntry<Comparable, AbstractTuple>(key, info);
        if(entries.size()==0)
        {
            entries.add(toAdd);
            return true;
        }
        int keyPos = keyPosInEntries(key);
        if(entries.get(keyPos).getKey().compareTo(key) == 0)
        {
            entries.get(keyPos).setValue(info);
        }
        else if(key.compareTo(entries.get(keyPos).getKey()) < 0)
        {
            entries.add(keyPos, toAdd);
        }
        else if(key.compareTo(entries.get(keyPos).getKey()) > 0)
        {
            entries.add(keyPos+1, toAdd);
        }
        return true;
//        for(int i=0; i<entries.size(); i++)
//        {
//            if(entries.get(i).getKey().compareTo(key)==0)
//            {
//                entries.get(i).setValue(info);
//                return true;
//            }
//            else if(entries.get(i).getKey().compareTo(key)>0)
//            {
//                entries.add(i, toAdd);
//                return true;
//            }
//        }
//        entries.add(entries.size(), toAdd);
//        return true;
    }

    public boolean removeItem(Comparable key, AbstractPager pager, AbstractTuple.AbstractTupleDesc desc) throws Exception
    {
        if(entries.size()==0)
            return false;
        Integer idx = keyPosInEntries(key);
//        for(int i=0; i<entries.size(); i++)
//        {
//            if(entries.get(i).getKey().compareTo(key)==0)
//            {
//                idx=i;
//                break;
//            }
//        }
//        if(idx!=-1)
        if(key.compareTo(entries.get(idx).getKey())==0)
        {
            entries.remove((int)idx);
            writeToPage(pager, desc);
            return true;
        }
        return false;
    }

    protected boolean contain(Comparable key)
    {
//        for (Map.Entry<Comparable, AbstractTuple> item : entries) {
//            if (item.getKey().compareTo(key) == 0) {
//                return true;
//            }
//        }
//        return false;
        if(entries.size()==0)
            return false;
        int possiblePos = keyPosInEntries(key);
        if(key.compareTo(entries.get(possiblePos).getKey())==0)
            return true;
        return false;
    }


    public static void main(String[] args) throws Exception
    {
        AbstractPager pager = new NaivePager();
        pager.open("test.data");
//        int attr_count = 2;
//        Object[] attr_example = new Object[attr_count];
//        String[] attr_name = new String[attr_count];
//        byte[] constraint_list = new byte[attr_count];
//        attr_example[0] = (int) 1;
//        attr_example[1] = (double) 3.3;
//        attr_name[0] = "int_value";
//        attr_name[1] = "double_value";
//
//        for(int i = 0; i < attr_count; ++i)
//            constraint_list[i] = 0;
//        SITuple.SITupleDesc desc = new SITuple.SITupleDesc(attr_example, attr_name, constraint_list,1);
//
//        SITuple[] tuples = new SITuple[10];
//        for(int i=0; i<10; i++)
//        {
//            tuples[i] = new SITuple(desc);
//            tuples[i].setAttr(0, i+13);
//            tuples[i].setAttr(1, (double)(i*0.5));
//        }

//        BPTNode aNode = new BPTNode(true, true, 0, pager);
//        List<Map.Entry<Comparable, AbstractTuple>> entries = new ArrayList<Map.Entry<Comparable, AbstractTuple>>();
//        for(int i=0; i<2; i++)
//        {
//            entries.add(new AbstractMap.SimpleEntry<Comparable, AbstractTuple>(i, tuples[i]));
//        }
//        aNode.setEntries(entries);
//        aNode.getEntries().add(new AbstractMap.SimpleEntry<Comparable, AbstractTuple>(3, tuples[3]));
//        aNode.writeToPage(pager, desc);
//        BPTNode bNode = new BPTNode(pager, desc, aNode.getId());
//        pager.close();
    }

}
