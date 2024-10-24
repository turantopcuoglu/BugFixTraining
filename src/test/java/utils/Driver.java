package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private Driver() {}

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver get() {
        if (driverPool.get() == null) {
        WebDriverManager.chromedriver().setup();
        driverPool.set(new ChromeDriver());
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
