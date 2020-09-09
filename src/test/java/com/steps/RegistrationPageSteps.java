package com.steps;

import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.google.inject.Inject;
import com.pages.AccountDetailsPage;
import com.pages.AuthenticationPage;
import com.pages.MainPage;
import com.pages.RegistrationPage;
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

public class RegistrationPageSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final TestCommons testCommons = new TestCommons();
    private final RegistrationPage registrationPage = new RegistrationPage().get();
    private final AuthenticationPage authenticationPage = new AuthenticationPage().get();
    private final AccountDetailsPage accountDetailsPage = new AccountDetailsPage().get();

    private final ContextInjection contextInjection;

    @Inject
    public RegistrationPageSteps(ContextInjection contextInjection) {
        this.contextInjection = contextInjection;
    }

    @Step("I click on Sign in button")
    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws Throwable {
        testCommons.customClick(mainPage.signInButton);
    }

    @Step("I write an email address")
    @When("I write an email address")
    public void iWriteAnEmailAddress() throws Throwable {
        //ARRANGE//
        contextInjection.generatedEmail = faker.random().hex(5) + mockNeat.emails().get();

        //ACT//
        testCommons.customSendKeys(authenticationPage.createAnAccountEmailInput, contextInjection.generatedEmail);
        logger.info(String.format("User valid email: \"%S\"", contextInjection.generatedEmail));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                contextInjection.generatedEmail.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write an invalid email address")
    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() throws Throwable {
        //ARRANGE//
        final String userInvalidEmailAddress = testCommons.getRandomResourceBundleValue
                (RESOURCE_BUNDLE_INVALID_EMAILS.getString("invalidEmails"));

        //ACT//
        testCommons.customSendKeys(authenticationPage.createAnAccountEmailInput, userInvalidEmailAddress);
        logger.info(String.format("User invalid email: \"%S\"", userInvalidEmailAddress));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                userInvalidEmailAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write an email address which is already in database")
    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() throws Throwable {
        //ARRANGE//
        final String userRegisteredEmailAddress = ContextInjection.DEFAULT_REGISTERED_EMAIL_ADDRESS;

        //ACT//
        testCommons.customSendKeys(authenticationPage.createAnAccountEmailInput, userRegisteredEmailAddress);
        logger.info(String.format("User registered email: \"%S\"", userRegisteredEmailAddress));

        //ASSERT//
        Assert.assertEquals(authenticationPage.createAnAccountEmailInput.getAttribute("value").toLowerCase(),
                userRegisteredEmailAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on Create An Account button")
    @And("I click on Create An Account button")
    public void iClickOnCreateAnAccountButton() throws Throwable {
        testCommons.customClick(authenticationPage.createAnAccountButton);
    }

    @Step("I can see registration page form")
    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(authenticationPage.createAccountPane),
                String.format(ContextInjection.VIEW_ERROR, "Registration page form"));
    }

    @Step("I can see account creation page form")
    @Then("I can see account creation page form")
    public void iCanSeeAccountCreationPageForm() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(registrationPage.accountCreationPane),
                String.format(ContextInjection.VIEW_ERROR, "Account creation page form"));
    }

    @Step("I write following data to registration form")
    @And("I write following data to registration form")
    public void iWriteFollowingDataToRegistrationForm(DataTable dataTable) throws Throwable {
        //ARRANGE//
        //data.get(Row).get(Column)
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
        testCommons.customSendKeys(registrationPage.firstNameInput, userFirstName);
        logger.info(String.format("User first name: \"%S\"", userFirstName));
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                userFirstName.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.lastNameInput, userLastName);
        logger.info(String.format("User last name: \"%S\"", userLastName));
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                userLastName.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.passwordInput, userPassword);
        logger.info(String.format("User password: \"%S\"", userPassword));
        Assert.assertEquals(registrationPage.passwordInput.getAttribute("value").toLowerCase(),
                userPassword.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.addressInput, userAddress);
        logger.info(String.format("User address: \"%S\"", userAddress));
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.cityInput, userCity);
        logger.info(String.format("User city: \"%S\"", userCity));
        Assert.assertEquals(registrationPage.cityInput.getAttribute("value").toLowerCase(),
                userCity.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.selectFromDropdownByText(userState, registrationPage.stateDropDown);
        logger.info(String.format("User state: \"%S\"", userState));
        Assert.assertEquals(registrationPage.readStateDropdown.getText().toLowerCase(),
                userState.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.postalCodeInput, userPostalCode);
        logger.info(String.format("User postal code: \"%S\"", userPostalCode));
        Assert.assertEquals(registrationPage.postalCodeInput.getAttribute("value").toLowerCase(),
                userPostalCode.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.selectFromDropdownByText(userCountry, registrationPage.countryDropDown);
        logger.info(String.format("User country: \"%S\"", userCountry));
        Assert.assertEquals(registrationPage.readCountryDropdown.getText().toLowerCase(),
                userCountry.toLowerCase(), ContextInjection.VALUE_ERROR);

        testCommons.customSendKeys(registrationPage.mobilePhoneInput, userMobilePhone);
        logger.info(String.format("User mobile phone: \"%S\"", userMobilePhone));
        Assert.assertEquals(registrationPage.mobilePhoneInput.getAttribute("value").toLowerCase(),
                userMobilePhone.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose gender")
    @And("I choose gender")
    public void iChooseGender() throws Throwable {
        //ARRANGE//
        final int randomNumber = testCommons.getRandomIntValue(2, 1);

        //ACT//
        if (randomNumber == 1) {
            testCommons.customClick(registrationPage.mrButton);
            logger.info("User gender: \"Male\"");
            //ASSERT//
            Assert.assertTrue(registrationPage.mrButton.isSelected());
        } else {
            testCommons.customClick(registrationPage.mrsButton);
            logger.info("User gender: \"Female\"");
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
        testCommons.customSendKeys(registrationPage.firstNameInput, userFirstName);
        logger.info(String.format("User first name: \"%S\"", userFirstName));

        //ASSERT//
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                userFirstName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write my last name")
    @And("I write my last name")
    public void iWriteMyLastName() throws Throwable {
        //ARRANGE//
        final String userLastName = mockNeat.names().last().val();

        //ACT//
        testCommons.customSendKeys(registrationPage.lastNameInput, userLastName);
        logger.info(String.format("User last name: \"%S\"", userLastName));

        //ASSERT//
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                userLastName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I check if email is already written and valid")
    @And("I check if email is already written and valid")
    public void iCheckIfEmailIsAlreadyWrittenAndValid() throws Throwable {
        Assert.assertEquals(registrationPage.emailInput.getAttribute("value").toLowerCase(),
                contextInjection.generatedEmail.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I clear my email address")
    @And("I clear my email address")
    public void iClearMyEmailAddress() throws Throwable {
        testCommons.customClick(registrationPage.emailInput);
        registrationPage.emailInput.clear();
    }

    @Step("I write password")
    @And("I write password")
    public void iWritePassword() throws Throwable {
        //ARRANGE//
        final String userPassword = mockNeat.passwords().medium().val();

        //ACT//
        testCommons.customSendKeys(registrationPage.passwordInput, userPassword);
        logger.info(String.format("User password: \"%S\"", userPassword));

        //ASSERT//
        Assert.assertEquals(registrationPage.passwordInput.getAttribute("value").toLowerCase(),
                userPassword.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose date of birth")
    @And("I choose date of birth")
    public void iChooseDateOfBirth() throws Throwable {
        //ARRANGE//
        final int day = testCommons.getRandomIntValue(28, 1);
        final int month = testCommons.getRandomIntValue(12, 1);
        final int year = testCommons.getRandomIntValue(2019, 1900);

        //ACT//
        testCommons.selectFromDropdownByValue(Integer.toString(day), registrationPage.dayOfBirth);
        testCommons.selectFromDropdownByValue(Integer.toString(month), registrationPage.monthOfBirth);
        testCommons.selectFromDropdownByValue(Integer.toString(year), registrationPage.yearOfBirth);
        logger.info(String.format("User birthday: \"%d-%d-%d\"", day, month, year));

        //ASSERT//
        Assert.assertEquals(registrationPage.readDayOfBirth.getText().replaceAll("[^\\d]", ""),
                Integer.toString(day), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(registrationPage.readMonthOfBirth.getText().replaceAll("\\s+", "").toLowerCase(),
                DateTime.now().withMonthOfYear(month).toString("MMMM", Locale.ENGLISH).toLowerCase(), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(registrationPage.readYearOfBirth.getText().replaceAll("[^\\d]", ""),
                Integer.toString(year), ContextInjection.VALUE_ERROR);
    }

    @Step("I sign in to receive newsletter and special offers")
    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() throws Throwable {
        //ARRANGE//
        int tempRandomValue = testCommons.getRandomIntValue(3, 3);

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
            if (!registrationPage.newsletterCheckbox.isSelected() && !registrationPage.specialOffersCheckbox.isSelected()) {
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
                registrationPage.assertFirstNameInput.getAttribute("value").toLowerCase(), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                registrationPage.assertLastNameInput.getAttribute("value").toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write company name")
    @And("I write company name")
    public void iWriteCompanyName() throws Throwable {
        //ARRANGE//
        final String companyName = mockNeat.departments().val();

        //ACT//
        testCommons.customSendKeys(registrationPage.companyInput, companyName);
        logger.info(String.format("User company name: \"%S\"", companyName));

        //ASSERT//
        Assert.assertEquals(registrationPage.companyInput.getAttribute("value").toLowerCase(),
                companyName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write my addresses")
    @And("I write my addresses")
    public void iWriteMyAddresses() throws Throwable {
        //ARRANGE//
        final String userAddress = faker.address().streetName();
        final String userSecondAddress = faker.address().secondaryAddress() + faker.address().buildingNumber();

        //ACT//
        testCommons.customSendKeys(registrationPage.addressInput, userAddress);
        testCommons.customSendKeys(registrationPage.addressSecondInput, userSecondAddress);
        logger.info(String.format("User addresses: \"%S\" and \"%S\"", userAddress, userSecondAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(registrationPage.addressSecondInput.getAttribute("value").toLowerCase(),
                userSecondAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write my address")
    @And("I write my address")
    public void iWriteMyAddress() throws Throwable {
        //ARRANGE//
        final String userAddress = faker.address().streetName() + faker.address().buildingNumber();

        //ACT//
        testCommons.customSendKeys(registrationPage.addressInput, userAddress);
        logger.info(String.format("User address: \"%S\"", userAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                userAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose country *{0}*")
    @And("I choose country {string}")
    public void iChooseCountry(String country) throws Throwable {
        //ARRANGE//
        final String defaultCountry = ContextInjection.DEFAULT_CUSTOMER_COUNTRY;

        //ACT//
        if (registrationPage.readCountryDropdown.getText().toLowerCase().equals(defaultCountry.toLowerCase()) &&
                !registrationPage.readCountryDropdown.getText().toLowerCase().equals(country.toLowerCase())) {
            testCommons.selectFromDropdownByText(country, registrationPage.countryDropDown);
        }
        logger.info(String.format("User chosen country: \"%S\"", country));

        //ASSERT//
        Assert.assertEquals(registrationPage.readCountryDropdown.getText().toLowerCase(),
                country.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write city name")
    @And("I write city name")
    public void iWriteCityName() throws Throwable {
        //ARRANGE//
        final String userCity = mockNeat.cities().us().val();

        //ACT//
        testCommons.customSendKeys(registrationPage.cityInput, userCity);
        logger.info(String.format("User chosen city: \"%S\"", userCity));

        //ASSERT//
        Assert.assertEquals(registrationPage.cityInput.getAttribute("value").toLowerCase(),
                userCity.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose state")
    @And("I choose state")
    public void iChooseState() throws Throwable {
        //ARRANGE//
        final String userState = faker.address().state();

        //ACT
        testCommons.selectFromDropdownByText(userState, registrationPage.stateDropDown);
        logger.info(String.format("User chosen state: \"%S\"", userState));

        //ASSERT//
        Assert.assertEquals(registrationPage.readStateDropdown.getText().toLowerCase(),
                userState.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write postal code")
    @And("I write postal code")
    public void iWritePostalCode() throws Throwable {
        //ARRANGE//
        final String userPostalCode = StringUtils.left(faker.address().zipCode(), 5);

        //ACT//
        testCommons.customSendKeys(registrationPage.postalCodeInput, userPostalCode);
        logger.info(String.format("User postal code: \"%S\"", userPostalCode));

        //ASSERT//
        Assert.assertEquals(registrationPage.postalCodeInput.getAttribute("value").toLowerCase(),
                userPostalCode.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write additional information")
    @And("I write additional information")
    public void iWriteAdditionalInformation() throws Throwable {
        //ARRANGE//
        final String userAdditionalInformation = faker.chuckNorris().fact();

        //ACT//
        testCommons.customSendKeys(registrationPage.additionalInformationBox, userAdditionalInformation);
        logger.info(String.format("User additional information: \"%S\"", userAdditionalInformation));

        //ASSERT//
        Assert.assertEquals(registrationPage.additionalInformationBox.getAttribute("value").toLowerCase(),
                userAdditionalInformation.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write home phone")
    @And("I write home phone")
    public void iWriteHomePhone() throws Throwable {
        //ARRANGE//
        final String userPhoneNumber = faker.phoneNumber().cellPhone();

        //ACT//
        testCommons.customSendKeys(registrationPage.homePhoneInput, userPhoneNumber);
        logger.info(String.format("User phone number: \"%S\"", userPhoneNumber));

        //ASSERT//
        Assert.assertEquals(registrationPage.homePhoneInput.getAttribute("value").toLowerCase(),
                userPhoneNumber.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write mobile phone")
    @And("I write mobile phone")
    public void iWriteMobilePhone() throws Throwable {
        //ARRANGE//
        final String userMobilePhone = faker.phoneNumber().cellPhone();

        //ACT//
        testCommons.customSendKeys(registrationPage.mobilePhoneInput, userMobilePhone);
        logger.info(String.format("User mobile phone number: \"%S\"", userMobilePhone));

        //ARRANGE//
        Assert.assertEquals(registrationPage.mobilePhoneInput.getAttribute("value").toLowerCase(),
                userMobilePhone.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write my address alias")
    @And("I write my address alias")
    public void iWriteMyAddressAlias() throws Throwable {
        //ARRANGE//
        final String userAddressAlias = mockNeat.emails().val();

        //ACT//
        registrationPage.addressAliasInput.clear();
        testCommons.customSendKeys(registrationPage.addressAliasInput, userAddressAlias);
        logger.info(String.format("User alias: \"%S\"", userAddressAlias));

        //ASSERT//
        Assert.assertEquals(registrationPage.addressAliasInput.getAttribute("value").toLowerCase(),
                userAddressAlias.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I clear my email address alias")
    @And("I clear my email address alias")
    public void iClearMyEmailAddressAlias() throws Throwable {
        testCommons.customClick(registrationPage.addressAliasInput);
        registrationPage.addressAliasInput.clear();
    }

    @Step("I click on Register button")
    @And("I click on Register button")
    public void iClickOnRegisterButton() throws Throwable {
        testCommons.customClick(registrationPage.registerButton);
    }

    @Step("I can see welcome message")
    @Then("I can see welcome message")
    public void iCanSeeWelcomeMessage() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(accountDetailsPage.myAccountDetailsDashboard));
        Assert.assertEquals(accountDetailsPage.myAccountDetailsDashboard.getText().toLowerCase(),
                ContextInjection.WELCOME_MESSAGE.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I can see create an account error")
    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(authenticationPage.createAnAccountError),
                String.format(ContextInjection.VIEW_ERROR, "Create an account error header"));
    }

    @Step("I can see registration error")
    @Then("I can see registration error")
    public void iCanSeeRegistrationError() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(registrationPage.registerError),
                String.format(ContextInjection.VIEW_ERROR, "Registration error header"));
    }

    @Step("I can see warning message about missing *{0}* input")
    @Then("I can see warning message about missing {string} input")
    public void iCanSeeWarningMessageAboutMissingInput(String stringName) throws Throwable {
        switch (stringName.toLowerCase()) {
            case "first name":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-FirstName").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-FirstName")));
                break;
            case "last name":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-LastName").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-LastName")));
                break;
            case "email address":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Email").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Email")));
                break;
            case "password":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Password").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Password")));
                break;
            case "address":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Address").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Address")));
                break;
            case "city":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-City").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-City")));
                break;
            case "state":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-State").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-State")));
                break;
            case "postal code":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-PostalCode").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-PostalCode")));
                break;
            case "country":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Country").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-Country")));
                break;
            case "mobile phone":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-MobilePhone").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-MobilePhone")));
                break;
            case "email address alias":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-EmailAlias").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-EmailAlias")));
                break;
            case "one element":
                Assert.assertTrue(registrationPage.registerError.getText().toLowerCase().contains
                        (RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-oneError").toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, RESOURCE_BUNDLE_ERROR_MESSAGES.getString("error-oneError")));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, stringName.toUpperCase()));
        }
    }
}