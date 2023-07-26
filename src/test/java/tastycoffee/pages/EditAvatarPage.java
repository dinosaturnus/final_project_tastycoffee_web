package tastycoffee.pages;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditAvatarPage extends TestBase {

    AuthorizationComponent authorizationComponent = new AuthorizationComponent();

    SelenideElement editAvatarButton = $(".userAvatar-buttons"),
            uploadImageButton = $("#upload-profile-file"),
            saveImageButton = $("#upload-avatar-result"),
            previewImage = $(".userAvatar-image"),
            deleteAvatarButton = $(".deleteAvatar");


    public EditAvatarPage authorizationUser(String valueEmail, String valuePass) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(valueEmail);
        authorizationComponent.setPassword(valuePass);
        authorizationComponent.clickSubmitButton();
        authorizationComponent.verifyAuthorization();

        return this;
    }

    public EditAvatarPage openAccountPage() {
        open("/my-account");

        return this;
    }

    public EditAvatarPage clickEditAvatarButton() {
        editAvatarButton.$(withText("Поменять фото профиля")).click();

        return this;
    }

    public EditAvatarPage uploadImage(String value) {
        uploadImageButton.uploadFromClasspath(value);

        return this;
    }

    public EditAvatarPage saveImage() {
        saveImageButton.click();

        return this;
    }

    public EditAvatarPage verifyNewAvatar() {
        previewImage.shouldBe(visible);

        return this;
    }

    public EditAvatarPage deleteAvatar() {
        deleteAvatarButton.click();

        return this;
    }

}
