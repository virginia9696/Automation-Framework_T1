package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driverManager.DriverFactory.getDriver;

public class CommonActions {

    public void scrollToElementAndClick(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element);
        action.perform();
    }

    public void waitUntilElementIsDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until((ExpectedCondition<Boolean>) arg -> element.isDisplayed());
    }

    public void waitUntilPageIsLoaded(WebDriver driver) {
        new WebDriverWait(driver, 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void clickDefaultButtonByName(String buttonName) {
        WebElement defaultButton = getDriver().findElement(By.xpath("//a[contains(text(),'" + buttonName + "')]"));
        defaultButton.click();
    }
}
