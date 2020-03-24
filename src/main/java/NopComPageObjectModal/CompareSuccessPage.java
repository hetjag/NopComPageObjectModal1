package NopComPageObjectModal;

import org.openqa.selenium.By;

public class CompareSuccessPage extends Utils
{
    private By _compareSuccessMassage = By.xpath("//div[@class='page-title']");
    String compareExpectedMessage = "Compare products";
    public void verifyUserShouldSeeCompareSuccessMassage()
    {
        assertURL("compareproducts");
        //assertTextMessage("Compare massage not display",expected,_compareSuccessMassage);
        assertTextMessage(_compareSuccessMassage,compareExpectedMessage,"Compare massage not display");

    }

}
