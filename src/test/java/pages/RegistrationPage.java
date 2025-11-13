package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement
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

    public RegistrationPage openPage(){
        //open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


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

        calendarInput.click();
        calendarComponent.setDay(value, mounth, year);


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
    public RegistrationPage setUploadPicture (String strings){

        uploadPicture.uploadFromClasspath("photo_1.jpg");

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
    public RegistrationPage checkResult (String key, String value){
        tableResponsive.$(byText(key)).parent().shouldHave(text(value)); // Student Name

        return this;
    }

    public RegistrationPage closeLargeModal (){

        closeLarge.click();

        return this;
    }
}
