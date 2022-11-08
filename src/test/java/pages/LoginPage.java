package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WebDriver webDriver;
    @FindBy(name = "username")
    private WebElement inputUsername;
    @FindBy(name = "password")
    private WebElement inputPassword;
    @FindBy(name = "login")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void setInputUsername(String username) {
        logger.info("Setting username: " + username);
        inputUsername.sendKeys(username);
    }

    public void setInputPassword(String password) {
        logger.info("Setting password: *******");
        inputPassword.sendKeys(password);
    }

    public WebDriver clickOnButtonLogin() {
        logger.info("Clicking on login button");
        buttonLogin.click();
        return this.webDriver;
    }
}
