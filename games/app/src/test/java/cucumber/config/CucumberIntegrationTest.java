package cucumber.config;

import cucumber.api.CucumberOptions; //configurações adicionais
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = { "src/test/resources/features"}, //Identifies either a directory containing feature files
        glue = { "classpath:cucumber.step.definitions", "classpath:cucumber.step.hooks"} ,//glue code (step definitions, hooks and plugins)
        strict=true
)
public class CucumberIntegrationTest {
}
