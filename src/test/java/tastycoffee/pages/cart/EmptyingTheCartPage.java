package tastycoffee.pages.cart;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tastycoffee.pages.components.AddProductToTheCartComponent;
import tastycoffee.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class EmptyingTheCartPage extends TestBase {

    AddProductToTheCartComponent addProductToTheCartComponent = new AddProductToTheCartComponent();

    SelenideElement productCard = $(".goods-item"),
            deleteAllItemsButton = $(".goodsRemove"),
            cartHeaderText = $(".content");

    ElementsCollection listOfProductsInTheCart = $$("#basket-products");

    public EmptyingTheCartPage addProduct(String productName) {
        addProductToTheCartComponent.openProductPage(productName);
        addProductToTheCartComponent.addProductToTheCart();

        return this;
    }

    public EmptyingTheCartPage openCart() {
        open("/basket");
        executeJavaScript("$('#supportTrigger').remove()");
        executeJavaScript("$('.socialNetworks').remove()");

        return this;
    }

    public EmptyingTheCartPage checkProductInTheCart(String productName) {
        listOfProductsInTheCart.findBy(text(productName)).shouldBe(visible);

        return this;
    }

    public EmptyingTheCartPage deleteOneItem(String productName) {
        listOfProductsInTheCart.findBy(text(productName)).$(".goods__price .blackLink").click();

        return this;
    }

    public EmptyingTheCartPage deleteAllItems() {
        deleteAllItemsButton.$(byText("Удалить все товары")).click();

        return this;
    }

    public EmptyingTheCartPage verifyItemRemoved(String productName) {
        productCard.$(withText(productName)).shouldNotBe(visible);

        return this;
    }

    public EmptyingTheCartPage verifyCartIsEmpty() {
        cartHeaderText.$(withText("Ваша корзина пуста")).shouldBe(visible);

        return this;
    }
}
