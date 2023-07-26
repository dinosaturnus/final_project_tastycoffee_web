package tastycoffee.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.AuthorizationPage;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class AuthorizationsTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Epic("Авторизация")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий авторизации пользователя")
    @Tag("Happy path")
    @Tag("Smoke")
    @Test
    void positiveAuthorizationTest() {

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
        });

        step("Ввеести логин", () -> {
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
    @DisplayName("Ввод неверного пароля при авторизации")
    @Tag("Негативный")
    @Tag("Smoke")
    @Test
    void negativeInvalidPasswordAuthorizationTest() {

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
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

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
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
