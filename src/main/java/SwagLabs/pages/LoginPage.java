package SwagLabs.pages;

import SwagLabs.utiles.BrowserActions;
import SwagLabs.utiles.CustomSoftAssertion;
import SwagLabs.utiles.ElementActions;
import SwagLabs.utiles.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public LoginPage insertUsername(String username) {

        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    public LoginPage insertPassword(String password) {

        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    public LoginPage SubmitLoginButton() {

        ElementActions.click(driver, loginButton);
        return this;
    }

    public String getErrorMessage()
    {
        return ElementActions.getText(driver,errorMessage);
    }


    /// Validations
    public LoginPage assertLoginPageUrl()
    {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),
                "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),"Swag Labs");
        return this;
    }

    public LoginPage assertSuccessLoginSoft()
    {
        assertLoginPageUrl().assertLoginPageTitle();
        return this;
    }

    public LoginPage assertUnsuccessfulLogin()
    {
        Validations.validateEquals(getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not as expected");
        return this;
    }
}
