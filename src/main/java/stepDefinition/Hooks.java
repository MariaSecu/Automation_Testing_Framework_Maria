package stepDefinition;

import contextManager.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeEach
    public void setUpBeforeEachTest() {
        testContext.getWebDriverManager().getDriver();

    }

    @AfterEach
    public void tearDownAfterEachTest() throws InterruptedException {
        Thread.sleep(3000);
        testContext.getWebDriverManager().closeDriver();
    }
}
