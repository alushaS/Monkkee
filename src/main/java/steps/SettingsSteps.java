package steps;

import io.qameta.allure.Step;
import pages.SettingsPage;

public class SettingsSteps extends BaseSteps {

    SettingsPage settingsPage;

    public SettingsSteps() {
        this.settingsPage = new SettingsPage();
    }

    @Step("Change language from English to French step")
    public void changeLanguage(String url, String option) {
        settingsPage
                .openSettingsPage(url)
                .isOpened()
                .changeLanguage(option);
    }
}
