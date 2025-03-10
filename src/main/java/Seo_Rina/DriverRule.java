package Seo_Rina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverRule {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    protected void setUp(){
        initDriver();
    }

    @AfterEach
    protected void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    public void initDriver() {
        String browser = System.getProperty("browser", "chrome");
       switch (browser.toLowerCase()){
           case "firefox":
               initFirefox();
               break;
           case "yandex":
               initYandex();
               break;
           default:
               initChrome();
       }
    }

    private void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void initYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();

        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getProperty("webdriver.yandex.bin"));

        driver = new ChromeDriver(options);
    }
}
