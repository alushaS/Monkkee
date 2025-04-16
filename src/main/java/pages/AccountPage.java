package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class AccountPage extends BasePage{

    public static final SelenideElement USER_REGISTERED = $x("//h1[contains(text(), 'User registered')]");
    public static final SelenideElement USER_NOT_REGISTERED = $x("//*[@class='alert alert-danger']");


    /**
     * Gets successful registration text.
     *
     * @return the successful registration text
     */
    public String getSuccessfulRegistrationText() {
        try { log.info("Getting successful registration text.");
            return USER_REGISTERED.getText();
        }
        catch (Exception e) {
            log.error("Failed to get successful registration text.", e); return "";
        }
    }

    /**
     * Gets failed registration text.
     *
     * @return the failed registration text
     */
    public String getFailedRegistrationText() {
        try { log.info("Getting failed registration text.");
            return USER_NOT_REGISTERED.getText();
        }
        catch (Exception e) {
            log.error("Failed to get failed registration text.", e); return "";
        }
    }
}
