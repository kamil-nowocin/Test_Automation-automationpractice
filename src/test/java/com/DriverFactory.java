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
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory extends FrameworkEnvironment {

    protected static WebDriver driver;

    private static String getBrowserName() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = DEFAULT_BROWSER;
            }
        }
        return browser;
    }

    protected void startBrowser() {
        switch (getBrowserName().toLowerCase()) {
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
            default:
                throw new IllegalStateException("This browser isn't supported yet. Sorry...");
        }
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    protected static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}