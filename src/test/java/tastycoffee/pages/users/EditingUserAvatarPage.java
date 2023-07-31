package tastycoffee.pages.users;

import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AuthorizationComponent;
import tastycoffee.pages.components.EditingUserAvatarComponent;
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
            deleteAvatarButton = $(".deleteAvatar"),
            noAvatarPreview = $(".no_img");


    public EditingUserAvatarPage authorizationUser(String email, String password) {

        authorizationComponent.openAuthorizationPage();
        authorizationComponent.setEmail(email);
        authorizationComponent.setPassword(password);
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

    public EditingUserAvatarPage uploadImage(String imagePath) {
        uploadImageButton.uploadFromClasspath(imagePath);

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

    public EditingUserAvatarPage checkThatAvatarRemoved() {
        noAvatarPreview.shouldBe(visible);

        return this;
    }
}
