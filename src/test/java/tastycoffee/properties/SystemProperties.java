package tastycoffee.properties;

public class SystemProperties {

    public static String browserProperty = System.getProperty("browser", "chrome"),
            browserSizeProperty = System.getProperty("browserSize", "1920x1080"),
            browserVersionProperty = System.getProperty("browserVersion", "112.0.5615.137");
}
