abstract public class AbstractRecordManager {

//    abstract void init() throws Exception;
//    abstract void open(String db_file_name) throws Exception;
    abstract void close() throws Exception;

//    abstract AbstractTuple getTuple(Comparable key) throws Exception;
//    abstract void insertTuple(AbstractTuple tuple) throws Exception;
//    abstract void setTuple(Comparable key, AbstractTuple tuple) throws  Exception;
//    abstract void removeTuple(Comparable key) throws Exception;

//    abstract boolean insertTuple(AbstractTuple tuple) throws Exception;
//    abstract AbstractTuple getTupleByRank(int rank) throws Exception;
//    abstract AbstractTuple getTuple(int page_id, int cell_id) throws Exception;
//    abstract boolean setTuple(int page_id, int cell_id, AbstractTuple tuple) throws Exception;

    abstract public class AbstractCursor {
        abstract void moveNext() throws Exception;
        abstract void movePrev() throws Exception;
        abstract boolean setPosition(int pos) throws Exception;
        abstract boolean isEnd() throws Exception;
        abstract boolean isrEnd() throws Exception;
        abstract AbstractTuple getTuple() throws Exception;
    }
}
