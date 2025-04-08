package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Checkbox {

    public static final SelenideElement TERMS_OF_USE_CHECKBOX = $x("//*[@id='registration_terms_of_use']");
    public static final SelenideElement WARNING_CHECKBOX = $x("//*[@id='registration_lost_password_warning_registered']");

    public void selectCheckBoxes() {
        TERMS_OF_USE_CHECKBOX.setSelected(true);
        WARNING_CHECKBOX.setSelected(true);
    }

}
