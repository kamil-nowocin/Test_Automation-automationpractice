package com.steps;

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
    private final AuthenticationPage authenticationPage = new AuthenticationPage();

    @Step("I can see login form")
    @Given("I can see login form")
    public void iCanSeeLoginForm() throws Throwable {
        Assert.assertTrue(testCommons.waitForElementToBeDisplayed(5, authenticationPage.registeredPane),
                String.format(VIEW_ERROR, "Login form"));
    }

    @Step("I enter login *{0}*")
    @And("I enter login {string}")
    public void iEnterLogin(String login) throws Throwable {
        //ACT//
        authenticationPage.registeredEmailInput.sendKeys(login);
        logger.info(String.format("User login: \"%S\"", login));

        //ASSERT//
        Assert.assertEquals(authenticationPage.registeredEmailInput.getAttribute("value").toLowerCase(),
                login.toLowerCase(), VALUE_ERROR);
    }

    @Step("I enter password *{0}*")
    @And("I enter password {string}")
    public void iEnterPassword(String password) throws Throwable {
        //ACT//
        authenticationPage.registeredPasswordInput.sendKeys(password);
        logger.info(String.format("User password: \"%S\"", password));

        //ASSERT//
        Assert.assertEquals(authenticationPage.registeredPasswordInput.getAttribute("value").toLowerCase(),
                password.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on Submit button")
    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws Throwable {
        authenticationPage.registeredSignInButton.click();
    }


    @Step("I can see warning message with include *{0}*")
    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) throws Throwable {
        Assert.assertTrue(testCommons.errorValidator(authenticationPage.registeredLoginError).toLowerCase().contains(warningMessage.toLowerCase()),
                String.format(MESSAGE_DIDNT_CONTAIN, warningMessage.toUpperCase()));
    }
}