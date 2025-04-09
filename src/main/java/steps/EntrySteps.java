package steps;

import io.qameta.allure.Step;
import pages.EntriesPage;
import pages.EntryPage;

public class EntrySteps extends BaseSteps{

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
        return this;
    }


    @Step("Create and delete new entry step")
    public EntrySteps deleteCreatedEntry(String entryText) {
        entryPage
                .createEntry(entryText)
                .deleteEntry(entryText);
        return this;
    }

    @Step("Delete all entries step")
    public EntrySteps deleteAllEntries() {
        entriesPage
                .deleteAllEntries();
        return this;
    }

    @Step("Search existing entry step")
    public EntrySteps searchEntry(String entryText) {
        entriesPage
                .searchEntry(entryText);
        return this;
    }






}
