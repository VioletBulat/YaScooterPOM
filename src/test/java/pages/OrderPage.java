package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    // Локаторы
    private final SelenideElement nameInput = $x(Config.getLocator("nameInput"));
    private final SelenideElement surnameInput = $x(Config.getLocator("surnameInput"));
    private final SelenideElement addressInput = $x(Config.getLocator("addressInput"));
    private final SelenideElement metroStationInput = $x(Config.getLocator("metroStationInput"));
    private final SelenideElement phoneInput = $x(Config.getLocator("phoneInput"));
    private final SelenideElement nextButton = $x(Config.getLocator("nextButton"));
    private final SelenideElement dateInput = $x(Config.getLocator("dateInput"));
    private final SelenideElement rentalPeriodDropdown = $x(Config.getLocator("rentalPeriodDropdown"));
    private final SelenideElement commentInput = $x(Config.getLocator("commentInput"));
    private final SelenideElement makeOrderButton = $x(Config.getLocator("makeOrderButton"));
    private final SelenideElement yesButton = $x(Config.getLocator("yesButton"));
    private final SelenideElement orderSuccessMessage = $x(Config.getLocator("orderSuccessMessage"));

    // Метод для заполнения поля имени
    public void fillName(String name) {
        nameInput.setValue(name);
    }

    // Метод для заполнения поля фамилии
    public void fillSurname(String surname) {
        surnameInput.setValue(surname);
    }

    // Метод для заполнения поля адреса
    public void fillAddress(String address) {
        addressInput.setValue(address);
    }

    // Метод для выбора станции метро
    public void selectMetroStation(String station) {
        metroStationInput.click();
        $x("//div[contains(text(),'" + station + "')]").click();
    }

    // Метод для заполнения поля телефона
    public void fillPhone(String phone) {
        phoneInput.setValue(phone);
    }

    // Клик по кнопке "Далее"
    public void nextButton() {
        nextButton.click();
    }

    // Метод для выбора даты доставки
    public void selectDate(String date) {
        dateInput.click();
        $x("//div[contains(text(),'" + date + "')]").click();
    }

    // Метод для выбора срока аренды
    public void selectRentalPeriod(String period) {
        rentalPeriodDropdown.click();
        $x("//div[contains(@class, 'Dropdown-option') and text()='" + period + "']").click();
    }

    // Метод для выбора цвета самоката
    public void selectColor(String color) {
        $x("//label[@for='" + color + "']").click();
    }

    // Метод для заполнения поля комментария
    public void fillComment(String comment) {
        commentInput.setValue(comment);
    }

    // Метод для клика по кнопке "Заказать"
    public void clickMakeOrderButton() {
        makeOrderButton.click();
    }

    // Метод для клика по кнопке "Да"
    public void clickYesButton() {
        yesButton.click();
    }

    // Метод для проверки наличия сообщения об успешном заказе
    public void assertOrderSuccess() {
        orderSuccessMessage.should(Condition.visible);
    }
}
