package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationWithTestsDataTest extends TestBase {

    @Test
    void fillFormTest() {


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("abasheva@ya.ru");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("9935275449");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");//
        $(".react-datepicker__year-select").$(byText("1983")).click();//
        $(".react-datepicker__week").$(byText("4")).click();//
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo_1.jpg");
        $("#currentAddress").setValue("Izhevsk 15");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName). text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9935275449"));
        $(".table-responsive").shouldHave(text("04 February,1983"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("photo_1.jpg"));
        $(".table-responsive").shouldHave(text("Izhevsk 15"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }
}