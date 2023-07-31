package tastycoffee.tests.product;

import org.junit.jupiter.api.Test;
import tastycoffee.pages.product.OptionInnerFieldsPage;
import tastycoffee.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static tastycoffee.tests.TestData.*;

public class OptionInnerFieldsTests extends TestBase {

    OptionInnerFieldsPage optionInnerFieldsPage = new OptionInnerFieldsPage();

    @Test
    void openMillingDropdownMenuAndSelectedOptionTest() {
        step("Открыть страницу товара", () -> {
            optionInnerFieldsPage.openProductPage(CANDY_URL);
        });

        step("Проверить, что по умолчанию выбран помол 'В зернах'", () -> {
            optionInnerFieldsPage.checkMillingDefaultValue(MILLING_DEFAULT_VALUE);
        });

        step("Открыть меню с вариантами помола", () -> {
            optionInnerFieldsPage.openMillingDropdownMenu();
        });

        step("Выбрать вариант помола 'для аэропресса (средний)'", () -> {
            optionInnerFieldsPage.selectOptionMilling(MILLING_SELECTED_VALUE);
        });

        step("Проверить, что меню закрылось после выбора варианта", () -> {
            optionInnerFieldsPage.verifyThatMillingDropdownMenuIsDisappeared();
        });

        step("Проверить, что выбранный вариант помола изменился на 'для аэропресса (средний)'", () -> {
            optionInnerFieldsPage.verifyThatMillingValueHasChanged(MILLING_SELECTED_VALUE);
        });
    }

}