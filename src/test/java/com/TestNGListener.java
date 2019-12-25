package com;

import io.qameta.allure.Attachment;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestNGListener extends FrameworkEnvironment implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 31) + "STARTING TEST SUITE " + iTestContext.getStartDate() + StringUtils.repeat("=", 31));
        logger.info(StringUtils.repeat("#", 110));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info(StringUtils.repeat("#", 110));
        logger.info(StringUtils.repeat("=", 45) + " END OF TEST SUITE " + StringUtils.repeat("=", 45));
        logger.info(StringUtils.repeat("#", 110));
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        //TODO
        //logger.info("THIS WONT BE PRINTED BEFORE 1ST SCENARIO IDK WHY, FOR ANOTHER SCENARIOS WORKS GREAT");
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        //TODO
        //logger.info("THIS METHOD WILL EXECUTE WHEN TEST WILL PASS");
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        //TODO
        //logger.info("THIS METHOD WILL EXECUTE WHEN TEST WILL FAIL");
    }

    @Attachment(type = "text/plain")
    public static String allureSaveTextLog() {
        return "Text log isn't implemented yet! \nSorry...";
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    public static byte[] allureSaveScreenshotPNG() throws IOException {
        return ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
        //THIS DOESNT LOOK GREAT IN ALLURE - HOVERER IT CAN MAKE FULL SCREENSHOT OF WEBSITE
//        BufferedImage screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverFactory.driver).getImage();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ImageIO.write(screenshot, "PNG", byteArrayOutputStream);
//        byteArrayOutputStream.flush();
//        byte[] ss = byteArrayOutputStream.toByteArray();
//        byteArrayOutputStream.close();
//        return ss;
    }
}