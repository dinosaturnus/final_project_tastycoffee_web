package tastycoffee.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tastycoffee.helpers.Attach;
import tastycoffee.properties.SystemProperties;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = SystemProperties.browserProperty;
        Configuration.browserSize = SystemProperties.browserSizeProperty;
        Configuration.browserVersion = SystemProperties.browserVersionProperty;
        Configuration.baseUrl = SystemProperties.baseUrlProperty;
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browserBinary = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        Configuration.remote = SystemProperties.remoteSelenoidProperty;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void clearBrowserCookies() {
        Selenide.clearBrowserCookies();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}

