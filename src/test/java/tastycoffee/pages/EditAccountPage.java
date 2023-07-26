package tastycoffee.pages;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class EditAccountPage extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();

    SelenideElement fullNameInput = $(".full_name"),
            phoneNumberInput = $(".input-wrap .phone-mask"),
            companyNameInput = $(".input-wrap [name='legal_name']"),
            companyAddressInput = $(".input-wrap [name='legal_address']"),
            companyInnInput = $(".input-wrap [name='legal_inn']"),
            companyKppInput = $(".input-wrap [name='legal_kpp']"),
            submitUpdateButton = $("#submit-update-account");

    public EditAccountPage authorizationUser(String valueEmail, String valuePass) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(valueEmail);
        authorizationComponent.setPassword(valuePass);
        authorizationComponent.clickSubmitButton();
        authorizationComponent.verifyAuthorization();

        return this;
    }

    public EditAccountPage openAccountPage() {
        open("/my-account");

        return this;
    }

    public EditAccountPage editFullName(String value) {
        fullNameInput.clear();
        fullNameInput.setValue(value);

        return this;
    }

    public EditAccountPage editPhoneNumber(String value) {
        phoneNumberInput.clear();
        phoneNumberInput.setValue(value);

        return this;
    }

    public EditAccountPage editCompanyName(String value) {
        companyNameInput.clear();
        companyNameInput.setValue(value);

        return this;
    }

    public EditAccountPage editCompanyAddress(String value) {
        companyAddressInput.clear();
        companyAddressInput.setValue(value);

        return this;
    }

    public EditAccountPage editCompanyInn(String value) {
        companyInnInput.clear();
        companyInnInput.setValue(value);

        return this;
    }

    public EditAccountPage editCompanyKpp(String value) {
        companyKppInput.clear();
        companyKppInput.setValue(value);

        return this;
    }

    public EditAccountPage clickSubmitUpdateButton() {
        submitUpdateButton.click();
        return this;
    }

    public EditAccountPage verifyUpdateResults(String fullName, String phoneNumber, String companyName,
                                               String companyAddress, String companyInn, String companyKpp) {
        fullNameInput.shouldHave(value(fullName));
        phoneNumberInput.shouldHave(value(phoneNumber));
        companyNameInput.shouldHave(value(companyName));
        companyAddressInput.shouldHave(value(companyAddress));
        companyInnInput.shouldHave(value(companyInn));
        companyKppInput.shouldHave(value(companyKpp));

        return this;
    }

}
