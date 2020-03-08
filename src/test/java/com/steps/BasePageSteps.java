package com.steps;

import com.DriverFactory;
import com.pages.base.BasePage;
import com.pages.base.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class BasePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage();
    private MainPage mainPage = new MainPage();
    private AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();
    private RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

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

    @Step("I am logged as customer {string} using {string} password")
    @When("I am logged as customer {string} using {string} password")
    public void iAmLoggedAsCustomerUsingPassword(String email, String password) throws Throwable {
        //ARRANGE//
        final String defaultUserName = "Thor Odinson";

        //ACT//
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iEnterLogin(email);
        authenticationPageSteps.iEnterPassword(password);
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        Assert.assertEquals(mainPage.loggedUser.getText().toUpperCase(), defaultUserName.toUpperCase(), VALUE_ERROR);
    }

    @Step("I am on MyAccount details page")
    @Given("I am on MyAccount details page")
    public void iAmOnMyAccountDetailsPage() {
        //ARRANGE//
        //ACT//
        //ASSERT//
        //TODO
    }
}