package tastycoffee.tests.users;

import io.qameta.allure.Description;
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
import static tastycoffee.data.TestData.*;

@Epic("Личный кабинет")
@Feature("Авторизация")
public class AuthorizationTests extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Story("Пользователь аутентифицирован")
    @Description("При вводе корректного логина и пароля система аутентифицирует пользователя")
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @DisplayName("Ввод корректного логина и пароля")
    void authorizationWithValidCredentialsTest() {
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

    @Test
    @Story("Пользователю отказано в аутентификации")
    @Description("При вводе некорректного пароля пользователю отказано в аутентификации, " +
            "появляется сообщение об ошибке")
    @Tag("Regress")
    @DisplayName("Ввод некорректного пароля и корректного логина")
    void invalidPasswordAuthorizationTest() {
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

        step("Проверить наличие сообщения об ошибке авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }

    @Test
    @Story("Пользователю отказано в аутентификации")
    @Description("При вводе некорректного логина пользователю отказано в аутентификации, " +
            "появляется сообщение об ошибке")
    @Tag("Regress")
    @DisplayName("Ввод некорректного логина и корректного пароля")
    void invalidEmailAuthorizationTest() {
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

        step("Проверить наличие сообщения об ошибке авторизации", () -> {
            authorizationPage.verifyErrorAuthorization();
        });
    }
}
