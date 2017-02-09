import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by huser
 * On 17/2/8.
 */
public class Draft2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("胡亮亮","123123");
        String path = Draft2.class.getResource("/").toString().substring(6);
        String filename = "data/data.properties";
        FileOutputStream fos = new FileOutputStream(path+filename);
        properties.store(fos,"Init properties");
    }
}
