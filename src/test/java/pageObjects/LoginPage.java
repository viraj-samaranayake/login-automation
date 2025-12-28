package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static testCases.BaseClass.driver;

public class LoginPage {

    public LoginPage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "user-name")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//h3[text() = 'Epic sadface: Username and password do not match any user in this service']")
    WebElement errorMsg;


    // Methods to actions
    public void setUsername(String un) {
        username.clear();
        username.sendKeys(un);
    }

    public void setPassword(String pw) {
        password.clear();
        password.sendKeys(pw);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }
}
