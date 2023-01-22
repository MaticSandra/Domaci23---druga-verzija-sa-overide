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
      String expectedResult = "https://www.saucedemo.com/";
      String actualResult = driver.getCurrentUrl();

      Assert.assertEquals(actualResult, expectedResult);

      driver.get("https://www.saucedemo.com/inventory.html");

      String expectedError = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
      String actualError = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
      //*[@id="login_button_container"]/div/form/div[3]/h3/text()

      Assert.assertEquals(actualError, expectedError);

  }


}
