package com.steps;

import com.google.inject.Inject;
import com.pages.base.MainPage;
import com.testSettings.ContextInjection;
import com.testSettings.DriverFactory;
import com.testSettings.TestCommons;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class MainPageSteps extends DriverFactory {

    private final ContextInjection contextInjection;

    private final TestCommons testCommons = new TestCommons();
    private final MainPage mainPage = new MainPage();
    private final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
    private final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();

    @Inject
    public MainPageSteps(ContextInjection contextInjection) {
        this.contextInjection = contextInjection;
    }

    @Step("I open home page")
    @Given("I open home page")
    public void iOpenHomePage() throws Throwable {
        //ARRANGE//
        final String expectedPageURL = "http://automationpractice.com/index.php";

        //ACT//
        DriverFactory.getDriver().get(HOME_URL);

        //ASSERT//
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL, _21VOID);
    }

    @Step("I can see automationpractice.com website")
    @Given("I can see automationpractice.com website")
    public void iCanSeeAutomationpracticeComWebsite() throws Throwable {
        //ARRANGE//
        final boolean isPageReadyToExecuteTests;

        //ACT//
        isPageReadyToExecuteTests = testCommons.isPageReady();
        logger.info(String.format("Page ready: \"%S\"", isPageReadyToExecuteTests));

        //ASSERT//
        Assert.assertTrue(isPageReadyToExecuteTests, PAGE_ERROR);
    }

    @Step("I am logged as customer *{0}* using *{1}* password")
    @When("I am logged as customer {string} using {string} password")
    public void iAmLoggedAsCustomerUsingPassword(String email, String password) throws Throwable {
        //ARRANGE//
        final String defaultUserName = contextInjection.defaultCustomerUserName;

        //ACT//
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iEnterLogin(email);
        authenticationPageSteps.iEnterPassword(password);
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        Assert.assertEquals(mainPage.currentLoggedUserName.getText().toLowerCase(), defaultUserName.toLowerCase(), VALUE_ERROR);
    }

    @Step("I am on MyAccount details page")
    @Given("I am on MyAccount details page")
    public void iAmOnMyAccountDetailsPage() throws Throwable {
        registrationPageSteps.iCanSeeWelcomeMessage();
    }
}