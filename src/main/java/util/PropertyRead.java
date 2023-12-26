package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyRead {
	public static String getProperty(String propertyName, String defaultValue) throws IOException {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/file.properties";
        FileReader fileReader = new FileReader(filePath);
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties.getProperty(propertyName,defaultValue);
    }
}
