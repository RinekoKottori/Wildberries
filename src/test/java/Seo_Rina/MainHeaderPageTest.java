package Seo_Rina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.sleep;

public class MainHeaderPageTest {
    private static WebDriver driver;

    public static DriverRule factory = new DriverRule();

    @BeforeAll
    static void setup() {
        driver = factory.getDriver();
        new MainHeaderPage(driver).openBrowser();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
    }

    @Test
    void checkIsJobButtonOpenJobPage() {
        new MainHeaderPage(driver).clickOnButtonFindJob();
        new WBJobPage(driver).checkIsWBJobPageOpen();
    }

    @Test
    void checkIsCatalogOpensCorrectly(){
        new MainHeaderPage(driver).clickOnButtonCatalog();
        new MainHeaderPage(driver).isCatalogOpen();
    }

    @Test
    void checkIsClickOnLogoOpenMainPage(){
        new MainHeaderPage(driver).writeRequestInFindingField("платье");
        new MainHeaderPage(driver).clickOnLogo();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
    }

    @Test
    void checkIsClickOnAddressMenuOpenCorrectly(){
        new MainHeaderPage(driver).clickOnAddress();
        new MainHeaderPage(driver).isAddressMenuOpen();
    }
}
