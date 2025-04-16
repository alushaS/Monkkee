package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class EntryPage {

    public static final SelenideElement BACK_TO_OVERVIEW = $x("//*[@title='Back to overview']");
    public static final SelenideElement ITALIC = $x("//*[@class='cke_button_icon cke_button__italic_icon']");

    /**
     * Create entry entries page.
     *
     * @param entryText the entry text
     * @return the entries page
     */
    public EntriesPage createEntry(String entryText) {
        ITALIC.shouldBe(Condition.visible);
        new Button().click(ITALIC);
        new Input("editable").write(entryText);
        new Button().click(BACK_TO_OVERVIEW);
        log.info("Entry {} is created.", entryText);
        return new EntriesPage();
    }
}
