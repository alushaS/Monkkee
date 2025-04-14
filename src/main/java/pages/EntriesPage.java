package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Slf4j
public class EntriesPage extends BasePage{

    public static final SelenideElement LOGOUT = $x("//button[@class='user-menu__btn']");
    public static final SelenideElement TOOLBAR = $x("//*[@class='btn-toolbar']");
    public static final SelenideElement CREATE_ENTRY = $x("//*[@id='create-entry']");
    public static final SelenideElement DELETE_ENTRY = $x("//*[@id='delete-entries']");
    public static final SelenideElement DELETE_ALL_CHECKBOX = $x("//*[@title='Select all']");
    public static final SelenideElement NO_ENTRIES_FOUND = $x("//*[contains(text(), 'No entries found')]");
    public static final SelenideElement SUBMIT = $x("//*[@type='submit']");
    public static final SelenideElement CALENDAR_INPUT_XPATH = $x("//*[@id='datepicker']");
    public static final SelenideElement CALENDAR_CURRENT_DATE = $x("//*[@class='day active enabled']");
    public static final SelenideElement DATEPICKER_MODE = $x("//*[@class='datepicker-days datepicker-mode']");
    public static final SelenideElement SEARCH_RESULT = $x("//*[@ng-show='searchExplanation']");
    public static final String ENTRY_TEXT_XPATH = "//*[contains(text(), '%s')]";
    public static final String NO_ENTRIES_FOUND_TEXT = "No entries found";

    /**
     * Is user logged in boolean.
     *
     * @return the boolean
     */
    public boolean isUserLoggedIn() {
        isOpened();
        log.info("User is logged in.");
        return LOGOUT.is(Condition.clickable);
    }

    /**
     * Is opened entries page.
     *
     * @return the entries page
     */
    public EntriesPage isOpened() {
        TOOLBAR.shouldBe(Condition.visible);
        log.info("Entry creation window is fully loaded.");
        return this;
    }

    /**
     * Open entry page.
     *
     * @return the entry page
     */
    public EntryPage openEntryPage() {
        CREATE_ENTRY.shouldBe(Condition.visible);
        new Button().click(CREATE_ENTRY);
        log.info("Entry page is opened.");
        return new EntryPage();
    }

    /**
     * Gets exist entry text.
     *
     * @param entryText the entry text
     * @return the exist entry text
     */
    public String getExistEntryText(String entryText) {
        try { log.info("Getting existing entry text.");
            return $x(String.format(ENTRY_TEXT_XPATH, entryText)).getText();
        }
        catch (Exception e) {
            log.error("Failed to get existing entry text.", e); return ""; }
    }

    /**
     * Is entry deleted boolean.
     *
     * @param entryText the entry text
     * @return the boolean
     */
    public boolean isEntryDeleted(String entryText) {
       log.info("Entry: {} is deleted.", entryText);
       return $x(String.format(ENTRY_TEXT_XPATH, entryText)).is(Condition.visible);
    }

    /**
     * Gets no entries found text.
     *
     * @return the no entries found text
     */
    public String getNoEntriesFoundText() {
        NO_ENTRIES_FOUND.shouldBe(Condition.visible);
        log.info("Message: {} is displayed.", NO_ENTRIES_FOUND);
        return NO_ENTRIES_FOUND.getText();
    }

    /**
     * Delete entry.
     *
     * @param entryText the entry text
     * @return the entries page
     */
    public EntriesPage deleteEntry(String entryText) {
        new Checkbox(entryText).setCheckboxValueForEntry(true);
        DELETE_ENTRY.click();
        getWebDriver().switchTo().alert().accept();
        log.info("Entry: {} was deleted.", entryText);
        return this;
    }

    /**
     * Delete all entries.
     *
     * @return the entries page
     */
    public EntriesPage deleteAllEntries() {
        new Button().click(DELETE_ALL_CHECKBOX);
        DELETE_ENTRY.click();
        getWebDriver().switchTo().alert().accept();
        new Button().click(LOGOUT);
        log.info("All entries were deleted.");
        return this;
    }

    /**
     * Search entry.
     *
     * @param entryText the entry text
     * @return the entries page
     */
    public EntriesPage searchEntry(String entryText) {
        new Input("appendedInputButton").write(entryText);
        new Button().click(SUBMIT);
        log.info("Entry {} was being searched.", entryText);
        return this;
    }

    /**
     * Search entry by date.
     *
     * @return the entries page
     */
    public EntriesPage searchEntryByDate() {
        CALENDAR_INPUT_XPATH.click();
        DATEPICKER_MODE.shouldBe(Condition.visible);
        CALENDAR_CURRENT_DATE.click();
        SEARCH_RESULT.shouldBe(Condition.visible);
        log.info("Entry was being searched by date.");
        return this;
    }
}
