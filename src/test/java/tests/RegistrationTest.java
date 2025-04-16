package tests;

import org.testng.annotations.Test;

public class RegistrationTest extends Preconditions implements ITestConstants {

    @Test(description = "Successful registration test")
    public void registerUserTest() {
        registrationSteps
                .registerUserWIthAllFieldsAndCheckUserRegistered(REGISTRATION_URL, userWithAllFields);
    }

    @Test(description = "Register user with all empty fields test")
    public void registerUserWithAllEmptyFieldsTest() {
        registrationSteps
                .registerUserWithAllEmptyFieldsAndCheckUserNotRegistered(REGISTRATION_URL, userWithAllEmptyFields);
    }

    @Test(description = "Register user with empty password confirmation field")
    public void registerUserWithEmptyPasswordConfirmationFieldTest() {
        registrationSteps
                .registerUserWithEmptyPasswordConfirmationFieldAndCheckUserNotRegistered(REGISTRATION_URL, userWithEmptyPasswordConfirmationField);
    }
}
