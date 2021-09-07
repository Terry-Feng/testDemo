package demo.project.pages;

import demo.project.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DefaultUrl("https://buggy.justtestit.org")
public class HomePage extends PageObject {
    @FindBy(xpath = "//a[contains(text(), 'Register')]")
    private WebElement registerLink;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[contains(text(), 'Register')]")
    private WebElement registerBtn;

    @FindBy(css = "[placeholder='Login']")
    private WebElement loginUsername;

    @FindBy(xpath = "//input[@placeholder='Login']/following-sibling::input")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@href='/' and contains(text(), 'Rating')]")
    private WebElement homeLink;

    @FindBy(xpath = "//h2[contains(text(), 'Overall Rating')]")
    private WebElement rateHeader;

    @FindBy(xpath = "//tr[1]//a[contains(text(), 'View more')]")
    private WebElement firstCar;

    @FindBy(id = "comment")
    private WebElement comment;

    @FindBy(xpath = "//button[contains(text(), 'Vote')]")
    private WebElement voteBtn;

    @FindBy(xpath = "//h4/strong")
    private WebElement voteNumEl;

    @FindBy(xpath = "//a[@href='/overall']")
    private WebElement overLink;

    @FindBy(xpath = "//p[contains(text(), 'Thank you for your vote')]")
    private WebElement voteSuccessMsg;

    private String commentText = "//td[contains(text(), '%s')]";

    public void register(User user) {
        registerLink.click();
        waitFor(username);
        username.sendKeys(user.getUsername());
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        password.sendKeys(user.getPassword());
        confirmPassword.sendKeys(user.getPassword());
        registerBtn.click();
    }

    public void login(User user) {
        loginUsername.sendKeys(user.getUsername());
        loginPassword.sendKeys(user.getPassword());
        loginBtn.click();
        homeLink.click();
    }

    public void checkHeader() {
        assertTrue(rateHeader.isDisplayed());
    }

    private int voteNum;
    private String randomComment;

    public void voteTheFirstCar() {
        waitFor(ExpectedConditions.elementToBeClickable(overLink));
        overLink.click();
        waitFor(firstCar);
        firstCar.click();
        waitFor(comment);
        voteNum = Integer.parseInt(voteNumEl.getText());
        randomComment = "test comment" + System.currentTimeMillis();
        comment.sendKeys(randomComment);
        waitFor(ExpectedConditions.elementToBeClickable(voteBtn));
        voteBtn.click();
    }

    public void checkVote() {
        waitFor(ExpectedConditions.visibilityOf(voteSuccessMsg));
        int newVoteNum = Integer.parseInt(voteNumEl.getText());
        assertEquals(voteNum + 1, newVoteNum);
        assertTrue(find(By.xpath(String.format(commentText, randomComment))).isDisplayed());
    }
}
