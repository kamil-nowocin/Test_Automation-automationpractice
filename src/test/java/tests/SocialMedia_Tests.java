package tests;

import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.BasePageSteps;
import com.steps.Hooks;
import com.steps.SocialMediaPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Regression Tests")
@Feature("SOCIAL MEDIA TESTS")
@Listeners({TestNGListener_WEB.class})
public class SocialMedia_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(description = "I click on social media FACEBOOK logo",
            priority = 0)
    @Description("As a user I would like to be redirected to social media pages from automationpractice.com ->\n" +
            "I click on social media FACEBOOK logo")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-039")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(39);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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
    @Issue("TAP-040")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(40);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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
    @Issue("TAP-041")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(41);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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
    @Issue("TAP-042")
    @Story("POSITIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(42);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final SocialMediaPageSteps mediaPageSteps = new SocialMediaPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        mediaPageSteps.iScrollTheWebsiteUntilICanSeeLogo("google");
        mediaPageSteps.iClickOnLogoButton("google");

        //ASSERT//
        mediaPageSteps.iAmRedirectedToSeleniumProfile("google");
    }
}