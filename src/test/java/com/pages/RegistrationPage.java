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

public class RegistrationPage extends BasePage<RegistrationPage> {

    //VIEW//
    @FindBy(how = How.XPATH, using = "//form[@id='account-creation_form']")
    public WebElement accountCreationPane;

    //MESSAGES//
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
    public WebElement registerError;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//input[@id='id_gender1']")
    public WebElement mrButton;

    @FindBy(how = How.XPATH, using = "//input[@id='id_gender2']")
    public WebElement mrsButton;

    @FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']")
    public WebElement firstNameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']")
    public WebElement lastNameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    public WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//select[@id='days']")
    public WebElement dayOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-days']//span")
    public WebElement readDayOfBirth;

    @FindBy(how = How.XPATH, using = "//select[@id='months']")
    public WebElement monthOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-months']//span")
    public WebElement readMonthOfBirth;

    @FindBy(how = How.XPATH, using = "//select[@id='years']")
    public WebElement yearOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-years']//span")
    public WebElement readYearOfBirth;

    @FindBy(how = How.XPATH, using = "//input[@id='newsletter']")
    public WebElement newsletterCheckbox;

    @FindBy(how = How.XPATH, using = "//input[@id='optin']")
    public WebElement specialOffersCheckbox;

    @FindBy(how = How.XPATH, using = "//input[@id='firstname']")
    public WebElement assertFirstNameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='lastname']")
    public WebElement assertLastNameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='company']")
    public WebElement companyInput;

    @FindBy(how = How.XPATH, using = "//input[@id='address1']")
    public WebElement addressInput;

    @FindBy(how = How.XPATH, using = "//input[@id='address2']")
    public WebElement addressSecondInput;

    @FindBy(how = How.XPATH, using = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(how = How.XPATH, using = "//select[@id='id_state']")
    public WebElement stateDropDown;

    @FindBy(how = How.XPATH, using = "//p[@class='required id_state select form-group']//span")
    public WebElement readStateDropdown;

    @FindBy(how = How.XPATH, using = "//input[@id='postcode']")
    public WebElement postalCodeInput;

    @FindBy(how = How.XPATH, using = "//select[@id='id_country']")
    public WebElement countryDropDown;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-id_country']//span")
    public WebElement readCountryDropdown;

    @FindBy(how = How.XPATH, using = "//textarea[@id='other']")
    public WebElement additionalInformationBox;

    @FindBy(how = How.XPATH, using = "//input[@id='phone']")
    public WebElement homePhoneInput;

    @FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']")
    public WebElement mobilePhoneInput;

    @FindBy(how = How.XPATH, using = "//input[@id='alias']")
    public WebElement addressAliasInput;

    @FindBy(how = How.XPATH, using = "//button[@id='submitAccount']")
    public WebElement registerButton;

    public RegistrationPage() {
        super("/index.php");
    }
}