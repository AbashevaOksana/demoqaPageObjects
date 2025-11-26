package tests;

import com.github.javafaker.Faker;
import data.DataFaker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static utils.RandomUtils.*;


public class RegistrationWithPageObjectsAndFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    DataFaker dataFaker = new DataFaker();

    @Test
    void fillFormTestFaker() {
        registrationPage.openPage()
                .delAds()
                .setFirstName(dataFaker.firstName)
                .setLastName(dataFaker.lastName)
                .setUserEmail(dataFaker.email)
                .setGenderInput(dataFaker.gender)
                .setUserNumber(dataFaker.phone)
                .setBirthDay(dataFaker.day, dataFaker.month, dataFaker.year)
                .setSubjectsInput(dataFaker.subject)
                .setHobbiesWrapper(dataFaker.hobby)
                .setUploadPicture(dataFaker.picture)
                .setCurrentAddress(dataFaker.address)
                .setState(dataFaker.state)
                .setCity(dataFaker.city);
        checkResultComponent.checkFormAppears()
                .checkResultReady("Student Name", dataFaker.firstName+ " " +DataFaker.lastName)
                .checkResultReady("Student Email", dataFaker.email)
                .checkResultReady("Gender", dataFaker.gender)
                .checkResultReady("Mobile", dataFaker.phone)
                .checkResultReady("Date of Birth", dataFaker.formattedBirthDate)
                .checkResultReady("Subjects", dataFaker.subject)
                .checkResultReady("Hobbies", dataFaker.hobby)
                .checkResultReady("Picture", dataFaker.picture)
                .checkResultReady("Address", dataFaker.address)
                .checkResultReady("State and City", dataFaker.stateAndCity);
    }
}

