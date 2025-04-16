package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;


@Slf4j
public class EntryTest extends BaseTest implements ITestConstants {

    @Test(description = "Create new entry test")
    public void createNewEntryTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps.createNewEntry(ENTRY_TEXT);
    }

    @Test(description = "Delete created entry test")
    public void deleteNewEntryTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps.deleteCreatedEntry(ENTRY_TEXT);
    }

    @Test(description = "After choosing a date on a calendar, all entries created on that date are displayed test")
    public void searchEntryByDateTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .searchEntryByDate();
    }

    @Test(description = "Delete all entries test")
    public void deleteAllEntriesTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .createNewEntry(ENTRY_TEXT)
                .deleteAllEntries(ENTRY_TEXT);
        loginSteps.loginUserAfterLogout(USER, PASSWORD);
    }
}
