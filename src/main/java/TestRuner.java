import managers.WebDriverManager;

public class TestRuner {
    public static void main(String[] args) {

        WebDriverManager webDriverManager = new WebDriverManager("CHROME");
        webDriverManager.getDriver().get("https:/www.google.md//");
        webDriverManager.closeDriver();
    }
}
