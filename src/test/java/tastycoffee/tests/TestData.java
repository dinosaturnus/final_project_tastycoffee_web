package tastycoffee.tests;

import static tastycoffee.utils.RandomUtils.*;

public class TestData {
    public static String email = "test12345@test.ru",
            password = "123456A",
            fullName = getRandomFullName(),
            phoneNumber = getRandomPhoneNumber(),
            companyName = getRandomCompanyName(),
            companyAddress = getRandomCompanyAddress(),
            companyInn = getRandomCompanyInn(),
            companyKpp = getRandomCompanyKpp();
}
