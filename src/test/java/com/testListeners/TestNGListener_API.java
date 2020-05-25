package com.testListeners;

import com.testSettings.ExcelEnvironment;
import com.testSettings.TestEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGListener_API extends TestEnvironment implements ITestListener {

    /**
     * For TestNG tests
     */
    public static String getTestName(ITestResult iTestResult) {
        return iTestResult.getMethod().getDescription().toUpperCase();
    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 29)
                + "STARTING API TEST SUITE " + iTestContext.getStartDate() + StringUtils.repeat("=", 28));
        logger.info(StringUtils.repeat("#", 110));
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 32)
                + "END OF TEST SUITE " + iTestContext.getEndDate() + StringUtils.repeat("=", 31));
        logger.info(StringUtils.repeat("#", 110));
        TestEnvironment.allureWriteExecutors();
        TestEnvironment.allureWriteProperties();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        logger.info(StringUtils.repeat("=", 48) + " TEST STARTED "
                + StringUtils.repeat("=", 48));
        logger.info(ANSI_BLUE + "TEST NAME: " + getTestName(iTestResult) + ANSI_RESET);
        logger.info("Doing some magic behind the application... Wish you could see it ;)");
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        logger.info(StringUtils.repeat("=", 37) + " TEST FINISHED WITH "
                + ANSI_GREEN + "SUCCESS STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), "PASSED", EXCEL_TC_RESULT_COLUMN);
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), getTestName(iTestResult), EXCEL_TC_NAME_COLUMN);
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        logger.info(StringUtils.repeat("=", 38) + " TEST FINISHED WITH "
                + ANSI_RED + "FAILED STATUS " + ANSI_RESET + StringUtils.repeat("=", 38));
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), "FAILED", EXCEL_TC_RESULT_COLUMN);
        ExcelEnvironment.setCellData(ExcelEnvironment.getExcelRowNumber(), getTestName(iTestResult), EXCEL_TC_NAME_COLUMN);
        allureSaveTextLog(iTestResult);
    }
}