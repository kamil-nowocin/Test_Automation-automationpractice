package com;

import com.github.javafaker.Faker;
import com.steps.Hooks;
import net.andreinc.mockneat.MockNeat;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class FrameworkEnvironment {

    protected static Logger logger = LoggerFactory.getLogger(Hooks.class);
    protected static Faker faker = new Faker();
    protected static MockNeat mockNeat = MockNeat.threadLocal();

    //BUNDLES//
    protected static final ResourceBundle resourceBundleInvalidEmails = ResourceBundle.getBundle("invalidEmails");
    protected static final ResourceBundle resourceBundleErrorMessages = ResourceBundle.getBundle("errorValidators");

    //DATA//
    protected static final int TIMEOUT = 15;
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001b[34m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String EXECUTOR = "GRADLE";
    protected static final String DEFAULT_BROWSER = "chrome";
    protected static final String HOME_URL = "http://automationpractice.com/index.php";
    protected static final String TODAY_DATE = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date());

    //MESSAGES//
    protected static final String PAGE_URL_DIDNT_CONTAIN = "Following page URL didn't contain this URL! ";
    protected static final String MESSAGE_DIDNT_CONTAIN = "Warning message didn't contain this phrase! ";
    protected static final String WELCOME_MESSAGE = "Welcome to your account. Here you can manage all of your personal information and orders. ";
    protected static final String PAGE_NOTLOADED = "Page wasn't ready to execute tests! ";
    protected static final String WRONG_RESULTS_NUMBER = "Results which have been found didn't match expected results! ";

    private static final String TRAVIS_BUILD_NUMBER = System.getProperty
            ("travis.buildNumber", "Build was made on localhost");
    private static final String TRAVIS_BUILD_WEB_URL = System.getProperty
            ("travis.buildURL", "Build was made on localhost");
    private static final String TRAVIS_BRANCH = System.getProperty
            ("travis.branch", "Build was made on localhost");
    private static final String BROWSER = System.getProperty
            ("browser", "Chrome");
    private static final String OS_NAME = System.getProperty
            ("travis.osName", "Build was made on localhost");
    private static final String JAVA_VERSION = System.getProperty
            ("travis.jdkVersion", "Build was made on localhost");

    static void allureWriteProperties() {
        Properties properties = new Properties();
        properties.setProperty("All tests were executed on:", HOME_URL);
        properties.setProperty("Travis build URL:", TRAVIS_BUILD_WEB_URL);
        properties.setProperty("Travis build Run:", TRAVIS_BUILD_NUMBER);
        properties.setProperty("Branch:", TRAVIS_BRANCH);
        properties.setProperty("Browser:", BROWSER);
        properties.setProperty("OS Name:", OS_NAME);
        properties.setProperty("JDK Version:", JAVA_VERSION);
        try {
            properties.store(new FileOutputStream("build/allure-results/environment.properties"), null);
        } catch (IOException e) {
            logger.error(String.valueOf(e));
        }
    }

    static void allureWriteExecutors() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", EXECUTOR);
        jsonObject.put("type", EXECUTOR);
        jsonObject.put("buildName", "Allure Report via Travis CI: " + TRAVIS_BUILD_NUMBER);
        jsonObject.put("buildUrl", TRAVIS_BUILD_WEB_URL);
        jsonObject.put("reportUrl", TRAVIS_BUILD_WEB_URL);
        try {
            FileWriter fileWriter = new FileWriter("build/allure-results/executor.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (IOException e) {
            logger.error(String.valueOf(e));
        }
    }
}