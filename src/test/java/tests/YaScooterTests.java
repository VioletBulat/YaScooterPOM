package tests;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pages.Config;
import pages.MainPage;
import pages.OrderPage;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class YaScooterTests {

    private MainPage mainPage;
    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public YaScooterTests(String name, String surname, String address, String station, String phone, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameters(name = "{index}: Order test with name={0}, surname={1}, address={2}, station={3}, phone={4}, date={5}, rentalPeriod={6}, color={7}, comment={8}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Пушкина, 1", "Бульвар Рокоссовского", "+75312575235", "1", "сутки", "black", "Комментарий"},
                {"Мария", "Петрова", "Санкт-Петербург, Невский проспект, 10", "Бульвар Рокоссовского", "+74951234567", "1", "трое суток", "grey", "Важное сообщение"}
        });
    }

    @Before
    public void setUp() {
        Config.configureSelenide();
        mainPage = new MainPage();
        orderPage = new OrderPage();
        mainPage.open();
        mainPage.closeCookieBanner();
    }

    @Test
    public void orderScooterTest() {
        mainPage.clickOrderButton(); // Переход на страницу заказа
        orderPage.fillName(name); // Заполнение поля имени
        orderPage.fillSurname(surname); // Заполнение поля фамилии
        orderPage.fillAddress(address); // Заполнение поля адреса
        orderPage.selectMetroStation(station); // Выбор станции метро
        orderPage.fillPhone(phone); // Заполнение поля телефона
        orderPage.nextButton(); // Клик по кнопке "Далее"
        orderPage.selectDate(date); // Выбор даты доставки
        orderPage.selectRentalPeriod(rentalPeriod); // Выбор срока аренды
        orderPage.selectColor(color); // Выбор цвета самоката
        orderPage.fillComment(comment); // Заполнение поля комментария
        orderPage.clickMakeOrderButton(); // Клик по кнопке "Заказать"
        orderPage.clickYesButton(); // Подтверждение заказа
        orderPage.assertOrderSuccess(); // Проверка, что заказ успешно оформлен
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
