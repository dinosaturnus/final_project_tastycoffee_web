package tastycoffee.pages.users;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditingUserAvatarPage extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();

    SelenideElement editAvatarButton = $(".userAvatar-buttons"),
            uploadImageButton = $("#upload-profile-file"),
            saveImageButton = $("#upload-avatar-result"),
            previewImage = $(".userAvatar-image"),
            deleteAvatarButton = $(".deleteAvatar");


    public EditingUserAvatarPage authorizationUser(String valueEmail, String valuePass) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(valueEmail);
        authorizationComponent.setPassword(valuePass);
        authorizationComponent.clickSubmitButton();
        authorizationComponent.verifyAuthorization();

        return this;
    }

    public EditingUserAvatarPage openAccountPage() {
        open("/my-account");

        return this;
    }

    public EditingUserAvatarPage clickEditAvatarButton() {
        editAvatarButton.$(withText("Поменять фото профиля")).click();

        return this;
    }

    public EditingUserAvatarPage uploadImage(String value) {
        uploadImageButton.uploadFromClasspath(value);

        return this;
    }

    public EditingUserAvatarPage saveImage() {
        saveImageButton.click();

        return this;
    }

    public EditingUserAvatarPage verifyNewAvatar() {
        previewImage.shouldBe(visible);

        return this;
    }

    public EditingUserAvatarPage deleteAvatar() {
        deleteAvatarButton.click();

        return this;
    }

}
