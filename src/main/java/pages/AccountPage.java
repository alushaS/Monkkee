package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage{

    public static final SelenideElement USER_REGISTERED = $x("//h1[contains(text(), 'User registered')]");
    public static final SelenideElement USER_NOT_REGISTERED = $x("//*[@class='alert alert-danger']");


    public String getSuccessfulRegistrationText() {
        return USER_REGISTERED.getText();
    }

//    public String getSuccessfulRegistrationText() {
//        try { log.info("Getting successful registration text.");
//            return USER_REGISTERED.getText(); }
//        catch (Exception e) {
//            log.error("Failed to get successful registration text.", e); return ""; }
//    }



    public String getFailedRegistrationText() {
        return USER_NOT_REGISTERED.getText();
    }

//    public String getFailedRegistrationText() {
//        try { log.info("Getting failed registration text.");
//            return USER_NOT_REGISTERED.getText(); }
//        catch (Exception e)
//        { log.error("Failed to get failed registration text.", e); return ""; }
//    }
}
