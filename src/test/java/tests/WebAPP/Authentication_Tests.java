package tests.WebAPP;

import com.buildListeners.TestNGListener;
import com.buildSettings.ContextInjection;
import com.buildSettings.ExcelEnvironment;
import com.steps.AuthenticationPageSteps;
import com.steps.MainPageSteps;
import com.steps.RegistrationPageSteps;
import com.steps.hooks.WEB_Hooks;
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
@Listeners({TestNGListener.class})
public class Authentication_Tests extends WEB_Hooks {

    @Issue("TAP-0001")
    @TmsLink("STORY-111")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-111]/[1] As a user I can log into automationpractice.com using registered email \"thor.odinson@example.com\" & password \"12345\"")
    @Test(description = "[US-111]/[1] I can log into automationpractice.com using registered email \"thor.odinson@example.com\" & password \"12345\"",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();

        excelEnvironment.saveTestResultsXLSX(1);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iCanSeeLoginForm();
        authenticationPageSteps.iEnterLogin("thor.odinson@example.com");
        authenticationPageSteps.iEnterPassword("12345");
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT
        registrationPageSteps.iCanSeeWelcomeMessage();
    }

    @Issue("TAP-0002")
    @TmsLink("STORY-111")
    @Story("NEGATIVE FLOW")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Kamil Nowocin")
    @Description("[US-111]/[2] As a user I can't log into automationpractice.com using email \"thanos.ALars@example.com\" & password \"12345\"")
    @Test(description = "[US-111]/[2] I can't log into automationpractice.com using email \"thanos.ALars@example.com\" & password \"12345\"",
            priority = 0)
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();

        excelEnvironment.saveTestResultsXLSX(2);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iCanSeeLoginForm();
        authenticationPageSteps.iEnterLogin("thanos.ALars@example.com");
        authenticationPageSteps.iEnterPassword("12345");
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        authenticationPageSteps.iCanSeeWarningMessageWithInclude("Authentication failed");
    }

    @Issue("TAP-0003")
    @TmsLink("STORY-111")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-111]/[2] As a user I can't log into automationpractice.com using email \"thor.odinson@example.com\" & password \"null\"")
    @Test(description = "[US-111]/[3] I can't log into automationpractice.com using email \"thor.odinson@example.com\" & password \"null\"",
            priority = 0)
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();

        excelEnvironment.saveTestResultsXLSX(3);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iCanSeeLoginForm();
        authenticationPageSteps.iEnterLogin("thor.odinson@example.com");
        authenticationPageSteps.iEnterPassword("");
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        authenticationPageSteps.iCanSeeWarningMessageWithInclude("Password is required");
    }

    @Issue("TAP-0004")
    @TmsLink("STORY-111")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-111]/[2] As a user I can't log into automationpractice.com using email \"null\" & password \"12345\"")
    @Test(description = "[US-111]/[4] I can't log into automationpractice.com using email \"null\" & password \"12345\"",
            priority = 0)
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final AuthenticationPageSteps authenticationPageSteps = new AuthenticationPageSteps();

        excelEnvironment.saveTestResultsXLSX(4);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        authenticationPageSteps.iCanSeeLoginForm();
        authenticationPageSteps.iEnterLogin("");
        authenticationPageSteps.iEnterPassword("12345");
        authenticationPageSteps.iClickOnSubmitButton();

        //ASSERT//
        authenticationPageSteps.iCanSeeWarningMessageWithInclude("An email address required");
    }
}