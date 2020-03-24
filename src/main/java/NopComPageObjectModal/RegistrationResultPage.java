package NopComPageObjectModal;

import org.openqa.selenium.By;

public class RegistrationResultPage extends Utils
{
    private By _registerSuccessMessage = By.className("result");
    String expected = "Your registration completed";
    private By _pageContinue = By.name("register-continue");
    public void verifyUserSeeRegistrationSuccessMessage()
    {
        sleep(3);
        assertURL("registerresult");
        assertTextMessage(_registerSuccessMessage,expected,"Registration not successful..." );
    }
    public void pageContinue()
    {
        sleep(3);
        clickOnElement(_pageContinue);
        System.out.println("cklciked continue");
    }

}
