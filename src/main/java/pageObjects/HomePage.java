package pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='block_top_menu']")
    private WebElement categoriesMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getElementFromListByPositionAndName(String categoryPosition, String elementName) {
        return driver.findElement(By.xpath(String.format("//*[@id=\"block_top_menu\"]/ul/li[%s]/a[@title='%s']",categoryPosition, elementName)));
    }

}