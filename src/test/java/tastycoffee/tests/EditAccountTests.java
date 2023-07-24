package tastycoffee.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.EditAccountPage;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class EditAccountTests extends TestBase {

    EditAccountPage editAccountPage = new EditAccountPage();

    @Epic("Редактирование ЛК пользователя")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий редактирования данных пользователя (без логина и пароля)")
    @Tag("Happy path")
    @Tag("Smoke")
    @Test
    void positiveAccountEditWithoutEmailAndPasswordTest() {

        step("Открыть главную страницу и авторизоваться", () -> {
            editAccountPage.authorizationUser(email, password);
        });

        step("Открыть страницу ЛК", () -> {
            editAccountPage.openAccountPage();
        });

        step("Редактировать данные пользователя", () -> {
            editAccountPage.editFullName(fullName)
                    .editPhoneNumber(phoneNumber)
                    .editCompanyName(companyName)
                    .editCompanyAddress(companyAddress)
                    .editCompanyInn(companyInn)
                    .editCompanyKpp(companyKpp);
        });

        step("Сохранить редактирование через кнопку 'Сохранить'", () -> {
            editAccountPage.clickSubmitUpdateButton();
        });

        step("Проверить изменения в данных пользователя", () -> {
            editAccountPage.verifyUpdateResults(fullName, phoneNumber, companyName,
                    companyAddress, companyInn, companyKpp);
        });


// часть с паролем - отложена
        // $(".input-wrap [type='password']").setValue(passwordNew);
//        $(".go-out").click();
//        Selenide.clearBrowserCookies();
//        Selenide.clearBrowserLocalStorage();
//
//        authorizationPage.openMainPage()
//                .closedYandexAutofillPopup()
//                .openPopupAuthorization()
//                .setEmail(email)
//                .setPassword(passwordNew)
//                .clickSubmitButton();
//        authorizationPage.verifyAuthorization(userNameInHeader);
//    }
//
//    void authoApi() {
////        String requestBody = "email=alina.vishnevskaya.12%40gmail.com&password=89611222970a";
////        "application/x-www-form-urlencoded; charset=UTF-8"
//        given()
//                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
//                .formParam("email", "alina.vishnevskaya.12@gmail.com")
//                .formParam("password", "89611222970a")
////                .cookie("tastycoffee_session", "eyJpdiI6Ijl2QTkyUUxMNjdTcFZSRzMyaHVqRmc9PSIsInZhbHVlIjoidDNScm51QVlRMUJ1OW9uMTJxRXdYdkZzejdxYURMK1Q4QjR1V1N6SFlLOWJwTDl3Q2Y2SnBHQTBDQTRQeXRJcWMxT0t2ZTFqcnJzRDBzaUJMNDdWZkxrQ014WG1vRktTRlJhZlluTyt4U1YwUnRISEF3d1hpemwyZXNuRE9yS2IiLCJtYWMiOiI4NDcxNGUwNTUwODg1ODllMzk2NmZhMTg5NjYyM2QwZTRmYTJlMGIzODU3NmFhOWU5NGE4M2Y1ZmQyZDFmMjg2IiwidGFnIjoiIn0%3D")
////                .cookie("XSRF-TOKEN", "eyJpdiI6IktiSkJGZkk5UXhBd01hWXNkZlJKVUE9PSIsInZhbHVlIjoiOEwxTjNmUGYxR3FVa1dWdUp1aW9ZZmdpb0FEbnRvTWJKQldjWFNCTHlwOFJ2QitmQ01NYjk5Zk5RTTlYL1lkTkp4ZVhSS2ptMFJaeU9MMXVJeEZ4UnozNWR3Y3N0RlVyTXlqZG1XQyt5Vzg3UFRTZnNUdDl3NE9NWEtzdnJ3YXEiLCJtYWMiOiI5ZmU5ODY1NzA3OWI5MzZhM2ZlMWI3YWNhN2YxYTI2YWVlMDEzNDNlYWZhMmI2MzQ5ZjBhM2M4MzE3NmZmN2Y1IiwidGFnIjoiIn0%3D")
////                .body(requestBody)
//                .log().all()
//                .when()
//                .post("https://shop.tastycoffee.ru/login")
//                .then()
//                .log().all()
//                .statusCode(200);
//
//        open(" ");
//

    }
}
