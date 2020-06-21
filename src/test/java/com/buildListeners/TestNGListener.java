package com.buildListeners;

import com.buildLogger.SlackLogger;
import com.buildSettings.ContextInjection;
import com.buildSettings.ExcelEnvironment;
import com.buildSettings.MessageBuilder;
import com.buildSettings.TestEnvironment;
import io.cucumber.java.Scenario;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGListener extends TestEnvironment implements ITestListener {

    public static List<String> passedTests = new ArrayList<>();
    public static List<String> failedTests = new ArrayList<>();

    /**
     * For TestNG tests
     */
    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        deleteOldLogs();
        MessageBuilder.messageStartSuite(iTestContext);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        MessageBuilder.messageEndSuite(iTestContext);
        TestEnvironment.allureWriteExecutors();
        TestEnvironment.allureWriteProperties();
        ContextInjection.passedTestsAmount = passedTests.size();
        ContextInjection.failedTestsAmount = failedTests.size();
        SlackLogger.sendTestExecutionStatusToSlack(iTestContext);
        suiteResultsCleaner();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        MessageBuilder.messageStartTest(iTestResult);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        MessageBuilder.messageSuccessTest();
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), "PASSED", EXCEL_TC_RESULT_COLUMN);
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), MessageBuilder.getTestDescription(iTestResult), EXCEL_TC_NAME_COLUMN);
        passedTests.add(MessageBuilder.getTestDescription(iTestResult));
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        MessageBuilder.messageFailTest();
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), "FAILED", EXCEL_TC_RESULT_COLUMN);
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), MessageBuilder.getTestDescription(iTestResult), EXCEL_TC_NAME_COLUMN);
        failedTests.add(MessageBuilder.getTestDescription(iTestResult));
        logger.error(String.valueOf(iTestResult.getThrowable()));
        allureSaveScreenshotPNG();
        allureSaveTextLog(iTestResult);
    }

    /**
     * For Cucumber tests
     **/
    public static void onScenarioStart(Scenario scenario) {
        MessageBuilder.messageStartScenario(scenario);
    }

    public static void onScenarioFinish(Scenario scenario) {
        MessageBuilder.messageFinishScenario(scenario);
    }
}