package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends PageObject {
    private final By SELECTOR_BUTTON_ADD_CART = By.className("tocart");
    private final By SELECTOR_MESSAGE_SUCCESS_ADD_CART = By.className("message-success");

    public void clickButtonAddCart(){
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_BUTTON_ADD_CART));

        find(SELECTOR_BUTTON_ADD_CART).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(SELECTOR_MESSAGE_SUCCESS_ADD_CART));
    }
}
