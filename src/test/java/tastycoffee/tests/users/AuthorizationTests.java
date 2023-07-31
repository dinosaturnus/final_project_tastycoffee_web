package tastycoffee.tests.users;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.users.AuthorizationPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class AuthorizationTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Epic("Действия с личным кабинетом пользователя")
    @Feature("Авторизация")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий авторизации пользователя")
    @Tags({
            @Tag ("Happy path"),
            @Tag ("Smoke"),
            @Tag ("Regress")
    })
    @Test
    void positiveAuthorizationTest() {

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
        });

        step("Ввеести логин", () -> {
            authorizationPage.setEmail(EMAIL);
        });

        step("Ввести пароль", () -> {
            authorizationPage.setPassword(PASSWORD);
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить успешность авторизации", () -> {
            authorizationPage.verifyAuthorization();
        });

    }

    @Epic("Действия с личным кабинетом пользователя")
    @Feature("Авторизация")
    @Story("Негативные сценарии")
    @DisplayName("Ввод неверного пароля при авторизации")
    @Tags({
            @Tag ("Negative"),
            @Tag ("Smoke"),
            @Tag ("Regress")
    })
    @Test
    void negativeInvalidPasswordAuthorizationTest() {

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
        });

        step("Ввести логин", () -> {
            authorizationPage.setEmail(EMAIL);
        });

        step("Ввести неверный пароль", () -> {
            authorizationPage.setPassword(PASSWORD + "1");
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить ошибку авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }

    @Epic("Действия с личным кабинетом пользователя")
    @Feature("Авторизация")
    @Story("Негативные сценарии")
    @DisplayName("Ввод неверного логина при авторизации")
    @Tags({
            @Tag ("Negative"),
            @Tag ("Smoke"),
            @Tag ("Regress")
    })
    @Test
    void negativeInvalidEmailAuthorizationTest() {

        step("Открыть страницу авторизации", () -> {
            authorizationPage.openAuthorizationPage();
        });

        step("Ввести неверный логин", () -> {
            authorizationPage.setEmail(EMAIL + "1");
        });

        step("Ввести пароль", () -> {
            authorizationPage.setPassword(PASSWORD);
        });

        step("Нажать кнопку 'Войти'", () -> {
            authorizationPage.clickSubmitButton();
        });

        step("Проверить ошибку авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }
}
