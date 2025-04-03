package Seo_Rina;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SellerWBPage {

    public SellerWBPage(WebDriver driver) {
    }

    private final By sellerPage = By.className("preview_Preview__WF4kj");

    @Step("Check is seller WB page open")
    void isSellerWBPageOpen() {
        String expectedUrl = "https://seller.wildberries.ru/about-portal/ru?redirect_url=https%3A%2F%2Fseller.wildberries.ru%2F";
        switchTo().window(1);
        webdriver().shouldHave(url(expectedUrl));
        $(sellerPage).shouldBe(visible);
    }

}
