import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class NaivePager extends AbstractPager {
    final static int POOL_PAGE_TOT = 1024;
    NaivePage[] page_pool;
    int tot_page;
    //    String db_file_name;
    RandomAccessFile raf = null;
    ConcurrentLinkedQueue<Integer> garbage_box;
    String file_name;

    NaivePager() {
        page_pool = new NaivePage[POOL_PAGE_TOT];
        tot_page = 0;
        garbage_box = new ConcurrentLinkedQueue<Integer>();
    }

    int getHash(int k) {
        return k % POOL_PAGE_TOT;
    }

    void open(String db_file_name) throws Exception {
//        this.db_file_name = db_file_name;
        raf = new RandomAccessFile(db_file_name, "rw");
        long temp_lenth = raf.length();
        tot_page = (int) (raf.length() / NaivePage.PAGE_SIZE);
        file_name = db_file_name;
    }

    void close() throws Exception {
        System.out.println("close pager " + file_name);

        for(int i = 0; i < POOL_PAGE_TOT; ++i) {
            if(page_pool[i] != null && page_pool[i].page_id != -1)
                writePage(page_pool[i]);
        }
        raf.close();
    }

    NaivePage readPage(int page_id) throws Exception {
        NaivePage rtn = new NaivePage(page_id);
        long pos = page_id * rtn.PAGE_SIZE;
        raf.seek(pos);
        raf.read(rtn.data);
        return rtn;
    }

    boolean writePage(NaivePage page) throws Exception {
        long pos = page.page_id * page.PAGE_SIZE;
        raf.seek(pos);
        raf.write(page.data);
        return true;
    }

    NaivePage get(int page_id) throws Exception {
        int index = getHash(page_id);

        if (page_pool[index] == null || page_pool[index].page_id < 0) {
            page_pool[index] = readPage(page_id);
            return page_pool[index];
        } else if (page_pool[index].page_id == page_id) {
            return page_pool[index];
        } else {
            writePage(page_pool[index]);
            return page_pool[index] = readPage(page_id);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("final close pager " + file_name);
        for(int i = 0; i < POOL_PAGE_TOT; ++i) {
            if(page_pool[i] != null && page_pool[i].page_id != -1)
                writePage(page_pool[i]);
        }
    }

    boolean write(AbstractPage page) throws Exception {
//        return true;
        NaivePage np = (NaivePage) page;
        int index = getHash(np.page_id);
        if (page_pool[index] == null || page_pool[index].page_id == np.page_id || page_pool[index].page_id == -1)
            page_pool[index] = np;
        else writePage(np);
        return true;
    }

    AbstractPage newPage() throws Exception {
        NaivePage page;
        if(!garbage_box.isEmpty()) {
            page = new NaivePage(garbage_box.poll());
        }
        else {
            page = new NaivePage(tot_page);
            tot_page += 1;
        }
        writePage(page);
        write(page);
        return page;
    }

    boolean delPage(int page_id) throws Exception {
//        return true;
        garbage_box.offer(page_id);
        int index = getHash(page_id);
        if(page_pool[index] != null && page_pool[index].page_id == page_id)
            page_pool[index] = null;
        return true;
    }

    public static void main(String[] args) throws Exception {
        String str1 = "hello_1";
        String str2 = "hello_2";
        NaivePager pager = new NaivePager();
        pager.open("hello.txt");
//        NaivePage page1 = (NaivePage) pager.newPage();
//        NaivePage page2 = (NaivePage) pager.newPage();
        NaivePage page = pager.get(1);
        page.data = str2.getBytes();
        pager.write(page);
        pager.close();
    }

}