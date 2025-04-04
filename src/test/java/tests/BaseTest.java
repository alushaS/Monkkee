package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.RegistrationPage;
import steps.RegistrationSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    public static final String USER = PropertyReader.getProperty("user");
    public static final String PASSWORD = PropertyReader.getProperty("password");
    public static final String PASSWORD_CONFIRMATION = PropertyReader.getProperty("passwordConfirmation");
    public static final String HINT = PropertyReader.getProperty("hint");
    public static final String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static final String REGISTRATION_URL = PropertyReader.getProperty("registrationUrl");

    protected RegistrationPage registrationPage;
    protected RegistrationSteps registrationSteps;
    protected AccountPage accountPage;

    public void initPages() {
        registrationPage =new RegistrationPage();
        registrationSteps = new RegistrationSteps();
        accountPage = new AccountPage();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

//    @AfterMethod
//    public void endTest() {
//        getWebDriver().quit();
//    }

}
