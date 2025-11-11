package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderInput = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        reactDatepickerMonth = $(".react-datepicker__month-select"),
        reactDatepickerYear = $(".react-datepicker__year-select"),
        reactDatepickerWeek = $(".react-datepicker__week"),
        subjectsInput = $("#subjectsInput"),
        hobbiesInput = $("#hobbiesWrapper"),
        uploadPicture = $("#uploadPicture"),
        currentAddress = $("#currentAddress"),
        state = $("#state"),
        stateCity = $("#stateCity-wrapper"),
        city = $("#city"),
        submit = $("#submit"),
        modal = $(".modal-dialog"),
        example = $("#example-modal-sizes-title-lg"),
        tableResponsive = $(".table-responsive"),
        closeLarge = $("#closeLargeModal");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value){

        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){

        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value){

        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGenderInput (String value){
        genderInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber (String value){

        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDay (String value, String mounth, String year){
        dateOfBirthInput.click();
        reactDatepickerMonth.selectOption(mounth);
        reactDatepickerYear.$(byText(year)).click();
        reactDatepickerWeek.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setSubjectsInput (String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbiesWrapper (String value){

        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUploadPicture (String value){

        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress (String value){

        currentAddress.setValue(value);

        return this;
    }
    public RegistrationPage setState (String value){
        state.click();
        stateCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity (String value){
        city.click();
        stateCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPage checkFormAppears (){
        submit.click();
        modal.should(appear);
        example.shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationPage checkResult1 (String value, String mail, String female,
                              String number, String s, String maths,
                              String sports, String string, String s1, String ncrDelhi){
        tableResponsive.shouldHave(text(value));
        tableResponsive.shouldHave(text(mail));
        tableResponsive.shouldHave(text(female));
        tableResponsive.shouldHave(text(number));
        tableResponsive.shouldHave(text(s));
        tableResponsive.shouldHave(text(maths));
        tableResponsive.shouldHave(text(sports));
        tableResponsive.shouldHave(text(string));
        tableResponsive.shouldHave(text(s1));
        tableResponsive.shouldHave(text(ncrDelhi));

        return this;
    }
    public RegistrationPage checkResult2 (String value, String female, String number){
        tableResponsive.shouldHave(text(value));
        tableResponsive.shouldHave(text(female));
        tableResponsive.shouldHave(text(number));

        return this;

    }
    public RegistrationPage closeLargeModal (){

        closeLarge.click();

        return this;
    }
}
