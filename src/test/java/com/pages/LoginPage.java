package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "#center_column > div.alert.alert-danger")
    public WebElement loginError;

    @FindBy(how = How.ID, using = "login_form")
    public WebElement loginForm;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement signInButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }
}