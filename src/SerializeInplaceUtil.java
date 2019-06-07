public class SerializeInplaceUtil {

    static int bytesToInt(byte[] b, int index) {
        return (b[0 + index] & 0xff) |
                (((int) b[1 + index] & 0xff) << 8) |
                (((int) b[2 + index] & 0xff) << 16) |
                (((int) b[3 + index] & 0xff) << 24);
    }

    static long bytesToLong(byte[] b, int index) {
//        byte[] b_low = Arrays.copyOfRange(b, 0, 4);
//        byte[] b_high = Arrays.copyOfRange(b, 4, 8);
        return ((long) bytesToInt(b, index) & 0xffffffffl) | (((long) bytesToInt(b, index + 4) & 0xffffffffl) << 32);
    }

    static float bytesToFloat(byte[] b, int index) {
        int float_int_value = bytesToInt(b, index);
        return Float.intBitsToFloat(float_int_value);
    }

    static double bytesToDouble(byte[] b, int index) {
        long double_long_value = bytesToLong(b, index);
        return Double.longBitsToDouble(double_long_value);
    }

    static String bytesToString(byte[] b, int index, int length) {
        return new String(b, index, length);
    }

    static Object stringShrink(String str) {
        int k = str.indexOf(0);
        return (Object) str.substring(0, k >= 0? k : str.length());
    }

    static Object bytesToObject(byte[] b, int index, int length, Class cls) {
        Object obj;
        if (cls == Integer.class) {
            obj = bytesToInt(b, index);
        } else if (cls == Long.class) {
            obj = bytesToLong(b, index);
        } else if (cls == Float.class) {
            obj = bytesToFloat(b, index);
        } else if (cls == Double.class) {
            obj = bytesToDouble(b, index);
        } else /* if(cls == String.class) */ {
            obj = stringShrink(bytesToString(b, index, length));
        }
        return obj;
    }

    static void intToBytes(int int_value, byte[] dest, int index) {
//        byte[] b = new byte[4];
        dest[index + 0] = (byte) (int_value & 0xff);
        dest[index + 1] = (byte) ((int_value >> 8) & 0xff);
        dest[index + 2] = (byte) ((int_value >> 16) & 0xff);
        dest[index + 3] = (byte) ((int_value >> 24) & 0xff);
//        return b;
    }

    static void longToBytes(long long_value, byte[] dest, int index) {
//        byte[] b = new byte[8];
//        byte[] b_low = intToBytes(((int) (long_value)) & 0xffffffff);
//        byte[] b_high = intToBytes(((int) (long_value >> 32)) & 0xffffffff);
//        System.arraycopy(b_low, 0, b, 0, b_low.length);
//        System.arraycopy(b_high, 0, b, b_low.length, b_high.length);
//        return b;
        intToBytes(((int) (long_value)) & 0xffffffff, dest, index);
        intToBytes(((int) (long_value >> 32)) & 0xffffffff, dest, index + 4);
    }

    static void floatToBytes(float float_value, byte[] dest, int index) {
        int float_int_value = Float.floatToRawIntBits(float_value);
        intToBytes(float_int_value, dest, index);
    }

    static void doubleToBytes(double double_value, byte[] dest, int index) {
        long double_long_value = Double.doubleToRawLongBits(double_value);
        longToBytes(double_long_value, dest, index);
    }

    static void stringToBytes(String string_value, byte[] dest, int index) {
        byte[] b = string_value.getBytes();
        System.arraycopy(b, 0, dest, index, b.length);
    }

    static void objectToBytes(Object obj,byte[] dest, int index) throws Exception  {


        if (obj.getClass() == Integer.class) {
            int int_obj = (int) obj;
            intToBytes(int_obj, dest, index);
        } else if (obj.getClass() == Long.class) {
            long long_obj = (long) obj;
            longToBytes(long_obj, dest, index);
        } else if (obj.getClass() == Float.class) {
            float float_obj = (float) obj;
            floatToBytes(float_obj, dest, index);
        } else if (obj.getClass() == Double.class) {
            double double_obj = (double) obj;
            doubleToBytes(double_obj, dest, index);
        } else /* if(obj.getClass() == String.class) */ {
            String string_obj = (String) obj;
            stringToBytes(string_obj, dest, index);
        }
    }

}