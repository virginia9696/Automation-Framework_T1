package steps;

import actions.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverManager.DriverFactory;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import utils.TextParser;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Steps {

    HomePage homePage = new HomePage(DriverFactory.getDriver());
    CommonActions commonActions = new CommonActions();
    CategoryPage categoryPage = new CategoryPage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @Given("user navigates on {string} page")
    public void userNavigatesOnPage(String url) {
        DriverFactory.getDriver().get(url);
    }

    @When("selects {string} category order {int} from top bar menu")
    public void selectCategoryFromTopBarMenu(String categoryName, int order) {
       homePage.getElementFromListByName(categoryName, order).click();
        commonActions.waitUntilPageIsLoaded(DriverFactory.getDriver());
    }

    @When("selects position {int} with name {string} item from displayed page")
    public void clickOnItemPage(Integer position, String item) {
        commonActions.scrollToElementAndClick(categoryPage.getProductByName(position,item));
    }

    @When("presses on {string} button")
    public void pressesOnButton(String button) {
        productPage.getButtonByName(button).click();
    }

    @Then("{int} item is displayed on shoppingCartPopUp")
    public void itemIsDisplayedInShoppingCartPopUp(int itemQuantity ) {
        commonActions.waitUntilElementIsDisplayed(productPage.getQtyFromShoppingCartPopUp());
        String actualItemQty = TextParser.getParsedValue(productPage.getQtyFromShoppingCartPopUp());
        assertEquals(format("Displayed quantity matches with expected: %s", actualItemQty), Integer.parseInt(actualItemQty),
                itemQuantity);
       productPage.getCloseWindow().click();
    }

    @Then("{int} items are displayed in the main shopping cart")
    public void itemsAreDisplayedInMainShoppingCart(int itemQuantity) {
        productPage.getShoppingCart().click();
        String actualItemQty = TextParser.getParsedValue(productPage.getGetQtyFromMainShoppingCart());
        assertEquals(format("Displayed quantity matches with expected: %s", actualItemQty),
                Integer.parseInt(actualItemQty), itemQuantity);

    }

    @When("removes item {int} from shopping card table, pressing on {string} button")
    public void pressesOnButtonItem(Integer itemPosition, String btnName) {
        productPage.deleteItemFromShoppingCart(itemPosition, btnName);
    }

    @And("item with name {string} is displayed in the shopping cart")
    public void itemWithNameIsDisplayedInTheShoppingCart(String itemName) {
        assertTrue(format("Displayed item name matches with expected: {}", productPage.itemDisplayed(itemName).getText()),
                productPage.itemDisplayed(itemName).isDisplayed());
    }

    @And("get the name of the displayed product {int}")
    public void getTheProductName(int order){
        productPage.getProductName(order);
    }
}
