package com.steps;

import com.DriverFactory;
import com.pages.base.BasePage;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class BasePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage();

    @Step("I open home page")
    @Given("I open home page")
    public void iOpenHomePage() throws Throwable {
        //ARRANGE//
        final String home_page = "http://automationpractice.com";

        //ACT//
        driver.get(home_page);

        //ASSERT//
        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL, _21VOID);
    }

    @Step("I can see automationpractice.com website")
    @Given("I can see automationpractice.com website")
    public void iCanSeeAutomationpracticeComWebsite() throws Throwable {
        //ARRANGE//
        final boolean isPageReadyToExecuteTests;

        //ACT//
        isPageReadyToExecuteTests = basePage.isPageReady();

        //ASSERT//
        Assert.assertTrue(isPageReadyToExecuteTests, PAGE_ERROR);
    }
}