package tastycoffee.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/selenoid.properties"
})

public interface SelenoidConfig extends Config {
    @Key("url")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();
}