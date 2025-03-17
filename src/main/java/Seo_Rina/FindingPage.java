package Seo_Rina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FindingPage {
    private final WebDriver driver;
    private final By searchedCardList = By.className("product-card-list");
    private final By cardsArticle = By.cssSelector("[data-nm-id]");
    private final By findingFirstItem = By.className("product-card__link");
    private final By itemIdSelector = By.cssSelector("article[id]");
    private final By productPageTitle = By.className("product-page__title");

    public FindingPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Checking that the cards are found contains the requested word")
    public void  checkCardsAreFoundContainsTheRequestedWord(String request) {
        for (SelenideElement searchedCard : $$(cardsArticle)) {
            $(searchedCardList).shouldBe(visible);
            searchedCard.shouldHave(Condition.text(request));
        }
    }

    @Step("Open item card and get id from it")
    public String openItemCard(String request) {
        new MainHeaderPage(driver).writeRequestInFindingField(request);
        $(findingFirstItem).shouldBe(visible);
        String itemId = $(itemIdSelector).getAttribute("id");
        $(findingFirstItem).click();
        return itemId;
    }

    @Step("Is item id open correctly")
    public void checkIsItemCardIsOpenCorrectly(String itemId) {
        $(productPageTitle).shouldBe(visible);
        $(itemIdSelector).shouldHave(attribute("id", itemId));
    }
}
