package tastycoffee.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tastycoffee.config.SelenoidConfig;
import tastycoffee.config.WebDriverConfig;
import tastycoffee.helpers.Attach;

import java.util.Map;

import static org.aeonbits.owner.ConfigFactory.*;

public class TestBase {
    private static WebDriverConfig webDriverConfig = create(WebDriverConfig.class, System.getProperties());
    private static SelenoidConfig selenoidConfig = create(SelenoidConfig.class, System.getProperties());
    protected static boolean isRemote = Boolean.getBoolean("isRemote");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();

        if (isRemote) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub",
                    selenoidConfig.login(), selenoidConfig.password(), selenoidConfig.url());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
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
        if (isRemote) {
            Attach.addVideo();
        }
    }
}