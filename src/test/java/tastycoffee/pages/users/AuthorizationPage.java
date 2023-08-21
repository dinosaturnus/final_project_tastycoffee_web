package tastycoffee.pages.users;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage extends TestBase {
    private SelenideElement emailInput = $("#login_email"),
            passwordInput = $("#login_password"),
            submitButton = $(".ib3 input.blackBtn"),
            goOutButton = $(".go-out"),
            errorAuthorizationText = $(".ib1 .siteError");

    public AuthorizationPage openAuthorizationPage() {
        open("/login");

        return this;
    }

    public AuthorizationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public AuthorizationPage setPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    public AuthorizationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public AuthorizationPage verifyAuthorization() {
        goOutButton.shouldBe(visible);

        return this;
    }

    public AuthorizationPage verifyErrorAuthorization() {
        errorAuthorizationText.shouldHave(text(" Пользователь не найден или неверно введен пароль! "));

        return this;
    }
}
