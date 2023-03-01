package stepDefinition;

import contextManager.TestContext;

public class GeneralSteps {

    private TestContext testContext;

    public GeneralSteps(TestContext context ){
        testContext = context;
    }
    //@Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adressURL) {testContext.getWebDriverManager().getDriver().get(adressURL);
    }
}
