package com.pages;

import com.pages.base.BasePage;
import org.apache.commons.lang3.StringUtils;
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
    private WebElement emailInput;

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
    private WebElement mrButton;

    @FindBy(how = How.ID, using = "id_gender2")
    private WebElement mrsButton;

    @FindBy(how = How.ID, using = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(how = How.ID, using = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailSecondInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    private WebElement dayOfBirth;

    @FindBy(how = How.ID, using = "months")
    private WebElement monthOfBirth;

    @FindBy(how = How.ID, using = "years")
    private WebElement yearOfBirth;

    @FindBy(how = How.ID, using = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(how = How.ID, using = "optin")
    private WebElement specialOffersCheckbox;

    //YOUR ADDRESS//
    @FindBy(how = How.ID, using = "firstname")
    public WebElement assertFirstNameInput;

    @FindBy(how = How.ID, using = "lastname")
    public WebElement assertLastNameInput;

    @FindBy(how = How.ID, using = "company")
    private WebElement companyInput;

    @FindBy(how = How.ID, using = "address1")
    public WebElement addressInput;

    @FindBy(how = How.ID, using = "address2")
    private WebElement addressSecondInput;

    @FindBy(how = How.ID, using = "city")
    public WebElement cityInput;

    @FindBy(how = How.ID, using = "id_state")
    public WebElement stateDropDown;

    @FindBy(how = How.ID, using = "postcode")
    public WebElement postalCodeInput;

    @FindBy(how = How.ID, using = "id_country")
    public WebElement countryDropDown;

    @FindBy(how = How.ID, using = "other")
    private WebElement additionalInformationBox;

    @FindBy(how = How.ID, using = "phone")
    private WebElement homePhoneInput;

    @FindBy(how = How.ID, using = "phone_mobile")
    public WebElement mobilePhoneInput;

    @FindBy(how = How.ID, using = "alias")
    public WebElement addressAliasInput;

    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement registerButton;


    private String tempEmail = mockNeat.emails().val();

    //GENERAL//
    public String getTempEmail() {
        return tempEmail;
    }

    public boolean errorValidator(String errorMessage) {
        waitForElementToBeVisible(10, registerError);
        return registerError.getText().contains(resourceBundleErrorMessages.getString(errorMessage));
    }

    //CHECKBOXES//
    public void mrOrMrsRadioButtonClick() {
        if (randomValue(2, 1) == 1) {
            mrButton.click();
            logger.info("Chosen gender: Male");
        } else {
            mrsButton.click();
            logger.info("Chosen gender: Female");
        }
    }

    public void newsletterCheckboxOrSpecialOffersCheckboxClick() {
        int tempRandomValue = randomValue(3, 1);
        if (tempRandomValue == 1) {
            newsletterCheckbox.click();
            logger.info("Signed to receive newsletter");
        } else if (tempRandomValue == 2) {
            specialOffersCheckbox.click();
            logger.info("Signed to receive special offers");
        } else {
            newsletterCheckbox.click();
            specialOffersCheckbox.click();
            logger.info("Signed to newsletter & special offers");
        }
    }

    //DATA INPUTS//
    public void sendInvalidEmailInput() {
        emailInput.sendKeys(resourceBundleInvalidEmails.getString("invalid" + randomValue(6, 1)));
    }

    public void sendRegisteredEmailInput() {
        emailInput.sendKeys("asfsafas@wp.pl");
    }

    public void sendEmailInput() {
        emailInput.sendKeys(tempEmail);
    }

    public void sendFirstNameInput() {
        firstNameInput.sendKeys(mockNeat.names().first().val());
    }

    public void sendLastNameInput() {
        lastNameInput.sendKeys(mockNeat.names().last().val());
    }

    public void sendPasswordInput() {
        passwordInput.sendKeys(mockNeat.passwords().medium().val());
    }

    public void sendDateOfBirth() {
        selectFromDropdownByIntValue(randomValue(28, 1), dayOfBirth);
        selectFromDropdownByIntValue(randomValue(12, 1), monthOfBirth);
        selectFromDropdownByIntValue(randomValue(119, 1), yearOfBirth);
    }

    public void sendCompanyInput() {
        companyInput.sendKeys(mockNeat.departments().val());
    }

    public void sendOnlyRequiredAddressInput() {
        addressInput.sendKeys(faker.address().streetName(), faker.address().buildingNumber());
    }

    public void sendAddressesInput() {
        addressInput.sendKeys(faker.address().streetName());
        addressSecondInput.sendKeys(faker.address().secondaryAddress(), faker.address().buildingNumber());
    }

    public void sendCityInput() {
        cityInput.sendKeys(mockNeat.cities().us().val());
    }

    public void sendStateDropDown() {
        selectFromDropdownByIntValue(randomValue(50, 1), stateDropDown);
    }

    public void sendPostalCodeInput() {
        postalCodeInput.sendKeys(StringUtils.left(faker.address().zipCode(), 5));
    }

    public void sendCountryDropDown(String countryName) {
        selectFromDropdownByStringValue(countryName, countryDropDown);
    }

    public void sendAdditionalInformationBox() {
        additionalInformationBox.sendKeys(faker.chuckNorris().fact());
    }

    public void sendHomePhoneInput() {
        homePhoneInput.sendKeys(faker.phoneNumber().cellPhone());
    }

    public void sendMobilePhoneInput() {
        mobilePhoneInput.sendKeys(faker.phoneNumber().cellPhone());
    }

    public void sendAddressAliasInput() {
        addressAliasInput.clear();
        addressAliasInput.sendKeys(mockNeat.emails().val());
    }
}