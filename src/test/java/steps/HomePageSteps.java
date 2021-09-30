package steps;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static driverManager.DriverFactory.getDriver;

@Slf4j
public class HomePageSteps {

    private HomePage homePage = new HomePage(getDriver());
    private CommonActions commonActions = new CommonActions();

    @Given("user navigates on {string} page")
    public void userNavigatesOnPage(String url) {
        getDriver().get(url);
        log.info(String.format("User navigates to: [%s] url ",url));
    }
    @Then("user select sign in popup")
    public void clickOnSignInPopup(String popup){
        homePage.getDriver().getCurrentUrl();
        log.info(String.format("User select sign in popup", popup));

        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @When("selects category {string} with name {string} from top bar menu")
    public void selectCategoryFromTopBarMenu(String categoryPosition , String category) {
        homePage.getElementFromListByPositionAndName(categoryPosition,category).click();
        commonActions.waitUntilPageIsLoaded(getDriver());
        log.info(String.format("Selects [%s] category from top bar menu",category));
    }
}