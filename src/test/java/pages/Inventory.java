package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventory extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCard;
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement remove;
    @FindBy (className =  "shopping_cart_link")
    private WebElement shoppingCart;
    @FindBy(className = "shopping_cart_badge")
    private WebElement badge;



    public Inventory(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getBadge() {
        return badge;
    }

    public void add(){
        addToCard.click();
    }
    public void remove(){
        remove.click();
    }
}


