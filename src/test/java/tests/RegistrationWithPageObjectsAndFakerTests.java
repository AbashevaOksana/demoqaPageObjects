package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static utils.RandomUtils.*;


public class RegistrationWithPageObjectsAndFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("en-GB"));

        String firstName = faker.name().firstName();

        String lastName = faker.name().lastName();

        String userEmail = faker.internet().emailAddress();

        String streetAddress = faker.address().streetAddress();

        //state & city
        Map<String, List<String>> stateCityMap = Map.of(
                "NCR", List.of("Delhi", "Gurgaon", "Noida"),
                "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
                "Haryana", List.of("Karnal", "Panipat"),
                "Rajasthan", List.of("Jaipur", "Jaiselmer")
        );
        List<String> states = new ArrayList<>(stateCityMap.keySet());
        String state = states.get(faker.random().nextInt(states.size()));
        List<String> cities = stateCityMap.get(state);
        String city = cities.get(faker.random().nextInt(cities.size()));
        String stateAndCity = state + " " + city;

        //календарь
        String birthDay = String.valueOf(faker.number().numberBetween(1, 28));
        String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        String birthYear = String.valueOf(faker.number().numberBetween(1950, 2005));
        String formattedDay = birthDay.length() == 1 ? "0" + birthDay : birthDay;
        String formattedBirthDate = formattedDay + " " + birthMonth + "," + birthYear;

        String genderInput = getRandomGender();

        String userNumber = getRandomStringNumber(10);

        String subjectsInput = getRandomSubjectsInput();

        String hobbiesWrapper = getRandomHobbiesWrapper();

        String uploadPicture = getRandomUploadPicture();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderInput(genderInput)
                .setUserNumber(userNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubjectsInput(subjectsInput)
                .setHobbiesWrapper(hobbiesWrapper)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .checkFormAppears();
        registrationPage.checkResult("Student Name", firstName+ " " +lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderInput)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", formattedBirthDate)
                .checkResult("Subjects", subjectsInput )
                .checkResult("Hobbies", hobbiesWrapper)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", stateAndCity);
        registrationPage.closeLargeModal();
    }
}

