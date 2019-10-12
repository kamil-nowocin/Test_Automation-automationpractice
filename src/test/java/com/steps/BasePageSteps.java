package com.steps;

import com.DriverFactory;
import com.pages.base.BasePage;
import cucumber.api.java.en.Given;
import org.testng.Assert;

public class BasePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);

    @Given("I open home page")
    public void iOpenHomePage() {
        basePage.openHomePage();
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
    }

    @Given("I can see Automationpractice.com website")
    public void iCanSeeAutomationpracticeComWebsite() {
        Assert.assertTrue(basePage.isPageReady());
    }
}