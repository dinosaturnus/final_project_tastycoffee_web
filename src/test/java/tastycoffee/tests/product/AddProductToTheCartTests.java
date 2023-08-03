package tastycoffee.tests.product;

import io.qameta.allure.Description;
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

    @Epic("Товар")
    @Feature("Добавление в корзину")
    @Story("Информационный поп-ап")
    @DisplayName("Появление поп-апа")
    @Description("После нажатия кнопки 'Купить' появляется информационный поп-ап с текстом 'Товар добавлен в корзину' " +
            "и кнопками 'Перейти в корзину' и 'Продолжить покупки'" )
    @Tags({
            @Tag("Regress")
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

    @Epic("Товар")
    @Feature("Добавление в корзину")
    @Story("Изменение счетчика товаров в шапке")
    @DisplayName("Увеличение значения")
    @Description("После добавления товара в корзину счетчик товаров увеличивается на 1 единицу")
    @Tags({
            @Tag("Regress")
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

    @Epic("Товар")
    @Feature("Добавление в корзину")
    @Story("UI/UX кнопки 'Купить'")
    @DisplayName("Изменение текста кнопки на 'В корзине'")
    @Description("После добавления товара в корзину дефолтный текст кнопки 'Купить' меняется на 'В корзине'")
    @Tags({
            @Tag("Regress")
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

    @Epic("Товар")
    @Feature("Добавление в корзину")
    @Story("Добавление товара кнопкой 'Купить'")
    @DisplayName("Нажатие кнопки 'Купить' добавляет товар в корзину")
    @Description("Товар появляется на странице корзины после нажатия кнопки 'Купить'")
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
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
