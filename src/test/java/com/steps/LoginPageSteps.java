package com.steps;

import com.DriverFactory;
import com.pages.LoginPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;

@Feature("LOGIN TESTS")
@Severity(SeverityLevel.CRITICAL)
public class LoginPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Step("I enter login {string}")
    @And("I enter login {string}")
    public void iEnterLogin(String email) {
        loginPage.emailInput.sendKeys(email);
    }

    @Step("I enter password {string}")
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @Step("I click on submit button")
    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        loginPage.signInButton.click();
    }

    @Step("I can see login form")
    @Then("I can see login form")
    public void iCanSeeLoginForm() {
        Assert.assertTrue(basePage.isDisplayed(10, loginPage.loginForm));
    }

    @Step("I can see warning message with include {string}")
    @Then("I can see warning message with include {string}")
    public void iCanSeeWarningMessageWithInclude(String warningMessage) {
        Assert.assertTrue(loginPage.errorValidator().contains(warningMessage), warningMessage);
    }
}