package tastycoffee.data;

import tastycoffee.config.AuthConfig;

import static org.aeonbits.owner.ConfigFactory.create;
import static tastycoffee.utils.RandomUtils.*;

public class TestData {
    private static AuthConfig authConfig = create(AuthConfig.class, System.getProperties());

    final public static String EMAIL = authConfig.email(),
            PASSWORD = authConfig.password();

    public static String fullName = getRandomFullName(),
            phoneNumber = getRandomPhoneNumber(),
            companyName = getRandomCompanyName(),
            companyAddress = getRandomCompanyAddress(),
            companyInn = getRandomCompanyInn(),
            companyKpp = getRandomCompanyKpp(),
            imagePath = "images/" + getRandomImage();

    final public static String NUTTY_URL = "espresso-nutty",
            CANDY_URL = "black-candy",
            NUTTY_NAME = "Натти",
            CANDY_NAME = "Кэнди",
            MILLING_DEFAULT_VALUE = "в зернах",
            MILLING_SELECTED_VALUE = "для аэропресса (средний)";
}


