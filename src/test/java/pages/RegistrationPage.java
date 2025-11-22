package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;
import utils.JsUtils;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
        openInput = $(".practice-form-wrapper"),
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderInput = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        calendarInput = $("#dateOfBirthInput"),
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

    CalendarComponent calendarComponent =  new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage(){

        open("/automation-practice-form");
        openInput.shouldHave(text("Student Registration Form"));


        return this;
    }
    public RegistrationPage delAds() {
        JsUtils.removeBanners();
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

    public RegistrationPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDay(day, month, year);
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
    public RegistrationPage setUploadPicture (String picture){

        uploadPicture.uploadFromClasspath(picture);

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
//    public RegistrationPage checkFormAppears (){
//        submit.click();
//        modal.should(appear);
//        example.shouldHave(text("Thanks for submitting the form"));
//
//        return this;
//    }
    public RegistrationPage checkResult (String key, String value){
        checkResultComponent.checkResultReady(key,  value); // Student Name

        return this;
    }

    public RegistrationPage closeLargeModal (){

        closeLarge.click();

        return this;
    }
}
