import java.io.File;

public class FileUtils {
    static public void delFile(String file_name) throws Exception {
        File file = new File(file_name);
        if(file.exists())
            file.delete();
    }
}
