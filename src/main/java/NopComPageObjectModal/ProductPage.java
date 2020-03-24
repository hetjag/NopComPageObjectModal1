package NopComPageObjectModal;

import org.openqa.selenium.By;

public class ProductPage extends Utils
{

    private By _email = By.cssSelector("input.button-2.email-a-friend-button");

    public void clickOnEmail()
    {
        scrollAndClick(_email);
    }
}
