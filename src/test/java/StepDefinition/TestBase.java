package StepDefinition;

import Page.Action.CompareLaptopAction;
import Page.Action.ResultAction;
import Runner.BrowserManager.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = DriverFactory.getDriver();
    protected CompareLaptopAction compareLaptopAction;
    protected ResultAction resultAction;

    public TestBase() {
        this.compareLaptopAction = new CompareLaptopAction(driver);
        this.resultAction = new ResultAction(driver);
    }
}
