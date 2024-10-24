package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfDataReader {
    private static Properties properties;

    static {
        String env = System.getProperty("env");
        try {
            if (env == null) {
                env = "test";
            }
            String path = "config/env/" + env + ".properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
