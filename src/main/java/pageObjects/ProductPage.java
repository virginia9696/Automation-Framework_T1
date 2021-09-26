package pageObjects;

import lombok.Getter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.String.format;

@Getter
public class ProductPage {

    private WebDriver driver;

    @FindBy(css = "#button_order_cart")
    private WebElement checkoutBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickShoppingCartCheckout(){
        checkoutBtn.click();
    }

}