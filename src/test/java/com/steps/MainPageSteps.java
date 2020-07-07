package com.steps;

import com.DriverFactory;
import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class MainPageSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();
    private final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

    @Step("I open home page")
    @Given("I open home page")
    public void iOpenHomePage() throws Throwable {
        //ARRANGE//
        final String expectedPageURL = "http://automationpractice.com/index.php";

        //ACT//
        DriverFactory.getDriver().get(HOME_URL);

        //ASSERT//
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL, ContextInjection._21VOID);
    }

    @Step("I can see automationpractice.com website")
    @Given("I can see automationpractice.com website")
    public void iCanSeeAutomationpracticeComWebsite() throws Throwable {
        //ARRANGE//
        final boolean isPageReadyToExecuteTests;

        //ACT//
        isPageReadyToExecuteTests = TestCommons.isPageReady();
        logger.info(String.format("Page ready: \"%S\"", isPageReadyToExecuteTests));

        //ASSERT//
        Assert.assertTrue(isPageReadyToExecuteTests, ContextInjection.PAGE_ERROR);
    }

    @Step("I am logged as customer *{0}* using *{1}* password")
    @When("I am logged as customer {string} using {string} password")
    public void iAmLoggedAsCustomerUsingPassword(String email, String password) throws Throwable {
        //ARRANGE//
        final String defaultUserName = ContextInjection.DEFAULT_CUSTOMER_USER_NAME;

        //ACT//
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iEnterLogin(email);
        authenticationPageSteps.iEnterPassword(password);
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        Assert.assertEquals(mainPage.currentLoggedUserName.getText().toLowerCase(), defaultUserName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I am on MyAccount details page")
    @Given("I am on MyAccount details page")
    public void iAmOnMyAccountDetailsPage() throws Throwable {
        registrationPageSteps.iCanSeeWelcomeMessage();
    }
}