package ch.bzz.dev.zwazel.timbookshelf;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationPath("/resource")
public class Config extends Application {
    private static Properties properties;

    private static void checkIfPropertyExists() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = new FileInputStream(Config.class.getClassLoader().getResource("config.properties").getFile())) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key, String defaultValue) {
        checkIfPropertyExists();

        return properties.getProperty(key, defaultValue);
    }

    public static String getProperty(String key) {
        checkIfPropertyExists();

        return properties.getProperty(key);
    }
}