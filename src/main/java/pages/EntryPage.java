package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.getSelectedText;

public class EntryPage {

    public static final SelenideElement BACK_TO_OVERVIEW = $x("//*[@title='Back to overview']");
    public static final SelenideElement ENTRY_SAVED = $x("//span[contains(text(), 'saved')]");
    public static final SelenideElement SAVE_ENTRY = $x("//*[contains(text(), 'cke_button cke_button__savetoggle cke_button_off')]");
    public static final SelenideElement ITALIC = $x("//*[@class='cke_button_icon cke_button__italic_icon']");

    public EntriesPage createEntry(String entryText) {
        new Button().click(ITALIC);
        new Input("editable").write(entryText);
        new Button().click(BACK_TO_OVERVIEW);
        return new EntriesPage();
    }
}
