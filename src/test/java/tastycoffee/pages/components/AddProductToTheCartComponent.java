package tastycoffee.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductToTheCartComponent {

    SelenideElement buyButton = $(".buyGoods");

    public void openProductPage(String productURL) {
        open("/coffee/" + productURL);
    }

    public void addProductToTheCart() {
        buyButton.click();
    }

}
