package Runner.BrowserManager;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal();
    private static List<WebDriver> storedDrivers = new ArrayList();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return (WebDriver)drivers.get();
    }

    public static void addDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
