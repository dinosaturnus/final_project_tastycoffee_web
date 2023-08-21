package tastycoffee.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
//    public static Faker faker = new Faker();

    public static String getRandomFullName() {
        return new Faker().name().fullName();
    }

    public static String getRandomPhoneNumber() {
        return "7 (9" + new Faker().number().numberBetween(11, 99) + ") " + new Faker().number().numberBetween(111, 999)
                + "-" + new Faker().number().numberBetween(1111, 9999);
    }

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

    public static String getRandomImage() {
       return new Faker().options().option("bird.jpg", "cat.webp", "dog.png");
    }
}
