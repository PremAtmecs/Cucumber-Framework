package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features/login.feature"},
        glue = "stepDefinition",
        dryRun = false,
        monochrome = true
)
public class TestRunner {
}
