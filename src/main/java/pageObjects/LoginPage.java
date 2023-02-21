package pageObjects;

import managers.DataManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement passwordInputLogin;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginNowButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillInTheLoginPage(String email, String password) throws InterruptedException {
        String emailSet = DataManager.generateEmail(25);
        emailInput.sendKeys(email);
        Thread.sleep(3000);
        passwordInputLogin.sendKeys(password);
        loginNowButton.click();

    }

}
