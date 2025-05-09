package Seo_Rina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class FindingPageTest {
    private static WebDriver driver;

    public static DriverRule factory = new DriverRule();

    @BeforeAll
    static void setup() {
        driver = factory.getDriver();
        new MainHeaderPage(driver).openBrowser();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
    }

    @Test
    public void checkIsItemCardIsOpenCorrectly() {
        String itemId = new FindingPage(driver).openItemCard("туфли");
        new FindingPage(driver).checkIsItemCardIsOpenCorrectly(itemId);
    }
}
