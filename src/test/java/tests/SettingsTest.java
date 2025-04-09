package tests;

import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    @Test (description = "Change language from English to French test")
    public void changeLanguageTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguage(LANGUAGE_SETTINGS, "fr");
        Assert.assertTrue(settingsPage.isLanguageChanged("Modifications enregistrées"));
    }

    @AfterMethod(description = "Change language to English")
    public void changeLanguage() {
        loginSteps.logoutUser();
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        settingsSteps
                .changeLanguage(LANGUAGE_SETTINGS, "en");
    }
}
