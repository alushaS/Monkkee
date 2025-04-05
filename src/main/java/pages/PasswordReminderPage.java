package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import steps.BaseSteps;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PasswordReminderPage extends BasePage {

    public static final SelenideElement SEND_PASSWORD_REMINDER = $x("//*[@class='btn btn-primary']");
    public static final SelenideElement PASSWORD_HINT_SENT = $x("//*[contains(text(), 'Password hint sent')]");

    public PasswordReminderPage() {
    }

    public PasswordReminderPage openPasswordReminderPage(String url) {
        open(url);
        return this;
    }

    public PasswordReminderPage fillReminderForm(String email) {
        new Input("email").write(email);
        new Button().click(SEND_PASSWORD_REMINDER);
        return this;
    }

    public String getHintSentMessage() {
        return PASSWORD_HINT_SENT.getText();
    }

}
