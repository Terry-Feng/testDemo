package demo.project.steps.serenitySteps;

import demo.project.models.User;
import demo.project.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class VoteSteps {

    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
    }

    @Step
    public void loginWithNewUser(User user) {
        homePage.register(user);
        homePage.login(user);
    }

    @Step
    public void checkLogin() {
        homePage.checkHeader();
    }

    @Step
    public void vote() {
        homePage.voteTheFirstCar();
    }

    @Step
    public void checkVote() {
        homePage.checkVote();
    }
}
