package com;

import com.steps.Hooks;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FrameworkEnvironment {

    protected static Logger logger = LoggerFactory.getLogger(Hooks.class);

    final int TIMEOUT = 15;
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001b[34m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String EXECUTOR = "GRADLE";
    protected static final String DEFAULT_BROWSER = "chrome";
    protected static final String HOME_URL = "http://automationpractice.com/index.php";
    protected final String todayDate = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date());

    private static String TRAVIS_BUILD_NUMBER = System.getProperty
            ("travis.buildNumber", "Build was made on localhost");
    private static String TRAVIS_BUILD_WEB_URL = System.getProperty
            ("travis.buildURL", "Build was made on localhost");
    private static String TRAVIS_BRANCH = System.getProperty
            ("travis.branch", "Master");
    private static String BROWSER = System.getProperty
            ("browser", "Chrome");

    static void allureWriteProperties() {
        Properties properties = new Properties();
        properties.setProperty("All tests were executed on:", HOME_URL);
        properties.setProperty("Travis build URL:", TRAVIS_BUILD_WEB_URL);
        properties.setProperty("Travis build Run:", TRAVIS_BUILD_NUMBER);
        properties.setProperty("Branch:", TRAVIS_BRANCH);
        properties.setProperty("Browser:", BROWSER);
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