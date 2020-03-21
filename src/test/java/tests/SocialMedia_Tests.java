package tests;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import com.steps.SocialMediaPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("SOCIAL MEDIA TESTS")
@Listeners({TestNGListener_WEB.class})
public class SocialMedia_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(description = "I click on social media FACEBOOK logo",
            priority = 0)
    @Description("As a user I would like to be redirected to social media pages from automationpractice.com ->\n" +
            "I click on social media FACEBOOK logo")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-0041")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(41);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mediaPageSteps.iScrollTheWebsiteUntilICanSeeLogo("facebook");
        mediaPageSteps.iClickOnLogoButton("facebook");

        //ASSERT//
        mediaPageSteps.iAmRedirectedToSeleniumProfile("facebook");
    }

    @Owner("Kamil Nowocin")
    @Test(description = "I click on social media TWITTER logo",
            priority = 0)
    @Description("As a user I would like to be redirected to social media pages from automationpractice.com ->\n" +
            "I click on social media TWITTER logo")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-0042")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(42);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mediaPageSteps.iScrollTheWebsiteUntilICanSeeLogo("twitter");
        mediaPageSteps.iClickOnLogoButton("twitter");

        //ASSERT//
        mediaPageSteps.iAmRedirectedToSeleniumProfile("twitter");
    }

    @Owner("Kamil Nowocin")
    @Test(description = "I click on social media YOUTUBE logo",
            priority = 0)
    @Description("As a user I would like to be redirected to social media pages from automationpractice.com ->\n" +
            "I click on social media YOUTUBE logo")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-0043")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(43);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mediaPageSteps.iScrollTheWebsiteUntilICanSeeLogo("youtube");
        mediaPageSteps.iClickOnLogoButton("youtube");

        //ASSERT//
        mediaPageSteps.iAmRedirectedToSeleniumProfile("youtube");
    }

    @Owner("Kamil Nowocin")
    @Test(description = "I click on social media GOOGLE+ logo",
            priority = 0)
    @Description("As a user I would like to be redirected to social media pages from automationpractice.com ->\n" +
            "I click on social media GOOGLE+ logo")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-0044")
    @Story("POSITIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(44);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mediaPageSteps.iScrollTheWebsiteUntilICanSeeLogo("google");
        mediaPageSteps.iClickOnLogoButton("google");

        //ASSERT//
        mediaPageSteps.iAmRedirectedToSeleniumProfile("google");
    }
}