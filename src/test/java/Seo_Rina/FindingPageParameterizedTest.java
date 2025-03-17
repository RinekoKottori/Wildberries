package Seo_Rina;


import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public class FindingPageParameterizedTest {
    private static WebDriver driver;

    public static DriverRule factory = new DriverRule();

    @BeforeAll
    static void setup() {
        driver = factory.getDriver();
        new MainHeaderPage(driver).openBrowser();
        new MainHeaderPage(driver).checkIsMainPageIsVisible();
    }

    @ParameterizedTest
    @MethodSource("isSearchingCorrectly")
    void setRequest(String request, String nameInCard) {
       new MainHeaderPage(driver).writeRequestInFindingField(request);
       new FindingPage(driver).checkCardsAreFoundContainsTheRequestedWord(nameInCard);
       new MainHeaderPage(driver).clearFindingField();
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
