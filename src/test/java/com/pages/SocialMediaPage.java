package com.pages;

import com.pages.base.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class SocialMediaPage extends MainPage {

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//*[@class=\"facebook\"]")
    public WebElement facebookButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"twitter\"]")
    public WebElement twitterButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"youtube\"]")
    public WebElement youtubeButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"google-plus\"]")
    public WebElement googleButton;
}