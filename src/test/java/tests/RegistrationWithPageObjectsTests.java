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
        registrationPage.checkResult1("Oksana Abasheva",
                "abasheva@ya.ru",
                "Female",
                "9935275449",
                "04 February,1983",
                "Maths",
                "Sports",
                "photo_1.jpg",
                "Izhevsk 15",
                "NCR Delhi");
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
        registrationPage.checkResult2("Oksana Abasheva",
                "Female",
                "9935275449");
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
        registrationPage.checkResult2("Oksana Abasheva",
                "Female",
                "9935275449");
        registrationPage.closeLargeModal();

    }
}

