package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class EntryTest extends BaseTest implements ITestConstants {

    @Test(description = "Create new entry test")
    public void createNewEntryTest() {
        loginSteps.loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps.createNewEntryAndCheckCreated(ENTRY_TEXT);
    }

    @Test(description = "Delete created entry test")
    public void deleteNewEntryTest() {
        loginSteps.loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps.deleteCreatedEntryAndCheckDeleted(ENTRY_TEXT);
    }

    @Test(description = "After choosing a date on a calendar, all entries created on that date are displayed test")
    public void searchEntryByDateTest() {
        loginSteps.loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntryAndCheckCreated(ENTRY_TEXT)
                .searchEntryByDateAndCheckFound();
    }

    @Test(description = "Delete all entries test")
    public void deleteAllEntriesTest() {
        loginSteps.loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntryAndCheckCreated(ENTRY_TEXT)
                .createNewEntryAndCheckCreated(ENTRY_TEXT)
                .deleteAllEntriesAndCheckDeleted(ENTRY_TEXT);
        loginSteps.loginUserAfterLogout(USER, PASSWORD);
    }
}
