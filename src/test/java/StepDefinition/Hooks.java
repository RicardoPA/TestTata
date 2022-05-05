package StepDefinition;

import Runner.BrowserManager.ChromeDriverManager;
import Runner.BrowserManager.DriverFactory;
import Runner.BrowserManager.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void prepareTest() {
        DriverManager driverManager = new ChromeDriverManager();
        DriverFactory.addDriver(driverManager.getDriver());
    }

    @After
    public void finalizarTest() {
        DriverFactory.getDriver().quit();
        DriverFactory.removeDriver();
    }
}
