package demo.project.steps.UI;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.project.models.User;
import demo.project.steps.serenitySteps.VoteSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.intellij.lang.annotations.JdkConstants;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class VoteBDDSteps {

    @Steps
    VoteSteps voteSteps;

    @Given("The home page is ready")
    public void loadHomePage() {
        voteSteps.openHomePage();
    }

    @When("I login with new user \"([^\"]*)\" and \"([^\"]*)\"")
    public void loginWithNewUser(String username, String password) {
        User user;
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        password = password.equalsIgnoreCase("random") ? "Test!" + System.currentTimeMillis() : password;
        if (username.equalsIgnoreCase("random")) {
            username = firstName + lastName;
        }
        user = new User(username, firstName, lastName, password);
        voteSteps.loginWithNewUser(user);
    }

    @Then("login success")
    public void checkLogin() {
        voteSteps.checkLogin();
    }

    @When("I vote for the first car")
    public void voteForTheFirstCar() {
        voteSteps.vote();
    }

    @Then("The vote result and comment is correct")
    public void checkVoteAndComment() {
        voteSteps.checkVote();
    }
}
