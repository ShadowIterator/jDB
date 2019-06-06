import java.util.Arrays;

public class SerializeUtil {

    static int bytesToInt(byte[] b) {
        return (b[0] & 0xff) |
                (((int) b[1] & 0xff) << 8) |
                (((int) b[2] & 0xff) << 16) |
                (((int) b[3] & 0xff) << 24);
    }

    static long bytesToLong(byte[] b) {
        byte[] b_low = Arrays.copyOfRange(b, 0, 4);
        byte[] b_high = Arrays.copyOfRange(b, 4, 8);
        return ((long) bytesToInt(b_low) & 0xffffffffl) | (((long) bytesToInt(b_high) & 0xffffffffl) << 32);
    }

    static float bytesToFloat(byte[] b) {
        int float_int_value = bytesToInt(b);
        return Float.intBitsToFloat(float_int_value);
    }

    static double bytesToDouble(byte[] b) {
        long double_long_value = bytesToLong(b);
        return Double.longBitsToDouble(double_long_value);
    }

    static String bytesToString(byte[] b) {
        return new String(b);
    }

    static Object stringShrink(String str) {
        int k = str.indexOf(0);
        return (Object) str.substring(0, k >= 0? k : str.length());
    }

    static Object bytesToObject(byte[] b, Class cls) {
        Object obj;
        if (cls == Integer.class) {
            obj = bytesToInt(b);
        } else if (cls == Long.class) {
            obj = bytesToLong(b);
        } else if (cls == Float.class) {
            obj = bytesToFloat(b);
        } else if (cls == Double.class) {
            obj = bytesToDouble(b);
        } else /* if(cls == String.class) */ {
            obj = stringShrink(bytesToString(b));
        }
        return obj;
    }

    static byte[] intToBytes(int int_value) {
        byte[] b = new byte[4];
        b[0] = (byte) (int_value & 0xff);
        b[1] = (byte) ((int_value >> 8) & 0xff);
        b[2] = (byte) ((int_value >> 16) & 0xff);
        b[3] = (byte) ((int_value >> 24) & 0xff);
        return b;
    }

    static byte[] longToBytes(long long_value) {
        byte[] b = new byte[8];
        byte[] b_low = intToBytes(((int) (long_value)) & 0xffffffff);
        byte[] b_high = intToBytes(((int) (long_value >> 32)) & 0xffffffff);
        System.arraycopy(b_low, 0, b, 0, b_low.length);
        System.arraycopy(b_high, 0, b, b_low.length, b_high.length);
        return b;
    }

    static byte[] floatToBytes(float float_value) {
        int float_int_value = Float.floatToRawIntBits(float_value);
        return intToBytes(float_int_value);
    }

    static byte[] doubleToBytes(double double_value) {
        long double_long_value = Double.doubleToRawLongBits(double_value);
        return longToBytes(double_long_value);
    }

    static byte[] stringToBytes(String string_value) {
        return string_value.getBytes();
    }

    static byte[] objectToBytes(Object obj) throws Exception  {

        byte[] b;

        if (obj.getClass() == Integer.class) {
            int int_obj = (int) obj;
            b = intToBytes(int_obj);
        } else if (obj.getClass() == Long.class) {
            long long_obj = (long) obj;
            b = longToBytes(long_obj);
        } else if (obj.getClass() == Float.class) {
            float float_obj = (float) obj;
            b = floatToBytes(float_obj);
        } else if (obj.getClass() == Double.class) {
            double double_obj = (double) obj;
            b = doubleToBytes(double_obj);
        } else /* if(obj.getClass() == String.class) */ {
            String string_obj = (String) obj;
            b = stringToBytes(string_obj);
        }
        return b;
    }

}
