package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static pages.SettingsPage.LANGUAGE_DROPDOWN;

public class Dropdown {

    /**
     * Language select option.
     *
     * @param option the option
     */
    public void languageSelectOption(String option) {
        LANGUAGE_DROPDOWN.selectOptionByValue(option);
    }
}
