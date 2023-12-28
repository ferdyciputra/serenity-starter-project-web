package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

public class HomePage extends PageObject {
    private final String URL_TOKOPEDIA_HOME_PAGE = BaseTest.getBaseUrl();
    private final By SELECTOR_INPUT_SEARCH = By.cssSelector("input[data-unify='Search']");

    public void openUrlTokopediaHomePage() {
        openUrl(URL_TOKOPEDIA_HOME_PAGE);
        waitFor(ExpectedConditions.urlToBe(URL_TOKOPEDIA_HOME_PAGE));
    }

    public void searchKeyword(String keyword) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_INPUT_SEARCH));
        typeInto(find(SELECTOR_INPUT_SEARCH), keyword);
        typeInto(find(SELECTOR_INPUT_SEARCH), String.valueOf(Keys.ENTER));
    }
}