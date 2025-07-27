package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.ProductDetailsPage;
import pageobjects.SearchResultPage;

import java.util.List;
import java.util.Map;

public class AddCartSteps {

    @Steps
    HomePage homePage;

    @Steps
    SearchResultPage searchResultPage;

    @Steps
    ProductDetailsPage productDetailsPage;

    @And("the user has added the following products to the cart:")
    public void theUserHasAddedTheFollowingProductsToTheCart(DataTable dataTable) {
        // Convert DataTable to a List of Maps
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String productName = row.get("Product Name");

            homePage.searchKeyword(productName);
            searchResultPage.clickProductByName(productName);
            productDetailsPage.clickButtonAddCart();
        }
    }


    @When("the user views the cart page")
    public void theUserViewsTheCartPage() {
        homePage.clickShowCart();
    }

    @Then("the cart should display a subtotal amount of {string}")
    public void theCartShouldDisplayASubtotalAmountOf(String expectedSubTotalAmount) {
        String actualSubTotalAmount = homePage.getSubTotalOnDropdownCartDialog();

        Assert.assertEquals(expectedSubTotalAmount, actualSubTotalAmount);
    }
}
