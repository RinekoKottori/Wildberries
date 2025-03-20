package Seo_Rina;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AviaWBPage {
    private WebDriver driver;
    private final By wbTravel = By.id("__next");

    public AviaWBPage(WebDriver driver) {
    }


    @Step("Check is avia url is open")
    public void checkIsAviaUrlOpen(){
        String expectedUrl = "https://www.wildberries.ru/travel?entry_point=tab_header";
        switchTo().window(1);
        webdriver().shouldHave(url(expectedUrl));
        $(wbTravel).shouldBe(visible);
    }
}
