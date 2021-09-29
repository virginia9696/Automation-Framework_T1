package pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;

@Getter
public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeWindow;

    @FindBy(css = "div#layer_cart div.clearfix")
    private WebElement shoppingCartPopUp;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(css = "#summary_products_quantity")
    private WebElement shoppingCartSummary;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    private WebElement cartQtyHeader;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity']")
    private WebElement qtyFromShoppingCartPopUp;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWithJavascript(String itemPosition, String btnName) {
        WebElement button = driver.findElement(By.xpath(format("//tbody/tr[position()=%s]//td/div/a[@title='%s']", itemPosition, btnName)));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", button);}
}