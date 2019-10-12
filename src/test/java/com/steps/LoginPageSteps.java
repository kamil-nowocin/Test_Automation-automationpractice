package com.steps;

import com.DriverFactory;
import com.pages.LoginPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class LoginPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @And("I enter login {string}")
    public void iEnterLogin(String email) {
        loginPage.emailInput.sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        loginPage.signInButton.click();
    }

    @Then("I can see login form")
    public void iCanSeeLoginForm() {
        Assert.assertTrue(basePage.isDisplayed(10, loginPage.loginForm));
    }

    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) {
        Assert.assertTrue(loginPage.errorValidator().contains(warningMessage), warningMessage);
    }
}