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

    public void openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
    public void setFirstName(String value){

        firstNameInput.setValue(value);
    }
    public void setLastName(String value){

        lastNameInput.setValue(value);
    }
    public void setUserEmail(String value){

        userEmailInput.setValue(value);
    }
    public void setGenderInput (String value){
        genderInput.$(byText(value)).click();
    }
    public void setUserNumber (String value){

        userNumberInput.setValue(value);
    }
    public void setBirthDay (String value, String mounth, String year){
        dateOfBirthInput.click();
        reactDatepickerMonth.selectOption(mounth);
        reactDatepickerYear.$(byText(year)).click();
        reactDatepickerWeek.$(byText(value)).click();

    }
    public void setSubjectsInput (String value){

        subjectsInput.setValue(value).pressEnter();
    }
    public void setHobbiesWrapper (String value){

        hobbiesInput.$(byText(value)).click();
    }
    public void setUploadPicture (String value){

        uploadPicture.uploadFromClasspath(value);
    }
    public void setCurrentAddress (String value){

        currentAddress.setValue(value);
    }
    public void setState (String value){
        state.click();
        stateCity.$(byText(value)).click();
    }
    public void setCity (String value){
        city.click();
        stateCity.$(byText(value)).click();
    }
    public void checkFormAppears (){
        submit.click();
        modal.should(appear);
        example.shouldHave(text("Thanks for submitting the form"));
    }
    public void checkResult1 (String value, String mail, String female,
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
    }
    public void checkResult2 (String value, String female, String number){
        tableResponsive.shouldHave(text(value));
        tableResponsive.shouldHave(text(female));
        tableResponsive.shouldHave(text(number));

    }
    public void closeLargeModal (){
        closeLarge.click();
    }
}
