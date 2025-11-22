package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    private final SelenideElement
            checkResultReadyInput = $(".table-responsive");

    public void checkResultReady (String key, String value) {
        checkResultReadyInput.$(byText(key)).parent().shouldHave(text(value));

    }

}
