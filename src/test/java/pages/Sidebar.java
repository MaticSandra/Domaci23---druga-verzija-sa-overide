package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar extends BasePage{
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public Sidebar(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void menuClick() {
        menu.click();
    }

    public void logoutClick() {
        logOutButton.click();
    }
}
