package tastycoffee.tests.cart;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import tastycoffee.pages.cart.EmptyingTheCartPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.data.TestData.*;

public class EmptyingTheCardTests extends TestBase {
    EmptyingTheCartPage emptyingTheCartPage = new EmptyingTheCartPage();

    @DisplayName("Предварительные шаги: добавление товаров в корзину, " +
            "открытие корзины и проверка добавленных товаров")
    @BeforeEach
    public void addProductsToTheCartPrecondition() {
        step("Добавить товары в корзину", () -> {
            emptyingTheCartPage.addProduct(NUTTY_URL)
                    .addProduct(CANDY_URL);
        });

        step("Открыть корзину и проверить наличие добавленных товаров", () -> {
            emptyingTheCartPage.openCart()
                    .checkProductInTheCart(NUTTY_NAME)
                    .checkProductInTheCart(CANDY_NAME);
        });
    }

    @Epic("Действия с корзиной")
    @Feature("Удаление одного товара")
    @Story("Позитивный сценарий")
    @DisplayName("Успешное удаление одного товара из корзины")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke"),
    })
    @Test
    void positiveDeleteOneItemsFromTheCartTest() {
        step("Удалить один товар", () -> {
            emptyingTheCartPage.deleteOneItem(NUTTY_NAME);
        });

        step("Проверить отсутствие удаленного товара", () -> {
            emptyingTheCartPage.verifyItemRemoved(NUTTY_NAME);
        });

        step("Проверить наличие оставшихся товаров", () -> {
            emptyingTheCartPage.checkProductInTheCart(CANDY_NAME);
        });
    }

    @Epic("Действия с корзиной")
    @Feature("Удаление всех товаров")
    @Story("Позитивный сценарий")
    @DisplayName("Успешное очищение корзины через кнопку 'Удалить все товары'")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke"),
    })
    @Test
    void positiveDeleteAllItemsFromTheCartTest() {
        step("Очистить корзину через кнопку 'Удалить все товары'", () -> {
            emptyingTheCartPage.deleteAllItems();
        });

        step("Проверить, что появился текст 'Ваша корзина пуста'", () -> {
            emptyingTheCartPage.verifyCartIsEmpty();
        });
    }
}
