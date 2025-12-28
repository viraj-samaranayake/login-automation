package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTestInValid extends BaseClass{

    LoginPage loginPage = new LoginPage();

    @Test
    void loginTestInvalid(){
        loginPage.setUsername("invalid_user");
        loginPage.setPassword("secret_sa12");
        loginPage.clickLoginBtn();

        String expErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMsg(),expErrorMsg,"Error message not displayed..");
    }
}
