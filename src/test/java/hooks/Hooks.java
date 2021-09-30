package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import dataReader.ConfigFileReader;
import driverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import utils.MakeScreenShot;
import java.io.IOException;
import java.util.Properties;
public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigFileReader configFileReader;
    Properties properties;
    private MakeScreenShot screenshotMaker = new MakeScreenShot();

    @Before(order = 0)
    public void getProperty() {
        configFileReader = new ConfigFileReader();
        properties = configFileReader.initProperties();
    }

    @Before(order = 1)
    public void launchBrowser() throws IOException {
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver(browserName);
        screenshotMaker.generateDirectory("feature");
    }

    @AfterStep
    public void afterStepScreenshot(Scenario scenario) {
        screenshotMaker.makeAShot(scenario.getName());
    }
    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }
}
