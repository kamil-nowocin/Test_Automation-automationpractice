package com.steps;

import com.DriverFactory;
import com.pages.RegistrationPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

@Feature("REGISTRATION TESTS")
@Severity(SeverityLevel.CRITICAL)
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
        registrationPage.sendEmailInput();
    }

    @Step("I write an invalid email address")
    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() {
        registrationPage.sendInvalidEmailInput();
    }

    @Step("I write an email address which is already in database")
    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() {
        registrationPage.sendRegisteredEmailInput();
    }

    @Step("I click on create an account button")
    @And("I click on create an account button")
    public void iClickOnCreateAnAccountButton() {
        registrationPage.createAnAccountButton.click();
    }

    @Step("I can see registration page form")
    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox));
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
        registrationPage.mrOrMrsRadioButtonClick();
    }

    @Step("I write my first name")
    @And("I write my first name")
    public void iWriteMyFirstName() {
        registrationPage.sendFirstNameInput();
    }

    @Step("I write my last name")
    @And("I write my last name")
    public void iWriteMyLastName() {
        registrationPage.sendLastNameInput();
    }

    @Step("I check if email is already written and valid")
    @And("I check if email is already written and valid")
    public void iCheckIfEmailIsAlreadyWrittenAndValid() {
        Assert.assertEquals(registrationPage.emailSecondInput.getAttribute("value"),
                registrationPage.getTempEmail());
    }

    @Step("I clear my email address")
    @And("I clear my email address")
    public void iClearMyEmailAddress() {
        registrationPage.emailSecondInput.clear();
    }

    @Step("I write password")
    @And("I write password")
    public void iWritePassword() {
        registrationPage.sendPasswordInput();
    }

    @Step("I choose date of birth")
    @And("I choose date of birth")
    public void iChooseDateOfBirth() {
        registrationPage.sendDateOfBirth();
    }

    @Step("I sign in to receive newsletter and special offers")
    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() {
        registrationPage.newsletterCheckboxOrSpecialOffersCheckboxClick();
    }

    @Step("I check if my first & last name are already written and are correct")
    @And("I check if my first & last name are already written and are correct")
    public void iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect() {
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value"),
                registrationPage.assertFirstNameInput.getAttribute("value"));
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value"),
                registrationPage.assertLastNameInput.getAttribute("value"));
    }

    @Step("I write company name")
    @And("I write company name")
    public void iWriteCompanyName() {
        registrationPage.sendCompanyInput();
    }

    @Step("I write my addresses")
    @And("I write my addresses")
    public void iWriteMyAddresses() {
        registrationPage.sendAddressesInput();
    }

    @Step("I write my address")
    @And("I write my address")
    public void iWriteMyAddress() {
        registrationPage.sendOnlyRequiredAddressInput();
    }

    @Step("I choose country")
    @And("I choose country")
    public void iChooseCountry() {
        registrationPage.sendCountryDropDown("United States");
    }

    @Step("I choose - as a country")
    @And("I choose - as a country")
    public void iChooseAsACountry() {
        registrationPage.sendCountryDropDown("-");
    }

    @Step("I write city name")
    @And("I write city name")
    public void iWriteCityName() {
        registrationPage.sendCityInput();
    }

    @Step("I choose state")
    @And("I choose state")
    public void iChooseState() {
        registrationPage.sendStateDropDown();
    }

    @Step("I write postal code")
    @And("I write postal code")
    public void iWritePostalCode() {
        registrationPage.sendPostalCodeInput();
    }

    @Step("I write additional information")
    @And("I write additional information")
    public void iWriteAdditionalInformation() {
        registrationPage.sendAdditionalInformationBox();
    }

    @Step("I write home phone")
    @And("I write home phone")
    public void iWriteHomePhone() {
        registrationPage.sendHomePhoneInput();
    }

    @Step("I write mobile phone")
    @And("I write mobile phone")
    public void iWriteMobilePhone() {
        registrationPage.sendMobilePhoneInput();
    }

    @Step("I write my address alias")
    @And("I write my address alias")
    public void iWriteMyAddressAlias() {
        registrationPage.sendAddressAliasInput();
    }

    @Step("I clear my email address alias")
    @And("I clear my email address alias")
    public void iClearMyEmailAddressAlias() {
        registrationPage.addressAliasInput.clear();
    }

    @Step("I click on register button")
    @And("I click on register button")
    public void iClickOnRegisterButton() {
        registrationPage.registerButton.click();
    }

    @Step("I can see welcome message")
    @Then("I can see welcome message")
    public void iCanSeeWelcomeMessage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.myAccountDashboard));
        Assert.assertEquals(registrationPage.myAccountDashboard.getText(),
                "Welcome to your account. Here you can manage all of your personal information and orders.aa");
    }

    @Step("I can see create an account error")
    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAnAccountError));
    }

    @Step("I can see registration error")
    @Then("I can see registration error")
    public void iCanSeeRegistrationError() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.registerError));
    }

    @Step("I can see create an account page")
    @Then("I can see create an account page")
    public void iCanSeeCreateAnAccountPage() {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox));
    }

    @Step("I can see registration error which include one missing element")
    @Then("I can see registration error which include one missing element")
    public void iCanSeeRegistrationErrorWhichIncludeOneMissingElement() {
        Assert.assertTrue(registrationPage.errorValidator("oneerror"));
    }

    @Step("I can see warning message about missing first name input")
    @Then("I can see warning message about missing first name input")
    public void iCanSeeWarningMessageAboutMissingFirstNameInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorfirstname"));
    }

    @Step("I can see warning message about missing last name input")
    @Then("I can see warning message about missing last name input")
    public void iCanSeeWarningMessageAboutMissingLastNameInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorlastname"));
    }

    @Step("I can see warning message about missing email address input")
    @Then("I can see warning message about missing email address input")
    public void iCanSeeWarningMessageAboutMissingEmailAddressInput() {
        Assert.assertTrue(registrationPage.errorValidator("erroremail"));
    }

    @Step("I can see warning message about missing password input")
    @Then("I can see warning message about missing password input")
    public void iCanSeeWarningMessageAboutMissingPasswordInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorpassword"));
    }

    @Step("I can see warning message about missing address input")
    @Then("I can see warning message about missing address input")
    public void iCanSeeWarningMessageAboutMissingAddressInput() {
        Assert.assertTrue(registrationPage.errorValidator("erroraddress"));
    }

    @Step("I can see warning message about missing city input")
    @Then("I can see warning message about missing city input")
    public void iCanSeeWarningMessageAboutMissingCityInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorcity"));
    }

    @Step("I can see warning message about missing state input")
    @Then("I can see warning message about missing state input")
    public void iCanSeeWarningMessageAboutMissingStateInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorstate"));
    }

    @Step("I can see warning message about missing postal code input")
    @Then("I can see warning message about missing postal code input")
    public void iCanSeeWarningMessageAboutMissingPostalCodeInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorpostalcode"));
    }

    @Step("I can see warning message about missing country input")
    @Then("I can see warning message about missing country input")
    public void iCanSeeWarningMessageAboutMissingCountryInput() {
        Assert.assertTrue(registrationPage.errorValidator("errorcountry"));
    }

    @Step("I can see warning message about missing mobile phone input")
    @Then("I can see warning message about missing mobile phone input")
    public void iCanSeeWarningMessageAboutMissingMobilePhoneInput() {
        Assert.assertTrue(registrationPage.errorValidator("errormobilephone"));
    }

    @Step("I can see warning message about missing email address alias")
    @Then("I can see warning message about missing email address alias")
    public void iCanSeeWarningMessageAboutMissingEmailAddressAlias() {
        Assert.assertTrue(registrationPage.errorValidator("erroremailalias"));
    }
}