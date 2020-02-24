package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

    public static WebDriver driver;

    private String getBrowserName() {
        String getBrowser = System.getProperty("browser");
        if (getBrowser == null) {
            getBrowser = System.getenv("browser");
            if (getBrowser == null) {
                getBrowser = BROWSER;
            }
        }
        return getBrowser;
    }

    private String getHost() {
        String getHost = System.getProperty("selenium.host");
        if (getHost == null) {
            getHost = System.getenv("selenium.host");
            if (getHost == null) {
                getHost = HOST;
            }
        }
        return getHost;
    }

    protected RemoteWebDriver remoteWebDriver(DesiredCapabilities desiredCapabilities, String remoteWebDriverURL) {
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(new URL(remoteWebDriverURL), desiredCapabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to launch remote driver!", e);
        }
        return remoteDriver;
    }

    protected void startBrowser() {
        DesiredCapabilities desiredCapabilities = null;
        if (driver == null) {
            switch (getHost().toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "opera":
                    WebDriverManager.operadriver().arch64().version("2.45").setup();
                    OperaOptions operaOptions = new OperaOptions();
                    operaOptions.addArguments("");
                    driver = new OperaDriver(operaOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "browserstack":
                    desiredCapabilities = new DesiredCapabilities();
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
                    //https://automate.browserstack.com/dashboard/v2 <- GET USER_NAME AND ACCESS_TOKEN FROM
                    //https://www.browserstack.com/automate/capabilities <- GENERATE YOUR OWN CAPABILITIES
                    //https://USER_NAME:ACCESS_TOKEN@hub-cloud.browserstack.com/wd/hub <- HOST_URL (.travis.yml for more information)
                    driver = remoteWebDriver(desiredCapabilities, HOST_URL);
                    break;
                default:
                    throw new IllegalStateException("This browser isn't supported yet! Sorry...");
            }
            logger.info(String.format("Chosen executor: %S", getHost()));
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method!");
        }
    }

    protected void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}