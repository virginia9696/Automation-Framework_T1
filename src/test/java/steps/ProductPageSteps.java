package steps;

import actions.CommonActions;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductPageSteps {

    private final CommonActions commonActions = new CommonActions();

    @When("presses on {string} button")
    public void pressesOnButton(String button) {
        commonActions.clickDefaultButtonByName(button);
        log.info(String.format("Presses on [%s] button ", button));
    }
}