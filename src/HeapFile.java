import java.io.File;
import java.util.Arrays;

public class HeapFile extends AbstractRecordManager {
    static int record_length = NaiveTuple.TUPLE_SIZE;
    static int cells_per_page = NaivePage.PAGE_SIZE / record_length;
    int tot_tuple;
    NaivePager pager;

    HeapFile() {
        tot_tuple = 0;
        pager = new NaivePager();
    }

    void init(String db_file_name) throws Exception {
        File file = new File(db_file_name);
        if(file.exists())
            file.delete();

        pager.open(db_file_name);
        NaiveTuple tuple = new NaiveTuple();
        tuple.id = 0;
        NaivePage page = (NaivePage) pager.newPage();
        byte[] b = page.getContent();
        byte[] c = tuple.serialize();
        System.arraycopy(c, 0, b, 0, record_length);
        pager.write(page);
    }

    void open(String db_file_name) throws Exception {
        pager.open(db_file_name);
        NaiveTuple tuple = (NaiveTuple) getTuple(0, 0);
        tot_tuple = tuple.id;
    }

    void close() throws Exception {
        pager.close();
    }

    boolean insertTuple(AbstractTuple tuple) throws Exception {
        if (tot_tuple % cells_per_page != 0) {
            setTuple((tot_tuple / cells_per_page) + 1, tot_tuple % cells_per_page, tuple);
        } else {
            AbstractPage page = pager.newPage();
            setTuple(page.getPageID(), 0, tuple);
        }
        ++tot_tuple;
        return true;
    }

    AbstractTuple getTupleByRank(int rank) throws Exception {
        int page_id = rank / cells_per_page;
        int cell_id = rank % cells_per_page;
        return getTuple(page_id + 1, cell_id);
    }

    AbstractTuple getTuple(int page_id, int cell_id) throws Exception {
        AbstractPage page = pager.get(page_id);
        byte[] cell = Arrays.copyOfRange(page.getContent(), cell_id * record_length, (cell_id + 1) * record_length);
        AbstractTuple tuple = new NaiveTuple();
        tuple.deSerialize(cell);
        return tuple;
    }

    boolean setTuple(int page_id, int cell_id, AbstractTuple tuple) throws Exception {
        AbstractPage page = pager.get(page_id);
        byte[] b = page.getContent();
        byte[] c = tuple.serialize();
        System.arraycopy(c, 0, b, cell_id * record_length, record_length);
        pager.write(page);
        return true;
    }

    public static void main(String[] args) throws Exception {
        HeapFile hf = new HeapFile();
        hf.init("database.temp.jDB");
        hf.close();
        hf.open("database.temp.jDB");
//        hf.insertTuple(new NaiveTuple(12, 12.4));
//        hf.insertTuple(new NaiveTuple(13, 11.4));
//        hf.insertTuple(new NaiveTuple(15, 1.4));
        for(int i = 0; i < 10000; ++i) {
            hf.insertTuple(new NaiveTuple(i, 0.12 + (i % 4)));
        }
        hf.getTupleByRank(0).print();
        hf.getTupleByRank(1).print();
        hf.getTupleByRank(2).print();

        for(HeapFile.Cursor cursor = hf.new Cursor(); !cursor.isEnd(); cursor.moveNext()){
            cursor.getTuple().print();
        }

        HeapFile.Cursor cursor = hf.new Cursor(7652);
        cursor.getTuple().print();


    }

    public class Cursor extends AbstractCursor {
        int rank;

        Cursor() {
            rank = 0;
        }

        Cursor(int k)  {
            rank = k;
        }

        void moveNext() throws Exception {
            if(rank == tot_tuple)
                rank = tot_tuple;
            ++rank;
        }

        void movePrev() throws Exception {
            if(rank == -1)
                rank = -1;
            --rank;
        }

        boolean setPosition(int pos) throws Exception {
            if(pos >= tot_tuple || pos < 0)
                return false;
            rank = pos;
            return true;
        }

        boolean isEnd() throws Exception {
            return rank == tot_tuple;
        }

        boolean isrEnd() throws Exception {
            return rank == -1;
        }


        AbstractTuple getTuple() throws Exception {
            return getTupleByRank(rank);
        }

    }
}
