package Swaglabs.tests;

import SwagLabs.pages.LoginPage;
import SwagLabs.utiles.BrowserActions;
import SwagLabs.utiles.CustomSoftAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserActions.navigateToURL(driver,"https://www.saucedemo.com/");
    }

    @Test
    public void successfulLogin()
    {
        new LoginPage(driver).insertUsername("standard_user")
                .insertPassword("secret_sauce").
                SubmitLoginButton()
                .assertSuccessLoginSoft();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        CustomSoftAssertion.customAssertAll();
    }
}
