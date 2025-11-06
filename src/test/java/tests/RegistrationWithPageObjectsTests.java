package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {



//        $(firstNameLocator).setValue("Oksana");
//        registrationPage.setFirstName("Oksana")
        registrationPage.openPage();
        registrationPage.setFirstName("Oksana");
        registrationPage.setLastName("Abasheva");
        registrationPage.setUserEmail("abasheva@ya.ru");
        registrationPage.setGenderInput("Female");
        registrationPage.setLastName("Abasheva");
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






//        $("#lastName").setValue("Abasheva");
//        registrationPage.setLastName("Abasheva")
//        $("#userEmail").setValue("abasheva@ya.ru");
//        registrationPage.setUserEmail("abasheva@ya.ru")
        //$("#gender-radio-2").parent().click();

//        $("#genterWrapper").$(byText("Other")).click();
//        registrationPage.setGender("Other")

//        $("#userNumber").setValue("9935275449");
//        registrationPage.setUserNumber("9935275449")

//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("February");//
//        $(".react-datepicker__year-select").$(byText("1983")).click();//
//        $(".react-datepicker__week").$(byText("4")).click();//
//        registrationPage.setBirthDay("4", "February", "1983")

//        $("#subjectsInput").setValue("Maths").pressEnter();
//        registrationPage.setSubjectsInput("Maths")

//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        registrationPage.setHobbiesWrapper("Sports")

//        $("#uploadPicture").uploadFromClasspath("img/photo_1.jpg");
//        registrationPage.setUploadPicture("img/photo_1.jpg")

//        $("#currentAddress").setValue("Izhevsk 15");
//        registrationPage.setCurrentAddress("Izhevsk 15")

//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        registrationPage.setState("NCR")

//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        registrationPage.setCity("Delhi")

//        $("#submit").click();
//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        registrationPage.checkFormAppears()


//        $(".table-responsive").shouldHave(text("Oksana Abasheva"));
//        $(".table-responsive").shouldHave(text("abasheva@ya.ru"));
//        $(".table-responsive").shouldHave(text("Female"));
//        $(".table-responsive").shouldHave(text("9935275449"));
//        $(".table-responsive").shouldHave(text("04 February,1983"));
//        $(".table-responsive").shouldHave(text("Maths"));
//        $(".table-responsive").shouldHave(text("Sports"));
//        $(".table-responsive").shouldHave(text("img/photo_1.jpg"));
//        $(".table-responsive").shouldHave(text("Izhevsk 15"));
//        $(".table-responsive").shouldHave(text("NCR Delhi"));
//        registrationPage.checkResult1("Oksana Abasheva", "abasheva@ya.ru", "Female", "9935275449", "04 February,1983", "Maths", "Sports", "img/photo_1.jpg", "Izhevsk 15", "NCR Delhi"),
//                ("abasheva@ya.ru"),
//                ("Female"),
//                ("9935275449"),
//                ("04 February,1983"),
//                ("Maths"),
//                ("Sports"),
//                ("img/photo_1.jpg"),
//                ("Izhevsk 15"),
//                ("NCR Delhi")

//        $("#closeLargeModal").click();
//        registrationPage.closeLargeModal()
    }
}

