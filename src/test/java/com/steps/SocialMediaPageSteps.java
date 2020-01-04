package com.steps;

import com.DriverFactory;
import com.pages.SocialMediaPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class SocialMediaPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage();
    private SocialMediaPage socialMediaPage = new SocialMediaPage();

    @Step("I scroll the website until I can see {0} logo")
    @When("I scroll the website until I can see {string} logo")
    public void iScrollTheWebsiteUntilICanSeeLogo(String logoName) throws Throwable {
        //ACT//
        switch (logoName.toLowerCase()) {
            case "facebook":
                basePage.scrollWebsiteToElement(socialMediaPage.facebookButton);
                Assert.assertTrue(basePage.isDisplayed(5, socialMediaPage.facebookButton),
                        String.format(VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "twitter":
                basePage.scrollWebsiteToElement(socialMediaPage.twitterButton);
                Assert.assertTrue(basePage.isDisplayed(5, socialMediaPage.twitterButton),
                        String.format(VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "youtube":
                basePage.scrollWebsiteToElement(socialMediaPage.youtubeButton);
                Assert.assertTrue(basePage.isDisplayed(5, socialMediaPage.youtubeButton),
                        String.format(VIEW_ERROR, logoName.toUpperCase()));
                break;
            case "google":
                basePage.scrollWebsiteToElement(socialMediaPage.googleButton);
                Assert.assertTrue(basePage.isDisplayed(5, socialMediaPage.googleButton),
                        String.format(VIEW_ERROR, logoName.toUpperCase()));
                break;
            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, logoName.toUpperCase()));
        }
    }

    @Step("I click on {0} logo button")
    @And("I click on {string} logo button")
    public void iClickOnLogoButton(String logoName) throws Throwable {
        //ACT//
        logger.info(String.format("Chosen social media platform: %S", logoName));
        switch (logoName.toLowerCase()) {
            case "facebook":
                socialMediaPage.facebookButton.click();
                break;
            case "twitter":
                socialMediaPage.twitterButton.click();
                break;
            case "youtube":
                socialMediaPage.youtubeButton.click();
                break;
            case "google":
                socialMediaPage.googleButton.click();
                break;
            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, logoName.toUpperCase()));
        }
    }

    @Step("I am redirected to Selenium {0} profile")
    @Then("I am redirected to Selenium {string} profile")
    public void iAmRedirectedToSeleniumProfile(String logoName) throws Throwable {
        //ARRANGE//
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());

        //ACT//
        driver.switchTo().window(browserTabs.get(1));
        logger.info(String.format("URL was: %S, URL expected: %S", driver.getCurrentUrl(), logoName + ".com"));

        //ASSERT//
        Assert.assertTrue(driver.getCurrentUrl().contains(logoName.toLowerCase() + ".com"),
                String.format(PAGE_URL_DIDNT_CONTAIN, logoName.toUpperCase()));
    }
}