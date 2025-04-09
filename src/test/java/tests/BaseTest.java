package tests;

import com.codeborne.selenide.Configuration;
import entity.Entry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.*;
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
    public static final String PASSWORD_REMINDER_URL = PropertyReader.getProperty("passwordReminderUrl");
    public static final String ENTRY_TEXT = PropertyReader.getProperty("entryText");
    public static final String NON_EXISTING_ENTRY_TEXT = PropertyReader.getProperty("nonExistingEntryText");
    public static final String LANGUAGE_SETTINGS = PropertyReader.getProperty("languageUrl");


    protected RegistrationPage registrationPage;
    protected RegistrationSteps registrationSteps;
    protected AccountPage accountPage;
    protected LoginPage loginPage;
    protected EntriesPage entriesPage;
    protected LoginSteps loginSteps;
    protected PasswordReminderPage passwordReminderPage;
    protected PasswordReminderSteps passwordReminderSteps;
    protected EntryPage entryPage;
    protected EntrySteps entrySteps;
    protected EntryTest entryTest;
    protected Entry entry;
    protected SettingsPage settingsPage;
    protected SettingsSteps settingsSteps;

    public void initPages() {
        registrationPage =new RegistrationPage();
        registrationSteps = new RegistrationSteps();
        accountPage = new AccountPage();
        loginPage = new LoginPage();
        entriesPage = new EntriesPage();
        loginSteps = new LoginSteps();
        passwordReminderPage = new PasswordReminderPage();
        entryPage = new EntryPage();
        entrySteps = new EntrySteps();
        entryTest = new EntryTest();
        entry = new Entry();
        passwordReminderSteps = new PasswordReminderSteps();
        settingsPage = new SettingsPage();
        settingsSteps = new SettingsSteps();
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
