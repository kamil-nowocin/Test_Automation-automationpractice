package com.pages.base;

import com.DriverFactory;
import com.FrameworkEnvironment;
import org.openqa.selenium.JavascriptExecutor;
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

    public BasePage() {
        //PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), TIMEOUT), this);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void waitForElementToBeClickable(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            logger.error(String.format("Couldn't click on element: %s", webElement));
        }
    }

    public void waitForElementToBeVisible(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            logger.error(String.format("Element wasn't visible: %s!", webElement));
        }
    }

    public void waitForElementToHaveAttribute(int timeInSeconds, WebElement webElement, String attribute, String value) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));
        } catch (Exception e) {
            logger.error(String.format("Could't find attribute: %S on web element: %S", attribute, webElement));
        }
    }

    public boolean isDisplayed(int timeInSeconds, WebElement webElement) throws
            NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            logger.error(String.format("Couldn't display element: %s ", webElement));
            return false;
        }
    }

    public void selectFromDropdownByIndex(int value, WebElement webElement) throws
            NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByIndex(value);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", webElement));
        }
    }

    public void selectFromDropdownByText(String textValue, WebElement webElement) throws
            NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByVisibleText(textValue);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", webElement));
        }
    }

    public void selectFromDropdownByValue(String textValue, WebElement webElement) throws
            NoSuchElementException {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByValue(textValue);
        } catch (Exception e) {
            logger.error(String.format("Couldn't select element: %s ", webElement));
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
        waitForElementToBeVisible(TIMEOUT, webElement);
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