package com.steps;

import com.DriverFactory;
import com.TestNGListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/
public class Hooks extends DriverFactory implements ITestListener {

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.info(ANSI_BLUE + "================================================" + ANSI_RESET + "BEFORE SCENARIO"
                + ANSI_BLUE + "===============================================" + ANSI_RESET);
        logger.info(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.info("SCENARIO NAME: " + scenario.getName().toUpperCase());
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        logger.info(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        String status = (scenario.isFailed() ? ANSI_RED + "FAILED" + ANSI_RESET : ANSI_GREEN + "SUCCESS" + ANSI_RESET);
        logger.info(ANSI_BLUE + "====================================" + ANSI_RESET + "SCENARIO FINISHED WITH " +
                status + " STATUS" + ANSI_BLUE + "=====================================" + ANSI_RESET);
        logger.info(ANSI_BLUE + "============================================" + ANSI_RESET + "CLEANUP AFTER SCENARIO"
                + ANSI_BLUE + "============================================" + ANSI_RESET);
        logger.info(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        System.out.println("\n");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            FileUtils.copyFile(scrFile, new File(currentPath + "/screenshots/" + scenario.getName()
                    + "-" + TODAY_DATE + ".png"));
            TestNGListener.allureSaveTextLog();
            TestNGListener.allureSaveScreenshotPNG();
        }
        destroyDriver();
    }
  
    @Attachment(type = "text/plain")
    private static String allureSaveTextLog() {
        return "Text log isn't implemented yet! \nSorry...";
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    private byte[] allureSaveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}