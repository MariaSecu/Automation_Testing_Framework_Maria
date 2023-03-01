package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public WebDriverManager(String webDriverType) {
        this.webDriverType = webDriverType;
    }

    private WebDriver driver;

    private static String webDriverType;

    private static int counter = 0;

    private WebDriver createDriver() {
        switch (webDriverType) {
            case "CHROME":
                counter++;
                System.out.println("Numarul rularii " + counter);
                System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
                driver = new ChromeDriver();

                break;
            case "FIREFOX":
                System.setProperty("webDriver.firefox.driver", "src/main/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("This driver is not created");
        }
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            System.out.println("Driver is closed");
        }
    }
}
