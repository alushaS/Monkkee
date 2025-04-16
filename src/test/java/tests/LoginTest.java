package tests;

import org.testng.annotations.Test;

public class LoginTest extends Preconditions implements ITestConstants {

    @Test(description = "Successful user login test")
    public void loginUser() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
    }

    @Test(description = "Login with empty login and password test")
    public void loginWithEmptyFieldsTest() {
        loginSteps
                .loginUserWithEmptyLoginAndPassword(LOGIN_URL, userWithAllEmptyFieldsForLogin);
    }

    @Test(description = "Login with empty password test")
    public void loginWithEmptyPasswordTest() {
        loginSteps
                .loginUserWithEmptyPassword(LOGIN_URL, userWithEmptyPasswordForLogin);
    }

    @Test(description = "Login with empty email test")
    public void loginWithEmptyEmailTest() {
        loginSteps
                .loginUserWithEmptyEmail(LOGIN_URL, userWithEmptyEmailForLogin);
    }

    @Test(description = "Send password reminder test")
    public void sendPasswordReminderTest() {
        passwordReminderSteps
                .sendPasswordReminder(PASSWORD_REMINDER_URL, USER);
    }
}
