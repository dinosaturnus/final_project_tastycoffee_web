package tastycoffee.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tastycoffee.pages.EditAvatarPage;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class EditAvatarUser extends TestBase {

    static EditAvatarPage editAvatarPage = new EditAvatarPage();

    @BeforeAll
    static void autho() {
        step("Открыть страницу авторизации и авторизоваться", () -> {
            editAvatarPage.authorizationUser(email, password);
        });

        step("Открыть страницу личного кабинета", () -> {
            editAvatarPage.openAccountPage();
        });
    }

    @CsvFileSource(resources = "/avatars_path.csv")

    @Epic("Редактирование личного кабинета пользователя")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий редактирования аватара пользователя")
    @Tag("Happy path")
    @Tag("Smoke")
    @ParameterizedTest (name = "Загрузка изображений с разными расширениями при изменении аватара")
    void paramTest(String imagePath) {
//        step("Открыть страницу авторизации и авторизоваться", () -> {
//            editAvatarPage.authorizationUser(email, password);
//        });
//
//        step("Открыть страницу личного кабинета", () -> {
//            editAvatarPage.openAccountPage();
//        });

        step("Выбрать и загрузить новый аватар", () -> {
            editAvatarPage.clickEditAvatarButton()
                    .uploadImage(imagePath)
                    .saveImage();
        });

        step("Проверить, что аватар загрузился", () -> {
            editAvatarPage.verifyNewAvatar();
        });

        step("Удалить загруженный аватар", () -> {
            editAvatarPage.deleteAvatar();
        });

    }
}
