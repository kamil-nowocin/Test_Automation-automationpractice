package com;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.qameta.allure.Description;
import org.testng.annotations.*;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Listeners({TestNGListener.class})
@CucumberOptions(
        tags = "not @ignore",
        features = {
                "src/test/resources/features"
        },
        plugin = {
                "pretty", "html:target/cucumber-report/single",
                "json:target/reports/cucumber.json",
        }
)

public class TestNGRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    @Description("TEST DESCRIPTION")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        FrameworkEnvironment.allureWriteProperties();
        FrameworkEnvironment.allureWriteExecutors();
    }
}