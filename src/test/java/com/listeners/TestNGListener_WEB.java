package com.listeners;

import com.DriverFactory;
import com.FrameworkEnvironment;
import cucumber.api.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGListener_WEB extends FrameworkEnvironment implements ITestListener {

    /**
     * For TestNG tests
     */
    public static String getTestName(ITestResult iTestResult) {
        return iTestResult.getMethod().getDescription();
    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        deleteOldLogs();
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 31)
                + "STARTING TEST SUITE " + iTestContext.getStartDate() + StringUtils.repeat("=", 31));
        logger.info(StringUtils.repeat("#", 110));
        System.out.println();
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        System.out.println();
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 32)
                + "END OF TEST SUITE " + iTestContext.getEndDate() + StringUtils.repeat("=", 32));
        logger.info(StringUtils.repeat("#", 110));
        FrameworkEnvironment.allureWriteExecutors();
        FrameworkEnvironment.allureWriteProperties();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        logger.info(StringUtils.repeat("=", 48) + " TEST STARTED "
                + StringUtils.repeat("=", 48));
        logger.info(ANSI_BLUE + "TEST NAME: " + getTestName(iTestResult).toUpperCase() + ANSI_RESET);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        logger.info(String.format("Chosen executor: %S", DriverFactory.getHost()));
        logger.info(StringUtils.repeat("=", 37) + " TEST FINISHED WITH "
                + ANSI_GREEN + "SUCCESS STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        logger.info(String.format("Chosen executor: %S", DriverFactory.getHost()));
        logger.info(StringUtils.repeat("=", 38) + " TEST FINISHED WITH "
                + ANSI_RED + "FAILED STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
        allureSaveScreenshotPNG();
        allureSaveTextLog();
//        loginger(iTestResult);
    }

    /**
     * For Cucumber tests
     **/
    public static void onScenarioStart(Scenario scenario) {
        deleteOldLogs();
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 46)
                + " BEFORE SCENARIO " + StringUtils.repeat("=", 47));
        logger.info(StringUtils.repeat("#", 110));
        logger.info(ANSI_BLUE + "SCENARIO NAME: " + scenario.getName().toUpperCase() + ANSI_RESET);
        System.out.println();
    }

    public static void onScenarioFinish(Scenario scenario) {
        logger.info(String.format("Chosen executor: %S", DriverFactory.getHost()));
        System.out.println();
        String status = (scenario.isFailed() ? ANSI_RED + "FAILED STATUS " + ANSI_RESET : ANSI_GREEN + "SUCCESS STATUS " + ANSI_RESET);
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 36)
                + " SCENARIO FINISHED WITH " + status + StringUtils.repeat("=", 35));
        logger.info(StringUtils.repeat("#", 110));
    }
}