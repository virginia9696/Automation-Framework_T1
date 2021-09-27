package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataReader.ConfigFileReader;
import driverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigFileReader configFileReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty() {
        configFileReader = new ConfigFileReader();
        properties = configFileReader.initProperties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }
}