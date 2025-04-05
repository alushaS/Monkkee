package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EntriesPage extends BasePage{

    public static final SelenideElement LOGOUT = $x("//*[contains(text(), 'Logout')]");

    public String getSuccessfulLoginText() {
        LOGOUT.shouldBe(Condition.visible);
        return LOGOUT.getText();
    }


}
