package steps;

import actions.CommonActions;
import context.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.CategoryPage;

import java.util.List;
import java.util.Objects;

import static context.ScenarioContext.getScenarioContext;
import static driverManager.DriverFactory.getDriver;

@Slf4j
public class CategoryPageSteps {

    private CommonActions commonActions = new CommonActions();
    private CategoryPage categoryPage = new CategoryPage(getDriver());

    @When("selects position {string} with name {string} item from displayed page")
    public void clickOnItemPage(String position, String item) {
        getScenarioContext().saveData(Context.ITEM_NAME, categoryPage.getProductByName(position,item).getText());
        commonActions.scrollToElementAndClick(categoryPage.getProductByName(position,item));
        log.info(String.format("Selects position [%s] with name [%s] ", position, item));
    }

    @And("get the name of the product {int} order")
    public void getProductName(int order){
        getScenarioContext().saveData(Context.ITEM_NAME, categoryPage.getProductName(order));
    }

    @When("enter found product name in the search bar and click search button")
    public void searchProduct(){
        String product = getScenarioContext().getData(Context.ITEM_NAME).toString();
        String foundProduct = categoryPage.searchProduct(product);
        getScenarioContext().saveData(Context.FOUND_PRODUCT, foundProduct);
    }

    @Then("The actual displayed product name is equal with expected product name")
    public void productIsFoundAndMatches(){
        String actualProduct = getScenarioContext().getData(Context.ITEM_NAME).toString();
        String expectedProduct = getScenarioContext().getData(Context.FOUND_PRODUCT).toString();
        Assert.assertTrue(actualProduct.equalsIgnoreCase(expectedProduct));
    }
    @When("valid email address is inserted")
    public void validDataIsInserted(){
        WebElement emailaddress = getDriver().findElement(By.xpath("//input[@id= 'email']"));
        emailaddress.sendKeys("yopmail.an@yopmail.com");
    }
    @When("valid password is inserted")
    public void validpasswordIsInserted(){
        WebElement password = getDriver().findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("11121314");

//    @When("user insert data in fields")
//    public void insertDataInFields (DataTable data){
//
//        List<String> insertValue = data.asList();
//
//        categoryPage.getEmailAddressImput().sendKeys(insertValue.get(0));
//        categoryPage.getPasswordImput().sendKeys(insertValue.get(1));
    }

    }