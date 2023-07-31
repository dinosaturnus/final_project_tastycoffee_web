package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class EditingUserAvatarComponent {

    SelenideElement editAvatarButton = $(".userAvatar-buttons"),
    uploadImageButton = $("#upload-profile-file"),
    saveImageButton = $("#upload-avatar-result"),
    previewImage = $(".userAvatar-image"),
    deleteAvatarButton = $(".deleteAvatar"),
    noAvatarPreview = $(".no_img");

    public void uploadingAndSavingAvatar(String imagePath) {
        editAvatarButton.$(withText("Поменять фото профиля")).click();
        uploadImageButton.uploadFromClasspath(imagePath);
        saveImageButton.click();
    }

    public void verifyNewAvatar() {
        previewImage.shouldBe(visible);
    }

    public void deleteAvatarAndVerifyThis() {
        deleteAvatarButton.click();
        noAvatarPreview.shouldBe(visible);
    }
}
