package Seo_Rina;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Seo_Rina.EnvConfig.BASE_URL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasketPage {
    public BasketPage(WebDriver driver){}
    private final By basketPage = By.className("basket-empty__wrap");
    private final By buttonWhenEmptyBasket = By.className("basket-empty__btn");

    @Step("Open browser")
    public void openBrowser() {
        open(BASE_URL);
    }

    @Step("Check is basket page is open without anything in it")
    public void isBasketPageOpen(){
        $(basketPage).shouldBe(visible).shouldHave(innerText("В корзине пока пусто"));
    }

    @Step("Click on button 'Перейти на главную страницу'")
    public void clickOnButtonInEmptyBasket(){
        $(buttonWhenEmptyBasket).shouldBe(visible).click();
    }

}
