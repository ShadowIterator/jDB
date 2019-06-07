public class SerializeInplaceUtil {

    static int bytesToInt(byte[] b, int index) {
        return (b[0 + index] & 0xff) |
                (((int) b[1 + index] & 0xff) << 8) |
                (((int) b[2 + index] & 0xff) << 16) |
                (((int) b[3 + index] & 0xff) << 24);
    }

    static long bytesToLong(byte[] b, int index) {
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

    static boolean bytesToBoolean(byte[] b, int index) {
        return b[index] != 0;
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

    static int intToBytes(int int_value, byte[] dest, int index) {
//        byte[] b = new byte[4];
        dest[index + 0] = (byte) (int_value & 0xff);
        dest[index + 1] = (byte) ((int_value >> 8) & 0xff);
        dest[index + 2] = (byte) ((int_value >> 16) & 0xff);
        dest[index + 3] = (byte) ((int_value >> 24) & 0xff);
        return 4;
    }

    static int longToBytes(long long_value, byte[] dest, int index) {
        intToBytes(((int) (long_value)) & 0xffffffff, dest, index);
        intToBytes(((int) (long_value >> 32)) & 0xffffffff, dest, index + 4);
        return 8;
    }

    static int floatToBytes(float float_value, byte[] dest, int index) {
        int float_int_value = Float.floatToRawIntBits(float_value);
        intToBytes(float_int_value, dest, index);
        return 4;
    }

    static int doubleToBytes(double double_value, byte[] dest, int index) {
        long double_long_value = Double.doubleToRawLongBits(double_value);
        longToBytes(double_long_value, dest, index);
        return 8;
    }

    static int booleanToBytes(boolean boolean_value, byte[] dest, int index) {
        dest[index] = (byte) (boolean_value? 0 : 1);
        return 1;
    }

    static int stringToBytes(String string_value, byte[] dest, int index) {
        byte[] b = string_value.getBytes();
        System.arraycopy(b, 0, dest, index, b.length);
        dest[index + b.length] = 0;
        return b.length + 1;
    }

    static int objectToBytes(Object obj, byte[] dest, int index) throws Exception  {


        if (obj.getClass() == Integer.class) {
            int int_obj = (int) obj;
            return intToBytes(int_obj, dest, index);
        } else if (obj.getClass() == Long.class) {
            long long_obj = (long) obj;
            return longToBytes(long_obj, dest, index);
        } else if (obj.getClass() == Float.class) {
            float float_obj = (float) obj;
            return floatToBytes(float_obj, dest, index);
        } else if (obj.getClass() == Double.class) {
            double double_obj = (double) obj;
            return doubleToBytes(double_obj, dest, index);
        } else /* if(obj.getClass() == String.class) */ {
            String string_obj = (String) obj;
            return stringToBytes(string_obj, dest, index);
        }
    }

}
