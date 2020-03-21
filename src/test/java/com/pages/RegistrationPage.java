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

public class RegistrationPage extends BasePage {

    //VIEW//
    @FindBy(how = How.ID, using = "account-creation_form")
    public WebElement accountCreationPane;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.ID, using = "id_gender1")
    public WebElement mrButton;

    @FindBy(how = How.ID, using = "id_gender2")
    public WebElement mrsButton;

    @FindBy(how = How.ID, using = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(how = How.ID, using = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    public WebElement dayOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-days']//span")
    public WebElement readDayOfBirth;

    @FindBy(how = How.ID, using = "months")
    public WebElement monthOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-months']//span")
    public WebElement readMonthOfBirth;

    @FindBy(how = How.ID, using = "years")
    public WebElement yearOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-years']//span")
    public WebElement readYearOfBirth;

    @FindBy(how = How.ID, using = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(how = How.ID, using = "optin")
    public WebElement specialOffersCheckbox;

    @FindBy(how = How.ID, using = "firstname")
    public WebElement assertFirstNameInput;

    @FindBy(how = How.ID, using = "lastname")
    public WebElement assertLastNameInput;

    @FindBy(how = How.ID, using = "company")
    public WebElement companyInput;

    @FindBy(how = How.ID, using = "address1")
    public WebElement addressInput;

    @FindBy(how = How.ID, using = "address2")
    public WebElement addressSecondInput;

    @FindBy(how = How.ID, using = "city")
    public WebElement cityInput;

    @FindBy(how = How.ID, using = "id_state")
    public WebElement stateDropDown;

    @FindBy(how = How.XPATH, using = "//p[@class='required id_state select form-group']//span")
    public WebElement readStateDropdown;

    @FindBy(how = How.ID, using = "postcode")
    public WebElement postalCodeInput;

    @FindBy(how = How.ID, using = "id_country")
    public WebElement countryDropDown;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-id_country']//span")
    public WebElement readCountryDropdown;

    @FindBy(how = How.ID, using = "other")
    public WebElement additionalInformationBox;

    @FindBy(how = How.ID, using = "phone")
    public WebElement homePhoneInput;

    @FindBy(how = How.ID, using = "phone_mobile")
    public WebElement mobilePhoneInput;

    @FindBy(how = How.ID, using = "alias")
    public WebElement addressAliasInput;

    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement registerButton;

    //MESSAGES//
    @FindBy(how = How.CSS, using = "#center_column > div")
    public WebElement registerError;
}