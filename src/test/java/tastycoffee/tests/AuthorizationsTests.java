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
    @DisplayName("Успешный сценарий авторизации пользователя")
    @Tag("Happy path")
    @Tag("Smoke")
    @Test
    void positiveAuthorizationTest() {

        step("Открытие главной страницы", () -> {
            authorizationPage.openMainPage();
        });

        step("Открытие поп-апа авторизации", () -> {
            authorizationPage.closedYandexAutofillPopup()
                    .openPopupAuthorization();
        });

        step("Ввод логина", () -> {
            authorizationPage.setEmail(email);
        });

        step("Ввод пароля", () -> {
            authorizationPage.setPassword(password);
        });

        step("Авторизация через нажатие кнопки 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверка успешности авторизации", () -> {
            authorizationPage.verifyAuthorization();
        });

    }

    @Epic("Авторизация")
    @Story("Негативные сценарии")
    @DisplayName("Ввод неверного пароля при авторизации")
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
    @DisplayName("Ввод неверного логина при авторизации")
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
