package com.buildSettings;

import com.DriverFactory;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestCommons extends TestEnvironment {

    /**
     * WAIT METHODS
     **/
    public void waitForElementToBeClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.CLICK_TIMEOUT.value);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (ElementNotInteractableException e) {
            logger.error(String.format("Couldn't click on element \"%S\"!", webElement));
        }
    }

    public void waitForElementToHaveAttribute(WebElement webElement, String attribute, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.ATTRIBUTE_TIMEOUT.value);
            wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't find attribute \"%S\" on element \"%S\"!", attribute, webElement));
        }
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.VISIBLE_TIMEOUT.value);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (ElementNotVisibleException e) {
            logger.error(String.format("Couldn't display element \"%S\"!", webElement));
        }
    }

    public boolean isElementVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.VISIBLE_TIMEOUT.value);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (ElementNotVisibleException e) {
            logger.error(String.format("Couldn't display element \"%S\"!", webElement));
            return false;
        }
    }

    /**
     * SELECT METHODS
     **/
    public void selectFromDropdownByIndex(int value, WebElement webElement) {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByIndex(value);
        } catch (ElementNotSelectableException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\"!", value, webElement));
        }
    }

    public void selectFromDropdownByText(String textValue, WebElement webElement) {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByVisibleText(textValue);
        } catch (ElementNotSelectableException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\"!", textValue, webElement));
        }
    }

    public void selectFromDropdownByValue(String textValue, WebElement webElement) {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByValue(textValue);
        } catch (ElementNotSelectableException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\"!", textValue, webElement));
        }
    }

    /**
     * RANDOM METHODS
     **/
    public int getRandomIntValue(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String getRandomStringValue(int length) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
        return stringBuilder.toString();
    }

    public String getRandomResourceBundleValue(String resourceBundle) {
        List<String> resourceBundleData = Arrays.asList((resourceBundle.split("\\s*, ")));
        Random random = new Random();
        return resourceBundleData.get(random.nextInt(resourceBundleData.size()));
    }

    /**
     * GENERAL METHODS
     **/
    public static boolean isPageReady() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.PAGE_LOAD_TIMEOUT.value);
            wait.until(webDriver ->
                    ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            logger.error(String.format("Page wasn't ready to execute tests: %s!", DriverFactory.getDriver().getCurrentUrl()));
            return false;
        }
        return true;
    }

    public void customClick(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        try {
            webElement.click();
        } catch (ElementNotInteractableException e) {
            logger.error(String.format("Couldn't click on element \"%S\"!", webElement), e);
        }
    }

    public void customSendKeys(WebElement webElement, String whatToSend) {
        waitForElementToBeVisible(webElement);
        try {
            webElement.sendKeys(whatToSend);
        } catch (ElementNotInteractableException e) {
            logger.error(String.format("Couldn't send \"%S\" on element \"%S\"!", whatToSend, webElement), e);
        }
    }

    public void networkThrottling(boolean enableThrottling) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (enableThrottling) {
            map.put("offline", true);
            map.put("latency", 10000);
            map.put("download_throughput", 0);
            map.put("upload_throughput", 0);
            CommandExecutor executor = ((ChromeDriver) DriverFactory.getDriver()).getCommandExecutor();
            executor.execute(new Command(((ChromeDriver) DriverFactory.getDriver()).getSessionId(), "setNetworkConditions",
                    ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map)))
            );
        }
    }

    public void scrollWebsiteToElement(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't scroll to element \"%S\"!", webElement), e);
        }
    }

    //Just for testing purpose, it shouldn't be used in development environment
    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}