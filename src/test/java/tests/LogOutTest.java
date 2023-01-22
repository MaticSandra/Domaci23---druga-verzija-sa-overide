package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{

  @Test
  public void logoutButtonTest(){

      loginPage.login("standard_user", "secret_sauce");
      sidebarPage.menuClick();
      driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
      sidebarPage.logoutClick();
      Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

      driver.get("https://www.saucedemo.com/inventory.html");

      Assert.assertEquals(sidebarPage.getErrorMessage().getText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");

  }


}
