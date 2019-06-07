import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class NaivePager extends AbstractPager {
    final static int POOL_PAGE_TOT = 131072; //512MB
    final static int INFO_PAGE_NUM = 1;
    AbstractPage[] page_pool;

    private GarbagePage pager_info_page;
    private GarbagePage garbage_page;
//    private int garbage_top;

    int tot_page;
    //    String db_file_name;
    RandomAccessFile raf = null;
//    ConcurrentLinkedQueue<Integer> garbage_box;
    String file_name;

    NaivePager() {
        page_pool = new NaivePage[POOL_PAGE_TOT];
        tot_page = 0;


//        garbage_box = new ConcurrentLinkedQueue<Integer>();
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
        if(temp_lenth == 0) {
            pager_info_page = new GarbagePage(new NaivePage(-2));
//            garbage_top = -2;
            garbage_page = new GarbagePage(brandNewPage(), pager_info_page.getPageID());
            pager_info_page.push(garbage_page.getPageID());
        }
        else {
            pager_info_page = new GarbagePage(readPage_inner(-2, 0));
//            int garbage_top = pager_info_page.pop();
            garbage_page = new GarbagePage(get(pager_info_page.pop()));
        }

    }

    void close() throws Exception {
        System.out.println("close pager " + file_name);

        pager_info_page.push(garbage_page.getPageID());
        pager_info_page.flush();
        writePage_inner(pager_info_page, 0);

        garbage_page.flush();
        write(garbage_page);

        for(int i = 0; i < POOL_PAGE_TOT; ++i) {
            if(page_pool[i] != null && page_pool[i].getPageID() != -1)
                writePage(page_pool[i]);
        }

        raf.close();
    }

    AbstractPage readPage_inner(int v_page_id, int r_page_id) throws Exception {
        AbstractPage rtn = new NaivePage(v_page_id);
        long pos = r_page_id * rtn.getPAGESIZE();
        raf.seek(pos);
        raf.read(rtn.getContent());
        return rtn;
    }

    boolean writePage_inner(AbstractPage page, int r_page_id) throws Exception {
        long pos = r_page_id * page.getPAGESIZE();
        raf.seek(pos);
        raf.write(page.getContent());
        return true;
    }


    AbstractPage readPage(int page_id) throws Exception {
//        NaivePage rtn = new NaivePage(page_id);
//        long pos = page_id * rtn.PAGE_SIZE;
//        raf.seek(pos);
//        raf.read(rtn.data);
//        return rtn;
        return readPage_inner(page_id, page_id + INFO_PAGE_NUM);
    }

    boolean writePage(AbstractPage page) throws Exception {
//        long pos = page.page_id * page.PAGE_SIZE;
//        raf.seek(pos);
//        raf.write(page.data);
//        return true;
        return writePage_inner(page, page.getPageID() + INFO_PAGE_NUM);
    }

    AbstractPage get(int page_id) throws Exception {
        int index = getHash(page_id);

        if (page_pool[index] == null || page_pool[index].getPageID() < 0) {
            page_pool[index] = readPage(page_id);
            return page_pool[index];
        } else if (page_pool[index].getPageID() == page_id) {
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
            if(page_pool[i] != null && page_pool[i].getPageID() != -1)
                writePage(page_pool[i]);
        }
    }

    boolean write(AbstractPage page) throws Exception {
//        return true;
//        NaivePage np = (NaivePage) page;
        int index = getHash(page.getPageID());
        if (page_pool[index] == null || page_pool[index].getPageID() == page.getPageID() || page_pool[index].getPageID() == -1)
            page_pool[index] = page;
        else writePage(page);
        return true;
    }

    private AbstractPage brandNewPage() throws Exception {
        NaivePage page;
        return new NaivePage(tot_page++);
    }

    AbstractPage newPage() throws Exception {
        NaivePage page;
        int unused_page_number = garbage_page.pop();
        if(unused_page_number >= 0) {
            page = new NaivePage(unused_page_number);
        }
        else {
            if(garbage_page.getPrev_page_id() >= 0) {
                page = new NaivePage(garbage_page.getPageID());
                garbage_page = new GarbagePage(get(garbage_page.getPrev_page_id()));
            }
            else {
                page = new NaivePage(tot_page++);
            }
        }
        write(page);
        return page;
//        page = new NaivePage(tot_page);
//        tot_page += 1;
//        writePage(page);
//        write(page);
    }

    boolean delPage(int page_id) throws Exception {
        int res = garbage_page.push(page_id);

        if(res <0) {
            garbage_page.flush();
            write(garbage_page);
            GarbagePage n_garbage_page = new GarbagePage(get(page_id), garbage_page.getPageID());
            garbage_page = n_garbage_page;
        }
        else {
            int index = getHash(page_id);
            if (page_pool[index] != null && page_pool[index].getPageID() == page_id)
                page_pool[index] = null;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String str1 = "hello_1";
        String str2 = "hello_2";
        NaivePager pager = new NaivePager();
        pager.open("hello.txt");
        int ELE_NUM = 10000;
        boolean[] used = new boolean[ELE_NUM * 2];
        for(int i = 0; i < used.length; ++i)
            used[i] = false;
        for(int i = 1 ; i < ELE_NUM/9; ++i) {
//            NaivePage page = (NaivePage) pager.newPage();
//            System.out.println("new page: " + page.getPageID());
//            Arrays.fill(page.getContent(), (byte) 1);
//            pager.delPage(i);
        }


        for(int i = 0; i < ELE_NUM / 14; ++i) {
            NaivePage page = (NaivePage) pager.newPage();
            System.out.println("new page: " + page.getPageID());
            Arrays.fill(page.getContent(), (byte) 1);

        }

        pager.close();

//        NaivePage page1 = (NaivePage) pager.newPage();
//        NaivePage page2 = (NaivePage) pager.newPage();
//        pager.newPage();
//        for(int i = 1; i<=10000; ++i)
//            pager.newPage();
//        pager.delPage(23);
//        pager.delPage(24);
//        pager.delPage(44);
//        for(int i = 100; i <= 2000; ++i) {
//            pager.delPage(i * 2);
//        }
//        NaivePage npage = (NaivePage) pager.newPage();
//
//        NaivePage page = (NaivePage) pager.get(1);
//        page.data = str1.getBytes();
//        pager.write(page);
//        pager.close();
//
//        int[] a = new int[10];
//        int[] b = Arrays.copyOfRange(a, 4, 7);
//        b[2] = 3;
////        System.out.println(a.length);
////        System.out.println(b.length);
//        for(int i = 0; i < a.length; ++i) {
//            System.out.print(a[i]);
//        }
//        System.out.println('\n');
//        for(int i = 0; i < b.length; ++i) {
//            System.out.print(b[i]);
//        }

//        String file_prefix = "test-doc\\sql-gen\\";
//        String file_name = file_prefix + "test_100.schema";
//        String out_file_name = file_name + ".result";
//        PrintStream ps=new PrintStream(new FileOutputStream(out_file_name));
//        System.setOut(ps);
//
//        File file = new File(file_name);
//        InputStreamReader inputreader= new InputStreamReader(new FileInputStream(file));
//        BufferedReader bf = new BufferedReader(inputreader);
//        String cmd;
//        try {
//            ArrayList<SQLResult> sqlResults = client.query(sql);
//            for (SQLResult sqlResult : sqlResults) {
//                sqlResult.print();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        while((cmd = bf.readLine()) != null) {
////            System.out.println("\n" + sql + ": ");
//            ArrayList<SQLResult> sqlResults = client.query(sql);
//            for(SQLResult res : sqlResults) {
//                res.print();
//            }
//        }



    }

}