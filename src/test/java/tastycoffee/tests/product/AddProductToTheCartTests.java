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

@Epic("Товар")
@Feature("Кнопка 'Купить'")
public class AddProductToTheCartTests extends TestBase {
    AddProductToTheCartPage addProductToTheCartPage = new AddProductToTheCartPage();

    @Test
    @Tag("Regress")
    @Story("Вызов информационного поп-апа")
    @Description("После нажатия кнопки 'Купить' появляется информационный поп-ап с текстом 'Товар добавлен в корзину' " +
            "и кнопками 'Перейти в корзину' и 'Продолжить покупки'" )
    @DisplayName("Появление поп-апа")
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

    @Test
    @Tag("Regress")
    @Story("Изменение счетчика товаров в шапке")
    @Description("После добавления товара в корзину счетчик товаров увеличивается на 1 единицу")
    @DisplayName("Увеличение значения")
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

    @Test
    @Tag("Regress")
    @Story("UI/UX кнопки 'Купить'")
    @Description("После добавления товара в корзину дефолтный текст кнопки 'Купить' меняется на 'В корзине'")
    @DisplayName("Изменение текста кнопки на 'В корзине'")
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

    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress")
    })
    @Story("Добавление товара в корзину")
    @Description("Товар появляется на странице корзины после нажатия кнопки 'Купить'")
    @DisplayName("Нажатие кнопки 'Купить' добавляет товар в корзину")
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
