package tastycoffee.properties;

public class SystemProperties {

    public static String browserProperty = System.getProperty("browser", "chrome"),
            browserSizeProperty = System.getProperty("browserSize", "1920x1080"),
            browserVersionProperty = System.getProperty("browserVersion", "115.0.5790.170"),
            baseUrlProperty = System.getProperty("baseUrl", "https://shop.tastycoffee.ru"),
            remoteSelenoidProperty = System.getProperty("remoteSelenoidUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
}
