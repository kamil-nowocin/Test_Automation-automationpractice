package tests.WebAPP;

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

    @Issue("TAP-0041")
    @TmsLink("STORY-777")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.MINOR)
    @Description("[US-777]/[1] I click on social media \"Facebook\" logo")
    @Test(description = "[US-777]/[1] I click on social media \"Facebook\" logo",
            priority = 0)
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

    @Issue("TAP-0042")
    @TmsLink("STORY-777")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "[US-777]/[2] I click on social media \"Twitter\" logo",
            priority = 0)
    @Description("[US-777]/[2] I click on social media \"Twitter\" logo")
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

    @Issue("TAP-0043")
    @TmsLink("STORY-777")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "[US-777]/[3] I click on social media \"YouTube\" logo",
            priority = 0)
    @Description("[US-777]/[3] I click on social media \"YouTube\" logo")
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

    @Issue("TAP-0044")
    @TmsLink("STORY-777")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "[US-777]/[4] I click on social media \"Google+\" logo",
            priority = 0)
    @Description("[US-777]/[4] I click on social media \"Google+\" logo")
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