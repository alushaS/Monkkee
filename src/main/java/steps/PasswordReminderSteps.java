package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.PasswordReminderPage;

public class PasswordReminderSteps extends BaseSteps{

    PasswordReminderPage passwordReminderPage;

    public PasswordReminderSteps() {
        this.passwordReminderPage = new PasswordReminderPage();
    }

    @Step("Send password reminder step for user: {email}")
    public void sendPasswordReminderAndCheckHintSent(String url, String email) {
        passwordReminderPage
                .openPasswordReminderPage(url)
                .fillReminderForm(email);
        Assert.assertEquals(passwordReminderPage.getHintSentMessage(), "Password hint sent");
    }
}
