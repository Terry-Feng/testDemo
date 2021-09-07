package demo.project.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.WithTag;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/API/User.feature",
        glue = "demo.project.steps.API")
@WithTag("API")
public class UserRunner {
}
