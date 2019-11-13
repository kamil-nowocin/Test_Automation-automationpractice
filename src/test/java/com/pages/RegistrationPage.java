package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BasePage {

    public RegistrationPage(final WebDriver driver) {
        super(driver);
    }

    //GENERAL//
    @FindBy(how = How.CSS, using = "#header > div.nav > div > div > nav > div.header_user_info > a")
    public WebElement signInButton;

    @FindBy(how = How.ID, using = "email_create")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement createAnAccountButton;

    @FindBy(how = How.ID, using = "create_account_error")
    public WebElement createAnAccountError;

    @FindBy(how = How.CSS, using = "#center_column > div")
    public WebElement registerError;

    @FindBy(how = How.ID, using = "account-creation_form")
    public WebElement accountCreationForm;

    @FindBy(how = How.CSS, using = "#center_column > p")
    public WebElement myAccountDashboard;

    @FindBy(how = How.CSS, using = "#create-account_form > h3")
    public WebElement createAccountBox;

    //YOUR PERSONAL INFORMATION//
    @FindBy(how = How.ID, using = "id_gender1")
    public WebElement mrButton;

    @FindBy(how = How.ID, using = "id_gender2")
    public WebElement mrsButton;

    @FindBy(how = How.ID, using = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(how = How.ID, using = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailSecondInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    public WebElement dayOfBirth;

    @FindBy(how = How.ID, using = "months")
    public WebElement monthOfBirth;

    @FindBy(how = How.ID, using = "years")
    public WebElement yearOfBirth;

    @FindBy(how = How.ID, using = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(how = How.ID, using = "optin")
    public WebElement specialOffersCheckbox;

    //YOUR ADDRESS//
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

    @FindBy(how = How.ID, using = "postcode")
    public WebElement postalCodeInput;

    @FindBy(how = How.ID, using = "id_country")
    public WebElement countryDropDown;

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

    public boolean errorValidator(String errorMessage) {
        waitForElementToBeVisible(10, registerError);
        return registerError.getText().contains(resourceBundleErrorMessages.getString(errorMessage));
    }
}