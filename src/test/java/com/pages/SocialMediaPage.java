package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SocialMediaPage extends BasePage {

    public SocialMediaPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@class=\"facebook\"]")
    public WebElement facebookButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"twitter\"]")
    public WebElement twitterButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"youtube\"]")
    public WebElement youtubeButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"google-plus\"]")
    public WebElement googleButton;
}