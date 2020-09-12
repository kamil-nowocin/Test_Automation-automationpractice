package com.buildSettings;

import com.DriverFactory;
import com.buildListeners.TestNGListener;
import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import net.andreinc.mockneat.MockNeat;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestEnvironment {

    protected static Faker faker = new Faker(Locale.US);
    protected static MockNeat mockNeat = MockNeat.secure();
    protected static Logger logger = LoggerFactory.getLogger(Logger.class);
    protected static final String TODAY_DATE = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date());
    protected static final DecimalFormat DOLLAR_DECIMAL_FORMAT = new DecimalFormat("$#0.00", new DecimalFormatSymbols(Locale.US));

    //BUNDLES//
    protected static final ResourceBundle RESOURCE_BUNDLE_INVALID_EMAILS = ResourceBundle.getBundle("invalidEmails");
    protected static final ResourceBundle RESOURCE_BUNDLE_ERROR_MESSAGES = ResourceBundle.getBundle("errorValidators");

    //GENERAL SETTINGS//
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001b[34m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String EXECUTOR = "GRADLE";
    public static final String HOME_URL = "http://automationpractice.com/";

    //ENVIRONMENT PROPERTIES//
    protected static final String TRAVIS_BUILD_NUMBER = System.getProperty
            ("travis.buildNumber", "Build was made on localhost");
    protected static final String TRAVIS_BUILD_WEB_URL = System.getProperty
            ("travis.buildURL", "Build was made on localhost");
    protected static final String TRAVIS_BRANCH = System.getProperty
            ("travis.branch", "Build was made on localhost");
    protected static final String OS_NAME = System.getProperty
            ("travis.osName", "Build was made on localhost");//DON'T KNOW HOW TO SET OS TYPE WHEN BUILD RUNS ON LOCAL MACHINE OR ONLINE
    protected static final String JAVA_VERSION = System.getProperty
            ("travis.jdkVersion", "Build was made on localhost");
    protected static final String SLACK_TOKEN = System.getProperty
            ("travis.slack", "");
    protected static final String DEFAULT_REMOTE_BROWSER = System.getProperty
            ("remote.browser", "chrome");
    protected static final String DEFAULT_TESTS_EXECUTOR = System.getProperty
            ("tests.executor", "chrome");
    protected static final String SELENIUM_GRID_URL = System.getProperty
            ("selenium.gridURL", "http://localhost:4444/wd/hub");
    protected static final String BROWSERSTACK_HOST_URL = System.getProperty
            ("browserstack.hostURL", "https://localhost:3000");

    //ENVIRONMENT METHODS//
    public static String getCurrentPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    protected static long getUnixTime() {
        return Instant.now().getEpochSecond();
    }

    public void allureWriteProperties() {
        Properties properties = new Properties();
        properties.setProperty("All tests were executed on:", HOME_URL);
        properties.setProperty("Travis build URL:", TRAVIS_BUILD_WEB_URL);
        properties.setProperty("Travis build Run:", TRAVIS_BUILD_NUMBER);
        properties.setProperty("Branch:", TRAVIS_BRANCH);
        properties.setProperty("Browser:", DEFAULT_TESTS_EXECUTOR);
        properties.setProperty("OS Name:", OS_NAME);
        properties.setProperty("JDK Version:", JAVA_VERSION);
        try {
            properties.store(new FileOutputStream("build/allure-results/environment.properties"), null);
        } catch (IOException e) {
            logger.error("Failed to create properties file!", e);
        }
    }

    public void allureWriteExecutors() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", EXECUTOR);
        jsonObject.put("type", EXECUTOR);
        jsonObject.put("buildName", String.format("Allure Report via Travis CI: %s", TRAVIS_BUILD_NUMBER));
        jsonObject.put("reportUrl", TRAVIS_BUILD_WEB_URL);
        try {
            FileWriter fileWriter = new FileWriter("build/allure-results/executor.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (IOException e) {
            logger.error("Failed to create json object!", e);
        }
    }

    @Attachment(value = "TestNG test FAIL logs", type = "text/plain")
    protected String allureSaveTextLog(ITestResult iTestResult) {
        return logBuilder(MessageBuilder.getTestDescription(iTestResult));
    }

    @Attachment(value = "Cucumber scenario FAIL logs", type = "text/plain")
    protected String allureSaveTextLogCucumber(Scenario scenario) {
        return logBuilder(scenario.getName().toUpperCase());
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    protected byte[] allureSaveScreenshotPNG() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    protected void localSaveScreenshotPNG(Scenario scenario) throws IOException {
        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "SCREENSHOT");
        File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(getCurrentPath()
                + File.separator
                + "screenshots"
                + File.separator
                + scenario.getName()
                + "-"
                + TODAY_DATE
                + ".png"));
    }

    protected String logBuilder(String fileName) {
        String path = getCurrentPath()
                + File.separator
                + "logs"
                + File.separator;
        path += fileName + ".log";
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            logger.error("Failed to attach .log file!", e);
        }
        return contentBuilder.toString();
    }

    protected void deleteOldLogs() {
        try {
            FileUtils.deleteDirectory(new File(getCurrentPath()
                    + File.separator
                    + "logs"));
        } catch (IOException e) {
            logger.error("Failed to delete logs directory!", e);
        }
    }

    protected void suiteResultsCleaner() {
        ContextInjection.passedTestsAmount = 0;
        ContextInjection.failedTestsAmount = 0;
        TestNGListener.passedTests.clear();
        TestNGListener.failedTests.clear();
    }

    protected enum Timeouts {
        SCRIPT_TIMEOUT(15),
        PAGE_LOAD_TIMEOUT(30),
        CLICK_TIMEOUT(15),
        ATTRIBUTE_TIMEOUT(15),
        VISIBLE_TIMEOUT(15);

        public final int value;

        Timeouts(int value) {
            this.value = value;
        }
    }

    protected void displayWebDriverManagerBrowsersVersions(Boolean showBrowserVersions) {
        if (showBrowserVersions) {
            logger.info(String.format("ChromeDriver available versions: %s", WebDriverManager.chromedriver().getDriverVersions()));
            logger.info(String.format("GeckoDriver available versions: %s", WebDriverManager.firefoxdriver().getDriverVersions()));
            logger.info(String.format("OperaDriver available versions: %s ", WebDriverManager.operadriver().getDriverVersions()));
            logger.info(String.format("EdgeDriver available versions: %s", WebDriverManager.edgedriver().getDriverVersions()));
            logger.info(String.format("IEDriver available versions: %s", WebDriverManager.iedriver().getDriverVersions()));
        }
    }
}