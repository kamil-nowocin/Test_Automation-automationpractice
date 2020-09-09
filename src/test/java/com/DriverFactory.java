package com;

import com.buildSettings.TestEnvironment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static String getTestsExecutor() {
        String getTestsExecutor = System.getProperty("tests.executor");
        if (getTestsExecutor == null) {
            getTestsExecutor = System.getenv("tests.executor");
            if (getTestsExecutor == null) {
                getTestsExecutor = DEFAULT_TESTS_EXECUTOR;
            }
        }
        return getTestsExecutor;
    }

    private String getRemoteBrowserName() {
        String getRemoteBrowserName = System.getProperty("remote.browser");
        if (getRemoteBrowserName == null) {
            getRemoteBrowserName = System.getenv("remote.browser");
            if (getRemoteBrowserName == null) {
                getRemoteBrowserName = DEFAULT_REMOTE_BROWSER;
            }
        }
        return getRemoteBrowserName;
    }

    private RemoteWebDriver remoteWebDriver(String remoteWebDriverURL, DesiredCapabilities desiredCapabilities) {
        try {
            driver = new RemoteWebDriver(new URL(remoteWebDriverURL), desiredCapabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to launch remote driver!", e);
        }
        return (RemoteWebDriver) driver;
    }

    protected void startBrowser() {
        displayWebDriverManagerBrowsersVersions(false);
        switch (getTestsExecutor().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                addDriver(driver = new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                addDriver(driver = new FirefoxDriver(firefoxOptions));
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                OperaOptions operaOptions = new OperaOptions();
                addDriver(driver = new OperaDriver(operaOptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                addDriver(driver = new EdgeDriver(edgeOptions));
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                addDriver(driver = new InternetExplorerDriver(internetExplorerOptions));
                break;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                addDriver(driver = new SafariDriver(safariOptions));
                break;
            case "grid":
                addDriver(driver = remoteWebDriver(SELENIUM_GRID_URL, getCapabilityForRemoteBrowser(getRemoteBrowserName().toLowerCase())));
                break;
            case "browserstack":
                DesiredCapabilities BrowserStackDesiredCapabilities = new DesiredCapabilities();
                if (getRemoteBrowserName().toLowerCase().equals("ie")) {
                    BrowserStackDesiredCapabilities.setCapability("browserName", "IE");
                    BrowserStackDesiredCapabilities.setCapability("browserVersion", "11.0");
                } else if (getRemoteBrowserName().toLowerCase().equals("edge")) {
                    BrowserStackDesiredCapabilities.setCapability("browserName", "Edge");
                    BrowserStackDesiredCapabilities.setCapability("browserVersion", "latest");
                } else if (getRemoteBrowserName().toLowerCase().equals("firefox")) {
                    BrowserStackDesiredCapabilities.setCapability("browser", "Firefox");
                    BrowserStackDesiredCapabilities.setCapability("browserVersion", "latest");
                } else if (getRemoteBrowserName().toLowerCase().equals("chrome")) {
                    BrowserStackDesiredCapabilities.setCapability("browserName", "Chrome");
                    BrowserStackDesiredCapabilities.setCapability("browserVersion", "latest");
                } else {
                    BrowserStackDesiredCapabilities.setCapability("browserName", DEFAULT_REMOTE_BROWSER);
                    BrowserStackDesiredCapabilities.setCapability("browserVersion", "latest");
                }
                HashMap<String, Object> BrowserStackOptions = new HashMap<>();
                BrowserStackOptions.put("os", "Windows");
                BrowserStackOptions.put("osVersion", "10");
                BrowserStackOptions.put("resolution", "1920x1080");
                BrowserStackOptions.put("projectName", "Automationpractice.com");
                BrowserStackOptions.put("local", "true");
                BrowserStackOptions.put("networkLogs", "true");
                BrowserStackOptions.put("seleniumVersion", "3.141.59");
                BrowserStackDesiredCapabilities.setCapability("bstack:options", BrowserStackOptions);
                //https://automate.browserstack.com/dashboard/v2 <- USER_NAME AND ACCESS_KEY
                //https://www.browserstack.com/automate/capabilities <- GENERATE YOUR OWN CAPABILITIES
                //-Dbrowserstack.hostURL=https://$USER_NAME:$ACCESS_KEY@hub-cloud.browserstack.com/wd/hub <- BROWSERSTACK_HOST_URL
                addDriver(driver = remoteWebDriver(BROWSERSTACK_HOST_URL, BrowserStackDesiredCapabilities));
                break;
            default:
                throw new IllegalStateException("This browser isn't supported yet! Sorry...");
        }
        //NOT THE BEST PRACTICE TO MIX IMPLICITLY WITH EXPLICITLY WAIT
        //getDriver().manage().timeouts().implicitlyWait(Timeouts.FIND_ELEMENT_TIMEOUT.value, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Timeouts.PAGE_LOAD_TIMEOUT.value, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(Timeouts.SCRIPT_TIMEOUT.value, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
    }

    public DesiredCapabilities getCapabilityForRemoteBrowser(String browserName) {
        DesiredCapabilities desiredCapabilities;
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setBrowserName("chrome");
                desiredCapabilities.setPlatform(Platform.MAC);
                return DesiredCapabilities.chrome();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setBrowserName("firefox");
                desiredCapabilities.setPlatform(Platform.MAC);
                return DesiredCapabilities.firefox();
            default:
                throw new IllegalStateException("This browser isn't supported yet. Sorry...");
        }
    }

    protected void destroyDriver() {
        for (WebDriver driver : storedDrivers) {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}