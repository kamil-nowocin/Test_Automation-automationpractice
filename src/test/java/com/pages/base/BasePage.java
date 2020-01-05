package com.pages.base;

import com.DriverFactory;
import com.FrameworkEnvironment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class BasePage extends FrameworkEnvironment {

    public final WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElementToBeClickable(int timeInSeconds, WebElement elementToClick) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        } catch (Exception e) {
            logger.error(String.format("Couldn't click on element: %s ", elementToClick));
        }
    }

    public void waitForElementToBeVisible(int timeInSeconds, WebElement elementToBeVisible) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
        } catch (Exception e) {
            logger.error(String.format("Element wasn't visible: %s!", elementToBeVisible));
        }
    }

    public boolean isDisplayed(int timeInSeconds, WebElement elementToBeDisplayed) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(elementToBeDisplayed));
            return elementToBeDisplayed.isDisplayed();
        } catch (Exception e) {
            logger.error(String.format("Couldn't display element: %s ", elementToBeDisplayed));
            return false;
        }
    }

    public void selectFromDropdownByIndex(int value, WebElement elementName) throws NoSuchElementException {
        try {
            Select dropdown = new Select(elementName);
            dropdown.selectByIndex(value);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", elementName));
        }
    }

    public void selectFromDropdownByText(String textValue, WebElement elementName) throws NoSuchElementException {
        try {
            Select dropdown = new Select(elementName);
            dropdown.selectByVisibleText(textValue);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", elementName));
        }
    }

    public void selectFromDropdownByValue(String textValue, WebElement elementName) throws NoSuchElementException {
        try {
            Select dropdown = new Select(elementName);
            dropdown.selectByValue(textValue);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", elementName));
        }
    }

    public int randomValue(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String randomString(int length) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
        return stringBuilder.toString();
    }

    public void scrollWebsiteToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public boolean isPageReady() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            logger.error(String.format("Page wasn't ready to execute tests: %s", driver.getCurrentUrl()));
            return false;
        }
        return true;
    }

    public String errorValidator(WebElement element) {
        waitForElementToBeVisible(10, element);
        return element.getText();
    }

    public String getRandomElementFromResourceBundleList(String resourceBundle) {
        List<String> resourceBundleData = Arrays.asList((resourceBundle.split("\\s*, ")));
        Random random = new Random();
        return resourceBundleData.get(random.nextInt(resourceBundleData.size()));
    }

    //This method is just for testing purpose, it shouldn't be used in development environment//
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}