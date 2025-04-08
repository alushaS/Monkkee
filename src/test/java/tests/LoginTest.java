package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends Preconditions{

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Successful user login test")
    public void loginUser() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        Assert.assertTrue(entriesPage.isUserLoggedIn());
    }

    @Test(description = "Login with empty login and password test")
    public void loginWithEmptyFieldsTest() {
        loginSteps
                .loginUser(LOGIN_URL, userWithAllEmptyFieldsForLogin);
        softAssert.assertEquals(loginPage.getFailedLoginText(), "Mandatory field");
        softAssert.assertEquals(loginPage.getFailedPasswordText(), "Mandatory field");
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
        passwordReminderSteps
                .sendPasswordReminder(PASSWORD_REMINDER_URL, USER);
        Assert.assertEquals(passwordReminderPage.getHintSentMessage(), "Password hint sent");
    }
}
