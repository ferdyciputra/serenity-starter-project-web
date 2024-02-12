package utilities;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtils extends PageObject {

    public void retryClickElementAndHandlingStaleElementException(By selector) {
        for (int repeat = 1; repeat <= 5; repeat++) {
            try {
                clickOn(find(selector));
                break;
            } catch (StaleElementReferenceException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void retryClickElementAndHandlingStaleElementException(WebElementFacade webElementFacade) {
        for (int repeat = 1; repeat <= 5; repeat++) {
            try {
                clickOn(webElementFacade);
                break;
            } catch (StaleElementReferenceException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void scrollUntilElementVisible(WebElementFacade webElementFacade) {
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(webElementFacade).perform();
    }

}
