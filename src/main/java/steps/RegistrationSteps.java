package steps;

import entity.User;
import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationSteps extends BaseSteps{

    RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage();
    }

    @Step("Register user: {email}")
    public void registerUserStep(String url, String email, String password, String passwordConfirmation, String hint) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUser(email, password, passwordConfirmation, hint);
    }

    @Step("Register user with all empty fields")
    public void registerUserStep(String url, User user) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUser(user);
    }

    @Step("Register user with empty password confirmation field")
    public void registerUserWithEmptyPasswordConfirmationFieldStep(String url, User user) {
        registrationPage
                .openRegistrationPage(url)
                .isOpened()
                .registerUserWOPasswordConfirmation(user);
    }
}
