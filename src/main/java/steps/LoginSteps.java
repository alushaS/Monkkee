package steps;

import entity.User;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.EntriesPage;
import pages.LoginPage;

import static pages.LoginPage.MANDATORY_FIELD;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage;
    EntriesPage entriesPage;

    SoftAssert softAssert = new SoftAssert();

    public LoginSteps() {
        this.loginPage = new LoginPage();
        this.entriesPage = new EntriesPage();
    }

    @Step("Login user: {email}")
    public void loginUser(String url, String email, String password) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(email, password);
        Assert.assertTrue(entriesPage.isUserLoggedIn());
    }

    @Step("Login user: {email} after logout and deletion of all entries")
    public void loginUserAfterLogout(String email, String password) {
        loginPage
                .loginUser(email, password);
    }

    @Step("Login user: {email}")
    public void loginUser(String url, User user) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(user.getEmail(), user.getPassword());
    }

    @Step("Login user: {email}")
    public void loginUserWithEmptyLoginAndPassword(String url, User user) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(user.getEmail(), user.getPassword());
        softAssert.assertEquals(loginPage.getFailedLoginText(), MANDATORY_FIELD);
        softAssert.assertEquals(loginPage.getFailedPasswordText(), MANDATORY_FIELD);
    }

    @Step("Login user: {email} with empty password")
    public void loginUserWithEmptyPassword(String url, User user) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(user.getEmail(), user.getPassword());
        Assert.assertEquals(loginPage.getFailedPasswordText(), MANDATORY_FIELD);
    }

    @Step("Login user: {email} with empty email")
    public void loginUserWithEmptyEmail(String url, User user) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(user.getEmail(), user.getPassword());
        Assert.assertEquals(loginPage.getFailedLoginText(), MANDATORY_FIELD);
    }

    @Step("Logout user")
    public void logoutUser() {
        loginPage
                .logout();
    }
}
