package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class LoginTest extends BaseClass{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Test
    public void loginTestValid(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBtn();

        String expPageName = "Products";
        String actualName = productsPage.getPageTitle();
        Assert.assertEquals(actualName,expPageName,"Login Failed..");
    }

}
