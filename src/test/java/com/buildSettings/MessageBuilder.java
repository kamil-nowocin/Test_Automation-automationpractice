package com.buildSettings;

import com.DriverFactory;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class MessageBuilder extends TestEnvironment {

    public static String getXmlSuiteName(ITestContext iTestContext) {
        return iTestContext.getCurrentXmlTest().getSuite().getName();
    }

    public static String getXmlTestName(ITestContext iTestContext) {
        return iTestContext.getName();
    }

    public static String getTestDescription(ITestResult iTestResult) {
        return iTestResult.getMethod().getDescription().toUpperCase();
    }

    public void messageStartSuite(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 31) + "STARTING TEST SUITE " + iTestContext.getStartDate() + StringUtils.repeat("=", 30));
        logger.info(StringUtils.repeat("#", 110));
    }

    public void messageEndSuite(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 32) + "END OF TEST SUITE " + iTestContext.getEndDate() + StringUtils.repeat("=", 31));
        logger.info(StringUtils.repeat("#", 110));
    }

    public void messageStartTest(ITestResult iTestResult) {
        logger.info(StringUtils.repeat("=", 48) + " TEST STARTED " + StringUtils.repeat("=", 48));
        logger.info(ANSI_BLUE + "TEST NAME: " + getTestDescription(iTestResult) + ANSI_RESET);
        logger.info(String.format("Chosen executor: \"%S\"", DriverFactory.getTestsExecutor()));
    }

    public void messageSuccessTest() {
        logger.info(StringUtils.repeat("=", 37) + " TEST FINISHED WITH " + ANSI_GREEN + "SUCCESS STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
    }

    public void messageFailTest() {
        logger.info(StringUtils.repeat("=", 38) + " TEST FINISHED WITH " + ANSI_RED + "FAILED STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
    }

    public void messageStartScenario(Scenario scenario) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 46) + " BEFORE SCENARIO " + StringUtils.repeat("=", 47));
        logger.info(StringUtils.repeat("#", 110));
        logger.info(ANSI_BLUE + "SCENARIO NAME: " + scenario.getName().toUpperCase() + ANSI_RESET);
        logger.info(String.format("Chosen executor: \"%S\"", DriverFactory.getTestsExecutor()));
    }

    public void messageFinishScenario(Scenario scenario) {
        String status = (scenario.isFailed() ? ANSI_RED + "FAILED STATUS " + ANSI_RESET : ANSI_GREEN + "SUCCESS STATUS " + ANSI_RESET);
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 36) + " SCENARIO FINISHED WITH " + status + StringUtils.repeat("=", 35));
        logger.info(StringUtils.repeat("#", 110));
        System.out.println();
    }
}