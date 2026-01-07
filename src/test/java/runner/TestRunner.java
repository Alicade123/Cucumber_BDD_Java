package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"scenario_outline",
            "base.dependenceInjection"
        },
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner {}

