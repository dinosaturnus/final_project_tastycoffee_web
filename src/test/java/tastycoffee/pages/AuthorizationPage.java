package tastycoffee.pages;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage extends TestBase {

    SelenideElement buttonOpenPopupAuthorization = $("button.enterOpen"),
            emailInput = $("#email"),
            passwordInput = $("#password"),
            submitButton = $("#sign-in"),
            goOutButton = $(".go-out"),
            errorAuthorizationText = $(".siteError");


    public AuthorizationPage openMainPage() {
        open(" ");

        return this;
    }

    public AuthorizationPage closedYandexAutofillPopup() {
        executeJavaScript("$('. visible').remove()");

        return this;
    }

    public AuthorizationPage openPopupAuthorization() {
        buttonOpenPopupAuthorization.click();

        return this;
    }

    public AuthorizationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public AuthorizationPage setPassword(String value) {
        passwordInput.setValue(value);

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
        errorAuthorizationText.shouldHave(text("Пользователь не найден или неверно введен пароль!"));

        return this;
    }

}
