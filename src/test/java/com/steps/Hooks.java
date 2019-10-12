package com.steps;

import com.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static final String todayDate = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date());

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001b[34m";

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
    @Attachment(type = "image/png")
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
                    + "-" + todayDate + ".png"));
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        destroyDriver();
    }
}