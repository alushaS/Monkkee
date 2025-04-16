package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest implements ITestConstants {

    @Test(description = "Search existing entry test")
    public void searchExistingEntryTest() {
        loginSteps
                .loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntryAndCheckCreated(ENTRY_TEXT)
                .searchEntryAndCheckExists(ENTRY_TEXT);
    }

    @Test(description = "Search non-existing entry test")
    public void searchNonExistingEntryTest() {
        loginSteps
                .loginUserAndCheckLogged(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntryAndCheckCreated(ENTRY_TEXT)
                .searchExistingEntryAndCheckNotExists(NON_EXISTING_ENTRY_TEXT);
    }
}
