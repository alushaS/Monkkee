package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {

    public static final SelenideElement LANGUAGE_DROPDOWN = $x("//*[@name='selectLocale']");

    /**
     * Language select option.
     *
     * @param option the option
     */
    public void languageSelectOption(String option) {
        LANGUAGE_DROPDOWN.selectOptionByValue(option);
    }
}
