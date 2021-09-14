package dataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/main/resources/configs/config.properties";

    /**
     * This method is used to load the properties from config.properties file
     * @return
     */
    public Properties initProperties() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}

