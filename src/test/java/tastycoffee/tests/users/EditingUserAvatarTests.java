package tastycoffee.tests.users;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tastycoffee.pages.users.EditingUserAvatarPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.data.TestData.*;

public class EditingUserAvatarTests extends TestBase {

    static EditingUserAvatarPage editingUserAvatarPage = new EditingUserAvatarPage();

    @DisplayName("Предварительные шаги: авторизоваться под пользователем" +
            "и перейти на страницу личного кабинета")
    @BeforeAll
    static void authorizationUserPrecondition() {
        step("Открыть страницу авторизации и авторизоваться", () -> {
            editingUserAvatarPage.authorizationUser(EMAIL, PASSWORD);
        });

        step("Открыть страницу личного кабинета", () -> {
            editingUserAvatarPage.openAccountPage();
        });
    }

    @AfterAll
    static void clearBrowserCookies() {
        step("Очистка куков после всех циклов теста для деавторизации пользователя", () -> {
            Selenide.clearBrowserCookies();
        });
    }

    @CsvFileSource(resources = "/avatars_path.csv")

    @Epic("Действия с личным кабинетом пользователя")
    @Feature("Редактирование аватара")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий редактирования аватара пользователя.")
    @Tag("Parameterized")
    @ParameterizedTest(name = "Загрузка изображений с расширениями .jpg, .webp и .png при изменении аватара")
    void positiveEditingUserAvatarTest(String imagePath) {

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

        step("Проверить, что аватар удален", () -> {
            editingUserAvatarPage.checkThatAvatarRemoved();
        });
    }
}
