package tastycoffee.tests.users;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import tastycoffee.data.TestData;
import tastycoffee.pages.users.EditingUserDataPage;
import tastycoffee.tests.TestBase;
import tastycoffee.utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static tastycoffee.data.TestData.*;

@Epic("Личный кабинет")
@Feature("Личные данные")
public class EditingUserDataTests extends TestBase {
    EditingUserDataPage editingUserDataPage = new EditingUserDataPage();

    @Test
    @Story("Редактирование личных данных")
    @Description("Редактирование данных пользователя валидными значениями. Без пароля и логина.")
    @Tags({
            @Tag("Smoke"),
            @Tag ("Regress")
    })
    @DisplayName("Валидные значения: имя и фамилия, номер телефона, " +
            "наименование организации, юридический адрес, ИНН, КПП")
    void userDataEditingTest() {
        step("Открыть страницу авторизации и авторизоваться", () -> {
            editingUserDataPage.authorizationUser(EMAIL, PASSWORD);
        });

        step("Открыть страницу личного кабинета", () -> {
            editingUserDataPage.openAccountPage();
        });

        step("Выбрать и загрузить новый аватар", () -> {
            editingUserDataPage.uploadedAvatar(imagePath);
        });

        step("Проверить, что появилось мини-превью нового аватара", () -> {
            editingUserDataPage.verifyAvatarUploaded();
        });

        step("Удалить загруженный аватар и проверить, что он удален", () -> {
            editingUserDataPage.deleteAvatar();
        });

        step("Редактировать данные пользователя", () -> {
            editingUserDataPage.editFullName(fullName)
                    .editPhoneNumber(phoneNumber)
                    .editCompanyName(companyName)
                    .editCompanyAddress(companyAddress)
                    .editCompanyInn(companyInn)
                    .editCompanyKpp(companyKpp);
        });

        step("Сохранить редактирование через кнопку 'Сохранить'", () -> {
            editingUserDataPage.clickSubmitUpdateButton();
        });

        step("Проверить изменения в данных пользователя", () -> {
            editingUserDataPage.verifyUpdateResults(fullName, phoneNumber, companyName,
                    companyAddress, companyInn, companyKpp);
        });
    }
}
