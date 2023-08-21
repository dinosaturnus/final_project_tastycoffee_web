package tastycoffee.pages.product;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OptionInnerFieldsPage extends TestBase {
    private SelenideElement optionInnerFields = $(".d-flex"),
            millingOptionInnerField = $(".bootstrap-select.milling"),
            millingDropdownMenu = $(".dropdown-menu");

    private ElementsCollection listDropdownMenuMilling = $$("ul.dropdown-menu");

    public OptionInnerFieldsPage openProductPage(String productURL) {
        open("/coffee/" + productURL);

        return this;
    }

    public OptionInnerFieldsPage checkMillingDefaultValue(String millingName) {
        optionInnerFields.$(withText(millingName)).shouldBe(visible);

        return this;
    }

    public OptionInnerFieldsPage openMillingDropdownMenu() {
        millingOptionInnerField.click();

        return this;
    }

    public OptionInnerFieldsPage selectOptionMilling(String millingName) {
        listDropdownMenuMilling.findBy(text(millingName)).click();

        return this;
    }

    public OptionInnerFieldsPage verifyThatMillingDropdownMenuIsDisappeared() {
        millingDropdownMenu.shouldBe(disappear);

        return this;
    }

    public OptionInnerFieldsPage verifyThatMillingValueHasChanged(String millingName) {
        optionInnerFields.$(withText(millingName)).shouldBe(visible);

        return this;
    }
}
