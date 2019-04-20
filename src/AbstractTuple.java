abstract public class AbstractTuple {
    abstract byte[] serialize();
    abstract void deSerialize(byte[] b);
    void print() {
        System.out.println("please implement print first");
    }
}
