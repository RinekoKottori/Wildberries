package Seo_Rina;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static Seo_Rina.EnvConfig.BASE_URL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage{
    public MainPage(WebDriver driver){}
    private final By mainPageCardList = By.className("main-page__content");
    private final By searchField = By.id("searchInput");

    @Step("Open browser")
    public void openBrowser() {
        open(BASE_URL);
    }

    @Step("Check is main page is visible")
    public void checkIsMainPageIsVisible() {
        $(mainPageCardList).shouldBe(visible);
    }

    @Step("Write request in finding field")
    public void  writeRequestInFindingField(String request) {
        $(searchField).shouldBe(visible).sendKeys(request);
        $(searchField).pressEnter();
        $(searchField).doubleClick();
        $(searchField).clear();
    }
}
