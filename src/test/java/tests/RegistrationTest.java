package tests;

import org.testng.annotations.Test;

public class RegistrationTest extends Preconditions implements ITestConstants {

    @Test(description = "Successful registration test")
    public void registerUserTest() {
        registrationSteps
                .registerUserWIthAllFields(REGISTRATION_URL, userWithAllFields);
    }

    @Test(description = "Register user with all empty fields test")
    public void registerUserWithAllEmptyFieldsTest() {
        registrationSteps
                .registerUserWithAllEmptyFields(REGISTRATION_URL, userWithAllEmptyFields);
    }

    @Test(description = "Register user with empty password confirmation field")
    public void registerUserWithEmptyPasswordConfirmationFieldTest() {
        registrationSteps
                .registerUserWithEmptyPasswordConfirmationField(REGISTRATION_URL, userWithEmptyPasswordConfirmationField);
    }
}
