package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"input-lastname\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"input-confirm\"]")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//*[@name=\"agree\"]")
    private WebElement privaceCheckBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;


    public void fillInTheRegisterPage(String firstName, String lastName, String email, String phone, String password, String confirmPassword) throws InterruptedException {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        Thread.sleep(2000);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(confirmPassword);
        privaceCheckBox.click();
        continueButton.click();

    }

    public boolean allTheElementsAreDisplyed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() && telephoneInput.isDisplayed()
                && passwordInput.isDisplayed() && passwordConfirmInput.isDisplayed()
                && privaceCheckBox.isDisplayed() && continueButton.isDisplayed();
    }

}
