package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest implements ITestConstants {

    @Test (description = "Change language from English to French test")
    public void changeLanguageTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguageToFrench(LANGUAGE_SETTINGS, "fr");
    }

    @AfterMethod(description = "Change language to English back")
    public void changeLanguage() {
        loginSteps.logoutUser();
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguageToEnglishBack(LANGUAGE_SETTINGS, "en");
    }
}
