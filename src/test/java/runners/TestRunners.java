package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/advanced-reports.json",
                "timeline:target/test-output-thread/"
        },
        tags="@test",
        monochrome = true
)

public class TestRunners extends AbstractTestNGCucumberTests {




}
