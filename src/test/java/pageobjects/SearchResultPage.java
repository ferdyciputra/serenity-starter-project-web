package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends PageObject {
    private final By SELECTOR_TITLE_RESULT_PRODUCT = By.cssSelector("div[data-testid='linkProductName']");
    private final By SELECTOR_ICON_PRODUCT_NOT_AVAILABLE = By.cssSelector("img[data-testid='imgSRPNotFoundImage']");

    public String getTitleFromResultProduct() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_TITLE_RESULT_PRODUCT));

        return find(SELECTOR_TITLE_RESULT_PRODUCT).getText();
    }

    public Boolean isIconProductNotAvailableDisplayed() {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_ICON_PRODUCT_NOT_AVAILABLE));
            return find(SELECTOR_ICON_PRODUCT_NOT_AVAILABLE).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
