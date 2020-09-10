package com.steps.hooks;

import com.DriverFactory;
import com.buildSettings.ExcelEnvironment;
import com.buildSettings.MessageBuilder;
import org.slf4j.MDC;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class API_Hooks extends DriverFactory implements ITestListener {

    private final ExcelEnvironment excelEnvironment = new ExcelEnvironment();

    @BeforeTest(alwaysRun = true, description = "Setting up Excel File")
    public void dataSetup() {
        excelEnvironment.setExcelSheet(ExcelEnvironment.TEST_DATA_EXCEL_SHEET_NAME);
    }

    @BeforeMethod(alwaysRun = true, description = "Setting up Test Class")
    public void beforeTest(ITestResult iTestResult) {
        MDC.put("testid", MessageBuilder.getTestDescription(iTestResult));
    }

    @AfterMethod(alwaysRun = true, description = "Teardown Test Class")
    public void afterTest() {
        MDC.remove("testid");
    }
}