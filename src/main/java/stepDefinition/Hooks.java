package stepDefinition;

import contextManager.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUpBeforeEachTest() throws InterruptedException {
        Thread.sleep(3000);
        testContext.getWebDriverManager().getDriver();

    }

    @After
    public void tearDownAfterEachTest() throws InterruptedException {
        testContext.getWebDriverManager().closeDriver();
    }
}
