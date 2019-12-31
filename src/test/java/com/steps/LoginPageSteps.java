package com.steps;

import com.FrameworkEnvironment;
import com.pages.LoginPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class LoginPageSteps extends FrameworkEnvironment {

    private BasePage basePage = new BasePage();
    private LoginPage loginPage = new LoginPage();

    @Step("I enter login {0}")
    @And("I enter login {string}")
    public void iEnterLogin(String login) throws Throwable {
        //ACT//
        loginPage.emailInput.sendKeys(login);
        logger.info(String.format("User login: %S", login));

        //ASSERT//
        Assert.assertEquals(loginPage.emailInput.getAttribute("value").toLowerCase(),
                login.toLowerCase(), VALUE_ERROR);
    }

    @Step("I enter password {0}")
    @And("I enter password {string}")
    public void iEnterPassword(String password) throws Throwable {
        //ACT//
        loginPage.passwordInput.sendKeys(password);
        logger.info(String.format("User password: %S", password));

        //ASSERT//
        Assert.assertEquals(loginPage.passwordInput.getAttribute("value").toLowerCase(),
                password.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on Submit button")
    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws Throwable {
        loginPage.signInButton.click();
    }

    @Step("I can see login form")
    @Then("I can see login form")
    public void iCanSeeLoginForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, loginPage.loginForm),
                String.format(VIEW_ERROR, "Login form"));
    }

    @Step("I can see warning message with include {0}")
    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) throws Throwable {
        Assert.assertTrue(basePage.errorValidator(loginPage.loginError).toLowerCase().contains(warningMessage.toLowerCase()),
                String.format(MESSAGE_DIDNT_CONTAIN, warningMessage.toUpperCase()));
    }
}