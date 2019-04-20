public abstract class AbstractPage {
    abstract byte[] getContent();
    abstract void setContent(byte[] content);
    abstract int getPageID();
    abstract boolean setPageID(int page_id);
//    abstract byte[] serialize();
//    abstract AbstractPage deSerialize(byte[] bytes);
}
