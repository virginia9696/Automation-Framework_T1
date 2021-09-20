package pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.String.format;

@Getter
public class ProductPage {

    private WebDriver driver;

    @FindBy(css = "span[class='ajax_cart_product_txt ']")
    private WebElement qtyFromShoppingCartPopUp;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeWindow;

    @FindBy(xpath = "div#layer_cart div.clearfix")
    private WebElement shoppingCartPopUp;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(css = "#summary_products_quantity")
    private WebElement getQtyFromMainShoppingCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getButtonByName(String button) {
        return driver.findElement(By.xpath(format("//span[.='%s']", button)));
    }

    public void deleteItemFromShoppingCart(Integer itemPosition, String btnName) {
       driver.findElement(By.xpath(format("//tbody/tr[position()=%s]//td/div/a[@title='%s']",itemPosition, btnName))).click();
    }

    public WebElement itemDisplayed(String itemName){
       WebElement item = driver.findElement(By.xpath(format("//p/a[text()='%s']", itemName)));
       return item;
    }

}
