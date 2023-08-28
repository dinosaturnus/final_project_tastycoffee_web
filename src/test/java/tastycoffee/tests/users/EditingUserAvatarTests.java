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

@Epic("Личный кабинет")
@Feature("Личные данные")
public class EditingUserAvatarTests extends TestBase {
    EditingUserAvatarPage editingUserAvatarPage = new EditingUserAvatarPage();

    @DisplayName("Очистка куков после всех циклов теста для деавторизации пользователя - " +
            "необходимо при запуске всего скоупа тестов проекта, иначе последующие тесты падают")
    @AfterAll
    static void clearBrowserCookies() {
        step("Очистка куков и деавторизация", () -> {
            Selenide.clearBrowserCookies();
        });
    }

    @DisplayName("Предварительные шаги: авторизация под пользователем" +
            "и переход на страницу личного кабинета")
    @BeforeAll
    void authorizationUserPrecondition() {
        step("Открыть страницу авторизации и авторизоваться", () -> {
            editingUserAvatarPage.authorizationUser(EMAIL, PASSWORD);
        });

        step("Открыть страницу личного кабинета", () -> {
            editingUserAvatarPage.openAccountPage();
        });
    }

    @CsvFileSource(resources = "/avatars_path.csv")

    @Tag("Regress")
    @ParameterizedTest(name = "Загрузка изображений с расширениями .jpg, .webp и .png при изменении аватара")
    @Story("Редактирование аватара")
    void editingUserAvatarTest(String imagePath) {
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
