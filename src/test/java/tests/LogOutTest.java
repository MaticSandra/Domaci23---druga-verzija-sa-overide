package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.Sidebar;

public class LogOutTest extends BaseTest{

    Sidebar sidebarPage;

    public void beforeClass(){
        super.beforeClass();
        sidebarPage = new Sidebar(driver, driverWait);
    }
    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        loginPage.login("standard_user", "secret_sauce");

    }

  @Test
  public void logoutButtonTest(){

      sidebarPage.menuClick();
      driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
      sidebarPage.logoutClick();

      Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

      driver.navigate().refresh();

      Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

      driver.get("https://www.saucedemo.com/inventory.html");

      Assert.assertEquals(sidebarPage.getErrorMessage().getText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");

  }


}
