package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends PageObject {
    private final By SELECTOR_TITLE_RESULT_PRODUCT = By.className("product-item-link");
    private final By SELECTOR_INFO_MESSAGE = By.xpath("//div[@class='message notice']/div");

    public String getTitleFromResultProduct() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_TITLE_RESULT_PRODUCT));

        return find(SELECTOR_TITLE_RESULT_PRODUCT).getText();
    }

    public String getInfoMessage(){
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_INFO_MESSAGE));

        return find(SELECTOR_INFO_MESSAGE).getText().trim();
    }
}
