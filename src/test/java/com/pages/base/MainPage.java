package com.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class MainPage extends BasePage {

    @FindBy(how = How.CSS, using = "#header > div.nav > div > div > nav > div.header_user_info > a")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//a[@class='account']//span")
    public WebElement loggedUser;

    @FindBy(how = How.XPATH, using = "//div[@id='contact-link']")
    public WebElement contactUsButton;

    @FindBy(how = How.XPATH, using = "//input[@class='search_query form-control ac_input']")
    public WebElement searchBoxInput;

    @FindBy(how = How.XPATH, using = "//form[@id='searchbox']//button[@type='submit']")
    public WebElement searchBoxSubmit;
}