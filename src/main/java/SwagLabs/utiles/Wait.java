package SwagLabs.utiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    /// to prevent creating objects
    private Wait(){}

    ///  wait for Element to be Present
    public static WebElement waitElementPresent(WebDriver driver, By locator)
    {
      WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  waits.until(driver1 -> driver1.findElement(locator));
    }

    ///  wait for Element to be Visible
    public static WebElement waitElementVisible (WebDriver driver, By locator)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10);
         webDriverWait.until(driver1->
                { WebElement element = waitElementPresent(driver,locator);
                    return element.isDisplayed() ? element : null ;
                });
    }

    ///  wait for Element to be Clickable
    public static WebElement isClickable(WebDriver driver,By locator){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(driver1->
         {
             WebElement newElement = waitElementVisible(driver,locator);
             return newElement.isEnabled()? newElement : null;
         });
    }
}