package NopComPageObjectModal;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod
    public void openBrowser()
    {
        browserSelector.setUpBrowser();

    }
    @AfterMethod
    public void closeBrowser(ITestResult result)
    {
        if (!result.isSuccess())
        {
            takeScreenShot(result.getName()+timeStamp());
        }
         driver.quit();

    }
}
