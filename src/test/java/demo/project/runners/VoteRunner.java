package demo.project.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.WithTag;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/UI/Vote.feature",
        glue = "demo.project.steps.UI")
@WithTag("UI")
public class VoteRunner {
}
