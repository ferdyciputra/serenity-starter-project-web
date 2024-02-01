package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchProductSteps {

    @Steps
    HomePage homePage;

    @Steps
    SearchResultPage searchResultPage;

    @Given("User navigate to the online store home page")
    public void userNavigateToTheOnlineStoreHomePage() {
        homePage.openUrl();
    }

    @When("User search for keyword {string} in search box and click button search")
    public void userSearchForKeywordInSearchBox(String keyword) {
        homePage.searchKeyword(keyword);
    }

    @Then("User can see product on the result page is contains {string}")
    public void userCanSeeProductOnTheResultPageIsContains(String expectedKeywordSearch) {
        String actualResultProduct = searchResultPage.getTitleFromResultProduct().toLowerCase();
        String message = "Product on the result page must be contains '" + expectedKeywordSearch + "' but found: " + actualResultProduct;

        Assert.assertTrue(message, actualResultProduct.contains(expectedKeywordSearch.toLowerCase()));
    }

    @Then("User can see info message {string}")
    public void userCanSeeInfoMessage(String expectedMessage) {
        String actualMessage = searchResultPage.getInfoMessage();

        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
