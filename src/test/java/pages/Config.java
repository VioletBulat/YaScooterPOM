package pages;

import com.codeborne.selenide.Configuration;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class Config {

    private static final String LOCATORS_PROPERTIES_FILE = "locators.properties";
    private static final Properties properties = new Properties();

    // Настройки Selenide из locators.properties
    public static void configureSelenide() {
        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    // Метод для загрузки локаторов из файла
    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(LOCATORS_PROPERTIES_FILE)) {
            if (input == null) {
                throw new IllegalArgumentException("Sorry, unable to find " + LOCATORS_PROPERTIES_FILE);
            }
            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + LOCATORS_PROPERTIES_FILE, e);
        }
        configureSelenide();
    }

    // Метод для получения локатора по ключу
    public static String getLocator(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("No value found for key: " + key);
        }
        return value;
    }
}
