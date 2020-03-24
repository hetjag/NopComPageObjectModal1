package NopComPageObjectModal;

import org.openqa.selenium.By;

public class EmailAFriendPage extends Utils
{
    String expected = "Your message has been sent.";
    String expectedError = "Only registered customers can use email a friend feature";
    private By _friendEmail = By.id("FriendEmail");
    private By _yourEmail = By.id("YourEmailAddress");
    private By _textBox = By.xpath("//*[@id='PersonalMessage']");
    private By _sendEmail = By.name("send-email");
    private String friendEmail = "wet@gmail.com";
    private String yourEmail = "set@gmail.com";
    private String message = "This is best product";
    private By _emailSuccessMessage = By.xpath("//div[@class='result']");
    private By _emailErrorMessage = By.xpath("//div[contains(@class,'message-error')]/ul/li");

    public void verifyUserOnEmailAFriendPage() {
        assertURL("productemailafriend");
    }

    public void emailAFriendDetails() {
        sleep(3);
        EnterText(_friendEmail, friendEmail);
        EnterText(_yourEmail, yourEmail);
        EnterText(_textBox, message);
        scrollAndClick(_sendEmail);
    }

    public void userFillsFriendDetailsWithoutOwnEmail() {
        sleep(3);
        EnterText(_friendEmail, friendEmail);
        EnterText(_textBox, message);
        scrollAndClick(_sendEmail);
    }

    public void clickOnSendEmail() {
        scrollAndClick(_sendEmail);
    }

    public void verifyUserSeeSuccessMessageOfEmailAFriend() {
        //   assertTextMessage("Your message has NOT been sent",expected,_emailSuccessMessage);
        assertTextMessage(_emailSuccessMessage, expected, "Your message has NOT been sent");
    }

    public void verifyUserSeeErrorMessage() {
        //     assertTextMessage("Your message not display",expected,_emailErrorMessage);
        assertTextMessage(_emailErrorMessage, expectedError, "Your message not display");
    }
}
