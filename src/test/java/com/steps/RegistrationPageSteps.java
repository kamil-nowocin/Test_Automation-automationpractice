package com.steps;

import com.DriverFactory;
import com.pages.RegistrationPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners({Hooks.class})
public class RegistrationPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private RegistrationPage registrationPage = new RegistrationPage(driver);

    @Step("I click on Sign in button")
    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        registrationPage.signInButton.click();
    }

    @Step("I write an email address")
    @When("I write an email address")
    public void iWriteAnEmailAddress() {
        registrationPage.emailInput.sendKeys(tempEmail);
    }

    @Step("I write an invalid email address")
    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() {
        registrationPage.emailInput.sendKeys(resourceBundleInvalidEmails.getString("invalid" + basePage.randomValue(6, 1)));
    }

    @Step("I write an email address which is already in database")
    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() {
        registrationPage.emailInput.sendKeys("asfsafas@wp.pl");
    }

    @Step("I click on Create An Account button")
    @And("I click on Create An Account button")
    public void iClickOnCreateAnAccountButton() {
        registrationPage.createAnAccountButton.click();
    }

    @Step("I can see registration page form")
    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox), VIEW_ERROR);
    }

    @Step("I write following data to registration form")
    @And("I write following data to registration form")
    public void iWriteFollowingDataToRegistrationForm(DataTable dataTable) {
        //(data.get(First Row).get(First Column))//
        List<List<String>> data = dataTable.asLists();
        registrationPage.firstNameInput.sendKeys(data.get(1).get(0));
        registrationPage.lastNameInput.sendKeys(data.get(1).get(1));
        registrationPage.passwordInput.sendKeys(data.get(1).get(2));
        registrationPage.addressInput.sendKeys(data.get(1).get(3));
        registrationPage.cityInput.sendKeys(data.get(1).get(4));
        registrationPage.stateDropDown.sendKeys(data.get(1).get(5));
        registrationPage.postalCodeInput.sendKeys(data.get(1).get(6));
        registrationPage.countryDropDown.sendKeys(data.get(1).get(7));
        registrationPage.mobilePhoneInput.sendKeys(data.get(1).get(8));
    }

    @Step("I choose gender")
    @And("I choose gender")
    public void iChooseGender() {
        if (basePage.randomValue(2, 1) == 1) {
            registrationPage.mrButton.click();
            logger.info("Chosen gender: Male");
        } else {
            registrationPage.mrsButton.click();
            logger.info("Chosen gender: Female");
        }
    }

    @Step("I write my first name")
    @And("I write my first name")
    public void iWriteMyFirstName() {
        registrationPage.firstNameInput.sendKeys(mockNeat.names().first().val());
    }

    @Step("I write my last name")
    @And("I write my last name")
    public void iWriteMyLastName() {
        registrationPage.lastNameInput.sendKeys(mockNeat.names().last().val());
    }

    @Step("I check if email is already written and valid")
    @And("I check if email is already written and valid")
    public void iCheckIfEmailIsAlreadyWrittenAndValid() {
        Assert.assertEquals(registrationPage.emailSecondInput.getAttribute("value"), tempEmail, VALUE_ERROR);
    }

    @Step("I clear my email address")
    @And("I clear my email address")
    public void iClearMyEmailAddress() {
        registrationPage.emailSecondInput.clear();
    }

    @Step("I write password")
    @And("I write password")
    public void iWritePassword() {
        registrationPage.passwordInput.sendKeys(mockNeat.passwords().medium().val());
    }

    @Step("I choose date of birth")
    @And("I choose date of birth")
    public void iChooseDateOfBirth() {
        registrationPage.selectFromDropdownByIntValue(basePage.randomValue(28, 1), registrationPage.dayOfBirth);
        registrationPage.selectFromDropdownByIntValue(basePage.randomValue(12, 1), registrationPage.monthOfBirth);
        registrationPage.selectFromDropdownByIntValue(basePage.randomValue(119, 1), registrationPage.yearOfBirth);
    }

    @Step("I sign in to receive newsletter and special offers")
    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() {
        //ARRANGE
        int tempRandomValue = basePage.randomValue(3, 1);

        //ACT
        if (tempRandomValue == 1) {
            registrationPage.newsletterCheckbox.click();
            logger.info("Signed to receive newsletter");
        } else if (tempRandomValue == 2) {
            registrationPage.specialOffersCheckbox.click();
            logger.info("Signed to receive special offers");
        } else {
            registrationPage.newsletterCheckbox.click();
            registrationPage.specialOffersCheckbox.click();
            logger.info("Signed to newsletter & special offers");
        }
    }

    @Step("I check if my first & last name are already written and are correct")
    @And("I check if my first & last name are already written and are correct")
    public void iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect() {
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value"),
                registrationPage.assertFirstNameInput.getAttribute("value"), VALUE_ERROR);
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value"),
                registrationPage.assertLastNameInput.getAttribute("value"), VALUE_ERROR);
    }

    @Step("I write company name")
    @And("I write company name")
    public void iWriteCompanyName() {
        registrationPage.companyInput.sendKeys(mockNeat.departments().val());
    }

    @Step("I write my addresses")
    @And("I write my addresses")
    public void iWriteMyAddresses() {
        registrationPage.addressInput.sendKeys(faker.address().streetName());
        registrationPage.addressSecondInput.sendKeys(faker.address().secondaryAddress(), faker.address().buildingNumber());
    }

    @Step("I write my address")
    @And("I write my address")
    public void iWriteMyAddress() {
        registrationPage.addressInput.sendKeys(faker.address().streetName(), faker.address().buildingNumber());
    }

    @Step("I choose country {string}")
    @And("I choose country {string}")
    public void iChooseCountry(String country) {
        basePage.selectFromDropdownByStringValue(country, registrationPage.countryDropDown);
    }

    @Step("I write city name")
    @And("I write city name")
    public void iWriteCityName() {
        registrationPage.cityInput.sendKeys(mockNeat.cities().us().val());
    }

    @Step("I choose state")
    @And("I choose state")
    public void iChooseState() {
        registrationPage.selectFromDropdownByIntValue(basePage.randomValue(50, 1), registrationPage.stateDropDown);
    }

    @Step("I write postal code")
    @And("I write postal code")
    public void iWritePostalCode() {
        registrationPage.postalCodeInput.sendKeys(StringUtils.left(faker.address().zipCode(), 5));
    }

    @Step("I write additional information")
    @And("I write additional information")
    public void iWriteAdditionalInformation() {
        registrationPage.additionalInformationBox.sendKeys(faker.chuckNorris().fact());
    }

    @Step("I write home phone")
    @And("I write home phone")
    public void iWriteHomePhone() {
        registrationPage.homePhoneInput.sendKeys(faker.phoneNumber().cellPhone());
    }

    @Step("I write mobile phone")
    @And("I write mobile phone")
    public void iWriteMobilePhone() {
        registrationPage.mobilePhoneInput.sendKeys(faker.phoneNumber().cellPhone());
    }

    @Step("I write my address alias")
    @And("I write my address alias")
    public void iWriteMyAddressAlias() {
        registrationPage.addressAliasInput.clear();
        registrationPage.addressAliasInput.sendKeys(mockNeat.emails().val());
    }

    @Step("I clear my email address alias")
    @And("I clear my email address alias")
    public void iClearMyEmailAddressAlias() {
        registrationPage.addressAliasInput.clear();
    }

    @Step("I click on Register button")
    @And("I click on Register button")
    public void iClickOnRegisterButton() {
        registrationPage.registerButton.click();
    }

    @Step("I can see welcome message")
    @Then("I can see welcome message")
    public void iCanSeeWelcomeMessage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.myAccountDashboard));
        Assert.assertEquals(registrationPage.myAccountDashboard.getText(), WELCOME_MESSAGE);
    }

    @Step("I can see create an account error")
    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAnAccountError), VIEW_ERROR);
    }

    @Step("I can see registration error")
    @Then("I can see registration error")
    public void iCanSeeRegistrationError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.registerError), VIEW_ERROR);
    }

    @Step("I can see create an account page")
    @Then("I can see create an account page")
    public void iCanSeeCreateAnAccountPage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox), VIEW_ERROR);
    }

    @Step("I can see warning message about missing {string} input")
    @Then("I can see warning message about missing {string} input")
    public void iCanSeeWarningMessageAboutMissingFInput(String stringName) {
        switch (stringName.toLowerCase()) {
            case "first name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorfirstname")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorfirstname"));
                break;
            case "last name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorlastname")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorlastname"));
                break;
            case "email address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("erroremail")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("erroremail"));
                break;
            case "password":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorpassword")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorpassword"));
                break;
            case "address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("erroraddress")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("erroraddress"));
                break;
            case "city":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorcity")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorcity"));
                break;
            case "state":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorstate")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorstate"));
                break;
            case "postal code":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorpostalcode")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorpostalcode"));
                break;
            case "country":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errorcountry")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errorcountry"));
                break;
            case "mobile phone":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("errormobilephone")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("errormobilephone"));
                break;
            case "email address alias":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("erroremailalias")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("erroremailalias"));
                break;
            case "one element":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).contains
                                (resourceBundleErrorMessages.getString("oneerror")),
                        MESSAGE_DIDNT_CONTAIN + resourceBundleErrorMessages.getString("oneerror"));
                break;
            default:
                throw new IllegalStateException(INPUT_ERROR);
        }
    }
}