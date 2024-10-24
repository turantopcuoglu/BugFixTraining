package utils;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class UserDataReader {
    private Map<String, Map<String, String>> users;

    String userType = "email";

    public UserDataReader() {
        String path = "config/resources/account/user.yml";
        LoaderOptions loaderOptions = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(loaderOptions));
        try (InputStream input = new FileInputStream(path)) {
            users = yaml.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEmail(String userType) {
        return users.get(userType).get("email").toString();
    }

    public String getPassword(String email) {
        return users.get(userType).get("password");
    }
}
