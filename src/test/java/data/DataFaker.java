package data;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static utils.RandomUtils.*;

public class DataFaker {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName();

    public static String lastName = faker.name().lastName();

    public static String email = faker.internet().emailAddress();

    public static String address = faker.address().streetAddress();

    //state & city
    static Map<String, List<String>> stateCityMap = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );
    static List<String> states = new ArrayList<>(stateCityMap.keySet());
    public static String state = states.get(faker.random().nextInt(states.size()));
    static List<String> cities = stateCityMap.get(state);
    public static String city = cities.get(faker.random().nextInt(cities.size()));
    public static String stateAndCity = state + " " + city;

    //календарь
    public static String day = String.valueOf(faker.number().numberBetween(1, 28));
    public static String month = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public static String year = String.valueOf(faker.number().numberBetween(1950, 2005));
    public  static String formattedDay = day.length() == 1 ? "0" + day : day;
    public static String formattedBirthDate = formattedDay + " " + month + "," + year;

    public static String gender = getRandomGender();


    public static String phone = faker.phoneNumber().subscriberNumber(10);

    //String subjects = getRandomSubjectsInput();
    public String subject = faker.options().option(
            "Maths", "Accounting", "Arts", "Biology", "Chemistry", "Civics",
            "Commerce", "Computer Science", "Economics", "English",
            "Hindi", "History", "Physics", "Social Studies"
    );
    public String hobby = faker.options().option("Sports", "Reading", "Music");

    public String picture = faker.options().option("photo_1.jpg", "photo_2.jpg", "photo_3.jpg");


}
