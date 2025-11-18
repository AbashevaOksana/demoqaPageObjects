package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageLast {

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
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPageLast openPage(){

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        return this;
    }
    public RegistrationPageLast setFirstName(String value){

        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPageLast setLastName(String value){

        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPageLast setUserEmail(String value){

        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPageLast setGenderInput (String value){
        genderInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPageLast setUserNumber (String value){

        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPageLast setBirthDay (String value, String mounth, String year){

        calendarInput.click();
        calendarComponent.setDay(value, mounth, year);


        return this;
    }
    public RegistrationPageLast setSubjectsInput (String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPageLast setHobbiesWrapper (String value){

        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPageLast setUploadPicture (String strings){

        uploadPicture.uploadFromClasspath("photo_1.jpg");

        return this;
    }
    public RegistrationPageLast setCurrentAddress (String value){

        currentAddress.setValue(value);

        return this;
    }
    public RegistrationPageLast setState (String value){
        state.click();
        stateCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPageLast setCity (String value){
        city.click();
        stateCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPageLast checkFormAppears (){
        submit.click();
        modal.should(appear);
        example.shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public RegistrationPageLast checkResult (String key, String value){
        checkResultComponent.checkResultReady(key,  value); // Student Name

        return this;
    }

    public RegistrationPageLast closeLargeModal (){

        closeLarge.click();

        return this;
    }
}
