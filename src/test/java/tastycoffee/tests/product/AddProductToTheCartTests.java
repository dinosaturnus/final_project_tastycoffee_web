package tastycoffee.tests.product;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import tastycoffee.pages.product.AddProductToTheCartPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.data.TestData.CANDY_NAME;
import static tastycoffee.data.TestData.CANDY_URL;

public class AddProductToTheCartTests extends TestBase {
    AddProductToTheCartPage addProductToTheCartPage = new AddProductToTheCartPage();

    @Epic("Действия с товаром")
    @Feature("Добавление товара в корзину")
    @Story("Позитивный сценарий")
    @DisplayName("Появление информационного поп-апа при добавлении товара в корзину")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke")
    })
    @Test
    void popUpAppearsAfterAddingItemToTheCartTest() {
        step("Открыть страницу товара", () -> {
            addProductToTheCartPage.openProductPage(CANDY_URL);
        });

        step("Нажать кнопку 'Купить'", () -> {
            addProductToTheCartPage.addProductToTheCart();
        });

        step("Проверить, что появился информационный поп-ап", () -> {
            addProductToTheCartPage.verifyThatModalItemAddToTheCartHasAppeared();
        });
    }

    @Epic("Действия с товаром")
    @Feature("Добавление товара в корзину")
    @Story("Позитивный сценарий")
    @DisplayName("Увеличение счетчика товаров в мини-корзине в шапке после добавления товара в корзину")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke")
    })
    @Test
    void cartCounterIncrementedAfterAddingProductTest() {
        step("Открыть страницу товара", () -> {
            addProductToTheCartPage.openProductPage(CANDY_URL);
        });

        step("Проверить, что в корзине в шапке 0 товаров", () -> {
            addProductToTheCartPage.verifyHeaderCartIsEmpty();
        });

        step("Нажать кнопку 'Купить'", () -> {
            addProductToTheCartPage.addProductToTheCart();
        });

        step("Проверить, что в корзине в шапке 1 товар", () -> {
            addProductToTheCartPage.verifyThatValueInHeaderCartChangedByOne();
        });
    }

    @Epic("Действия с товаром")
    @Feature("Добавление товара в корзину")
    @Story("Позитивный сценарий")
    @DisplayName("Изменение текста кнопки 'Купить' на 'В корзине' после добавления товара в корзину")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke")
    })
    @Test
    void buyButtonTextChangesAfterAddingProductTheCartTest() {
        step("Открыть страницу товара", () -> {
            addProductToTheCartPage.openProductPage(CANDY_URL);
        });

        step("Проверить, что текст кнопки дефолтный - 'Купить'", () -> {
            addProductToTheCartPage.checkingDefaultBuyButtonText();
        });

        step("Нажать кнопку 'Купить'", () -> {
            addProductToTheCartPage.addProductToTheCart();
        });

        step("Проверить, что текст кнопки изменился на 'В корзине'", () -> {
            addProductToTheCartPage.verifyThatBuyButtonHasChangedItsText();
        });
    }

    @Epic("Действия с товаром")
    @Feature("Добавление товара в корзину")
    @Story("Позитивный сценарий")
    @DisplayName("Наличие товара на странице корзины после нажатия кнопки 'Купить'")
    @Tags({
            @Tag("Happy path"),
            @Tag("Smoke")
    })
    @Test
    void checkingThatTheProductAppearsInTheCartAfterClickByButtonTest() {
        step("Открыть страницу корзины", () -> {
            addProductToTheCartPage.openCartPage();
        });

        step("Проверить, что корзина пуста", () -> {
            addProductToTheCartPage.checkingThatCartIsEmpty();
        });

        step("Открыть страницу товара", () -> {
            addProductToTheCartPage.openProductPage(CANDY_URL);
        });

        step("Нажать кнопку 'Купить'", () -> {
            addProductToTheCartPage.addProductToTheCart();
        });

        step("Открыть страницу корзины", () -> {
            addProductToTheCartPage.openCartPage();
        });

        step("Проверить, что добавленный товар присутствует в корзине", () -> {
            addProductToTheCartPage.verifyThatAddedProductAvailableInTheCart(CANDY_NAME);
        });
    }
}
