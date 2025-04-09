package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Search existing entry test")
    public void searchExistingEntryTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .searchEntry(ENTRY_TEXT);
        Assert.assertEquals(entriesPage.getExistEntryText(ENTRY_TEXT), ENTRY_TEXT);
    }

    @Test(description = "Search non-existing entry test")
    public void searchNonExistingEntryTest() {
        loginSteps
                .loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .searchEntry(NON_EXISTING_ENTRY_TEXT);
        Assert.assertEquals(entriesPage.getNoEntriesFoundText(), "No entries found");
    }
}
