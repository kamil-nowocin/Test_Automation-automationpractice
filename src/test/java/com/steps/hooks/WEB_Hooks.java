package com.steps.hooks;

import com.DriverFactory;
import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.buildSettings.MessageBuilder;
import com.buildSettings.TestCommons;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.MDC;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class WEB_Hooks extends DriverFactory implements ITestListener {

    private final TestCommons testCommons = new TestCommons();
    private final TestNGListener testNGListener = new TestNGListener();
    private final ExcelEnvironment excelEnvironment = new ExcelEnvironment();

    /**
     * For TestNG -> @Test annotation
     **/
    @BeforeTest(alwaysRun = true, description = "Setting up Excel File")
    public void dataSetup() {
        excelEnvironment.setExcelSheet(ExcelEnvironment.TEST_DATA_EXCEL_SHEET_NAME);
    }

    @BeforeMethod(alwaysRun = true, description = "Setting up Test Class")
    public void beforeTest(ITestResult iTestResult) throws IOException {
        MDC.put("testid", MessageBuilder.getTestDescription(iTestResult));
        startBrowser();
        testCommons.networkThrottling(false);
    }

    @AfterMethod(alwaysRun = true, description = "Teardown Test Class")
    public void afterTest() {
        MDC.remove("testid");
        getDriver().close();
    }

    @AfterSuite(alwaysRun = true, description = "Teardown Test Suite")
    public void afterSuite() {
        destroyDriver();
    }

    /**
     * For Cucumber -> Feature file
     **/
    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        MDC.put("testid", scenario.getName().toUpperCase());
        testNGListener.onScenarioStart(scenario);
        startBrowser();
        testCommons.networkThrottling(false);
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        testNGListener.onScenarioFinish(scenario);
        MDC.remove("testid");
        destroyDriver();
    }
}