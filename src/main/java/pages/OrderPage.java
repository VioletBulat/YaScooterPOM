package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriverWait wait;

    // Инициализация WebDriverWait
    public OrderPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локаторы
    private final By nameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationInput = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropdown = By.xpath("//div[@class='Dropdown-placeholder' and contains(text(), '* Срок аренды')]");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By makeOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By orderSuccessMessage = By.xpath("//*[contains(text(), 'Заказ оформлен')]");

    // Метод для заполнения поля имени
    public void fillName(String name) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameField.sendKeys(name);
    }

    // Метод для заполнения поля фамилии
    public void fillSurname(String surname) {
        WebElement surnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(surnameInput));
        surnameField.sendKeys(surname);
    }

    // Метод для заполнения поля адреса
    public void fillAddress(String address) {
        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(addressInput));
        addressField.sendKeys(address);
    }

    // Метод для выбора станции метро
    public void selectMetroStation() {
        WebElement stationInput = wait.until(ExpectedConditions.elementToBeClickable(metroStationInput));
        stationInput.click();
        stationInput.sendKeys(Keys.ARROW_DOWN);
        stationInput.sendKeys(Keys.ENTER);
    }

    // Метод для заполнения поля телефона
    public void fillPhone(String phone) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        phoneField.sendKeys(phone);

        // Нажатие кнопки "Далее" после ввода номера телефона
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']")));
        nextButton.click();
    }

    // Метод для выбора даты доставки
    public void selectDate(String date) {
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
        dateElement.click();
        dateElement.sendKeys(date);
        dateElement.sendKeys(Keys.ENTER);
    }

    // Метод для выбора срока аренды
    public void selectRentalPeriod(String period) {
        WebElement rentalDropdown = wait.until(ExpectedConditions.elementToBeClickable(rentalPeriodDropdown));
        rentalDropdown.click();
        WebElement periodOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Dropdown-option' and contains(text(), '" + period + "')]")));
        periodOption.click();
    }

    // Метод для выбора цвета самоката
    public void selectColor(String color) {
        WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='" + color + "']")));
        colorOption.click();
    }

    // Метод для заполнения поля комментария
    public void fillComment(String comment) {
        WebElement commentField = wait.until(ExpectedConditions.visibilityOfElementLocated(commentInput));
        commentField.sendKeys(comment);
    }


    // Метод для клика по кнопке "Заказать"
    public void clickMakeOrderButton() {
        WebElement makeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(makeOrderButton));
        makeOrderBtn.click();
    }

    // Метод для клика по кнопке "Да"
    public void clickYesButton() {
        WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesBtn.click();
    }

    // Метод для проверки наличия сообщения об успешном заказе
    public void assertOrderSuccess() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMessage));
        if (successMessage == null) {
            throw new AssertionError("Элемент с текстом 'Заказ оформлен' не найден");
        }
    }
}
