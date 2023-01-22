package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement message;

    public Login(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void login(String username, String password) {

        this.username.sendKeys(username);
        this.password.sendKeys(password);

        loginButton.click();
    }

    public WebElement getMessage() {
        return message;
    }
}
