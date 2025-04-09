package steps;

import entity.User;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.SettingsPage;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Login user: {email}")
    public void loginUser(String url, String email, String password) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .loginUser(email, password);
    }

    @Step("Login user: {email} after logout")
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

    public void logoutUser() {
        loginPage
                .logout();
    }
}
