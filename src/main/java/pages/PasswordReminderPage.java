package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class PasswordReminderPage extends BasePage {

    public static final SelenideElement SEND_PASSWORD_REMINDER = $x("//*[@class='btn btn-primary']");
    public static final SelenideElement PASSWORD_HINT_SENT = $x("//h1");

    public PasswordReminderPage() {
    }

    /**
     * Open password reminder page password reminder page.
     *
     * @param url the url
     * @return the password reminder page
     */
    public PasswordReminderPage openPasswordReminderPage(String url) {
        open(url);
        log.info("Password reminder page is opened.");
        return this;
    }

    /**
     * Fill reminder form password reminder page.
     *
     * @param email the email
     * @return the password reminder page
     */
    public PasswordReminderPage fillReminderForm(String email) {
        new Input("email").write(email);
        new Button().click(SEND_PASSWORD_REMINDER);
        log.info("Password reminder for user {} was sent.", email);
        return this;
    }

    /**
     * Gets hint sent message.
     *
     * @return the hint sent message
     */
    public String getHintSentMessage() {
        try { log.info("Getting successful hint sent message.");
            return PASSWORD_HINT_SENT.getText();
        }
        catch (Exception e) {
            log.error("Failed to get hint sent message.", e); return "";
        }
    }
}
