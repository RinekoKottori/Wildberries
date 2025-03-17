package Seo_Rina;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class WBJobPage {
    private WebDriver driver;
    private final By mainPage = By.className("Home_welcomeBlockWrapper__h_RWh");

    public WBJobPage(WebDriver driver) {
    }

    @Step("Check is WB job page open")
    public void checkIsWBJobPageOpen(){
        String expectedUrl = "https://career.wb.ru/";
        switchTo().window(1);
        webdriver().shouldHave(url(expectedUrl));
        $(mainPage).shouldBe(visible);
    }
}
