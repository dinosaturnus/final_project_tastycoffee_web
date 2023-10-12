package tastycoffee.tests.cart;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import tastycoffee.pages.cart.EmptyingTheCartPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.data.ProductInfoData.*;

@Epic("Корзина")
@Feature("Очищение корзины")
public class EmptyingTheCardTests extends TestBase {
    EmptyingTheCartPage emptyingTheCartPage = new EmptyingTheCartPage();

    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @Story("Удаление одного товара")
    @Description("Товар удаляется из корзины после нажатия кнопки 'Удалить' в карточке товара")
    @DisplayName("Удаление через карточку товара")
    void deleteOneItemsFromTheCartTest() {
        step("Добавить товары в корзину", () -> {
            emptyingTheCartPage.addProduct(NUTTY_URL)
                    .addProduct(CANDY_URL);
        });

        step("Открыть корзину и проверить наличие добавленных товаров", () -> {
            emptyingTheCartPage.openCart()
                    .checkProductInTheCart(NUTTY_NAME)
                    .checkProductInTheCart(CANDY_NAME);
        });

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

    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @Story("Удаление всех товаров")
    @Description("Корзина очищается полностью после нажатия кнопки 'Удалить все товары'")
    @DisplayName("Удаление через кнопку 'Удалить все товары'")
    void deleteAllItemsFromTheCartTest() {
        step("Добавить товары в корзину", () -> {
            emptyingTheCartPage.addProduct(NUTTY_URL)
                    .addProduct(CANDY_URL);
        });

        step("Открыть корзину и проверить наличие добавленных товаров", () -> {
            emptyingTheCartPage.openCart()
                    .checkProductInTheCart(NUTTY_NAME)
                    .checkProductInTheCart(CANDY_NAME);
        });

        step("Очистить корзину через кнопку 'Удалить все товары'", () -> {
            emptyingTheCartPage.deleteAllItems();
        });

        step("Проверить, что появился текст 'Ваша корзина пуста'", () -> {
            emptyingTheCartPage.verifyCartIsEmpty();
        });
    }
}
