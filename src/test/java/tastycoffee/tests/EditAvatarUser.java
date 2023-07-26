package tastycoffee.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.EditAccountPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.email;
import static tastycoffee.tests.TestData.password;

public class EditAvatarUser extends TestBase {

    @Test
    void positiveEditAvatarUserTest() {

        EditAccountPage editAccountPage = new EditAccountPage();

        step("Открыть страницу авторизации и авторизоваться", () -> {
            editAccountPage.authorizationUser( email, password);
        });

        step("Открыть страницу личного кабинета", () -> {
            editAccountPage.openAccountPage();
        });

        $(".userAvatar-buttons").$(withText("Поменять фото профиля")).click();
        $("#upload-profile-file").uploadFromClasspath("images/cat.webp");
        $("#upload-avatar-result").click();
        $(".userAvatar-image").shouldBe(visible);

    }
}
