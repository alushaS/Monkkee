package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static elements.Dropdown.LANGUAGE_DROPDOWN;
import static pages.EntriesPage.SUBMIT;

public class SettingsPage extends BasePage {

    public static final String LANGUAGE_CHANGED_TEXT = "//*[contains(text(), '%s')]";

    public SettingsPage openSettingsPage(String url) {
        open(url);
        return this;
    }

    public SettingsPage isOpened() {
        LANGUAGE_DROPDOWN.shouldBe(Condition.visible);
        return this;
    }

    public SettingsPage changeLanguage(String option) {
        new Dropdown().languageSelectOption(option);
        SUBMIT.click();
        return this;
    }

    public boolean isLanguageChanged(String text) {
        $x(String.format(LANGUAGE_CHANGED_TEXT, text)).shouldBe(Condition.visible);
        return $x(String.format(LANGUAGE_CHANGED_TEXT, text)).is(Condition.visible);
    }
}
