package tastycoffee.pages.users;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.pages.components.UserAvatarComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class EditingUserDataPage extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();
    UserAvatarComponent userAvatarComponent = new UserAvatarComponent();

    SelenideElement fullNameInput = $(".full_name"),
            phoneNumberInput = $(".input-wrap .phone-mask"),
            companyNameInput = $(".input-wrap [name='legal_name']"),
            companyAddressInput = $(".input-wrap [name='legal_address']"),
            companyInnInput = $(".input-wrap [name='legal_inn']"),
            companyKppInput = $(".input-wrap [name='legal_kpp']"),
            submitUpdateButton = $("#submit-update-account");

    public EditingUserDataPage authorizationUser(String email, String password) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(email);
        authorizationComponent.setPassword(password);
        authorizationComponent.clickSubmitButton();
        authorizationComponent.verifyAuthorization();

        return this;
    }

    public EditingUserDataPage openAccountPage() {
        open("/my-account");

        return this;
    }

    public EditingUserDataPage editFullName(String fullName) {
        fullNameInput.setValue(fullName);

        return this;
    }

    public EditingUserDataPage editPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public EditingUserDataPage editCompanyName(String companyName) {
        companyNameInput.setValue(companyName);

        return this;
    }

    public EditingUserDataPage editCompanyAddress(String companyAddress) {
        companyAddressInput.setValue(companyAddress);

        return this;
    }

    public EditingUserDataPage editCompanyInn(String companyInn) {
        companyInnInput.setValue(companyInn);

        return this;
    }

    public EditingUserDataPage editCompanyKpp(String companyKpp) {
        companyKppInput.setValue(companyKpp);

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

    public EditingUserDataPage uploadedAvatar(String imagePath) {
        userAvatarComponent.uploadingAndSavingAvatar(imagePath);

        return this;
    }

    public EditingUserDataPage verifyAvatarUploaded() {
        userAvatarComponent.verifyNewAvatar();

        return this;
    }

    public EditingUserDataPage deleteAvatar() {
        userAvatarComponent.deleteAvatarAndVerifyThis();

        return this;
    }
}
