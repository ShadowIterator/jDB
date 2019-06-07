public class GarbagePage extends NaivePage{

    int prev_page_id;
    int current_cell_id;
    int cell_capacity;


    GarbagePage(AbstractPage page, int t_prev_page_id) {
        this.prev_page_id = t_prev_page_id;
        this.current_cell_id = 0;
        initAbstractPage(page);
    }

    GarbagePage(AbstractPage page) {
        fromAbstractPage(page);
    }

    void fromAbstractPage(AbstractPage page) {
        this.cell_capacity = page.getPAGESIZE() - 12;
        this.data = page.getContent();
        this.page_id = page.getPageID();
        this.prev_page_id = SerializeInplaceUtil.bytesToInt(data, cell_capacity + 4);
        this.current_cell_id = SerializeInplaceUtil.bytesToInt(data, cell_capacity + 8);
    }

    void initAbstractPage(AbstractPage page) {
        this.cell_capacity = page.getPAGESIZE() - 12;
        this.data = page.getContent();
        this.page_id = page.getPageID();
    }

//
//    void init() {
//
//    }

    boolean empty() {
        return current_cell_id == 0;
    }

    boolean full() {
        return current_cell_id == cell_capacity;
    }

    int pop() {
        if(empty())
            return -1;
        current_cell_id -= 4;
        return SerializeInplaceUtil.bytesToInt(data, current_cell_id);
    }

    int push(int garbage_page_id) {
        if(full())
            return -1;
        SerializeInplaceUtil.intToBytes(garbage_page_id, data, current_cell_id);
        return current_cell_id = current_cell_id + 4;
    }

    void flush() {
        SerializeInplaceUtil.intToBytes(prev_page_id, data, cell_capacity + 4);
        SerializeInplaceUtil.intToBytes(current_cell_id, data, cell_capacity + 8);
    }

    int getPrev_page_id() {
        return prev_page_id;
    }

}
