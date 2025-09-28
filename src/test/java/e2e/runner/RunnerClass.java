package e2e.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "e2e.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags = "@BeymenSmokeTest"
)
public class RunnerClass {

}

