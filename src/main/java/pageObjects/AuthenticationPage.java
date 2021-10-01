package pageObjects;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    @Getter
    public class AuthenticationPage {
        private WebDriver driver;
        @FindBy(xpath = "//h1")
        private WebElement pageHeading;
        @FindBy(id = "email")
        private WebElement email;
        @FindBy(id = "passwd")
        private WebElement password;
        @FindBy(id = "SubmitLogin")
        private WebElement signInBtn;
        @FindBy(css = "p[class='info-account']")
        private WebElement infoAccount;
        @FindBy(xpath = "//a[@title='Log me out']")
        private WebElement logOutBtn;
        public AuthenticationPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public String getTextInfoAccount() {
            return infoAccount.getText();
        }
    }



