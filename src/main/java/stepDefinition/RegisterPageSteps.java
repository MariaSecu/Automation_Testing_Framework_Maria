package stepDefinition;

import contextManager.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterPageSteps {
    private TestContext testContext;
    private RegisterPage registerPage;

    public RegisterPageSteps(TestContext context) {
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());

    }

    @When("^The registration form is populated with below data$")
    public void theRegistrationFormIsPopulatedWithBelowData(Map<String, String> formData) throws InterruptedException {
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");
        String email = formData.get("email");
        String telephone = formData.get("telephone");
        String password = formData.get("password");
        String confirmPassword = formData.get("confirmPassword");
        registerPage.fillInTheRegisterPage(firstName, lastName, email, telephone, password, confirmPassword);
        Thread.sleep(5000);

    }


    @And("^privacyButton is clicked$")
    public void privacybuttonIsClicked() throws InterruptedException {
        Thread.sleep(2000);
        registerPage.clickOnThePrivacyButton();
    }

    @And("^continueButton is clicked$")
    public void continuebuttonIsClicked() throws InterruptedException {
        registerPage.clickOnTheContinueButton();
    }


    @Then("^The following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorAreDisplayedInTheScreen(String condition, List<String> errorMessage) throws InterruptedException {
        Thread.sleep(5000);
        for (int i = 1; i < errorMessage.size(); i++) {
            boolean elementIsDisplayed = false;
            try {
                WebElement webElement = testContext.getWebDriverManager().getDriver().findElement(By.xpath("//*[contains(text(),'" + errorMessage.get(i) + "')]"));
                elementIsDisplayed = webElement.isDisplayed();
                System.out.println(webElement.getText());
                System.out.println(webElement.isDisplayed());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (condition.contains("are not"))
                Assert.assertFalse(" The error message is not displayed", elementIsDisplayed);
            else
                Assert.assertTrue("The error message is displayed", elementIsDisplayed);

        }
    }
}
