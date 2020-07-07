package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class AuthenticationPage extends BasePage<AuthenticationPage> {

    /**
     * CREATE AN ACCOUNT
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//form[@id='create-account_form']")
    public WebElement createAccountPane;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//input[@id='email_create']")
    public WebElement createAnAccountEmailInput;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitCreate']")
    public WebElement createAnAccountButton;

    //MESSAGES//
    @FindBy(how = How.XPATH, using = "//div[@id='create_account_error']")
    public WebElement createAnAccountError;

    /**
     * ALREADY REGISTERED
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//form[@id='login_form']")
    public WebElement registeredPane;

    //MESSAGES//
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
    public WebElement registeredLoginError;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement registeredEmailInput;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    public WebElement registeredPasswordInput;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
    public WebElement registeredSignInButton;

    public AuthenticationPage() {
        super("/index.php");
    }
}