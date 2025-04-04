package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import entity.User;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    public static final SelenideElement REGISTRATION_SUBMIT = $x("//button[@class='btn btn-primary']");
    public static final SelenideElement TERMS_OF_USE_CHECKBOX = $x("//*[@id='registration_terms_of_use']");
    public static final SelenideElement WARNING_CHECKBOX = $x("//*[@id='registration_lost_password_warning_registered']");


    public RegistrationPage() {
    }

    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    public RegistrationPage isOpened() {
        REGISTRATION_SUBMIT.shouldBe(Condition.visible);
        return this;
    }

    private RegistrationPage fillRegistrationForm(String email, String password, String passwordConfirmation, String hint) {
        isOpened();
        new Input("registration_email").write(email);
        new Input("registration_password").write(password);
        new Input("registration_password_confirmation").write(passwordConfirmation);
        new Input("registration_password_hint").write(hint);
        return this;
    }

    private RegistrationPage fillRegistrationForm(User user) {
        isOpened();
        new Input("registration_email").write(user.getEmail());
        new Input("registration_password").write(user.getPassword());
        new Input("registration_password_confirmation").write(user.getPasswordConfirmation());
        new Input("registration_password_hint").write(user.getHint());
        return this;
    }

    public AccountPage registerUser(String email, String password, String passwordConfirmation, String hint) {
        fillRegistrationForm(email, password, passwordConfirmation, hint);
        TERMS_OF_USE_CHECKBOX.setSelected(true);
        WARNING_CHECKBOX.setSelected(true);
        new Button().click(REGISTRATION_SUBMIT);
        return new AccountPage();
    }

    public AccountPage registerUser(User user) {
        fillRegistrationForm(user);
        TERMS_OF_USE_CHECKBOX.setSelected(true);
        WARNING_CHECKBOX.setSelected(true);
        return new AccountPage();
    }

    public AccountPage registerUserWOPasswordConfirmation(User user) {
        fillRegistrationForm(user);
        TERMS_OF_USE_CHECKBOX.setSelected(true);
        WARNING_CHECKBOX.setSelected(true);
        new Button().click(REGISTRATION_SUBMIT);
        return new AccountPage();
    }

    public boolean isButtonOkDisabled() {
        return REGISTRATION_SUBMIT.is(Condition.clickable);
    }

}
