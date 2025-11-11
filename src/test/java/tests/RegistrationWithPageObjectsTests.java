package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
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
                .setCity("Delhi")
                .checkFormAppears();
        registrationPage.checkResult("Student Name", "Oksana Abasheva")
                .checkResult("Student Email", "abasheva@ya.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9935275449")
                .checkResult("Date of Birth", "04 February,1983")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "photo_1.jpg")
                .checkResult("Address", "Izhevsk 15")
                .checkResult("State and City", "NCR Delhi");
        registrationPage.closeLargeModal();

    }
    @Test
    void requiredParametersFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Oksana")
                .setLastName("Abasheva")
                .setGenderInput("Female")
                .setUserNumber("9935275449")
                .checkFormAppears();
        registrationPage.checkResult("Student Name", "Oksana Abasheva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9935275449");

        registrationPage.closeLargeModal();

    }
    @Test
    void negativeFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Abasheva")
                .setGenderInput("Female")
                .setUserNumber("9935275")
                .checkFormAppears();
        registrationPage.checkResult("Student Name", "Oksana Abasheva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9935275449");

        registrationPage.closeLargeModal();

    }
}

