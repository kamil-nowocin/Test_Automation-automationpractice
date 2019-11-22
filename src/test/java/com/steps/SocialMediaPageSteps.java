package com.steps;

import com.DriverFactory;
import com.pages.SocialMediaPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.ArrayList;

@Listeners({Hooks.class})
public class SocialMediaPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private SocialMediaPage socialMediaPage = new SocialMediaPage(driver);

    @Step("I scroll the website until I can see {0} logo")
    @When("I scroll the website until I can see {string} logo")
    public void iScrollTheWebsiteUntilICanSeeLogo(String logoName) {
        switch (logoName.toLowerCase()) {
            case "facebook":
                basePage.scrollWebsiteToElement(socialMediaPage.facebookButton);
                break;
            case "twitter":
                basePage.scrollWebsiteToElement(socialMediaPage.twitterButton);
                break;
            case "youtube":
                basePage.scrollWebsiteToElement(socialMediaPage.youtubeButton);
                break;
            case "google+":
                basePage.scrollWebsiteToElement(socialMediaPage.googleButton);
                break;
            default:
                throw new IllegalStateException(INPUT_ERROR);
        }
    }

    @Step("I click on {0} logo button")
    @And("I click on {string} logo button")
    public void iClickOnLogoButton(String logoName) {
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
            case "google+":
                socialMediaPage.googleButton.click();
                break;
            default:
                throw new IllegalStateException(INPUT_ERROR);
        }
    }

    @Step("I am redirected to Selenium {0} profile")
    @Then("I am redirected to Selenium {string} profile")
    public void iAmRedirectedToSeleniumProfile(String logoName) {
        //ARRANGE//
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());

        //ACT//
        driver.switchTo().window(browserTabs.get(1));
        switch (logoName.toLowerCase()) {
            case "facebook":
                String facebook = "facebook.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(facebook), PAGE_URL_DIDNT_CONTAIN + facebook);
                break;
            case "twitter":
                String twitter = "twitter.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(twitter), PAGE_URL_DIDNT_CONTAIN + twitter);
                break;
            case "youtube":
                String yt = "youtube.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(yt), PAGE_URL_DIDNT_CONTAIN + yt);
                break;
            case "google+":
                String google = "google.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(google), PAGE_URL_DIDNT_CONTAIN + google);
                break;
            default:
                throw new IllegalStateException(INPUT_ERROR);
        }
    }
}