package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .delAds()
                .setFirstName("Oksana")
                .setLastName("Abasheva")
                .setUserEmail("abasheva@ya.ru")
                .setGenderInput("Female")
                .setUserNumber("9935275449")
                .setBirthDay("4", "February", "1983")
                .setSubjectsInput("Maths")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("photo_1.jpg")
                .setCurrentAddress("Izhevsk 15")
                .setState("NCR")
                .setCity("Delhi");
        checkResultComponent.checkFormAppears()
                .checkResultReady("Student Name", "Oksana Abasheva")
                .checkResultReady("Student Email", "abasheva@ya.ru")
                .checkResultReady("Gender", "Female")
                .checkResultReady("Mobile", "9935275449")
                .checkResultReady("Date of Birth", "04 February,1983")
                .checkResultReady("Subjects", "Maths")
                .checkResultReady("Hobbies", "Sports")
                .checkResultReady("Picture", "photo_1.jpg")
                .checkResultReady("Address", "Izhevsk 15")
                .checkResultReady("State and City", "NCR Delhi");


    }
    @Test
    void requiredParametersFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Oksana")
                .setLastName("Abasheva")
                .setGenderInput("Female")
                .setUserNumber("9935275449");
        checkResultComponent.checkFormAppears()
                .checkResultReady("Student Name", "Oksana Abasheva")
                .checkResultReady("Gender", "Female")
                .checkResultReady("Mobile", "9935275449");

    }
    @Test
    void negativeFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Abasheva")
                .setGenderInput("Female")
                .setUserNumber("9935275");
        checkResultComponent.checkFormAppears()
                .checkResultReady("Student Name", "Oksana Abasheva")
                .checkResultReady("Gender", "Female")
                .checkResultReady("Mobile", "9935275449");

    }
}

