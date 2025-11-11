package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage();
        registrationPage.setFirstName("Oksana");
        registrationPage.setLastName("Abasheva");
        registrationPage.setUserEmail("abasheva@ya.ru");
        registrationPage.setGenderInput("Female");
        registrationPage.setUserNumber("9935275449");
        registrationPage.setBirthDay("4", "February", "1983");
        registrationPage.setSubjectsInput("Maths");
        registrationPage.setHobbiesWrapper("Sports");
        registrationPage.setUploadPicture("photo_1.jpg");
        registrationPage.setCurrentAddress("Izhevsk 15");
        registrationPage.setState("NCR");
        registrationPage.setCity("Delhi");
        registrationPage.checkFormAppears();
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

        registrationPage.openPage();
        registrationPage.setFirstName("Oksana");
        registrationPage.setLastName("Abasheva");
        registrationPage.setGenderInput("Female");
        registrationPage.setUserNumber("9935275449");
        registrationPage.checkFormAppears();
        registrationPage.checkResult2("Oksana Abasheva",
                "Female",
                "9935275449");
        registrationPage.closeLargeModal();

    }
    @Test
    void negativeFillFormTest() {

        registrationPage.openPage();
        registrationPage.setFirstName("Anna");
        registrationPage.setLastName("Abasheva");
        registrationPage.setGenderInput("Female");
        registrationPage.setUserNumber("9935275");
        registrationPage.checkFormAppears();
        registrationPage.checkResult2("Oksana Abasheva",
                "Female",
                "9935275449");
        registrationPage.closeLargeModal();

    }
}

