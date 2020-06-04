package com;

import com.buildSettings.TestEnvironment;
import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@CucumberOptions(
        tags = "not @ignore",
        strict = true,
        features = {
                "src/test/resources/features"
        },
        glue = {
                "com.steps"
        },
        plugin = {
                "pretty", "html:target/cucumber-report/single",
                "json:target/reports/cucumber.json",
        }
)
//This is experimental file and doesn't work well when using current settings.
//If you would like to use TestNGRunner for running feature files, you have to edit build.gradle file.
public class TestNGRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
        TestEnvironment.allureWriteProperties();
        TestEnvironment.allureWriteExecutors();
    }
}