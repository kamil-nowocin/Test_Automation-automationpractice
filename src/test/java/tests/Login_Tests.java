package tests;

import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.BasePageSteps;
import com.steps.Hooks;
import com.steps.LoginPageSteps;
import com.steps.RegistrationPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("LOGIN TESTS")
@Listeners({TestNGListener_WEB.class})
public class Login_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I can log into automationpractice.com using registered email thor.odinson@example.com")
    @Description("As a user I would like to log in automationpractice.com ->\n" +
            "I can log into automationpractice.com using registered email thor.odinson@example.com")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-009")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(9);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        final LoginPageSteps loginPageSteps = new LoginPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        loginPageSteps.iCanSeeLoginForm();
        loginPageSteps.iEnterLogin("thor.odinson@example.com");
        loginPageSteps.iEnterPassword("12345");
        loginPageSteps.iClickOnSubmitButton();

        //ASSERT
        registrationPageSteps.iCanSeeWelcomeMessage();
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I can't log into automationpractice.com using unregistered email thanos.ALars@example.com and wrong password")
    @Description("As a user I would like to log in automationpractice.com ->\n" +
            "I can't log into automationpractice.com using email thanos.ALars@example.com and wrong password")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-010")
    @Story("NEGATIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(10);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        final LoginPageSteps loginPageSteps = new LoginPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        loginPageSteps.iCanSeeLoginForm();
        loginPageSteps.iEnterLogin("thanos.ALars@example.com");
        loginPageSteps.iEnterPassword("12345");
        loginPageSteps.iClickOnSubmitButton();

        //ASSERT//
        loginPageSteps.iCanSeeWarningMessageWithInclude("Authentication failed");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I can't log into automationpractice.com using registered email thor.odinson@example.com without password")
    @Description("As a user I would like to log in automationpractice.com ->\n" +
            "I can't log into automationpractice.com using email thor.odinson@example.com without password")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-011")
    @Story("NEGATIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(11);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        final LoginPageSteps loginPageSteps = new LoginPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        loginPageSteps.iCanSeeLoginForm();
        loginPageSteps.iEnterLogin("thor.odinson@example.com");
        loginPageSteps.iEnterPassword("");
        loginPageSteps.iClickOnSubmitButton();

        //ASSERT//
        loginPageSteps.iCanSeeWarningMessageWithInclude("Password is required");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I can't log into automationpractice.com using email \"null\" with password")
    @Description("As a user I would like to log in automationpractice.com ->\n" +
            "I can't log into automationpractice.com using email \"null\" with password")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-012")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(12);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        final LoginPageSteps loginPageSteps = new LoginPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        loginPageSteps.iCanSeeLoginForm();
        loginPageSteps.iEnterLogin("");
        loginPageSteps.iEnterPassword("12345");
        loginPageSteps.iClickOnSubmitButton();

        //ASSERT//
        loginPageSteps.iCanSeeWarningMessageWithInclude("An email address required");
    }
}