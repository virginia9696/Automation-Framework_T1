package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public WebDriver initializeDriver(String browser) {
        System.out.println("Browser value is: " + browser);
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            System.setProperty("webdriver.geckodriver.exe","src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.out.println("Please pass the correct browser value: " + browser);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
