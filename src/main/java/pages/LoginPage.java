package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import entity.User;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static pages.EntriesPage.LOGOUT;
import static pages.EntriesPage.SUBMIT;
import static pages.RegistrationPage.SUBMIT_REG;

public class LoginPage extends BasePage {

    public static final SelenideElement LOGIN_MANDATORY = $x("//*[@class='form-group has-error'][1]/descendant::div[@class='help-block ng-binding']");
    public static final SelenideElement PASSWORD_MANDATORY = $x("//*[@class='col-sm-9']/descendant::div[2]");
    public static final SelenideElement PASSWORD_REMINDER = $x("//*[contains(text(), 'Send password reminder')]");

    public LoginPage() {
    }

    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    public LoginPage isOpened() {
        SUBMIT.shouldBe(Condition.visible);
        return this;
    }

    private LoginPage fillLoginForm(String email, String password) {
        isOpened();
        new Input("login").write(email);
        new Input("password").write(password);
        return this;
    }

    private LoginPage fillLoginForm(User user) {
        isOpened();
        new Input("login").write(user.getEmail());
        new Input("password").write(user.getPassword());
        return this;
    }

    public EntriesPage loginUser(String email, String password) {
        fillLoginForm(email, password);
        new Button().click(SUBMIT_REG);
        return new EntriesPage();
    }

    public EntriesPage loginUser(User user) {
        fillLoginForm(user);
        new Button().click(SUBMIT_REG);
        return new EntriesPage();
    }

    public String getFailedLoginText() {
        return LOGIN_MANDATORY.getText();
    }

    public String getFailedPasswordText() {
        return PASSWORD_MANDATORY.getText();
    }

    public LoginPage logout() {
        LOGOUT.click();
        return this;
    }
}
