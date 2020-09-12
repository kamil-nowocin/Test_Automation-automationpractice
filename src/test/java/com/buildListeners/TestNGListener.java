package com.buildListeners;

import com.DriverFactory;
import com.buildLogger.SlackLogger;
import com.buildSettings.ContextInjection;
import com.buildSettings.ExcelEnvironment;
import com.buildSettings.MessageBuilder;
import com.buildSettings.TestEnvironment;
import io.cucumber.java.Scenario;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGListener extends ExcelEnvironment implements ITestListener {

    public static List<String> passedTests = new ArrayList<>();
    public static List<String> failedTests = new ArrayList<>();

    private final SlackLogger slackLogger = new SlackLogger();
    private final MessageBuilder messageBuilder = new MessageBuilder();
    private final TestEnvironment testEnvironment = new TestEnvironment();
    private final ExcelEnvironment excelEnvironment = new ExcelEnvironment();

    /**
     * For TestNG tests
     */
    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        deleteOldLogs();
        messageBuilder.messageStartSuite(iTestContext);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        messageBuilder.messageEndSuite(iTestContext);
        testEnvironment.allureWriteExecutors();
        testEnvironment.allureWriteProperties();
        ContextInjection.passedTestsAmount = passedTests.size();
        ContextInjection.failedTestsAmount = failedTests.size();
        slackLogger.sendTestExecutionStatusToSlack(iTestContext);
        suiteResultsCleaner();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        messageBuilder.messageStartTest(iTestResult);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        messageBuilder.messageSuccessTest();
        excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), "PASSED", EXCEL_TC_RESULT_COLUMN);
        excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), MessageBuilder.getTestDescription(iTestResult), EXCEL_TC_NAME_COLUMN);
        passedTests.add(MessageBuilder.getTestDescription(iTestResult));
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        messageBuilder.messageFailTest();
        excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), "FAILED", EXCEL_TC_RESULT_COLUMN);
        excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), MessageBuilder.getTestDescription(iTestResult), EXCEL_TC_NAME_COLUMN);
        failedTests.add(MessageBuilder.getTestDescription(iTestResult));
        logger.error(String.valueOf(iTestResult.getThrowable()));
        if (DriverFactory.getDriver() != null) {
            allureSaveScreenshotPNG();
        }
        allureSaveTextLog(iTestResult);
    }

    /**
     * For Cucumber tests
     **/
    public void onScenarioStart(Scenario scenario) {
        messageBuilder.messageStartScenario(scenario);
    }

    public void onScenarioFinish(Scenario scenario) throws IOException {
        messageBuilder.messageFinishScenario(scenario);
        setExcelCucumberTestsResult(scenario);
    }

    private void setExcelCucumberTestsResult(Scenario scenario) throws IOException {
        excelEnvironment.setExcelSheet(TEST_DATA_EXCEL_SHEET_NAME);
        excelEnvironment.saveTestResultsXLSX(CUCUMBER_RESULT_COUNTER_ROW);
        if (scenario.isFailed()) {
            excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), "FAILED", EXCEL_TC_RESULT_COLUMN);
            localSaveScreenshotPNG(scenario);
            allureSaveScreenshotPNG();
            allureSaveTextLogCucumber(scenario);
        } else {
            excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), "PASSED", EXCEL_TC_RESULT_COLUMN);
        }
        excelEnvironment.setCellData(excelEnvironment.getExcelRowNumber(), scenario.getName(), EXCEL_TC_NAME_COLUMN);
        CUCUMBER_RESULT_COUNTER_ROW++;
    }
}