package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import entity.User;
import org.checkerframework.checker.units.qual.C;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    public static final SelenideElement SUBMIT = $x("//button[@class='btn btn-primary']");

    public RegistrationPage() {
    }

    public RegistrationPage openRegistrationPage(String url) {
        open(url);
        return this;
    }

    public RegistrationPage isOpened() {
        SUBMIT.shouldBe(Condition.visible);
        return this;
    }

    private RegistrationPage fillRegistrationForm(User user) {
        isOpened();
        new Input("email").writeToRegistration(user.getEmail());
        new Input("password").writeToRegistration(user.getPassword());
        new Input("password_confirmation").writeToRegistration(user.getPasswordConfirmation());
        new Input("password_hint").writeToRegistration(user.getHint());
        return this;
    }


    public AccountPage registerUser(User user) {
        fillRegistrationForm(user);
        new Checkbox().selectCheckBoxes();
        new Button().click(SUBMIT);
        return new AccountPage();
    }

    public AccountPage registerUserWOPasswordConfirmation(User user) {
        fillRegistrationForm(user);
        new Checkbox().selectCheckBoxes();
        new Button().click(SUBMIT);
        return new AccountPage();
    }

    public boolean isButtonOkEnabled() {
        return SUBMIT.is(Condition.clickable);
    }

}
