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

    //CREATE AN ACCOUNT
    @FindBy(how = How.ID, using = "email_create")
    public WebElement registerNewEmailInput;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement createAnAccountButton;

    @FindBy(how = How.ID, using = "create_account_error")
    public WebElement createAnAccountError;

    //ALREADY REGISTERED
    @FindBy(how = How.ID, using = "login_form")
    public WebElement loginForm;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(how = How.CSS, using = "#center_column > div.alert.alert-danger")
    public WebElement loginError;
}