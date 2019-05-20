import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test {


    static boolean wtf(Comparable a, Comparable b)
    {
        if(a.compareTo(b)<=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) throws Exception
    {
        String a = "c";
        String b = "bgh";
//        boolean c = wtf(a,b);
//        System.out.println(c);
        AbstractMap.SimpleEntry x = new AbstractMap.SimpleEntry(a,b);
        System.out.println(x);
    }
}
