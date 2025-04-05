package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions{

    @Test(description = "Successful user login test")
    public void loginUser() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
    Assert.assertEquals(entriesPage.getSuccessfulLoginText(), "Logout");
    }

    @Test(description = "Login with empty login and password test")
    public void loginWithEmptyFieldsTest() {
        loginSteps
                .loginUser(LOGIN_URL, userWithAllEmptyFieldsForLogin);
        Assert.assertEquals(loginPage.getFailedLoginText(), "Mandatory field");
        Assert.assertEquals(loginPage.getFailedPasswordText(), "Mandatory field");
    }

    @Test(description = "Login with empty password test")
    public void loginWithEmptyPasswordTest() {
        loginSteps
                .loginUser(LOGIN_URL, userWithEmptyPasswordForLogin);
        Assert.assertEquals(loginPage.getFailedPasswordText(), "Mandatory field");
    }

    @Test(description = "Login with empty email test")
    public void loginWithEmptyEmailTest() {
        loginSteps
                .loginUser(LOGIN_URL, userWithEmptyEmailForLogin);
        Assert.assertEquals(loginPage.getFailedLoginText(), "Mandatory field");
    }

    @Test(description = "Send password reminder test")
    public void sendPasswordReminderTest() {
            passwordReminderPage
                    .openPasswordReminderPage(PASSWORD_REMINDER_URL)
                    .fillReminderForm(USER);
            Assert.assertEquals(passwordReminderPage.getHintSentMessage(), "Password hint sent");
    }


}
