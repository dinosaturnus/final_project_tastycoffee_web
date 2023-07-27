package tastycoffee.pages.product;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddItemToTheCartPage {

    SelenideElement modalItemAddToTheCart = $("[data-modal-name='thanks']"),
            headerNumberItemsInTheCart = $("#header_cart_text"),
            buyButton = $(".buyBtn");

    public AddItemToTheCartPage openProductPage() {
        open("/coffee/espresso-nutty");

        return this;
    }

    public AddItemToTheCartPage verifyCartIsEmpty() {
        headerNumberItemsInTheCart.shouldHave(text("0 товаров"));

        return this;
    }

    public AddItemToTheCartPage addProductToTheCart() {
        buyButton.click();

        return this;
    }

    public void verifyItemAddToTheCart() {
        modalItemAddToTheCart.shouldBe(appear);
        headerNumberItemsInTheCart.shouldHave(text("1 товар"));
    }

}
