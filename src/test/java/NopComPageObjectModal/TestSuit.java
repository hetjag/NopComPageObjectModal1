package NopComPageObjectModal;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    CompareSuccessPage compareSuccessPage = new CompareSuccessPage();
    ProductPage productPage = new ProductPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    BooksCategoryPage booksCategoryPage = new BooksCategoryPage();
    @Test
    public void userShouldAbleToRegisterSuccessfully() {
        //user clicks on register button
        homePage.clickOnRegisterButton();
        takeScreenShot("sample");
        //verify that user is on register page
        registrationPage.verifyUserIsOnRegisterPage();
        //fill up registration details
        registrationPage.userEntrsRegistrationDetails();
        registrationPage.userClicksOnRegisterSubmitButton();
        //verify registration success message
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();

    }

    @Test
    public void userShouldBeAbleToCompareTwoDifferentProductSuccessfully() {

        //select two products & click compare
        homePage.addProductsForComparison();
        //verify compare success massage
        compareSuccessPage.verifyUserShouldSeeCompareSuccessMassage();

    }

    @Test
    public void registeredUserShouldBeAbleToReferAProductTOAFriend() {
        homePage.clickOnRegisterButton();
        registrationPage.userEntrsRegistrationDetails();
        registrationPage.userClicksOnRegisterSubmitButton();

        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();

        //click on continue registration
        registrationResultPage.pageContinue();

        //click on any product
        homePage.clickOnProduct();

        //click on product
        productPage.clickOnEmail();

        //verify user in product email a friend page
        emailAFriendPage.verifyUserOnEmailAFriendPage();

        //user entering details
        emailAFriendPage.emailAFriendDetails();

        //verify email a friend massage display
        emailAFriendPage.verifyUserSeeSuccessMessageOfEmailAFriend();

    }

    @Test
    public void nonRegisteredUserShouldNotBeAbleToReferAProductToAFriend() {
//        click on any product
        homePage.clickOnProduct();

        //  Enter friends email
        productPage.clickOnEmail();

        //verify user in product email a friend page
        emailAFriendPage.verifyUserOnEmailAFriendPage();

        //Enter friend details
        emailAFriendPage.emailAFriendDetails();

        // verify error massage
        emailAFriendPage.verifyUserSeeErrorMessage();
    }

    @Test
    public void userShouldBeAbleToSortProductHighToLowByPrice()
    {
        sleep(3);

        //click on book category
        homePage.clickOnBookCategory();

        //verify user on books category page
        booksCategoryPage.verifyUserShouldOnCategoryPage();

        //select sort by options High to Low
        booksCategoryPage.selectCategoryOpitionsHighToLow();

        // verify price organised high to low
        booksCategoryPage.verifyPriceOrganisedHighToLow();
    }


}
