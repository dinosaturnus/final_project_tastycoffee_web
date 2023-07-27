package tastycoffee.tests.users;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tastycoffee.pages.users.EditingUserAvatarPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class EditingUserAvatarTests extends TestBase {

    static EditingUserAvatarPage editingUserAvatarPage = new EditingUserAvatarPage();

    @BeforeAll
    static void autho() {
        step("Открыть страницу авторизации и авторизоваться", () -> {
            editingUserAvatarPage.authorizationUser(email, password);
        });

        step("Открыть страницу личного кабинета", () -> {
            editingUserAvatarPage.openAccountPage();
        });
    }

    @CsvFileSource(resources = "/avatars_path.csv")

    @Epic("Действия с личным кабинетом пользователя")
    @Feature("Редактирование аватара")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий редактирования аватара пользователя")
    @Tag("Happy path")
    @Tag("Regress")
    @ParameterizedTest(name = "Загрузка изображений с расширениями .jpeg, .webp и .png при изменении аватара")
    void paramTest(String imagePath) {

        step("Выбрать и загрузить новый аватар", () -> {
            editingUserAvatarPage.clickEditAvatarButton()
                    .uploadImage(imagePath)
                    .saveImage();
        });

        step("Проверить, что появилось мини-превью нового аватара", () -> {
            editingUserAvatarPage.verifyNewAvatar();
        });

        step("Удалить загруженный аватар", () -> {
            editingUserAvatarPage.deleteAvatar();
        });

    }
}
