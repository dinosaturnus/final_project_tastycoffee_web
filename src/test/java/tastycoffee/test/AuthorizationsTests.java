package tastycoffee.test;

import org.junit.jupiter.api.Test;
import tastycoffee.pages.AuthorizationPage;

public class AuthorizationsTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    String email = "test12345@test.ru",
            password = "123456A";

    @Test
    void positiveAuthorizationTest() {

        authorizationPage.openMainPage()
                .closedYandexAutofillPopup()
                .openPopupAuthorization()
                .setEmail(email)
                .setPassword(password)
                .clickSubmitButton();

        authorizationPage.verifyAuthorization();
    }

    @Test
    void negativeInvalidPasswordAuthorizationTest() {

        authorizationPage.openMainPage()
                .closedYandexAutofillPopup()
                .openPopupAuthorization()
                .setEmail(email)
                .setPassword(password + "1")
                .clickSubmitButton();

        authorizationPage.verifyErrorAuthorization();
    }

    @Test
    void negativeInvalidEmailAuthorizationTest() {

        authorizationPage.openMainPage()
                .closedYandexAutofillPopup()
                .openPopupAuthorization()
                .setEmail(email + "1")
                .setPassword(password)
                .clickSubmitButton();

        authorizationPage.verifyErrorAuthorization();
    }
}
