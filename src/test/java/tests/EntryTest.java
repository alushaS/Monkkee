package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;


@Slf4j
public class EntryTest extends BaseTest{

    @Test(description = "Create new entry test")
    public void createNewEntryTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps.createNewEntry(ENTRY_TEXT);
        Assert.assertEquals(entriesPage.getExistEntryText(ENTRY_TEXT), ENTRY_TEXT);
    }

    @Test(description = "Delete created entry test")
    public void deleteNewEntryTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps.deleteCreatedEntry(ENTRY_TEXT);
        Assert.assertTrue(entriesPage.isEntryDeleted(ENTRY_TEXT));
    }

    @Test(description = "Delete all entries test")
    public void deleteAllEntriesTest() {
        loginSteps.loginUser(LOGIN_URL, USER, PASSWORD);
        entrySteps
                .createNewEntry(ENTRY_TEXT)
                .createNewEntry(ENTRY_TEXT)
                .deleteAllEntries();
        loginSteps.loginUserAfterLogout(USER, PASSWORD);
        Assert.assertEquals(entriesPage.getNoEntriesFoundText(), "No entries found");
    }
}
