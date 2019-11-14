package com.steps;

import com.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Hooks extends DriverFactory implements ITestListener {

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.debug(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "================================================" + ANSI_RESET + "BEFORE SCENARIO"
                + ANSI_BLUE + "===============================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.debug("SCENARIO NAME: " + scenario.getName().toUpperCase());
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        logger.debug(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        String status = (scenario.isFailed() ? ANSI_RED + "FAILED" + ANSI_RESET : ANSI_GREEN + "SUCCESS" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "====================================" + ANSI_RESET + "SCENARIO FINISHED WITH " +
                status + " STATUS" + ANSI_BLUE + "=====================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "============================================" + ANSI_RESET + "CLEANUP AFTER SCENARIO"
                + ANSI_BLUE + "============================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        System.out.println("\n");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
            FileUtils.copyFile(scrFile, new File(currentPath + "/screenshots/" + scenario.getName()
                    + "-" + TODAY_DATE + ".png"));
            allureSaveTextLog();
            allureSaveScreenshotPNG();
        }
        destroyDriver();
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    private byte[] allureSaveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(type = "text/plain")
    private static String allureSaveTextLog() {
        return "Text log isn't implemented yet! \nSorry...";
    }
}