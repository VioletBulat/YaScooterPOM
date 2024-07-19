package pages;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("Unable to find config.properties file.");
            }
            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load config.properties", ex);
        }
    }

    public static String getLocator(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("No value found for key: " + key);
        }
        return value;
    }
}
