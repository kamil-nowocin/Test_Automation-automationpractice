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

public class AuthenticationPage extends BasePage {

    /**
     * CREATE AN ACCOUNT
     **/
    //VIEW//
    @FindBy(how = How.ID, using = "create-account_form")
    public WebElement createAccountPane;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.ID, using = "email_create")
    public WebElement createAnAccountEmailInput;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement createAnAccountButton;

    //MESSAGES//
    @FindBy(how = How.ID, using = "create_account_error")
    public WebElement createAnAccountError;

    /**
     * ALREADY REGISTERED
     **/
    //VIEW//
    @FindBy(how = How.ID, using = "login_form")
    public WebElement registeredPane;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.ID, using = "email")
    public WebElement registeredEmailInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement registeredPasswordInput;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement registeredSignInButton;

    //MESSAGES//
    @FindBy(how = How.CSS, using = "#center_column > div.alert.alert-danger")
    public WebElement registeredLoginError;
}