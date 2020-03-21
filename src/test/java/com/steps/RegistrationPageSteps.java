package com.steps;

import com.ContextInjection;
import com.FrameworkEnvironment;
import com.google.inject.Inject;
import com.pages.AccountDetailsPage;
import com.pages.AuthenticationPage;
import com.pages.RegistrationPage;
import com.pages.base.BasePage;
import com.pages.base.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class RegistrationPageSteps extends FrameworkEnvironment {

    private ContextInjection contextInjection;

    private BasePage basePage = new BasePage();
    private MainPage mainPage = new MainPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private AuthenticationPage authenticationPage = new AuthenticationPage();
    private AccountDetailsPage accountDetailsPage = new AccountDetailsPage();

    @Inject
    public RegistrationPageSteps(ContextInjection contextInjection) {
        this.contextInjection = contextInjection;
    }

    @Step("I click on Sign in button")
    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws Throwable {
        mainPage.signInButton.click();
    }

    @Step("I write an email address")
    @When("I write an email address")
    public void iWriteAnEmailAddress() throws Throwable {
        //ARRANGE//
        contextInjection.generatedEmail = mockNeat.emails().val();

        //ACT//
        authenticationPage.createAnAccountEmailInput.sendKeys(contextInjection.generatedEmail);
        logger.info(String.format("User valid email: %S", contextInjection.generatedEmail));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                contextInjection.generatedEmail.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an invalid email address")
    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() throws Throwable {
        //ARRANGE//
        final String userInvalidEmailAddress = basePage.getRandomElementFromResourceBundleList
                (resourceBundleInvalidEmails.getString("invalidEmails"));

        //ACT//
        authenticationPage.createAnAccountEmailInput.sendKeys(userInvalidEmailAddress);
        logger.info(String.format("User invalid email: %S", userInvalidEmailAddress));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                userInvalidEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an email address which is already in database")
    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() throws Throwable {
        //ARRANGE//
        final String userRegisteredEmailAddress = "asfsafas@wp.pl";

        //ACT//
        authenticationPage.createAnAccountEmailInput.sendKeys(userRegisteredEmailAddress);
        logger.info(String.format("User registered email: %S", userRegisteredEmailAddress));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                userRegisteredEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on Create An Account button")
    @And("I click on Create An Account button")
    public void iClickOnCreateAnAccountButton() throws Throwable {
        authenticationPage.createAnAccountButton.click();
    }

    @Step("I can see registration page form")
    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(5, authenticationPage.createAccountPane),
                String.format(VIEW_ERROR, "Registration page form"));
    }

    @Step("I can see account creation page form")
    @Then("I can see account creation page form")
    public void iCanSeeAccountCreationPageForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(5, registrationPage.accountCreationPane),
                String.format(VIEW_ERROR, "Account creation page form"));
    }

    @Step("I write following data to registration form")
    @And("I write following data to registration form")
    public void iWriteFollowingDataToRegistrationForm(DataTable dataTable) throws Throwable {
        //ARRANGE//
        //(data.get(Row).get(Column))
        List<List<String>> data = dataTable.asLists();
        final String userFirstName = data.get(1).get(0);
        final String userLastName = data.get(1).get(1);
        final String userPassword = data.get(1).get(2);
        final String userAddress = data.get(1).get(3);
        final String userCity = data.get(1).get(4);
        final String userState = data.get(1).get(5);
        final String userPostalCode = data.get(1).get(6);
        final String userCountry = data.get(1).get(7);
        final String userMobilePhone = data.get(1).get(8);

        //ACT//
        registrationPage.firstNameInput.sendKeys(userFirstName);
        logger.info(String.format("User first name: %S", userFirstName));
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                userFirstName.toLowerCase(), VALUE_ERROR);

        registrationPage.lastNameInput.sendKeys(userLastName);
        logger.info(String.format("User last name: %S", userLastName));
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                userLastName.toLowerCase(), VALUE_ERROR);

        registrationPage.passwordInput.sendKeys(userPassword);
        logger.info(String.format("User password: %S", userPassword));
        Assert.assertEquals(registrationPage.passwordInput.getAttribute("value").toLowerCase(),
                userPassword.toLowerCase(), VALUE_ERROR);

        registrationPage.addressInput.sendKeys(userAddress);
        logger.info(String.format("User address: %S", userAddress));
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), VALUE_ERROR);

        registrationPage.cityInput.sendKeys(userCity);
        logger.info(String.format("User city: %S", userCity));
        Assert.assertEquals(registrationPage.cityInput.getAttribute("value").toLowerCase(),
                userCity.toLowerCase(), VALUE_ERROR);

        registrationPage.stateDropDown.sendKeys(userState);
        logger.info(String.format("User state: %S", userState));
        Assert.assertEquals(registrationPage.readStateDropdown.getText().toLowerCase(),
                userState.toLowerCase(), VALUE_ERROR);

        registrationPage.postalCodeInput.sendKeys(userPostalCode);
        logger.info(String.format("User postal code: %S", userPostalCode));
        Assert.assertEquals(registrationPage.postalCodeInput.getAttribute("value").toLowerCase(),
                userPostalCode.toLowerCase(), VALUE_ERROR);

        registrationPage.countryDropDown.sendKeys(userCountry);
        logger.info(String.format("User country: %S", userCountry));
        Assert.assertEquals(registrationPage.readCountryDropdown.getText().toLowerCase(),
                userCountry.toLowerCase(), VALUE_ERROR);

        registrationPage.mobilePhoneInput.sendKeys(userMobilePhone);
        logger.info(String.format("User mobile phone: %S", userMobilePhone));
        Assert.assertEquals(registrationPage.mobilePhoneInput.getAttribute("value").toLowerCase(),
                userMobilePhone.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose gender")
    @And("I choose gender")
    public void iChooseGender() throws Throwable {
        //ARRANGE//
        final int randomNumber = basePage.randomIntValue(2, 1);

        //ACT//
        if (randomNumber == 1) {
            registrationPage.mrButton.click();
            logger.info("User gender: Male");
            //ASSERT//
            Assert.assertTrue(registrationPage.mrButton.isSelected());

        } else {
            registrationPage.mrsButton.click();
            logger.info("User gender: Female");
            //ASSERT//
            Assert.assertTrue(registrationPage.mrsButton.isSelected());
        }
    }

    @Step("I write my first name")
    @And("I write my first name")
    public void iWriteMyFirstName() throws Throwable {
        //ARRANGE//
        final String userFirstName = mockNeat.names().first().val();

        //ACT//
        registrationPage.firstNameInput.sendKeys(userFirstName);
        logger.info(String.format("User first name: %S", userFirstName));

        //ASSERT//
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                userFirstName.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write my last name")
    @And("I write my last name")
    public void iWriteMyLastName() throws Throwable {
        //ARRANGE//
        final String userLastName = mockNeat.names().last().val();

        //ACT//
        registrationPage.lastNameInput.sendKeys(userLastName);
        logger.info(String.format("User last name: %S", userLastName));

        //ASSERT//
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                userLastName.toLowerCase(), VALUE_ERROR);
    }

    @Step("I check if email is already written and valid")
    @And("I check if email is already written and valid")
    public void iCheckIfEmailIsAlreadyWrittenAndValid() throws Throwable {
        Assert.assertEquals(registrationPage.emailInput.getAttribute("value").toLowerCase(),
                contextInjection.generatedEmail.toLowerCase(), VALUE_ERROR);
    }

    @Step("I clear my email address")
    @And("I clear my email address")
    public void iClearMyEmailAddress() throws Throwable {
        registrationPage.emailInput.clear();
    }

    @Step("I write password")
    @And("I write password")
    public void iWritePassword() throws Throwable {
        //ARRANGE//
        final String userPassword = mockNeat.passwords().medium().val();

        //ACT//
        registrationPage.passwordInput.sendKeys(userPassword);
        logger.info(String.format("User password: %S", userPassword));

        //ASSERT//
        Assert.assertEquals(registrationPage.passwordInput.getAttribute("value").toLowerCase(),
                userPassword.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose date of birth")
    @And("I choose date of birth")
    public void iChooseDateOfBirth() throws Throwable {
        //ARRANGE//
        final int day = basePage.randomIntValue(28, 1);
        final int month = basePage.randomIntValue(12, 1);
        final int year = basePage.randomIntValue(2019, 1900);

        //ACT//
        registrationPage.selectFromDropdownByValue(Integer.toString(day), registrationPage.dayOfBirth);
        registrationPage.selectFromDropdownByValue(Integer.toString(month), registrationPage.monthOfBirth);
        registrationPage.selectFromDropdownByValue(Integer.toString(year), registrationPage.yearOfBirth);
        logger.info(String.format("User birthday: %d-%d-%d ", day, month, year));

        //ASSERT//
        Assert.assertEquals(registrationPage.readDayOfBirth.getText().replaceAll("[^\\d]", ""),
                Integer.toString(day), VALUE_ERROR);
        Assert.assertEquals(registrationPage.readMonthOfBirth.getText().replaceAll("\\s+", "").toLowerCase(),
                DateTime.now().withMonthOfYear(month).toString("MMMM", Locale.ENGLISH).toLowerCase(), VALUE_ERROR);
        Assert.assertEquals(registrationPage.readYearOfBirth.getText().replaceAll("[^\\d]", ""),
                Integer.toString(year), VALUE_ERROR);
    }

    @Step("I sign in to receive newsletter and special offers")
    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() throws Throwable {
        //ARRANGE//
        int tempRandomValue = basePage.randomIntValue(3, 1);

        //ACT//
        if (tempRandomValue == 1) {
            if (!registrationPage.newsletterCheckbox.isSelected()) {
                registrationPage.newsletterCheckbox.click();
                logger.info("User signed to receive newsletter");
            }
            //ASSERT//
            Assert.assertTrue(registrationPage.newsletterCheckbox.isSelected());

        } else if (tempRandomValue == 2) {
            if (!registrationPage.specialOffersCheckbox.isSelected()) {
                registrationPage.specialOffersCheckbox.click();
                logger.info("User signed to receive special offers");
            }
            //ASSERT//
            Assert.assertTrue(registrationPage.specialOffersCheckbox.isSelected());

        } else {
            if (!registrationPage.newsletterCheckbox.isSelected() &&
                    registrationPage.specialOffersCheckbox.isSelected()) {
                registrationPage.newsletterCheckbox.click();
                registrationPage.specialOffersCheckbox.click();
                logger.info("User signed to receive newsletter & special offers");
            }
            //ASSERT//
            Assert.assertTrue(registrationPage.newsletterCheckbox.isSelected() &&
                    registrationPage.specialOffersCheckbox.isSelected());
        }
    }

    @Step("I check if my first & last name are already written and are correct")
    @And("I check if my first & last name are already written and are correct")
    public void iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect() throws Throwable {
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                registrationPage.assertFirstNameInput.getAttribute("value").toLowerCase(), VALUE_ERROR);
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                registrationPage.assertLastNameInput.getAttribute("value").toLowerCase(), VALUE_ERROR);
    }

    @Step("I write company name")
    @And("I write company name")
    public void iWriteCompanyName() throws Throwable {
        //ARRANGE//
        final String companyName = mockNeat.departments().val();

        //ACT//
        registrationPage.companyInput.sendKeys(companyName);
        logger.info(String.format("User company name: %S", companyName));

        //ASSERT//
        Assert.assertEquals(registrationPage.companyInput.getAttribute("value").toLowerCase(),
                companyName.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write my addresses")
    @And("I write my addresses")
    public void iWriteMyAddresses() throws Throwable {
        //ARRANGE//
        final String userAddress = faker.address().streetName();
        final String userSecondAddress = faker.address().secondaryAddress() + faker.address().buildingNumber();

        //ACT//
        registrationPage.addressInput.sendKeys(userAddress);
        registrationPage.addressSecondInput.sendKeys(userSecondAddress);
        logger.info(String.format("User addresses: %S and %S", userAddress, userSecondAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), VALUE_ERROR);
        Assert.assertEquals(registrationPage.addressSecondInput.getAttribute("value").toLowerCase(),
                userSecondAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write my address")
    @And("I write my address")
    public void iWriteMyAddress() throws Throwable {
        //ARRANGE//
        final String userAddress = faker.address().streetName() + faker.address().buildingNumber();

        //ACT//
        registrationPage.addressInput.sendKeys(userAddress);
        logger.info(String.format("User address: %S", userAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose country *{0}*")
    @And("I choose country {string}")
    public void iChooseCountry(String country) throws Throwable {
        //ARRANGE//
        final String defaultCountry = contextInjection.defaultCustomerCountry;

        //ACT//
        if (registrationPage.readCountryDropdown.getText().toLowerCase().equals(defaultCountry.toLowerCase()) &&
                !registrationPage.readCountryDropdown.getText().toLowerCase().equals(country.toLowerCase())) {
            basePage.selectFromDropdownByText(country, registrationPage.countryDropDown);
        }
        logger.info(String.format("User chosen country: %S", country));

        //ASSERT//
        Assert.assertEquals(registrationPage.readCountryDropdown.getText().toLowerCase(),
                country.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write city name")
    @And("I write city name")
    public void iWriteCityName() throws Throwable {
        //ARRANGE//
        final String userCity = mockNeat.cities().us().val();

        //ACT//
        registrationPage.cityInput.sendKeys(userCity);
        logger.info(String.format("User chosen city: %S", userCity));

        //ASSERT//
        Assert.assertEquals(registrationPage.cityInput.getAttribute("value").toLowerCase(),
                userCity.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose state")
    @And("I choose state")
    public void iChooseState() throws Throwable {
        //ARRANGE//
        final String userState = faker.address().state();

        //ACT
        registrationPage.selectFromDropdownByText(userState, registrationPage.stateDropDown);
        logger.info(String.format("User chosen state: %S", userState));

        //ASSERT//
        Assert.assertEquals(registrationPage.readStateDropdown.getText().toLowerCase(),
                userState.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write postal code")
    @And("I write postal code")
    public void iWritePostalCode() throws Throwable {
        //ARRANGE//
        final String userPostalCode = StringUtils.left(faker.address().zipCode(), 5);

        //ACT//
        registrationPage.postalCodeInput.sendKeys(userPostalCode);
        logger.info(String.format("User postal code: %S", userPostalCode));

        //ASSERT//
        Assert.assertEquals(registrationPage.postalCodeInput.getAttribute("value").toLowerCase(),
                userPostalCode.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write additional information")
    @And("I write additional information")
    public void iWriteAdditionalInformation() throws Throwable {
        //ARRANGE//
        final String userAdditionalInformation = faker.chuckNorris().fact();

        //ACT//
        registrationPage.additionalInformationBox.sendKeys(userAdditionalInformation);
        logger.info(String.format("User additional information: %S", userAdditionalInformation));

        //ASSERT//
        Assert.assertEquals(registrationPage.additionalInformationBox.getAttribute("value").toLowerCase(),
                userAdditionalInformation.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write home phone")
    @And("I write home phone")
    public void iWriteHomePhone() throws Throwable {
        //ARRANGE//
        final String userPhoneNumber = faker.phoneNumber().cellPhone();

        //ACT//
        registrationPage.homePhoneInput.sendKeys(userPhoneNumber);
        logger.info(String.format("User phone number: %S", userPhoneNumber));

        //ASSERT//
        Assert.assertEquals(registrationPage.homePhoneInput.getAttribute("value").toLowerCase(),
                userPhoneNumber.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write mobile phone")
    @And("I write mobile phone")
    public void iWriteMobilePhone() throws Throwable {
        //ARRANGE//
        final String userMobilePhone = faker.phoneNumber().cellPhone();

        //ACT//
        registrationPage.mobilePhoneInput.sendKeys(userMobilePhone);
        logger.info(String.format("User mobile phone number: %S", userMobilePhone));

        //ARRANGE//
        Assert.assertEquals(registrationPage.mobilePhoneInput.getAttribute("value").toLowerCase(),
                userMobilePhone.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write my address alias")
    @And("I write my address alias")
    public void iWriteMyAddressAlias() throws Throwable {
        //ARRANGE//
        final String userAddressAlias = mockNeat.emails().val();

        //ACT//
        registrationPage.addressAliasInput.clear();
        registrationPage.addressAliasInput.sendKeys(userAddressAlias);
        logger.info(String.format("User alias: %S", userAddressAlias));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressAliasInput.getAttribute("value").toLowerCase(),
                userAddressAlias.toLowerCase(), VALUE_ERROR);
    }

    @Step("I clear my email address alias")
    @And("I clear my email address alias")
    public void iClearMyEmailAddressAlias() throws Throwable {
        registrationPage.addressAliasInput.clear();
    }

    @Step("I click on Register button")
    @And("I click on Register button")
    public void iClickOnRegisterButton() throws Throwable {
        registrationPage.registerButton.click();
    }

    @Step("I can see welcome message")
    @Then("I can see welcome message")
    public void iCanSeeWelcomeMessage() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(5, accountDetailsPage.myAccountDetailsDashboard));
        Assert.assertEquals(accountDetailsPage.myAccountDetailsDashboard.getText().toLowerCase(),
                WELCOME_MESSAGE.toLowerCase(), VALUE_ERROR);
    }

    @Step("I can see create an account error")
    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(5, authenticationPage.createAnAccountError),
                String.format(VIEW_ERROR, "Create an account error header"));
    }

    @Step("I can see registration error")
    @Then("I can see registration error")
    public void iCanSeeRegistrationError() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(5, registrationPage.registerError),
                String.format(VIEW_ERROR, "Registration error header"));
    }

    @Step("I can see warning message about missing *{0}* input")
    @Then("I can see warning message about missing {string} input")
    public void iCanSeeWarningMessageAboutMissingInput(String stringName) throws Throwable {
        switch (stringName.toLowerCase()) {
            case "first name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-FirstName").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-FirstName")));
                break;

            case "last name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-LastName").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-LastName")));
                break;

            case "email address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-Email").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-Email")));
                break;

            case "password":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-Password").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-Password")));
                break;

            case "address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-Address").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-Address")));
                break;

            case "city":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-City").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-City")));
                break;

            case "state":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-State").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-State")));
                break;

            case "postal code":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-PostalCode").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-PostalCode")));
                break;
            case "country":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-Country").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-Country")));
                break;

            case "mobile phone":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-MobilePhone").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-MobilePhone")));
                break;

            case "email address alias":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-EmailAlias").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-EmailAlias")));
                break;

            case "one element":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("error-oneError").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("error-oneError")));
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, stringName.toUpperCase()));
        }
    }
}