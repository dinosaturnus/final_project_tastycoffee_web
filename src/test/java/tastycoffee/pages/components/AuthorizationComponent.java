package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationComponent extends TestBase {

    SelenideElement buttonOpenPopupAuthorization = $("button.enterOpen"),
            emailInput = $("#login_email"),
            passwordInput = $("#login_password"),
            submitButton = $(".ib3 input.blackBtn"),
            goOutButton = $(".go-out"),
            supportPopup = $("#supportTrigger");


    public void openAuthorizationPage() {
        open("/login");
//        supportPopup.should(exist);
//        refresh();
//        buttonOpenPopupAuthorization.click();
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
