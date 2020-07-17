package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    Properties prop = new Properties();
    String fileName = "data.properties";

    InputStream inputStream;
    String value;

    public String getPropValue(String fileName,String key) throws IOException {
        try {
            if (inputStream == null) {
                prop.load(new FileInputStream("src/main/resources/" + fileName));
            } else {
                System.out.println("File Not Found");
            }
            value = prop.getProperty(key);
            System.out.println(key + " - " + value);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return value;
    }
}
