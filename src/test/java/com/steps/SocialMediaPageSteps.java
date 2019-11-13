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

    @Step("I scroll the website until I can see {string} logo")
    @When("I scroll the website until I can see {string} logo")
    public void iScrollTheWebsiteUntilICanSeeLogo(String logoName) {
        switch (logoName) {
            case "Facebook":
                basePage.scrollWebsiteToElement(socialMediaPage.facebookButton);
                break;
            case "Twitter":
                basePage.scrollWebsiteToElement(socialMediaPage.twitterButton);
                break;
            case "YouTube":
                basePage.scrollWebsiteToElement(socialMediaPage.youtubeButton);
                break;
            case "Google+":
                basePage.scrollWebsiteToElement(socialMediaPage.googleButton);
                break;
        }
    }

    @Step("I click on {string} logo button")
    @And("I click on {string} logo button")
    public void iClickOnLogoButton(String logoName) {
        switch (logoName) {
            case "Facebook":
                socialMediaPage.facebookButton.click();
                break;
            case "Twitter":
                socialMediaPage.twitterButton.click();
                break;
            case "YouTube":
                socialMediaPage.youtubeButton.click();
                break;
            case "Google+":
                socialMediaPage.googleButton.click();
                break;
        }
    }

    @Step("I am redirected to Selenium {string} profile")
    @Then("I am redirected to Selenium {string} profile")
    public void iAmRedirectedToSeleniumProfile(String logoName) {
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        switch (logoName) {
            case "Facebook":
                String facebook = "facebook.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(facebook), PAGE_URL_DIDNT_CONTAIN + facebook);
                break;
            case "Twitter":
                String twitter = "twitter.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(twitter), PAGE_URL_DIDNT_CONTAIN + twitter);
                break;
            case "YouTube":
                String yt = "youtube.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(yt), PAGE_URL_DIDNT_CONTAIN + yt);
                break;
            case "Google+":
                String google = "google.com";
                Assert.assertTrue(driver.getCurrentUrl().contains(google), PAGE_URL_DIDNT_CONTAIN + google);
                break;
        }
    }
}