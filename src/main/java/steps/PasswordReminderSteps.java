package steps;

import io.qameta.allure.Step;
import pages.PasswordReminderPage;

public class PasswordReminderSteps extends BaseSteps{

    PasswordReminderPage passwordReminderPage;

    public PasswordReminderSteps() {
        this.passwordReminderPage = new PasswordReminderPage();
    }

    @Step("Send password reminder step for user: {email}")
    public void sendPasswordReminder(String url, String email) {
        passwordReminderPage
                .openPasswordReminderPage(url)
                .fillReminderForm(email);
    }
}
