package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.RegistrationPage.SUBMIT;

public class EntriesPage extends BasePage{

    public static final SelenideElement LOGOUT = $x("//button[@class='user-menu__btn']");
    public static final SelenideElement TOOLBAR = $x("//*[@class='btn-toolbar']");
    public static final SelenideElement CREATE_ENTRY = $x("//*[@id='create-entry']");
    public static final SelenideElement DELETE_ENTRY = $x("//*[@id='delete-entries']");
    public static String ENTRY_TEXT_XPATH = "//*[contains(text(), '%s')]";
    public static String ENTRY_CHECKBOX = "//*[contains(text(), '%s')]/preceding::input[@type='checkbox'][1]";
    public static final SelenideElement DELETE_ALL_CHECKBOX = $x("//*[@title='Select all']");
    public static final SelenideElement NO_ENTRIES_FOUND = $x("//*[contains(text(), 'No entries found')]");
    public static final SelenideElement SUBMIT_SEARCH = $x("//*[@type='submit']");


    public boolean isUserLoggedIn() {
        isOpened();
        return LOGOUT.is(Condition.clickable);
    }

    public EntriesPage isOpened() {
        TOOLBAR.shouldBe(Condition.visible);
        return this;
    }

    public EntryPage openEntryPage() {
        CREATE_ENTRY.shouldBe(Condition.visible);
        new Button().click(CREATE_ENTRY);
        return new EntryPage();
    }

    public String getExistEntryText(String entryText) {
        return $x(String.format(ENTRY_TEXT_XPATH, entryText)).getText();
    }

    public boolean isEntryDeleted(String entryText) {
       return $x(String.format(ENTRY_TEXT_XPATH, entryText)).is(Condition.visible);
    }

    public String getNoEntriesFoundText() {
        return NO_ENTRIES_FOUND.getText();
    }

    public EntriesPage deleteEntry(String entryText) {
        $x(String.format(ENTRY_CHECKBOX, entryText)).click();
        DELETE_ENTRY.click();
        getWebDriver().switchTo().alert().accept();
        return this;
    }

    public EntriesPage deleteAllEntries() {
        new Button().click(DELETE_ALL_CHECKBOX);
        DELETE_ENTRY.click();
        getWebDriver().switchTo().alert().accept();
        new Button().click(LOGOUT);
        return this;
    }

    public EntriesPage searchEntry(String entryText) {
        new Input("appendedInputButton").write(entryText);
        new Button().click(SUBMIT_SEARCH);
        return this;
    }




}
