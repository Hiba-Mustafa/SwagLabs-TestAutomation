package SwagLabs.pages;

import SwagLabs.utiles.BrowserActions;
import SwagLabs.utiles.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    /// Locators
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    /// Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    /// Actions
    public void insertUsername(String username) {
        ElementActions.sendData(driver, this.username, username);
    }

    public void insertPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
    }

    public void SubmitLoginButton() {
        ElementActions.click(driver, loginButton);
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }

//    public void navigateToLoginPage() {
//        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
//    }

    /// Validation

    public void assertSuccessLogin() {
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/inventory.html");
    }

    public void assertUnsuccessfulLogin()
    {Assert.assertEquals(getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");}

}
