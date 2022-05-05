package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"StepDefinition"},
        features = "src/test/resources/TestCases",
        plugin = "json:target/ReportJson/LocalChromeCucumber.json"
)

public class MainRun {
}
