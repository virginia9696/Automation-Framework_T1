package steps;

import actions.CommonActions;
import context.Context;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pageObjects.CategoryPage;

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

}