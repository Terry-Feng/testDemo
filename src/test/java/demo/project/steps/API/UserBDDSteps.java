package demo.project.steps.API;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.project.steps.serenitySteps.UserSteps;

import java.util.Map;

public class UserBDDSteps {
    @When("I register a new user with following data")
    public void registerUser(DataTable table) {
        Map<String, String> userInfo = table.asMaps(String.class, String.class).get(0);
        UserSteps.createUser(userInfo);
    }

    @When("I login with user \"([^\"]*)\" and password \"([^\"]*)\"")
    public void login(String username, String password) {
        UserSteps.login(username, password);
    }

    @Then("Server response with following data")
    public void checkRegisterResponse(DataTable table) {
        Map<String, String> expectInfo = table.asMaps(String.class, String.class).get(0);
        UserSteps.checkRegisterResponse(expectInfo);
    }

    @Then("Server response status \"([^\"]*)\" and message \"([^\"]*)\"")
    public void checkLoginResponse(int status, String message) {
        UserSteps.checkLoginResponse(status, message);
    }
}
