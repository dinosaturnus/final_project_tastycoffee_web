package tastycoffee.pages.users;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class EditingUserDataPage extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();

    SelenideElement fullNameInput = $(".full_name"),
            phoneNumberInput = $(".input-wrap .phone-mask"),
            companyNameInput = $(".input-wrap [name='legal_name']"),
            companyAddressInput = $(".input-wrap [name='legal_address']"),
            companyInnInput = $(".input-wrap [name='legal_inn']"),
            companyKppInput = $(".input-wrap [name='legal_kpp']"),
            submitUpdateButton = $("#submit-update-account");

    public EditingUserDataPage authorizationUser(String valueEmail, String valuePass) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(valueEmail);
        authorizationComponent.setPassword(valuePass);
        authorizationComponent.clickSubmitButton();
        authorizationComponent.verifyAuthorization();

        return this;
    }

    public EditingUserDataPage openAccountPage() {
        open("/my-account");

        return this;
    }

    public EditingUserDataPage editFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public EditingUserDataPage editPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public EditingUserDataPage editCompanyName(String value) {
        companyNameInput.setValue(value);

        return this;
    }

    public EditingUserDataPage editCompanyAddress(String value) {
        companyAddressInput.setValue(value);

        return this;
    }

    public EditingUserDataPage editCompanyInn(String value) {
        companyInnInput.setValue(value);

        return this;
    }

    public EditingUserDataPage editCompanyKpp(String value) {
        companyKppInput.setValue(value);

        return this;
    }

    public EditingUserDataPage clickSubmitUpdateButton() {
        submitUpdateButton.click();
        return this;
    }

    public EditingUserDataPage verifyUpdateResults(String fullName, String phoneNumber, String companyName,
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
