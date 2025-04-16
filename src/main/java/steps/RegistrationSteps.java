package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.AccountPage;
import pages.RegistrationPage;

public class RegistrationSteps extends BaseSteps implements IConstants {

    RegistrationPage registrationPage;
    AccountPage accountPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage();
        this.accountPage = new AccountPage();
    }

    @Step("Register user: {email}")
    public void registerUserWIthAllFieldsAndCheckUserRegistered(String url, User user) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUser(user);
        Assert.assertEquals(accountPage.getSuccessfulRegistrationText(), USER_REGISTERED);
    }

    @Step("Register user with empty password confirmation field")
    public void registerUserWithEmptyPasswordConfirmationFieldAndCheckUserNotRegistered(String url, User user) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUserWOPasswordConfirmation(user);
        Assert.assertEquals(accountPage.getFailedRegistrationText(), USER_NOT_REGISTERED);
    }

    @Step("Register user with all empty fields")
    public void registerUserWithAllEmptyFieldsAndCheckUserNotRegistered(String url, User user) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUserWithEmptyFields(user);
        Assert.assertTrue(registrationPage.isButtonOkDisabled());
    }
}
