package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import entity.User;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class RegistrationPage extends BasePage {

    public static final SelenideElement SUBMIT_REG = $x("//button[@class='btn btn-primary']");

    public RegistrationPage() {
    }

    /**
     * Open registration page.
     *
     * @param url the url
     * @return the registration page
     */
    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    /**
     * Is opened registration page.
     *
     * @return the registration page
     */
    public RegistrationPage isOpened() {
        SUBMIT_REG.shouldBe(Condition.visible);
        log.info("Registration page is opened.");
        return this;
    }

    /**
     * Fill registration form.
     *
     * @param user the user
     * @return the registration page
     */
    public RegistrationPage fillRegistrationForm(User user) {
        isOpened();
        new Input("email").writeToRegistration(user.getEmail());
        new Input("password").writeToRegistration(user.getPassword());
        new Input("password_confirmation").writeToRegistration(user.getPasswordConfirmation());
        new Input("password_hint").writeToRegistration(user.getHint());
        log.info("Registration form is submitted with email: {}.", user.getEmail());
        return this;
    }


    /**
     * Register user account page.
     *
     * @param user the user
     * @return the account page
     */
    public AccountPage registerUser(User user) {
        fillRegistrationForm(user);
        new Checkbox("registration_terms_of_use").setCheckboxValue(true);
        new Checkbox("registration_lost_password_warning_registered").setCheckboxValue(true);
        new Button().click(SUBMIT_REG);
        log.info("Checkboxes \"Terms of use\" and \"Password lost warning\" are selected.");
        return new AccountPage();
    }

    /**
     * Register user with empty fields account page.
     *
     * @param user the user
     * @return the account page
     */
    public AccountPage registerUserWithEmptyFields(User user) {
        fillRegistrationForm(user);
        new Checkbox("registration_terms_of_use").setCheckboxValue(true);
        new Checkbox("registration_lost_password_warning_registered").setCheckboxValue(true);
        log.info("Attempt to register a user with empty fields.");
        return new AccountPage();
    }

    /**
     * Register user wo password confirmation account page.
     *
     * @param user the user
     * @return the account page
     */
    public AccountPage registerUserWOPasswordConfirmation(User user) {
        fillRegistrationForm(user);
        new Checkbox("registration_terms_of_use").setCheckboxValue(true);
        new Checkbox("registration_lost_password_warning_registered").setCheckboxValue(true);
        new Button().click(SUBMIT_REG);
        log.info("Attempt to register a user with empty password confirmation field.");
        return new AccountPage();
    }

    /**
     * Is button ok disabled boolean.
     *
     * @return the boolean
     */
    public boolean isButtonOkDisabled() {
        return SUBMIT_REG.is(Condition.disabled);
    }
}
