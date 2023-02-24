import managers.DataManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.RegisterPage;

public class TestRuner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManager = new WebDriverManager("CHROME");
        webDriverManager.getDriver().get("https://demo-opencart.com/");
        Thread.sleep(3000);
        try {
            HomePage homePage = new HomePage(WebDriverManager.getDriver());
            homePage.navigateToRegisterPage();

            String emailAddress = DataManager.generateEmail(25);


            RegisterPage registerPage = new RegisterPage(WebDriverManager.getDriver());
            registerPage.fillInTheRegisterPage("Marian", "Popescu", emailAddress, "088897034", "passwrdsw", "passwrdsw");

            LogoutPage logoutPage = new LogoutPage(WebDriverManager.getDriver());
            logoutPage.navigateToLogoutPage();

            LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());
            loginPage.clickLoginButton();
            loginPage.fillInTheLoginPage(emailAddress, "passwrdsw");


        } catch (Exception capturedException) {
            capturedException.printStackTrace();


        } finally {
            Thread.sleep(5000);
            webDriverManager.closeDriver();
        }
    }

}
