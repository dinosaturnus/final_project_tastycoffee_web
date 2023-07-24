package tastycoffee.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.AuthorizationPage;

import static io.qameta.allure.Allure.step;

public class AuthorizationsTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    String email = "test12345@test.ru",
            password = "123456A";

    @Epic("Авторизация")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий авторизации юзера (happy path)")
    @Tag("Happy path")
    @Tag("Smoke")
    @Test
    void positiveAuthorizationTest() {

        step("Открыть главную страницу", () -> {
            authorizationPage.openMainPage();
        });

        step("Открыть окно авторизации", () -> {
            authorizationPage.closedYandexAutofillPopup()
                    .openPopupAuthorization();
        });

        step("Ввести логин", () -> {
            authorizationPage.setEmail(email);
        });

        step("Ввести пароль", () -> {
            authorizationPage.setPassword(password);
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить успешность авторизации", () -> {
            authorizationPage.verifyAuthorization();
        });

    }

    @Epic("Авторизация")
    @Story("Негативные сценарии")
    @DisplayName("Введен неверный пароль")
    @Tag("Негативный")
    @Tag("Smoke")
    @Test
    void negativeInvalidPasswordAuthorizationTest() {

        step("Открыть главную страницу", () -> {
            authorizationPage.openMainPage();
        });

        step("Открыть окно авторизации", () -> {
            authorizationPage.closedYandexAutofillPopup()
                    .openPopupAuthorization();
        });

        step("Ввести логин", () -> {
            authorizationPage.setEmail(email);
        });

        step("Ввести неверный пароль", () -> {
            authorizationPage.setPassword(password + "1");
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить ошибку авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }

    @Epic("Авторизация")
    @Story("Негативные сценарии")
    @DisplayName("Введен неверный логин")
    @Tag("Негативный")
    @Tag("Smoke")
    @Test
    void negativeInvalidEmailAuthorizationTest() {

        step("Открыть главную страницу", () -> {
            authorizationPage.openMainPage();
        });

        step("Открыть окно авторизации", () -> {
            authorizationPage.closedYandexAutofillPopup()
                    .openPopupAuthorization();
        });

        step("Ввести неверный логин", () -> {
            authorizationPage.setEmail(email + "1");
        });

        step("Ввести пароль", () -> {
            authorizationPage.setPassword(password);
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить ошибку авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }
}
