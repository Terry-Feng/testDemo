package demo.project.steps.API;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.project.steps.serenitySteps.DashboardSteps;

public class DashboardBDDSteps {
    private DashboardSteps dashboardSteps = new DashboardSteps();

    @Given("^The resource \"([^\"]*)\" on \"([^\"]*)\" environment is ready$")
    public void initHomePage(String resource, String env) {
        dashboardSteps.retrieveDashboard(resource,env);
    }

    @When("I check the most popular maker")
    public void getMostPopularMaker() {
        dashboardSteps.getPopularMaker();
    }

    @When("I check the most popular model")
    public void getMostPopularModel() {
        dashboardSteps.getPopularModel();
    }

    @Then("The response contains most popular maker information")
    public void checkMakerInfo() {
        dashboardSteps.checkMakerInfo();
    }

    @Then("The response contains most popular model information")
    public void checkModelInfo() {
        dashboardSteps.checkModelInfo();
    }
}
