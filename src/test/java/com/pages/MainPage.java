package com.pages;

import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class MainPage extends BasePage<MainPage> {

    //VIEW//
    @FindBy(how = How.XPATH, using = "//a[@class='account']//span")
    public WebElement currentLoggedUserName;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//div[@id='contact-link']")
    public WebElement contactUsButton;

    @FindBy(how = How.XPATH, using = "//input[@class='search_query form-control ac_input']")
    public WebElement searchBoxInput;

    @FindBy(how = How.XPATH, using = "//form[@id='searchbox']//button[@type='submit']")
    public WebElement searchBoxSubmit;

    //SUB-MENU//
    @FindBy(how = How.XPATH, using = "//li//a[@title='Women' and not(img)]")
    public WebElement subMenuWomen;

    @FindBy(how = How.XPATH, using = "(//li//a[@title='Dresses' and not(img)])[2]")
    public WebElement subMenuDresses;

    @FindBy(how = How.XPATH, using = "(//li//a[@title='T-shirts' and not(img)])[2]")
    public WebElement subMenuTshirts;

    @FindBy(how = How.XPATH, using = "//span[@class='cat-name']")
    public WebElement subMenuChosenCategory;

    public MainPage() {
        super(TestEnvironment.HOME_URL);
    }
}