package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverManager.DriverFactory;
import io.cucumber.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import pageObjects.AuthenticationPage;
import java.util.List;

@Slf4j
public class AuthenticationPageSteps {

    AuthenticationPage authenticationPage= new AuthenticationPage(DriverFactory.getDriver());
    @Then("page heading {string} is displayed")
    public void authenticationPageDisplayed(String pageHeading) {
        String actualPageHeading =authenticationPage.getPageHeading().getText();
        Assert.assertEquals(String.format("Page heading %s is wrong", actualPageHeading), pageHeading.toUpperCase(), actualPageHeading );
    }

    @When("enters data in fields")
    public void entersDataInFields(DataTable data) {
        List<List<String>> userCredentials = data.asLists();
        authenticationPage.getEmail().sendKeys(userCredentials.get(0).get(0));
        authenticationPage.getPassword().sendKeys(userCredentials.get(0).get(1));
        log.info(String.format("User enters email: [%s] and  password: [%s] " , data.row(0).get(0), data.row(0).get(1)));
    }

    @And("clicks on SignIn button")
    public void clicksOnButton() {
        authenticationPage.getSignInBtn().click();
        log.info("Clicks on Sign In button");
    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String text) {
        Assert.assertTrue("User is logged in on the account",authenticationPage.getTextInfoAccount().contains(text));
        authenticationPage.getLogOutBtn().click();
        log.info("Log out from the account");
    }
}
