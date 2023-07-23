package tastycoffee.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x1920";
        Configuration.baseUrl = "https://shop.tastycoffee.ru";
//        RestAssured.baseURI = "https://shop.tastycoffee.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserBinary = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";

    }

    @AfterEach
    void afterEach() {
        Selenide.clearBrowserCookies();
    }
}

