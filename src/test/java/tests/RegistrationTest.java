package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends Preconditions{

    @Test(description = "Successful registration test")
    public void registerUserTest() {
        registrationSteps.registerUserStep(REGISTRATION_URL, USER, PASSWORD, PASSWORD_CONFIRMATION, HINT);
    Assert.assertEquals(accountPage.getSuccessfulRegistrationText(), "User registered");
    }

    @Test(description = "Register user with all empty fields test")
    public void registerUserWithAllEmptyFieldsTest() {
        registrationSteps.registerUserStep(REGISTRATION_URL, userWithAllEmptyFields);
    Assert.assertFalse(registrationPage.isButtonOkDisabled());
    }

    @Test(description = "Register user with empty password confirmation field")
    public void registerUserWithEmptyPasswordConfirmationFieldTest() {
        registrationSteps
                .registerUserWithEmptyPasswordConfirmationFieldStep(REGISTRATION_URL, userWithEmptyPasswordConfirmationField);
        Assert.assertEquals(accountPage.getFailedRegistrationText(), "Registration not successful");
    }
}
