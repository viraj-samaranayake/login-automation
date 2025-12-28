package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static testCases.BaseClass.driver;

public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span.title")
    WebElement pageTitle;

    @FindBy(css = "button#react-burger-menu-btn")
    WebElement hamBurgerIcon;

    @FindBy(css = "a#logout_sidebar_link")
    WebElement logoutIcon;


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public boolean verifyPageTitle(){
        String title = "Products";
        return title.equals(getPageTitle());
    }

    public boolean verifyUrl(){
        return driver.getCurrentUrl().contains("inventory");
    }

    public void clickHamburgerIcon(){
        hamBurgerIcon.click();
    }

    public void clickLogout(){
        logoutIcon.click();
    }
}
