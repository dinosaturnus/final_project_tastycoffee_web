package tastycoffee.data;

import static tastycoffee.utils.RandomUtils.*;

public class UserProfileData {
    public static String fullName = getRandomFullName(),
            phoneNumber = getRandomPhoneNumber(),
            companyName = getRandomCompanyName(),
            companyAddress = getRandomCompanyAddress(),
            companyInn = getRandomCompanyInn(),
            companyKpp = getRandomCompanyKpp(),
            imagePath = "images/" + getRandomImage();
}
