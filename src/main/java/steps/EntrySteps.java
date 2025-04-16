package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.EntriesPage;
import pages.EntryPage;

import static pages.EntriesPage.NO_ENTRIES_FOUND_TEXT;
import static pages.EntriesPage.SEARCH_RESULT;

public class EntrySteps extends BaseSteps {

    EntryPage entryPage;
    EntriesPage entriesPage;

    public EntrySteps() {
        this.entryPage = new EntryPage();
        this.entriesPage = new EntriesPage();
    }

    @Step("Create new entry step")
    public EntrySteps createNewEntry(String entryText) {
        entriesPage
                .openEntryPage()
                .createEntry(entryText);
        Assert.assertEquals(entriesPage.getExistEntryText(entryText), entryText);
        return this;
    }


    @Step("Create and delete new entry step")
    public EntrySteps deleteCreatedEntry(String entryText) {
        entriesPage
                .openEntryPage()
                .createEntry(entryText)
                .deleteEntry(entryText);
        Assert.assertTrue(entriesPage.isEntryDeleted(entryText));
        return this;
    }

    @Step("Delete all entries step")
    public EntrySteps deleteAllEntries(String entryText) {
        entriesPage
                .deleteAllEntries();
        Assert.assertTrue(entriesPage.isEntryDeleted(entryText));
        return this;
    }

    @Step("Search existing entry step")
    public EntrySteps searchExistingEntry(String entryText) {
        entriesPage
                .searchEntry(entryText);
        Assert.assertEquals(entriesPage.getExistEntryText(entryText), entryText);
        return this;
    }

    @Step("Search non-existing entry step")
    public EntrySteps searchNonExistingEntry(String entryText) {
        entriesPage
                .searchEntry(entryText);
        Assert.assertEquals(entriesPage.getNoEntriesFoundText(), NO_ENTRIES_FOUND_TEXT);
        return this;
    }

    @Step("Search an entry by date")
    public EntrySteps searchEntryByDate () {
        entriesPage
                .searchEntryByDate();
        Assert.assertTrue(SEARCH_RESULT.is(Condition.visible));
        return this;
    }
}
