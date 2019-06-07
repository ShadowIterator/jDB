public class NaivePage extends AbstractPage {
    final static int PAGE_SIZE = 1024;//4096; // Bytes
    int page_id;
    byte[] data;
    NaivePage() {
        page_id = -1;
        data = new byte[PAGE_SIZE];
    }

    NaivePage(int page_id) {
        this.page_id = page_id;
        data = new byte[PAGE_SIZE];
    }

    byte[] getContent(){
        return data;
    }

    void setContent(byte[] content) {
        data = content;
    }

    int getPageID() {
        return page_id;
    }

    boolean setPageID(int page_id) {
        this.page_id = page_id;
        return true;
    }

    int getPAGESIZE() {
        return PAGE_SIZE;
    }
}
