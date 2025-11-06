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
    public void setGenderInput (String female){
        genderInput.$(byText("Female")).click();
    }
    public void setUserNumber (String value){
        userNumberInput.setValue(value);
    }
    public void setBirthDay (String week, String mounth, String year){
        dateOfBirthInput.click();
        reactDatepickerMonth.selectOption("February");
        reactDatepickerYear.$(byText("1983")).click();
        reactDatepickerWeek.$(byText("4")).click();

    }
    public void setSubjectsInput (String value){
        subjectsInput.setValue(value).pressEnter();
    }
    public void setHobbiesWrapper (String value){
        hobbiesInput.$(byText("Sports")).click();
    }
    public void setUploadPicture (String value){
        uploadPicture.uploadFromClasspath("photo_1.jpg");
    }
    public void setCurrentAddress (String value){
        currentAddress.setValue(value);
    }
    public void setState (String value){
        state.click();
        stateCity.$(byText("NCR")).click();
    }
    public void setCity (String value){
        city.click();
        stateCity.$(byText("Delhi")).click();
    }
    public void checkFormAppears (){
        submit.click();
        modal.should(appear);
        example.shouldHave(text("Thanks for submitting the form"));
    }
    public void checkResult1 (String value, String mail, String female,
                              String number, String s, String maths,
                              String sports, String string, String s1, String ncrDelhi){
        tableResponsive.shouldHave(text("Oksana Abasheva"));
        tableResponsive.shouldHave(text("abasheva@ya.ru"));
        tableResponsive.shouldHave(text("Female"));
        tableResponsive.shouldHave(text("9935275449"));
        tableResponsive.shouldHave(text("04 February,1983"));
        tableResponsive.shouldHave(text("Maths"));
        tableResponsive.shouldHave(text("Sports"));
        tableResponsive.shouldHave(text("photo_1.jpg"));
        tableResponsive.shouldHave(text("Izhevsk 15"));
        tableResponsive.shouldHave(text("NCR Delhi"));
    }
    public void closeLargeModal (){
        closeLarge.click();
    }
}
