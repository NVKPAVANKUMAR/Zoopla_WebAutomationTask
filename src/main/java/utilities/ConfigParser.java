package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigParser {
    public static Object fetchProperity(String key) {
        try {
            FileInputStream fis = new FileInputStream("Configuration/config.properties");
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
