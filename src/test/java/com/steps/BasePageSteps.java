package com.steps;

import com.DriverFactory;
import com.pages.base.BasePage;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/
@Listeners({Hooks.class})
public class BasePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);

    @Step("I open home page")
    @Given("I open home page")
    public void iOpenHomePage() throws Throwable {
        //ACT//
        basePage.openHomePage();
        //ASSERT//
        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL, _21VOID);
    }

    @Step("I can see Automationpractice.com website")
    @Given("I can see Automationpractice.com website")
    public void iCanSeeAutomationpracticeComWebsite() throws Throwable {
        Assert.assertTrue(basePage.isPageReady(), PAGE_ERROR);
    }
}