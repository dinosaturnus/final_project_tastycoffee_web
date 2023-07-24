package tastycoffee.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomFullName() {
        return new Faker().name().fullName();
    }

    public static String getRandomPhoneNumber() {
        return "7 (9" + getRandomInt(11, 99) + ") " + getRandomInt(111, 999) + "-" + getRandomInt(1111, 9999);
    }

//    public static String getRandomEmail() {
//        return new Faker().internet().emailAddress();
//    }

    public static String getRandomCompanyName() {
        return new Faker().company().name();
    }

    public static String getRandomCompanyAddress() {
        return new Faker().address().fullAddress();
    }

    public static String getRandomCompanyInn() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomCompanyKpp() {
        return new Faker().random().hex(9);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
