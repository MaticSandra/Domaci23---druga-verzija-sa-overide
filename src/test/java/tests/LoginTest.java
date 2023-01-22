package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginStandardUser(){
        loginPage.login("standard_user", "secret_sauce");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/inventory.html"));
        driver.navigate().refresh();

        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("/inventory.html"));
    }

    @Test
    public void loginLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");


//        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")));
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));

        String actualMessage = errorMessage.getText();
        String expectedMessage= "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    public void loginProblemUser() {
        loginPage.login("problem_user", "secret_sauce");

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        String expectedMessage= "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
