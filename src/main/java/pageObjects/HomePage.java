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

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']")
    private WebElement categoriesMenu;

    @FindBy(css = "i.icon-trash")
    private WebElement deleteBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getElementFromListByName(String elementName, int order) {
        return categoriesMenu.findElement(By.xpath(String.format(
                "/descendant::a[@title='%s']['%s]", elementName, order)));
    }

}
