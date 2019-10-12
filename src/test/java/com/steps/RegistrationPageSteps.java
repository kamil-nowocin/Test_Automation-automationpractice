package com.steps;

import com.DriverFactory;
import com.pages.RegistrationPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;

public class RegistrationPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private RegistrationPage registrationPage = new RegistrationPage(driver);

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        registrationPage.signInButton.click();
    }

    @When("I write an email address")
    public void iWriteAnEmailAddress() {
        registrationPage.sendEmailInput();
    }

    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() {
        registrationPage.sendInvalidEmailInput();
    }

    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() {
        registrationPage.sendRegisteredEmailInput();
    }

    @And("I click on create an account button")
    public void iClickOnCreateAnAccountButton() {
        registrationPage.createAnAccountButton.click();
    }

    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox));
    }

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

    @And("I choose gender")
    public void iChooseGender() {
        registrationPage.mrOrMrsRadioButtonClick();
    }

    @And("I write my first name")
    public void iWriteMyFirstName() {
        registrationPage.sendFirstNameInput();
    }

    @And("I write my last name")
    public void iWriteMyLastName() {
        registrationPage.sendLastNameInput();
    }

    @And("I check if email is already written and valid")
    public void iCheckIfEmailIsAlreadyWrittenAndValid() {
        Assert.assertEquals(registrationPage.emailSecondInput.getAttribute("value"),
                registrationPage.getTempEmail());
    }

    @And("I clear my email address")
    public void iClearMyEmailAddress() {
        registrationPage.emailSecondInput.clear();
    }

    @And("I write password")
    public void iWritePassword() {
        registrationPage.sendPasswordInput();
    }

    @And("I choose date of birth")
    public void iChooseDateOfBirth() {
        registrationPage.sendDateOfBirth();
    }

    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() {
        registrationPage.newsletterCheckboxOrSpecialOffersCheckboxClick();
    }

    @And("I check if my first & last name are already written and are correct")
    public void iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect() {
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value"),
                registrationPage.assertFirstNameInput.getAttribute("value"));
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value"),
                registrationPage.assertLastNameInput.getAttribute("value"));
    }

    @And("I write company name")
    public void iWriteCompanyName() {
        registrationPage.sendCompanyInput();
    }

    @And("I write my addresses")
    public void iWriteMyAddresses() {
        registrationPage.sendAddressesInput();
    }

    @And("I write my address")
    public void iWriteMyAddress() {
        registrationPage.sendOnlyRequiredAddressInput();
    }

    @And("I choose country")
    public void iChooseCountry() {
        registrationPage.sendCountryDropDown("United States");
    }

    @And("I choose - as a country")
    public void iChooseAsACountry() {
        registrationPage.sendCountryDropDown("-");
    }

    @And("I write city name")
    public void iWriteCityName() {
        registrationPage.sendCityInput();
    }

    @And("I choose state")
    public void iChooseState() {
        registrationPage.sendStateDropDown();
    }

    @And("I write postal code")
    public void iWritePostalCode() {
        registrationPage.sendPostalCodeInput();
    }

    @And("I write additional information")
    public void iWriteAdditionalInformation() {
        registrationPage.sendAdditionalInformationBox();
    }

    @And("I write home phone")
    public void iWriteHomePhone() {
        registrationPage.sendHomePhoneInput();
    }

    @And("I write mobile phone")
    public void iWriteMobilePhone() {
        registrationPage.sendMobilePhoneInput();
    }

    @And("I write my address alias")
    public void iWriteMyAddressAlias() {
        registrationPage.sendAddressAliasInput();
    }

    @And("I clear my email address alias")
    public void iClearMyEmailAddressAlias() {
        registrationPage.addressAliasInput.clear();
    }

    @And("I click on register button")
    public void iClickOnRegisterButton() {
        registrationPage.registerButton.click();
    }

    @Then("I can see welcome message")
    public void iCanSeeWelcomeMessage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.myAccountDashboard));
        Assert.assertEquals(registrationPage.myAccountDashboard.getText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAnAccountError));
    }

    @Then("I can see registration error")
    public void iCanSeeRegistrationError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.registerError));
    }

    @Then("I can see create an account page")
    public void iCanSeeCreateAnAccountPage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox));
    }

    @Then("I can see registration error which include one missing element")
    public void iCanSeeRegistrationErrorWhichIncludeOneMissingElement() {
        Assert.assertTrue(registrationPage.errorValidator("oneerror"));
    }

    @Then("I can see warning message about missing first name input")
    public void iCanSeeWarningMessageAboutMissingFirstNameInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorfirstname"));
    }

    @Then("I can see warning message about missing last name input")
    public void iCanSeeWarningMessageAboutMissingLastNameInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorlastname"));
    }

    @Then("I can see warning message about missing email address input")
    public void iCanSeeWarningMessageAboutMissingEmailAddressInput() {
        Assert.assertTrue(registrationPage.errorValidator("erroremail"));
    }

    @Then("I can see warning message about missing password input")
    public void iCanSeeWarningMessageAboutMissingPasswordInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorpassword"));
    }

    @Then("I can see warning message about missing address input")
    public void iCanSeeWarningMessageAboutMissingAddressInput() {
        Assert.assertTrue(registrationPage.errorValidator("erroraddress"));
    }

    @Then("I can see warning message about missing city input")
    public void iCanSeeWarningMessageAboutMissingCityInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorcity"));
    }

    @Then("I can see warning message about missing state input")
    public void iCanSeeWarningMessageAboutMissingStateInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorstate"));
    }

    @Then("I can see warning message about missing postal code input")
    public void iCanSeeWarningMessageAboutMissingPostalCodeInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorpostalcode"));
    }

    @Then("I can see warning message about missing country input")
    public void iCanSeeWarningMessageAboutMissingCountryInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorcountry"));
    }

    @Then("I can see warning message about missing mobile phone input")
    public void iCanSeeWarningMessageAboutMissingMobilePhoneInput() {
        Assert.assertTrue(registrationPage.errorValidator("errormobilephone"));
    }

    @Then("I can see warning message about missing email address alias")
    public void iCanSeeWarningMessageAboutMissingEmailAddressAlias() {
        Assert.assertTrue(registrationPage.errorValidator("erroremailalias"));
    }
}