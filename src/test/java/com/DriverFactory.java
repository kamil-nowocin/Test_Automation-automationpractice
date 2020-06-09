package com;

import com.buildSettings.TestEnvironment;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class DriverFactory extends TestEnvironment {

    protected WebDriver driver;
    private static final List<WebDriver> storedDrivers = new ArrayList<>();
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return drivers.get();
    }

    private void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    private String getRemoteBrowserName() {
        String getBrowser = System.getProperty("browser");
        if (getBrowser == null) {
            getBrowser = System.getenv("browser");
            if (getBrowser == null) {
                getBrowser = BROWSER;
            }
        }
        return getBrowser;
    }

    public static String getHost() {
        String getHost = System.getProperty("selenium.host");
        if (getHost == null) {
            getHost = System.getenv("selenium.host");
            if (getHost == null) {
                getHost = HOST;
            }
        }
        return getHost;
    }

    private RemoteWebDriver remoteWebDriver(DesiredCapabilities desiredCapabilities, String remoteWebDriverURL) {
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(new URL(remoteWebDriverURL), desiredCapabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to launch remote driver!", e);
        }
        return remoteDriver;
    }

    protected void startBrowser() {
        displayWebDriverManagerBrowsersVersions(false);
        DesiredCapabilities desiredCapabilities;
        switch (getHost().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                addDriver(driver = new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("");
                addDriver(driver = new FirefoxDriver(firefoxOptions));
                break;
            case "opera":
                WebDriverManager.operadriver().arch64().browserVersion("2.45").setup();
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("");
                addDriver(driver = new OperaDriver(operaOptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                addDriver(driver = new EdgeDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                addDriver(driver = new InternetExplorerDriver());
                break;
            case "safari":
                addDriver(driver = new SafariDriver());
                break;
            case "browserstack":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("os", "Windows");
                desiredCapabilities.setCapability("os_version", "10");
                desiredCapabilities.setCapability("resolution", "1920x1080");
                desiredCapabilities.setCapability("build", "Automationpractice.com");
                desiredCapabilities.setCapability("project", "Automationpractice.com");
                desiredCapabilities.setCapability("browserstack.timezone", "Europe/Warsaw");
                if (getRemoteBrowserName().toLowerCase().equals("ie")) {
                    desiredCapabilities.setCapability("browser", "IE");
                    desiredCapabilities.setCapability("browser_version", "11.0");
                }
                if (getRemoteBrowserName().toLowerCase().equals("firefox")) {
                    desiredCapabilities.setCapability("browser", "Firefox");
                    desiredCapabilities.setCapability("browser_version", "70.0");
                } else {
                    desiredCapabilities.setCapability("browser", "Chrome");
                    desiredCapabilities.setCapability("browser_version", "78.0");
                }
                //https://automate.browserstack.com/dashboard/v2 <- USER_NAME AND ACCESS_KEY
                //https://$USERNAME:$ACCESS_KEY@hub-cloud.browserstack.com/wd/hub <- HOST_URL
                //https://www.browserstack.com/automate/capabilities <- GENERATE YOUR OWN CAPABILITIES
                addDriver(driver = remoteWebDriver(desiredCapabilities, HOST_URL));
                break;
            default:
                throw new IllegalStateException("This browser isn't supported yet! Sorry...");
        }
        getDriver().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
    }

    protected void destroyDriver() {
        for (WebDriver driver : storedDrivers) {
            driver.quit();
        }
    }
}