package com;

import com.github.javafaker.Faker;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import cucumber.api.Scenario;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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

public class FrameworkEnvironment {

    protected static Logger logger = LoggerFactory.getLogger(Hooks.class);
    protected static Faker faker = new Faker(new Locale("en-US"));
    protected static MockNeat mockNeat = MockNeat.threadLocal();

    //BUNDLES//
    protected static final ResourceBundle resourceBundleInvalidEmails = ResourceBundle.getBundle("invalidEmails");
    protected static final ResourceBundle resourceBundleErrorMessages = ResourceBundle.getBundle("errorValidators");

    //DYNAMIC DATA//
    protected final String tempEmail = mockNeat.emails().val();

    //STATIC DATA//
    protected static final int TIMEOUT = 15;
    protected static final int EXCEL_TC_NAME_COLUMN = 0;
    protected static final int EXCEL_TC_RESULT_COLUMN = 4;
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001b[34m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String EXECUTOR = "GRADLE";
    protected static final String HOME_URL = "http://automationpractice.com/index.php";
    protected static final String TODAY_DATE = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date());

    //MESSAGES//
    protected static final String WELCOME_MESSAGE =
            "Welcome to your account. Here you can manage all of your personal information and orders.";
    protected static final String PAGE_URL_DIDNT_CONTAIN =
            "Following page URL didn't contain this web address %S.com!";
    protected static final String MESSAGE_DIDNT_CONTAIN =
            "Warning message didn't contain %S!";
    protected static final String PAGE_ERROR =
            "Page wasn't ready to execute tests!";
    protected static final String RESULTS_ERROR =
            "Results which have been found %S, didn't match expected number of results %s!";
    protected static final String SEARCH_ERROR =
            "Results which have been found didn't match expected item names!";
    protected static final String SORTING_ERROR =
            "Results which have been found didn't match expected %S sorting results!";
    protected static final String VIEW_ERROR =
            "Element wasn't displayed %S!";
    protected static final String INPUT_ERROR =
            "Invalid input type! %S is not supported!";
    protected static final String VALUE_ERROR =
            "Value didn't match expected value!";
    protected static final String _21VOID =
            "Upssss, something went really bad! Even Michael Scofield couldn't have predicted that error! :)";

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
            ("travis.jdkVersion", "Build was made on localhost");//DOESN'T WORK, IDK WHY
    protected static final String BROWSER = System.getProperty
            ("browser", "Chrome");
    protected static final String HOST = System.getProperty
            ("selenium.host", "Chrome");
    protected static final String HOST_URL = System.getProperty
            ("selenium.hostURL", "https://localhost:3000");

    public static String getCurrentPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    protected static void allureWriteProperties() {
        Properties properties = new Properties();
        properties.setProperty("All tests were executed on:", HOME_URL);
        properties.setProperty("Travis build URL:", TRAVIS_BUILD_WEB_URL);
        properties.setProperty("Travis build Run:", TRAVIS_BUILD_NUMBER);
        properties.setProperty("Branch:", TRAVIS_BRANCH);
        properties.setProperty("Browser:", HOST);
        properties.setProperty("OS Name:", OS_NAME);
        properties.setProperty("JDK Version:", JAVA_VERSION);
        try {
            properties.store(new FileOutputStream("build/allure-results/environment.properties"), null);
        } catch (IOException e) {
            logger.error("Failed to create properties file!", e);
        }
    }

    protected static void allureWriteExecutors() {
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
        return logBuilder(TestNGListener_WEB.getTestName(iTestResult));
    }

    @Attachment(value = "Cucumber scenario FAIL logs", type = "text/plain")
    protected String allureSaveTextLogCucumber(Scenario scenario) {
        return logBuilder(scenario.toString());
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    protected byte[] allureSaveScreenshotPNG() {
        return ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
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
            logger.error("Failed to attach .logs object!", e);
        }
        return contentBuilder.toString();
    }

    protected void localSaveScreenshotPNG(Scenario scenario) throws IOException {
        byte[] screenshot = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        File scrFile = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(getCurrentPath()
                + File.separator
                + "screenshots"
                + File.separator
                + scenario.getName()
                + "-"
                + TODAY_DATE
                + ".png"));
    }

    protected void deleteOldLogs() {
        try {
            Files.walk(Paths.get(getCurrentPath()
                    + File.separator
                    + "logs"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            logger.error("Failed to delete logs files!", e);
        }
    }
}