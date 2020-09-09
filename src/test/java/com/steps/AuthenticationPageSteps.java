package com.steps;

import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.AuthenticationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class AuthenticationPageSteps extends TestEnvironment {

    private final TestCommons testCommons = new TestCommons();
    private final AuthenticationPage authenticationPage = new AuthenticationPage().get();

    @Step("I can see login form")
    @Given("I can see login form")
    public void iCanSeeLoginForm() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(authenticationPage.registeredPane),
                String.format(ContextInjection.VIEW_ERROR, "Login form"));
    }

    @Step("I enter login *{0}*")
    @And("I enter login {string}")
    public void iEnterLogin(String login) throws Throwable {
        //ACT//
        testCommons.customSendKeys(authenticationPage.registeredEmailInput, login);
        logger.info(String.format("User login: \"%S\"", login));

        //ASSERT//
        Assert.assertEquals(authenticationPage.registeredEmailInput.getAttribute("value").toLowerCase(),
                login.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I enter password *{0}*")
    @And("I enter password {string}")
    public void iEnterPassword(String password) throws Throwable {
        //ACT//
        testCommons.customSendKeys(authenticationPage.registeredPasswordInput, password);
        logger.info(String.format("User password: \"%S\"", password));

        //ASSERT//
        Assert.assertEquals(authenticationPage.registeredPasswordInput.getAttribute("value").toLowerCase(),
                password.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on Submit button")
    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws Throwable {
        testCommons.customClick(authenticationPage.registeredSignInButton);
    }


    @Step("I can see warning message with include *{0}*")
    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) throws Throwable {
        Assert.assertTrue(authenticationPage.registeredLoginError.getText().toLowerCase().contains(warningMessage.toLowerCase()),
                String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, warningMessage.toUpperCase()));
    }
}