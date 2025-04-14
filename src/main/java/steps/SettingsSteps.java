package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.SettingsPage;

import static pages.SettingsPage.LANGUAGE_CHANGED_TO_ENGLISH;
import static pages.SettingsPage.LANGUAGE_CHANGED_TO_FRENCH;

public class SettingsSteps extends BaseSteps {

    SettingsPage settingsPage;

    public SettingsSteps() {
        this.settingsPage = new SettingsPage();
    }

    @Step("Change language from English to French step")
    public void changeLanguageToFrench(String url, String option) {
        settingsPage
                .openSettingsPage(url)
                .isOpened()
                .changeLanguage(option);
        Assert.assertTrue(settingsPage.isLanguageChanged(LANGUAGE_CHANGED_TO_FRENCH));
    }

    @Step("Change language to English back")
    public void changeLanguageToEnglishBack(String url, String option) {
        settingsPage
                .openSettingsPage(url)
                .isOpened()
                .changeLanguage(option);
        Assert.assertTrue(settingsPage.isLanguageChanged(LANGUAGE_CHANGED_TO_ENGLISH));
    }
}
