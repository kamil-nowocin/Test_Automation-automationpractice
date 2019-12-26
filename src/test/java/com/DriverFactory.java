package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class DriverFactory extends FrameworkEnvironment {

    protected static WebDriver driver;

    private static String getBrowserName() {
        String getBrowser = System.getProperty("browser");
        if (getBrowser == null) {
            getBrowser = System.getenv("browser");
            if (getBrowser == null) {
                getBrowser = DEFAULT_BROWSER;
            }
        }
        return getBrowser;
    }

    private static String getHost() {
        String getHost = System.getProperty("selenium.host");
        if (getHost == null) {
            getHost = System.getenv("selenium.host");
            if (getHost == null) {
                getHost = HOST;
            }
        }
        return getHost;
    }

    protected void startBrowser() {
        if (driver == null) {
            switch (getHost().toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("");
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().arch64().version("2.45").setup();
                    OperaOptions operaOptions = new OperaOptions();
                    operaOptions.addArguments("");
                    driver = new OperaDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                case "browserstack":
                    //https://www.browserstack.com/automate/capabilities <- generate your own capabilities
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability("os", "Windows");
                    desiredCapabilities.setCapability("os_version", "10");
                    desiredCapabilities.setCapability("resolution", "1920x1080");
                    desiredCapabilities.setCapability("build", "Automationpractice.com");
                    desiredCapabilities.setCapability("project", "Automationpractice.com");
                    desiredCapabilities.setCapability("browserstack.timezone", "Europe/Warsaw");
                    if (getBrowserName().toLowerCase().equals("ie")) {
                        desiredCapabilities.setCapability("browser", "IE");
                        desiredCapabilities.setCapability("browser_version", "11.0");
                    }
                    if (getBrowserName().toLowerCase().equals("firefox")) {
                        desiredCapabilities.setCapability("browser", "Firefox");
                        desiredCapabilities.setCapability("browser_version", "70.0");
                    } else {
                        desiredCapabilities.setCapability("browser", "Chrome");
                        desiredCapabilities.setCapability("browser_version", "78.0");
                    }
                    driver = remoteWebDriver(desiredCapabilities);
                    break;
                default:
                    throw new IllegalStateException("This browser isn't supported yet. Sorry...");
            }
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    private RemoteWebDriver remoteWebDriver(DesiredCapabilities desiredCapabilities) {
        //GET USER_NAME AND ACCESS_KEY FROM https://automate.browserstack.com/dashboard/v2
        //HOST_URL = https://USER_NAME:ACCESS_KEY@hub-cloud.browserstack.com/wd/hub
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(new URL(HOST_URL), desiredCapabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to launch remote driver!", e);
        }
        return remoteDriver;
    }

    protected static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}