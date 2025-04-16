package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Checkbox {

    String label;
    private static final String CHECKBOX_LOCATOR = "//*[@id='%s']";
    private static final String ENTRY_CHECKBOX_LOCATOR = "//*[contains(text(), '%s')]/preceding::input[@type='checkbox'][1]";

    public Checkbox(String label) {
        this.label = label;
    }

    /**
     * Sets checkbox value.
     *
     * @param selected the selected
     */
    public void setCheckboxValue(boolean selected) {
        SelenideElement checkbox = $x(String.format(CHECKBOX_LOCATOR, label));
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Sets checkbox value for entry.
     *
     * @param selected the selected
     */
    public void setCheckboxValueForEntry(boolean selected) {
        SelenideElement checkbox = $x(String.format(ENTRY_CHECKBOX_LOCATOR, label));
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
