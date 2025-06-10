package SwagLabs.utiles;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions() {
    }

    public static void navigateToURL(WebDriver driver, String url)
    {
        driver.get(url);
    }

    public static String getCurrentURL(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }

    /// Set page Title
    public static String getPageTitle(WebDriver driver)
    {
        return driver.getTitle();
    }

    /// Refresh page
    public static void refreshPage (WebDriver driver)
    {
        driver.navigate().refresh();
    }
}
