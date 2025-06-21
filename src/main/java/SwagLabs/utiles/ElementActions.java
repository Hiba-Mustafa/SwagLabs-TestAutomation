package SwagLabs.utiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    /// to prevent creating objects
    private ElementActions(){}

    /// Send keys
    public static void sendData(WebDriver driver, By locator, String data){

        Wait.waitElementVisible(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).sendKeys(data);
        driver.findElement(locator).sendKeys(data);
    }

    /// Click
    public static void click(WebDriver driver, By locator){
        Wait.isClickable(driver, locator);
        Scrolling.scrollToElement(driver,locator);
        driver.findElement(locator).click();
        findElement(driver, locator).click();
    }

    public static String getText(WebDriver driver, By locator)
    {
        Wait.waitElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return driver.findElement(locator).getText();

    }

    public static WebElement findElement(WebDriver driver, By locator)
    {
        return driver.findElement(locator);
    }
}
