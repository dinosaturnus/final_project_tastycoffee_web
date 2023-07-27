package tastycoffee.tests.product;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tastycoffee.pages.product.AddItemToTheCartPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;

public class AddItemToTheCartForUnauthorizedTests extends TestBase {

    AddItemToTheCartPage addItemToTheCartPage = new AddItemToTheCartPage();

    @Epic("Действия с товаром")
    @Feature("Добавление товара в корзину")
    @Story("Позитивный сценарий")
    @DisplayName("Успешный сценарий добавления товара в корзину со страницы товара под неавторизованным пользователем")
    @Tag("Happy path")
    @Tag("Smoke")
    @Test
    void positiveAddItemToTheCartFromTheProductPageTest() {

        step("Открыть страницу товара", () -> {
            addItemToTheCartPage.openProductPage();
        });

        step("Проверить, что в корзине 0 товаров", () -> {
            addItemToTheCartPage.verifyCartIsEmpty();
        });

        step("Нажать кнопку 'Купить'", () -> {
            addItemToTheCartPage.addProductToTheCart();
        });

        step("Проверить, что в корзине 1 товар", () -> {
            addItemToTheCartPage.verifyItemAddToTheCart();
        });
    }


}
