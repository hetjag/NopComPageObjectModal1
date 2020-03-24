package NopComPageObjectModal;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private String firstName = "Raj";
    private String lastName = "Smith";
    private static String timeStemp = timeStamp();


    public  void verifyUserIsOnRegisterPage()
    {
        assertURL("register");

    }
    public  void userEntrsRegistrationDetails()
    {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EnterText(_firstName,firstName);
        EnterText(_lastName,lastName);
        EnterText(_email,"Rajpatel+"+timeStamp()+"@gmail.com");
        EnterText(_password,"Test1234");
        EnterText(_confirmPassword,"Test1234");

    }

    public void userClicksOnRegisterSubmitButton(){
        clickOnElement(_registerButton);

    }



}
