package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigReader {
    private static ConfigReader instance;
    private static final Properties properties = new Properties();
    private static final String testdataFilePath = "/home/kamau/IdeaProjects/GitHubAssessment/src/test/resources/TestData.Properties";

    private ConfigReader() {
        try(InputStream inputStream = new FileInputStream(testdataFilePath)) {
            properties.load(Objects.requireNonNull(inputStream));
        }
        catch (IOException ex) {
            System.out.println("Could not load properties file");
        }
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }
        return instance;
    }

    public  String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        ConfigReader configReader = ConfigReader.getInstance();
        String baseUrl = configReader.getProperty("OrangeHRM");
        System.out.println(baseUrl);
    }
}
