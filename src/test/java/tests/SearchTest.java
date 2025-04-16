package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest implements ITestConstants {

    @Test(description = "Search existing entry test")
    public void searchExistingEntryTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .searchExistingEntry(ENTRY_TEXT);
    }

    @Test(description = "Search non-existing entry test")
    public void searchNonExistingEntryTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .searchNonExistingEntry(NON_EXISTING_ENTRY_TEXT);
    }
}
