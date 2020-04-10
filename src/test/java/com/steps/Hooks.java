package com.steps;

import com.DriverFactory;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_API;
import com.listeners.TestNGListener_WEB;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.MDC;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

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
    @BeforeTest(description = "Setting up Excel File")
    public void dataSetup() {
        ExcelEnvironment.setExcelSheet(ExcelEnvironment.testDataExcelSheetName);
    }

    @BeforeMethod(description = "Setting up Test Class")
    public void beforeTest(ITestResult iTestResult) {
        MDC.put("testid", TestNGListener_WEB.getTestName(iTestResult));
        MDC.put("testid", TestNGListener_API.getTestName(iTestResult));
        startBrowser();
    }

    @AfterMethod(description = "Teardown Test Class")
    public void afterTest() {
        MDC.remove("testid");
        removeDriver();
    }

    /**
     * For Cucumber -> Feature file
     **/
    @Before
    public void beforeScenario(Scenario scenario) {
        MDC.put("testid", scenario.getName().toUpperCase());
        TestNGListener_WEB.onScenarioStart(scenario);
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        TestNGListener_WEB.onScenarioFinish(scenario);
        if (scenario.isFailed()) {
            localSaveScreenshotPNG(scenario);
            allureSaveScreenshotPNG();
            allureSaveTextLogCucumber(scenario);
        }
        MDC.remove("testid");
        removeDriver();
    }
}