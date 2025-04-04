package pages;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage{

    public static final String USER_REGISTERED = "//h1[contains(text(), 'User registered')]";
    public static final String USER_NOT_REGISTERED = "//*[@class='alert alert-danger']";


    public String getSuccessfulRegistrationText() {
        return $x(USER_REGISTERED).getText();
    }

    public String getFailedRegistrationText() {
        return $x(USER_NOT_REGISTERED).getText();
    }
}
