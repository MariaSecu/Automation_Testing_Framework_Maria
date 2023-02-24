import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class JunitPractice {

    WebDriverManager webDriverManager = new WebDriverManager("CHROME");

    @BeforeEach
    public void beforeTestProcedure() {
        webDriverManager.getDriver().get("https://demo-opencart.com/");
    }

    @AfterEach
    public void afterTestInstruction() {
        webDriverManager.closeDriver();
    }

    @Test
    @DisplayName("Registration page is accessible from home page")
    public void VerifyIfTheRegisterPageIsAccesible() throws InterruptedException {

        HomePage homePage = new HomePage(WebDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlIsValid = WebDriverManager.getDriver().getCurrentUrl().contains("register");
        Assertions.assertTrue(urlIsValid, "Invsalid url");

    }

    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementsAreDisplayed() throws InterruptedException {

        HomePage homePage = new HomePage(WebDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        Thread.sleep(2000);
        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());
        Assertions.assertTrue(registerPage.allTheElementsAreDisplyed(), "There are no register page elements");


    }


}
