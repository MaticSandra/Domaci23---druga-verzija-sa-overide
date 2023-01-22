package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Inventory;
import pages.Login;
import pages.Sidebar;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Login loginPage;
    protected Inventory inventoryPage;
    protected Sidebar sidebarPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdiver.chrome.driver", "C:\\ITBootCamp\\chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new Login(driver, driverWait);
        sidebarPage = new Sidebar(driver, driverWait);
        inventoryPage = new Inventory(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
