package steps;

import cucumber.api.java.en.Then;
import driverManager.DriverFactory;
import org.junit.Assert;
import pageObjects.AuthenticationPage;

import java.util.Locale;

public class AuthenticationPageSteps {

    AuthenticationPage authenticationPage= new AuthenticationPage(DriverFactory.getDriver());

    @Then("page heading {string} is displayed")
    public void authenticationPageDisplayed(String pageHeading) {
        String actualPageHeading =authenticationPage.getPageHeading().getText();
        Assert.assertEquals(String.format("Page heading %s is wrong", actualPageHeading), pageHeading.toUpperCase(), actualPageHeading );

    }

}
