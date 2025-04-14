package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import entity.User;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static pages.EntriesPage.LOGOUT;
import static pages.EntriesPage.SUBMIT;
import static pages.RegistrationPage.SUBMIT_REG;

@Log4j2
public class LoginPage extends BasePage {

    public static final SelenideElement LOGIN_MANDATORY = $x("//*[@class='form-group has-error'][1]/descendant::div[@class='help-block ng-binding']");
    public static final SelenideElement PASSWORD_MANDATORY = $x("//*[@class='col-sm-9']/descendant::div[2]");
    public static final String  MANDATORY_FIELD = "Mandatory field";

    public LoginPage() {
    }

    /**
     * Open login page.
     *
     * @param url the url
     * @return the login page
     */
    public LoginPage openLoginPage(String url) {
        open(url);
        log.info("Login page is opened.");
        return this;
    }

    /**
     * Is opened login page.
     *
     * @return the login page
     */
    public LoginPage isOpened() {
        SUBMIT.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Fill login form login page.
     *
     * @param email    the email
     * @param password the password
     * @return the login page
     */
    public LoginPage fillLoginForm(String email, String password) {
        isOpened();
        new Input("login").write(email);
        new Input("password").write(password);
        log.info("Login page is submitted with email: {} and password: {}.", email, password);
        return this;
    }

    /**
     * Fill login form login page.
     *
     * @param user the user
     * @return the login page
     */
    public LoginPage fillLoginForm(User user) {
        isOpened();
        new Input("login").write(user.getEmail());
        new Input("password").write(user.getPassword());
        log.info("Login page is submitted with email: {} and password: {}.", user.getEmail(), user.getPassword());
        return this;
    }

    /**
     * Login user entries page.
     *
     * @param email    the email
     * @param password the password
     * @return the entries page
     */
    public EntriesPage loginUser(String email, String password) {
        fillLoginForm(email, password);
        new Button().click(SUBMIT_REG);
        log.info("User with email: {} and password: {} is logged in.", email, password);
        return new EntriesPage();
    }

    /**
     * Login user entries page.
     *
     * @param user the user
     * @return the entries page
     */
    public EntriesPage loginUser(User user) {
        fillLoginForm(user);
        new Button().click(SUBMIT_REG);
        log.info("User with email: {} and password: {} is logged in.", user.getEmail(), user.getPassword());
        return new EntriesPage();
    }

    /**
     * Gets failed login text.
     *
     * @return the failed login text
     */
    public String getFailedLoginText() {
        try { log.info("Getting validation message for email field.");
            return LOGIN_MANDATORY.getText();
        }
        catch (Exception e) {
            log.error("Failed to get validation message for email field.", e); return "";
        }
    }

    /**
     * Gets failed password text.
     *
     * @return the failed password text
     */
    public String getFailedPasswordText() {
        try { log.info("Getting validation message for password field.");
            return PASSWORD_MANDATORY.getText();
        }
        catch (Exception e) {
            log.error("Failed to get validation message for password field.", e); return "";
        }
    }

    /**
     * Logout login page.
     *
     * @return the login page
     */
    public LoginPage logout() {
        LOGOUT.click();
        log.info("User was logged out.");
        return this;
    }
}
