package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Inventory;

public class AddRemoveProductTest extends BaseTest {

    Inventory inventoryPage;

    public void beforeClass(){
        super.beforeClass();
        inventoryPage = new Inventory(driver, driverWait);
    }
    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        loginPage.login("standard_user", "secret_sauce");

    }

    @Test
    public void addRemoveTest(){

        inventoryPage.add();

        Assert.assertEquals(inventoryPage.getBadge().getText(), "1");

        inventoryPage.remove();
        Assert.assertTrue(inventoryPage.getShoppingCart().getText().isEmpty());

    }



}
