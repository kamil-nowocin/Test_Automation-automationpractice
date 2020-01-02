package com;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.qameta.allure.Description;
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
        features = {
                "src/test/resources/features"
        },
        plugin = {
                "pretty", "html:target/cucumber-report/single",
                "json:target/reports/cucumber.json",
        }
)
//This is experimental file and doesn't work well when using current settings.
//If you would like to use TestNGRunner for running feature files, you have to edit build.gradle file.
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