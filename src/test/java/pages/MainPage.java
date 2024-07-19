package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Локаторы для элементов на главной странице
    private final SelenideElement cookieBannerCloseButton = $x(Config.getLocator("cookieBannerCloseButton"));
    private final SelenideElement orderButton = $x(Config.getLocator("orderButton"));

    // Метод для закрытия баннера с куки
    public void closeCookieBanner() {
        cookieBannerCloseButton.click();  // Закрываем баннер
    }

    // Метод для клика по кнопке заказа
    public void clickOrderButton() {
        orderButton.click();
    }

    // Метод для открытия главной страницы
    public void open() {
        com.codeborne.selenide.Selenide.open("");
    }
}
