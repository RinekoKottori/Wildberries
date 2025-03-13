package Seo_Rina;


import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public class FindingPageTest {
    private static WebDriver driver;

    public static DriverRule factory = new DriverRule();

    @BeforeAll
    static void setup() {
        driver = factory.getDriver();
        new MainPage(driver).openBrowser();
        new MainPage(driver).checkIsMainPageIsVisible();
    }

    @ParameterizedTest
    @MethodSource("isSearchingCorrectly")
    void setRequest(String request, String nameInCard) {
       new MainPage(driver).writeRequestInFindingField(request);
       new FindingPage(driver).checkCardsAreFoundContainsTheRequestedWord(nameInCard);
    }
    private static Stream<Arguments> isSearchingCorrectly() {
        return Stream.of(
                Arguments.of("туфли", "туфли"),
                Arguments.of("платье", "платье"),
                Arguments.of("запонки", "запонки"),
                Arguments.of("кружка", "кружка")
        );
    }
}
