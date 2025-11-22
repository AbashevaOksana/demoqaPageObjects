package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    private SelenideElement
            checkResultReadyInput = $(".table-responsive"),
            submit = $("#submit"),
            modal = $(".modal-dialog"),
            example = $("#example-modal-sizes-title-lg");

    public CheckResultComponent checkFormAppears (){
        submit.click();
        modal.should(appear);
        example.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public CheckResultComponent checkResultReady (String key, String value) {
        checkResultReadyInput.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}


