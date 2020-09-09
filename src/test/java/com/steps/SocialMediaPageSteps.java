package com.steps;

import com.DriverFactory;
import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.SocialMediaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class SocialMediaPageSteps extends TestEnvironment {

    private final TestCommons testCommons = new TestCommons();
    private final SocialMediaPage socialMediaPage = new SocialMediaPage().get();

    @Step("I scroll the website until I can see *{0}* logo")
    @When("I scroll the website until I can see {string} logo")
    public void iScrollTheWebsiteUntilICanSeeLogo(String logoName) throws Throwable {
        //ACT//
        switch (logoName.toLowerCase()) {
            case "facebook":
                testCommons.scrollWebsiteToElement(socialMediaPage.facebookButton);
                Assert.assertTrue(testCommons.isElementVisible(socialMediaPage.facebookButton),
                        String.format(ContextInjection.VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "twitter":
                testCommons.scrollWebsiteToElement(socialMediaPage.twitterButton);
                Assert.assertTrue(testCommons.isElementVisible(socialMediaPage.twitterButton),
                        String.format(ContextInjection.VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "youtube":
                testCommons.scrollWebsiteToElement(socialMediaPage.youtubeButton);
                Assert.assertTrue(testCommons.isElementVisible(socialMediaPage.youtubeButton),
                        String.format(ContextInjection.VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "google":
                testCommons.scrollWebsiteToElement(socialMediaPage.googleButton);
                Assert.assertTrue(testCommons.isElementVisible(socialMediaPage.googleButton),
                        String.format(ContextInjection.VIEW_ERROR, logoName.toUpperCase()));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, logoName.toUpperCase()));
        }
    }

    @Step("I click on *{0}* logo button")
    @And("I click on {string} logo button")
    public void iClickOnLogoButton(String logoName) throws Throwable {
        //ACT//
        switch (logoName.toLowerCase()) {
            case "facebook":
                testCommons.customClick(socialMediaPage.facebookButton);
                break;
            case "twitter":
                testCommons.customClick(socialMediaPage.twitterButton);
                break;
            case "youtube":
                testCommons.customClick(socialMediaPage.youtubeButton);
                break;
            case "google":
                testCommons.customClick(socialMediaPage.googleButton);
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, logoName.toUpperCase()));
        }
        logger.info(String.format("Chosen social media platform: \"%S\"", logoName));
    }

    @Step("I am redirected to Selenium *{0}* profile")
    @Then("I am redirected to Selenium {string} profile")
    public void iAmRedirectedToSeleniumProfile(String logoName) throws Throwable {
        //ARRANGE//
        List<String> browserTabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());

        //ACT//
        DriverFactory.getDriver().switchTo().window(browserTabs.get(1));
        logger.info(String.format("URL was: \"%S\" URL expected: \"%S\"", DriverFactory.getDriver().getCurrentUrl(), logoName + ".com"));

        //ASSERT//
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains(logoName.toLowerCase() + ".com"),
                String.format(ContextInjection.PAGE_URL_DIDNT_CONTAIN, logoName.toUpperCase()));
    }
}