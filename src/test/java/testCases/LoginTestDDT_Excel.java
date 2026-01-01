package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utilities.DataProviders;

import java.time.Duration;

public class LoginTestDDT_Excel extends BaseClass{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")
    public void loginDDT(String username, String password, String expectedResult){

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();

        boolean result = productsPage.verifyUrl();

        /**
         Valid username and password - login successful - test passed     -- logout need
         Valid username and password - login unsuccessful - test failed
         Invalid username and password - login successful - test failed
         Invalid username and password - login unsuccessful - test passed   -- logout need
         */

        // All positive & negative test cases executed successfully as following ;

        if(expectedResult.equalsIgnoreCase("valid")) {
            if (result) {
                Assert.assertTrue(true);
                productsPage.clickHamburgerIcon();
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
                productsPage.clickLogout();

            } else {
                Assert.fail();
            }
        }else if(expectedResult.equalsIgnoreCase("invalid")) {
            if (result) {
                productsPage.clickHamburgerIcon();
                productsPage.clickLogout();
                Assert.fail();
            } else {
                Assert.assertTrue(true);
            }
        }

    }
}
