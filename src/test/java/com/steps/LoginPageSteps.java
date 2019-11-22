package com.steps;

import com.DriverFactory;
import com.pages.LoginPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/
@Listeners({Hooks.class})
public class LoginPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Step("I enter login {0}")
    @And("I enter login {string}")
    public void iEnterLogin(String email) throws Throwable {
        loginPage.emailInput.sendKeys(email);
    }

    @Step("I enter password {0}")
    @And("I enter password {string}")
    public void iEnterPassword(String password) throws Throwable {
        loginPage.passwordInput.sendKeys(password);
    }

    @Step("I click on Submit button")
    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws Throwable {
        loginPage.signInButton.click();
    }

    @Step("I can see login form")
    @Then("I can see login form")
    public void iCanSeeLoginForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, loginPage.loginForm), VIEW_ERROR);
    }

    @Step("I can see warning message with include {0}")
    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) throws Throwable {
        Assert.assertTrue(basePage.errorValidator(loginPage.loginError).contains(warningMessage),
                MESSAGE_DIDNT_CONTAIN + warningMessage);
    }
}