package com.steps;

import com.DriverFactory;
import com.pages.SocialMediaPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class SocialMediaPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private SocialMediaPage socialMediaPage = new SocialMediaPage(driver);

    private static final String message = "You weren't redirected to: ";

    @When("I scroll the website until I can see my Facebook logo")
    public void iScrollTheWebsiteUntilICanSeeMyFacebookLogo() {
        basePage.scrollWebsiteToElement(socialMediaPage.facebookButton);
    }

    @And("I click on Facebook logo button")
    public void iClickOnFacebookLogoButton() {
        socialMediaPage.facebookButton.click();
    }

    @Then("I am redirected to Selenium FanPage on Facebook")
    public void iAmRedirectedToSeleniumFanPageOnFacebook() {
        //ARRANGE
        String redirectedPage = "facebook.com";

        //ACT
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        //ASSERT
        Assert.assertTrue(driver.getCurrentUrl().contains(redirectedPage), message);
    }

    @When("I scroll the website until I can see Twitter logo")
    public void iScrollTheWebsiteUntilICanSeeTwitterLogo() {
        basePage.scrollWebsiteToElement(socialMediaPage.twitterButton);
    }

    @And("I click on Twitter logo button")
    public void iClickOnTwitterLogoButton() {
        socialMediaPage.twitterButton.click();
    }

    @Then("I am redirected to Selenium Twitter account")
    public void iAmRedirectedToSeleniumTwitterAccount() {
        //ARRANGE
        String redirectedPage = "twitter.com";

        //ACT
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        //ASSERT
        Assert.assertTrue(driver.getCurrentUrl().contains(redirectedPage), message);
    }

    @When("I scroll the website until I can see YouTube logo")
    public void iScrollTheWebsiteUntilICanSeeYouTubeLogo() {
        basePage.scrollWebsiteToElement(socialMediaPage.youtubeButton);
    }

    @And("I click on Youtube logo button")
    public void iClickOnYoutubeLogoButton() {
        socialMediaPage.youtubeButton.click();
    }

    @Then("I am redirected to Selenium YouTube chanel")
    public void iAmRedirectedToSeleniumYouTubeChanel() {
        //ARRANGE
        String redirectedPage = "youtube.com";

        //ACT
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        //ASSERT
        Assert.assertTrue(driver.getCurrentUrl().contains(redirectedPage), message);
    }

    @When("I scroll the website until I can see Google+ logo")
    public void iScrollTheWebsiteUntilICanSeeGoogleLogo() {
        basePage.scrollWebsiteToElement(socialMediaPage.googleButton);
    }

    @And("I click on Google+ logo button")
    public void iClickOnGoogleLogoButton() {
        socialMediaPage.googleButton.click();
    }

    @Then("I am redirected to Selenium Google+ profile")
    public void iAmRedirectedToSeleniumGoogleProfile() {
        //ARRANGE
        String redirectedPage = "google.com";

        //ACT
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        //ASSERT
        Assert.assertTrue(driver.getCurrentUrl().contains(redirectedPage), message);
    }
}