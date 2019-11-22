package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerServicePage extends BasePage {

    //VIEW//
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading bottom-indent']")
    public WebElement contactUsHeader;

    @FindBy(how = How.XPATH, using = "//form[@class='contact-form-box']")
    public WebElement contactUsForm;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']//li")
    public WebElement contactUsErrorMessage;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    public WebElement contactUsSuccessMessage;
    //GENERAL//
    @FindBy(how = How.XPATH, using = "//div[@id='contact-link']")
    public WebElement contactUsButton;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//select[@id='id_contact']")
    public WebElement subjectHeadingDropdown;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//input[@id='email']")
    public WebElement emailAddressInput;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//input[@id='id_order']")
    public WebElement orderReferenceInput;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//input[@type='file']")
    public WebElement attachFileInput;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//span[@class='action']")
    public WebElement chooseFileButton;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-3']//span[@class='filename']")
    public WebElement chosenFileName;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-12 col-md-9']//textarea[@class='form-control']")
    public WebElement messageTextArea;

    @FindBy(how = How.XPATH, using = "//div[@class='submit']//button")
    public WebElement sendButton;

    public CustomerServicePage(final WebDriver driver) {
        super(driver);
    }
}