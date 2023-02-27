package stepDefinition;

import contextManager.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import pageObjects.HomePage;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }

    private String link;

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String link) {
        testContext.getWebDriverManager().getDriver().get(link);
        testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(link);

    }

    @When("my Account button is clicked$")
    public void myAccountButtonIsClicked() throws Throwable {
        Thread.sleep(2500);
        homePage.clickOnMyAccountBtn();
    }


    @Then("^register account button is displayed$")
    public void registerAccountButtonIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(homePage.registerButtonIsDisplayed(), "The register button is displayed");
    }

    @And("^register account button is clicked$")
    public void registerAccountButtonIsClicked() {
        homePage.clickOnRegisterButton();
    }

    @Then("^the new URL contain the following \"([^\"]*)\"$")
    public void theNewURLContainTheFollowingString(String contentKey) {
        Boolean stringIsPresentInUrl = WebDriverManager.getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(stringIsPresentInUrl, "The url contain " + contentKey);

    }

    @And("^the \"([^\"]*)\" is close$")
    public void theIsClose(String link) throws Throwable {
        Thread.sleep(2500);
        WebDriverManager.getDriver().close();
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
