package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    // Инициализация WebDriver
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы для элементов на главной странице
    private final By cookieBannerCloseButton = By.xpath(Config.getLocator("cookieBannerCloseButton"));  // Кнопка закрытия баннера
    private final By orderButton = By.xpath(Config.getLocator("orderButton"));  // Кнопка оформления заказа

    // Метод для закрытия баннера с куки
    public void closeCookieBanner() {
        driver.findElement(cookieBannerCloseButton).click();  // Закрываем баннер
    }

    // Метод для клика по кнопке заказа
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
