package Seo_Rina;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Seo_Rina.EnvConfig.BASE_URL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainHeaderPage {
    public MainHeaderPage(WebDriver driver){}
    private final By mainPageCardList = By.className("main-page__content-wrapper");
    private final By searchField = By.id("searchInput");
    private final By findJobButton = By.cssSelector("a[data-wba-header-name='Job']");
    private final By buttonCatalog = By.className("j-menu-burger-btn");
    private final By mainCatalog = By.className("j-menu-burger-main");
    private final By logoWild = By.className("nav-element__logo");
    private final By address = By.className("simple-menu__link--address");
    private final By addressIncognito = By.className("j-b-add-address-popup");
    private final By aviaUrl = By.className("j-avia");
    private final By searchByPhotoButton = By.id("searchByImageFormAbNew");
    private final By searchByPhotoWindow = By.className("upload-image-for-search-by-image-popup__header");


    @Step("Open browser")
    public void openBrowser() {
        open(BASE_URL);
    }

    @Step("Check is main page is visible")
    public void checkIsMainPageIsVisible() {
        $(mainPageCardList).shouldBe(visible);
    }

    @Step("Send request in finding field")
    public void  writeRequestInFindingField(String request) {
        $(searchField).shouldBe(visible).sendKeys(request);
        $(searchField).pressEnter();
    }

    @Step("Clear field after find requested items")
    public void clearFindingField() {
        $(searchField).doubleClick();
        $(searchField).clear();
    }

    @Step ("Click on button 'Работа в WB'")
    public void clickOnButtonFindJob(){
        $(findJobButton).shouldBe(visible).click();
    }

    @Step("Click on button Catalog")
    public void clickOnButtonCatalog(){
        $(buttonCatalog).shouldBe(visible).click();
    }

    @Step("Check is catalog open")
    public void isCatalogOpen(){
        $(buttonCatalog).shouldHave(cssClass("nav-element__burger--close"));
        $(mainCatalog).shouldBe(visible);
    }

    @Step("Click on logo 'Wildberries'")
    public void clickOnLogo(){
        $(logoWild).shouldBe(visible).click();
    }

    @Step("Click on address")
    public void clickOnAddress(){
        $(address).shouldBe(visible).click();
    }

    @Step("Check is address menu open")
    public void isAddressMenuOpen(){
        $(addressIncognito).shouldBe(visible);
    }

    @Step("Click on avia")
    public void clickOnAvia(){
        $(aviaUrl).shouldBe(visible).click();
    }

    @Step("Click on search by photo button open search window")
    public void clickOnSearchByPhotoButton(){
        $(searchByPhotoButton).shouldBe(visible).click();
    }

    @Step("Check is window search by photo open")
    public void isSearchByPhotoWindowOpen(){
        $(searchByPhotoWindow).shouldBe(visible).shouldHave(exactText("Найти товары по фото"));
    }
}
