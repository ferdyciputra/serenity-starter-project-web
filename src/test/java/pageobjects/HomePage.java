package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

public class HomePage extends PageObject {
    private final String URL_HOME_PAGE = BaseTest.getBaseUrl();
    private final By SELECTOR_INPUT_SEARCH = By.id("search");
    private final By SELECTOR_SHOW_CART = By.className("showcart");
    private final By SELECTOR_SUB_TOTAL_ON_DROPDOWN_CART_DIALOG = By.xpath("//div[@data-role='dropdownDialog']//div[@class='subtotal']//span[@class='price']");

    public void openUrl(){
        openUrl(URL_HOME_PAGE);
        waitFor(ExpectedConditions.urlToBe(URL_HOME_PAGE));
    }

    public void searchKeyword(String keyword) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_INPUT_SEARCH));
        typeInto(find(SELECTOR_INPUT_SEARCH), keyword + Keys.ENTER);

        waitFor(ExpectedConditions.urlContains("catalogsearch"));
    }

    public void clickShowCart(){
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_SHOW_CART));

        find(SELECTOR_SHOW_CART).click();
    }

    public String getSubTotalOnDropdownCartDialog(){
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_SUB_TOTAL_ON_DROPDOWN_CART_DIALOG));

        return find(SELECTOR_SUB_TOTAL_ON_DROPDOWN_CART_DIALOG).getText();
    }
}