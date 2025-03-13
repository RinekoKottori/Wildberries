package Seo_Rina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FindingPage {
    private final WebDriver driver;
    private final By searchedCardList = By.className("product-card-list");
    private final By cardsArticle = By.cssSelector("[data-nm-id]");

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

}
