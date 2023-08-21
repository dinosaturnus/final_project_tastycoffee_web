package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationComponent extends TestBase {
    private SelenideElement emailInput = $("#login_email"),
            passwordInput = $("#login_password"),
            submitButton = $(".ib3 input.blackBtn"),
            goOutButton = $(".go-out");

    public void openAuthorizationPage() {
        open("/login");
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void verifyAuthorization() {
        goOutButton.shouldBe(visible);
    }
}
