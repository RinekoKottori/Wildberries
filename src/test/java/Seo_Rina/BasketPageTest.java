package Seo_Rina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BasketPageTest {

    private static WebDriver driver;

    public static DriverRule factory = new DriverRule();

    @BeforeAll
    static void setup() {
        driver = factory.getDriver();
        new MainHeaderPage(driver).openBrowser();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
        new MainHeaderPage(driver).clickOnBasketIcon();
    }

    @Test
    void checkIsClickOnButtonInBasketEmptyOpenMainPage(){
        new BasketPage(driver).clickOnButtonInEmptyBasket();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
    }
}
