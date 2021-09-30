package steps;

import actions.CommonActions;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static driverManager.DriverFactory.getDriver;

@Slf4j
public class ProductPageSteps {

    private final CommonActions commonActions = new CommonActions();

    @When("presses on {string} button")
    public void pressesOnButton(String button) {
        commonActions.clickDefaultButtonByName(button);
        log.info(String.format("Presses on [%s] button ", button));
    }
    @When("user click on sign in button")
    public void clickOnButton(String button){
        commonActions.waitUntilPageIsLoaded(getDriver());
        log.info(String.format("Click on sign in button", button));

        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
}