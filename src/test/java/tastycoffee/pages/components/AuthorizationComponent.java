package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.AuthorizationPage;
import tastycoffee.test.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationComponent extends TestBase {
    SelenideElement buttonOpenPopupAuthorization = $("button.enterOpen"),
            emailInput = $("#email"),
            passwordInput = $("#password"),
            submitButton = $("#sign-in"),
            goOutButton = $(".go-out");

    public void openPopup() {
        open(" ");
        executeJavaScript("$('#root').remove()");
        buttonOpenPopupAuthorization.click();
    }

    public void setEmail(String value) {
        emailInput.setValue(value);

    }

    public void setPassword(String value) {
        passwordInput.setValue(value);

    }

    public void clickSubmitButton() {
        submitButton.click();

    }

    public void verifyAuthorization() {
        goOutButton.shouldBe(visible);

    }
}
