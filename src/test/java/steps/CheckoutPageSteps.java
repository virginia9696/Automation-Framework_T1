package steps;

import actions.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import utils.TextParser;

import static driverManager.DriverFactory.getDriver;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CheckoutPageSteps {

    private CheckoutPage checkoutPage = new CheckoutPage(getDriver());
    private ProductPage productPage = new ProductPage(getDriver());
    private CommonActions commonActions = new CommonActions();

    @Then("{string} items displayed on shoppingCartPopUp")
    public void itemIsDisplayedInShoppingCartPopUp(String itemQuantity) {
        commonActions.waitUntilElementIsDisplayed(checkoutPage.getShoppingCartPopUp());
        String actualItemQty = checkoutPage.getQtyFromShoppingCartPopUp().getText();
        assertEquals(format("Displayed quantity [%s] does not match with expected: [%s]", actualItemQty, itemQuantity),
                itemQuantity, actualItemQty);
    }

    @Then("{string} items are displayed in the shopping cart header")
    public void itemsAreDisplayedInMainShoppingCart(String itemQuantity) {
        checkoutPage.getCloseWindow().click();
        commonActions.waitUntilElementIsHidden(checkoutPage.getCloseWindow());
        log.info("Close shopping cart pop-up");
        String actualItemQty = checkoutPage.getCartQtyHeader().getText();
        assertEquals(format("Displayed quantity [%s] does not match with expected: [%s]", actualItemQty, itemQuantity),
                itemQuantity, actualItemQty);
    }

    @When("removes item {string} from shopping card table, pressing on {string} button")
    public void pressesOnButtonRemoveBtn(String itemPosition, String btnName) {
        checkoutPage.clickWithJavascript(itemPosition, btnName);
        log.info(String.format("Removes item [%s] from shopping cart table, pressing on [%s] button", itemPosition, btnName));
    }

    @And("item with name {string} is displayed in the shopping cart")
    public void itemWithNameIsDisplayedInTheShoppingCart(String expecteditemName) {
        assertTrue(format("Expected item with name [%s] is displayed in the shopping cart: ", expecteditemName),
                checkoutPage.itemNameDisplayed(expecteditemName).isDisplayed());

    }

    @Then("{string} item is displayed on shopping-cart summary")
    public void itemIsDisplayedOnShoppingCartSummary(String itemQty) {
        commonActions.moveToElement(checkoutPage.getShoppingCart());
        productPage.clickShoppingCartCheckout();
        commonActions.waitUntilPageIsLoaded(getDriver());
        String actualItemQty = TextParser.getParsedValue(checkoutPage.getShoppingCartSummary());
        assertEquals((format("Displayed quantity [%s] does not matches with expected: [%s]", actualItemQty, itemQty)),
                itemQty, actualItemQty);

    }
}