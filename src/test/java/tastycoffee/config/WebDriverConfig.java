package tastycoffee.config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://shop.tastycoffee.ru")
    String baseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("version")
    @DefaultValue("115")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}
