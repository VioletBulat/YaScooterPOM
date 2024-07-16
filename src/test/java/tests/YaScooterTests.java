package tests;

import org.junit.runner.RunWith;
import pages.MainPage;
import pages.OrderPage;
import utils.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class YaScooterTests {

    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    // Метод инициализации для создания нового драйвера и открытия веб-страницы перед тестами
    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        mainPage.closeCookieBanner();
    }

    // Параметризованный метод для передачи данных в тесты
    @Parameterized.Parameters(name = "{index}: Order test with name={0}, surname={1}, address={2}, phone={3}, date={4}, rentalPeriod={5}, color={6}, comment={7}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Иван", "Иванов", "Москва, ул. Пушкина, 1", "+75312575235", "01.08.2024", "сутки", "black", "Комментарий"},
                {"Мария", "Петрова", "Санкт-Петербург, Невский проспект, 10", "+74951234567", "02.08.2024", "трое суток", "grey", "Важное сообщение"}
        });
    }

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    // Конструктор для передачи параметров в тесты
    public YaScooterTests(String name, String surname, String address, String phone, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    // Тестовый метод для проверки процесса заказа самоката
    @Test
    public void orderScooterTest() {
        mainPage.clickOrderButton(); // Переход на страницу заказа
        orderPage.fillName(name); // Заполнение поля имени
        orderPage.fillSurname(surname); // Заполнение поля фамилии
        orderPage.fillAddress(address); // Заполнение поля адреса
        orderPage.selectMetroStation(); // Выбор станции метро
        orderPage.fillPhone(phone); // Заполнение поля телефона
        orderPage.selectDate(date); // Выбор даты доставки
        orderPage.selectRentalPeriod(rentalPeriod); // Выбор срока аренды
        orderPage.selectColor(color); // Выбор цвета самоката
        orderPage.fillComment(comment); // Заполнение поля комментария
        orderPage.clickMakeOrderButton(); // Клик по кнопке "Заказать"
        orderPage.clickYesButton(); // Подтверждение заказа
        orderPage.assertOrderSuccess(); // Проверка, что заказ успешно оформлен
    }

    // Метод для завершения работы с браузером после тестов
    @After
    public void teardown() {
            driver.quit();
    }
}
