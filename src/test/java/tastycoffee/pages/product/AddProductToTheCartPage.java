package tastycoffee.pages.product;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductToTheCartPage {

    SelenideElement modalItemAddToTheCart = $("[data-modal-name='thanks']"),
            headerNumberItemsInTheCart = $("#header_cart_text"),
            buyButton = $(".buyGoods"),
            buyButtonAdded = $(".blackBtn.added"),
            productInformationInCart = $(".goods-col");

    public AddProductToTheCartPage openProductPage(String productURL) {
        open("/coffee/" + productURL);

        return this;
    }

    public AddProductToTheCartPage verifyHeaderCartIsEmpty() {
        headerNumberItemsInTheCart.shouldHave(text("0 товаров"));

        return this;
    }

    public AddProductToTheCartPage addProductToTheCart() {
        buyButton.click();

        return this;
    }

    public AddProductToTheCartPage verifyThatModalItemAddToTheCartHasAppeared() {
        modalItemAddToTheCart.shouldBe(appear);

        return this;
    }

    public AddProductToTheCartPage verifyThatValueInHeaderCartChangedByOne() {
        headerNumberItemsInTheCart.shouldHave(text("1 товар"));

        return this;
    }

    public AddProductToTheCartPage verifyThatBuyButtonHasChangedItsText() {
        buyButtonAdded.shouldHave(text("В корзине"));

        return this;
    }

    public AddProductToTheCartPage openCartPage() {
        open("/basket");

        return this;
    }

    public AddProductToTheCartPage verifyThatAddedProductAvailableInTheCart(String productName) {
        productInformationInCart.$(withText(productName)).shouldBe(visible);

        return this;
    }

}
