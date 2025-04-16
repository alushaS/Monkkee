package pages;

import com.codeborne.selenide.Condition;
import elements.Dropdown;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static elements.Dropdown.LANGUAGE_DROPDOWN;
import static pages.EntriesPage.SUBMIT;

@Log4j2
public class SettingsPage extends BasePage {

    public static final String LANGUAGE_CHANGED_TEXT = "//*[contains(text(), '%s')]";
    public static final String LANGUAGE_CHANGED_TO_FRENCH = "Modifications enregistrées";
    public static final String LANGUAGE_CHANGED_TO_ENGLISH = "Your language has been changed successfully";

    /**
     * Open settings page.
     *
     * @param url the url
     * @return the settings page
     */
    public SettingsPage openSettingsPage(String url) {
        open(url);
        return this;
    }

    /**
     * Is opened settings page.
     *
     * @return the settings page
     */
    public SettingsPage isOpened() {
        LANGUAGE_DROPDOWN.shouldBe(Condition.visible);
        log.info("Settings page is opened.");
        return this;
    }

    /**
     * Change language settings page.
     *
     * @param option the option
     * @return the settings page
     */
    public SettingsPage changeLanguage(String option) {
        new Dropdown().languageSelectOption(option);
        SUBMIT.click();
        log.info("Language is changed to {}.", option);
        return this;
    }

    /**
     * Is language changed boolean.
     *
     * @param text the text
     * @return the boolean
     */
    public boolean isLanguageChanged(String text) {
        $x(String.format(LANGUAGE_CHANGED_TEXT, text)).shouldBe(Condition.visible);
        return $x(String.format(LANGUAGE_CHANGED_TEXT, text)).is(Condition.visible);
    }
}
