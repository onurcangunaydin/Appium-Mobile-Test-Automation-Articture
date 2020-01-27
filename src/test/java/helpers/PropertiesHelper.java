package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static InputStream inputStream;
    private static Properties properties;

    public static Properties getPropValues() {


        try {
            properties = new Properties();
            String propFileName = "config.properties";

            inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String getProperty(String property) {
        return getPropValues().getProperty(property);
    }
}
