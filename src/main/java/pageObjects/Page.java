package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")
    protected WebElement myAccountButton;

    @FindBy(xpath = "//*[@class=\"dropdown open\"]/ul/li[1]/a")
    protected WebElement registereButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    protected WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
    protected WebElement loginButton;


    public void navigateToRegisterPage() throws InterruptedException {

        myAccountButton.click();
        registereButton.click();
    }

    public void navigateToLogoutPage() throws InterruptedException {
        Thread.sleep(1000);
        myAccountButton.click();
        Thread.sleep(1000);
        logoutButton.click();

    }

    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        loginButton.click();
    }


}


