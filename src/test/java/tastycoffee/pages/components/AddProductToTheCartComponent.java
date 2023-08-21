package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductToTheCartComponent {
    private SelenideElement buyButton = $(".buyGoods"),
            modalItemAddToTheCart = $("[data-modal-name='thanks']");

    public void openProductPage(String productURL) {
        open("/coffee/" + productURL);
    }

    public void addProductToTheCart() {
        buyButton.click();
    }

    public void verifyThatProductAddedToTheCart() {
        modalItemAddToTheCart.shouldBe(appear);
    }
}
