package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomStringName(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomInt(111, 9999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomStringNumber(10));
        System.out.println(getRandomSubjectsInput());
        System.out.println(getRandomHobbiesWrapper());
        System.out.println(getRandomUploadPicture());
    }


    public static String getRandomStringName(int len){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rmd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++)
            sb.append(AB.charAt(rmd.nextInt(AB.length())));

        return sb.toString();
    }
    public static String getRandomStringNumber(int len){
        String AB = "0123456789";
        SecureRandom rmd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++)
            sb.append(AB.charAt(rmd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomStringName(10) + "@qa.guru";
    }
    public static String getRandomAddress() {
        return getRandomStringName(10) + " "+getRandomStringName(10)+" "+getRandomStringName(10);
    }
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);

    }

    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s",getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));

    }

    public static String getRandomGender() {
        String[] genders = {"Male","Female","Other"};
        return getRandomItemFromArray(genders);

    }
    public static String getRandomSubjectsInput() {
        String[] subjects = {"Maths","Accounting","Arts", "Social Studies", "Biology"};
        return getRandomItemFromArray(subjects);

    }

    public static String getRandomHobbiesWrapper() {
        String[] hobbies = {"Sports","Reading","Music"};
        return getRandomItemFromArray(hobbies);

    }
    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0,array.length - 1);
        return array[index];

    }

    public static String getRandomUploadPicture() {
        String[] picture = {"photo_1.jpg","photo_2.jpg","photo_3.jpg"};
        return getRandomItemFromArray(picture);

    }
}
