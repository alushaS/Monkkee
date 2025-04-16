package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest implements ITestConstants {

    @Test (description = "Change language from English to French test")
    public void changeLanguageTest() {
        loginSteps
                .loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguageToFrenchAndCheckLanguageChanged(LANGUAGE_SETTINGS, "fr");
    }

    @AfterMethod(description = "Change language to English back")
    public void changeLanguage() {
        loginSteps.logoutUser();
        loginSteps
                .loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguageToEnglishBackAndCheckLanguageChanged(LANGUAGE_SETTINGS, "en");
    }
}
