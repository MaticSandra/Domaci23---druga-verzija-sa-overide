package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveProductTest extends BaseTest {

    @Test
    public void addRemoveTest(){
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.add();

        Assert.assertEquals(inventoryPage.getBadge().getText(), "1");

        inventoryPage.remove();
        Assert.assertTrue(inventoryPage.getShoppingCart().getText().isEmpty());

    }

}
