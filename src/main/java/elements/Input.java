package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;

    public String inputLocator = "//*[@id='%s']";
    public String inputLocatorReg = "//*[@id='registration_%s']";

    public Input(String label) {
        this.label = label;
    }

    /**
     * Write input.
     *
     * @param text the text
     * @return the input
     */
    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    /**
     * Write to registration input.
     *
     * @param text the text
     * @return the input
     */
    public Input writeToRegistration(String text) {
        $x(String.format(inputLocatorReg, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
