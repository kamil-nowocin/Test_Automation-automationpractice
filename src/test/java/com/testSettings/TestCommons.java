package com.testSettings;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.*;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class TestCommons extends TestEnvironment {

    public void waitForElementToBeClickable(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't click on element \"%S\" !", webElement));
        }
    }

    public void waitForElementToBeVisible(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException e) {
            logger.error(String.format("Element wasn't visible \"%S\" !", webElement));
        }
    }

    public void waitForElementToHaveAttribute(int timeInSeconds, WebElement webElement, String attribute, String value) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));
        } catch (NotFoundException e) {
            logger.error(String.format("Could't find attribute \"%S\" on element \"%S\" !", attribute, webElement));
        }
    }

    public boolean waitForElementToBeDisplayed(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't display element \"%S\" !", webElement));
            return false;
        }
    }

    public static void networkThrottling(boolean enableThrottling) throws IOException {
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

    public void selectFromDropdownByIndex(int value, WebElement webElement) throws NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByIndex(value);
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\" !", value, webElement));
        }
    }

    public void selectFromDropdownByText(String textValue, WebElement webElement) throws NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByVisibleText(textValue);
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\" !", textValue, webElement));
        }
    }

    public void selectFromDropdownByValue(String textValue, WebElement webElement) throws NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByValue(textValue);
        } catch (NoSuchElementException e) {
            logger.error(String.format("Couldn't select \"%S\" from element \"%S\" !", textValue, webElement));
        }
    }

    public int randomIntValue(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String randomStringValue(int length) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
        return stringBuilder.toString();
    }

    public void scrollWebsiteToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public boolean isElementDisplayed(By selector) throws NoSuchElementException {
        try {
            DriverFactory.getDriver().findElement(selector);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPageReady() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), TIMEOUT);
            wait.until(webDriver ->
                    ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            logger.error(String.format("Page wasn't ready to execute tests: %s", DriverFactory.getDriver().getCurrentUrl()));
            return false;
        }
        return true;
    }

    public String errorValidator(WebElement webElement) {
        waitForElementToBeDisplayed(TIMEOUT, webElement);
        return webElement.getText();
    }

    public String getRandomElementFromResourceBundleList(String resourceBundle) {
        List<String> resourceBundleData = Arrays.asList((resourceBundle.split("\\s*, ")));
        Random random = new Random();
        return resourceBundleData.get(random.nextInt(resourceBundleData.size()));
    }

    //Just for testing purpose, it shouldn't be used in development environment
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}