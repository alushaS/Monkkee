package tests;

import org.testng.annotations.Test;

public class LoginTest extends Preconditions implements ITestConstants {

    @Test(description = "Successful user login test")
    public void loginUser() {
        loginSteps
                .loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
    }

    @Test(description = "Login with empty login and password test")
    public void loginWithEmptyFieldsTest() {
        loginSteps
                .loginUserWithEmptyLoginAndPasswordAndCheckValidations(LOGIN_URL, userWithAllEmptyFieldsForLogin);
    }

    @Test(description = "Login with empty password test")
    public void loginWithEmptyPasswordTest() {
        loginSteps
                .loginUserWithEmptyPasswordAndCheckValidation(LOGIN_URL, userWithEmptyPasswordForLogin);
    }

    @Test(description = "Login with empty email test")
    public void loginWithEmptyEmailTest() {
        loginSteps
                .loginUserWithEmptyEmailAndCheckValidation(LOGIN_URL, userWithEmptyEmailForLogin);
    }

    @Test(description = "Send password reminder test")
    public void sendPasswordReminderTest() {
        passwordReminderSteps
                .sendPasswordReminderAndCheckHintSent(PASSWORD_REMINDER_URL, USER);
    }
}
