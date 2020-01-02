package com.steps;

import com.DriverFactory;
import com.listeners.TestNGListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class Hooks extends DriverFactory implements ITestListener {

    /**
     * For TestNG -> @Test annotation
     **/
    @BeforeMethod
    public void beforeTest() {
        startBrowser();
    }

    @AfterMethod
    public void afterTest() {
        destroyDriver();
    }

    /**
     * For Cucumber -> Feature file
     **/
    @Before
    public void beforeScenario(Scenario scenario) {
        TestNGListener.onScenarioStart(scenario);
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        TestNGListener.onScenarioFinish(scenario);
        if (scenario.isFailed()) {
            localSaveScreenshotPNG(scenario);
            allureSaveScreenshotPNG();
            allureSaveTextLog();

        }
        destroyDriver();
    }
}