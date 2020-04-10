package com.listeners;

import com.FrameworkEnvironment;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGRetry extends FrameworkEnvironment implements IRetryAnalyzer {

    private int retryStatus = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            int retryLimit = 2;
            if (retryStatus < retryLimit) {
                retryStatus++;
                iTestResult.setStatus(ITestResult.FAILURE);
                logger.info(String.format(ANSI_RED + "TEST WILL BE REPEATED (%d/2): %S" + ANSI_RESET, retryStatus,
                        iTestResult.getMethod().getDescription()));
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}