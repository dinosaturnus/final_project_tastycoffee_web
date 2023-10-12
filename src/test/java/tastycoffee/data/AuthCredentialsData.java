package tastycoffee.data;

import tastycoffee.config.AuthConfig;

import static org.aeonbits.owner.ConfigFactory.create;

public class AuthCredentialsData {
    private static AuthConfig authConfig = create(AuthConfig.class, System.getProperties());

    final public static String EMAIL = authConfig.email(),
            PASSWORD = authConfig.password();
}
