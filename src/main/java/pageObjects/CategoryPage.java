package pageObjects;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class CategoryPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='product_list row list']")
    private WebElement productList;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductByName(String position, String product){
        return driver.findElement(By.xpath(String.format("//li[%s]//a[@class='product-name' and @title='%s']",position, product)));
    }

    public String getProductName(int position){
        WebElement webElement = driver.findElement(By.xpath((String.format("//li[%s]//a[@class='product-name']" , position))));
        return webElement.getText();
    }

    public String searchProduct(String productName){
        driver.findElement(By.id("search_query_top")).sendKeys(productName);
        driver.findElement(By.name("submit_search")).click();
        return getProductName(1);
    }

}