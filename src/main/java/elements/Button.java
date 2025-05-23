package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Button {

    /**
     * Click.
     *
     * @param selenideElement the selenide element
     */
    public void click(SelenideElement selenideElement) {
        selenideElement.shouldBe(Condition.visible).click();
    }
}
