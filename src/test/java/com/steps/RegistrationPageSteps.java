package com.steps;

import com.FrameworkEnvironment;
import com.pages.RegistrationPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class RegistrationPageSteps extends FrameworkEnvironment {

    private BasePage basePage = new BasePage();
    private RegistrationPage registrationPage = new RegistrationPage();

    @Step("I click on Sign in button")
    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws Throwable {
        registrationPage.signInButton.click();
    }

    @Step("I write an email address")
    @When("I write an email address")
    public void iWriteAnEmailAddress() throws Throwable {
        //ARRANGE//
        final String userValidEmailAddress = tempEmail;

        //ACT//
        registrationPage.emailInput.sendKeys(userValidEmailAddress);
        logger.info(String.format("User valid email: %S", userValidEmailAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.emailInput.getAttribute("value").toLowerCase(),
                userValidEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an invalid email address")
    @When("I write an invalid email address")
    public void iWriteAnInvalidEmailAddress() throws Throwable {
        //ARRANGE//
        final String userInvalidEmailAddress = basePage.getRandomElementFromResourceBundleList
                (resourceBundleInvalidEmails.getString("invalidEmails"));

        //ACT//
        registrationPage.emailInput.sendKeys(userInvalidEmailAddress);
        logger.info(String.format("User invalid email: %S", userInvalidEmailAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.emailInput.getAttribute("value").toLowerCase(),
                userInvalidEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an email address which is already in database")
    @When("I write an email address which is already in database")
    public void iWriteAnEmailAddressWhichIsAlreadyInDatabase() throws Throwable {
        //ARRANGE//
        final String userRegisteredEmailAddress = "asfsafas@wp.pl";

        //ACT//
        registrationPage.emailInput.sendKeys(userRegisteredEmailAddress);
        logger.info(String.format("User registered email: %S", userRegisteredEmailAddress));

        //ASSERT//
        Assert.assertEquals(registrationPage.emailInput.getAttribute("value").toLowerCase(),
                userRegisteredEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on Create An Account button")
    @And("I click on Create An Account button")
    public void iClickOnCreateAnAccountButton() throws Throwable {
        registrationPage.createAnAccountButton.click();
    }

    @Step("I can see registration page form")
    @Then("I can see registration page form")
    public void iCanSeeRegistrationPageForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAccountBox),
                String.format(VIEW_ERROR, "Registration page form"));
    }

    @Step("I write following data to registration form")
    @And("I write following data to registration form")
    public RegistrationPageSteps iWriteFollowingDataToRegistrationForm(DataTable dataTable) throws Throwable {
        //ARRANGE//
        List<List<String>> data = dataTable.asLists();
        //(data.get(Row).get(Column))//

        registrationPage.firstNameInput.sendKeys(data.get(1).get(0));
        Assert.assertEquals(registrationPage.firstNameInput.getAttribute("value").toLowerCase(),
                data.get(1).get(0).toLowerCase(), VALUE_ERROR);

        registrationPage.lastNameInput.sendKeys(data.get(1).get(1));
        Assert.assertEquals(registrationPage.lastNameInput.getAttribute("value").toLowerCase(),
                data.get(1).get(1).toLowerCase(), VALUE_ERROR);

        registrationPage.passwordInput.sendKeys(data.get(1).get(2));
        Assert.assertEquals(registrationPage.passwordInput.getAttribute("value").toLowerCase(),
                data.get(1).get(2).toLowerCase(), VALUE_ERROR);

        registrationPage.addressInput.sendKeys(data.get(1).get(3));
        Assert.assertEquals(registrationPage.addressInput.getAttribute("value").toLowerCase(),
                data.get(1).get(3).toLowerCase(), VALUE_ERROR);

        registrationPage.cityInput.sendKeys(data.get(1).get(4));
        Assert.assertEquals(registrationPage.cityInput.getAttribute("value").toLowerCase(),
                data.get(1).get(4).toLowerCase(), VALUE_ERROR);

        registrationPage.stateDropDown.sendKeys(data.get(1).get(5));
        Assert.assertEquals(registrationPage.chosenStateFromDropdown.getText().toLowerCase(),
                data.get(1).get(5).toLowerCase(), VALUE_ERROR);

        registrationPage.postalCodeInput.sendKeys(data.get(1).get(6));
        Assert.assertEquals(registrationPage.postalCodeInput.getAttribute("value").toLowerCase(),
                data.get(1).get(6).toLowerCase(), VALUE_ERROR);

        registrationPage.countryDropDown.sendKeys(data.get(1).get(7));
        Assert.assertEquals(registrationPage.chosenCountryFromDropdown.getText().toLowerCase(),
                data.get(1).get(7).toLowerCase(), VALUE_ERROR);

        registrationPage.mobilePhoneInput.sendKeys(data.get(1).get(8));
        Assert.assertEquals(registrationPage.mobilePhoneInput.getAttribute("value").toLowerCase(),
                data.get(1).get(8).toLowerCase(), VALUE_ERROR);
        return this;
    }

    @Step("I choose gender")
    @And("I choose gender")
    public void iChooseGender() throws Throwable {
        //ARRANGE//
        final int randomNumber = basePage.randomValue(2, 1);

        //ACT//
        if (randomNumber == 1) {
            registrationPage.mrButton.click();
            logger.info("Chosen gender: Male");

            //ASSERT//
            Assert.assertTrue(registrationPage.mrButton.isSelected());
        } else {
            registrationPage.mrsButton.click();
            logger.info("Chosen gender: Female");

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
        Assert.assertEquals(registrationPage.emailSecondInput.getAttribute("value").toLowerCase(),
                tempEmail.toLowerCase(), VALUE_ERROR);
    }

    @Step("I clear my email address")
    @And("I clear my email address")
    public void iClearMyEmailAddress() throws Throwable {
        registrationPage.emailSecondInput.clear();
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
        final int day = basePage.randomValue(28, 1);
        final int month = basePage.randomValue(12, 1);
        final int year = basePage.randomValue(2019, 1900);

        //ACT//
        registrationPage.selectFromDropdownByValue(Integer.toString(day), registrationPage.dayOfBirth);
        registrationPage.selectFromDropdownByValue(Integer.toString(month), registrationPage.monthOfBirth);
        registrationPage.selectFromDropdownByValue(Integer.toString(year), registrationPage.yearOfBirth);
        logger.info(String.format("User birthday: %d-%d-%d ", day, month, year));

        //ASSERT//
        //{TODO}
    }

    @Step("I sign in to receive newsletter and special offers")
    @And("I sign in to receive newsletter and special offers")
    public void iSignInToReceiveNewsletterAndSpecialOffers() throws Throwable {
        //ARRANGE//
        int tempRandomValue = basePage.randomValue(3, 1);

        //ACT//
        if (tempRandomValue == 1) {
            registrationPage.newsletterCheckbox.click();
            logger.info("Signed to receive newsletter");

            //ASSERT//
            Assert.assertTrue(registrationPage.newsletterCheckbox.isSelected());
        } else if (tempRandomValue == 2) {
            registrationPage.specialOffersCheckbox.click();
            logger.info("Signed to receive special offers");

            //ASSERT//
            Assert.assertTrue(registrationPage.specialOffersCheckbox.isSelected());
        } else {
            registrationPage.newsletterCheckbox.click();
            registrationPage.specialOffersCheckbox.click();
            logger.info("Signed to newsletter & special offers");

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
        logger.info(String.format("Company name: %S", companyName));

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
        logger.info(String.format("User address: %S and %S", userAddress, userSecondAddress));

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

    @Step("I choose country {0}")
    @And("I choose country {string}")
    public void iChooseCountry(String country) throws Throwable {
        //ACT//
        basePage.selectFromDropdownByText(country, registrationPage.countryDropDown);
        logger.info(String.format("Chosen country: %S", country));

        //ASSERT//
        Assert.assertEquals(registrationPage.chosenCountryFromDropdown.getText().toLowerCase(),
                country.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write city name")
    @And("I write city name")
    public void iWriteCityName() throws Throwable {
        //ARRANGE//
        final String userCity = mockNeat.cities().us().val();

        //ACT//
        registrationPage.cityInput.sendKeys(userCity);
        logger.info(String.format("City name: %S", userCity));

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
        logger.info(String.format("State name: %S", userState));

        //ASSERT//
        Assert.assertEquals(registrationPage.chosenStateFromDropdown.getText().toLowerCase(),
                userState.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write postal code")
    @And("I write postal code")
    public void iWritePostalCode() throws Throwable {
        //ARRANGE//
        final String userPostalCode = StringUtils.left(faker.address().zipCode(), 5);

        //ACT//
        registrationPage.postalCodeInput.sendKeys(userPostalCode);
        logger.info(String.format("Postal code: %S", userPostalCode));

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
        logger.info(String.format("Additional information: %S", userAdditionalInformation));

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
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.myAccountDashboard));
        Assert.assertEquals(registrationPage.myAccountDashboard.getText().toLowerCase(),
                WELCOME_MESSAGE.toLowerCase(), VALUE_ERROR);
    }

    @Step("I can see create an account error")
    @Then("I can see create an account error")
    public void iCanSeeCreateAnAccountError() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.createAnAccountError),
                String.format(VIEW_ERROR, "create an account error"));
    }

    @Step("I can see registration error")
    @Then("I can see registration error")
    public void iCanSeeRegistrationError() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, registrationPage.registerError),
                String.format(VIEW_ERROR, "registration error"));
    }

    @Step("I can see warning message about missing {0} input")
    @Then("I can see warning message about missing {string} input")
    public void iCanSeeWarningMessageAboutMissingFInput(String stringName) throws Throwable {
        switch (stringName.toLowerCase()) {
            case "first name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorfirstname").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorfirstname")));
                break;
            case "last name":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorlastname").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorlastname")));
                break;
            case "email address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("erroremail").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("erroremail")));
                break;
            case "password":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorpassword").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorpassword")));
                break;
            case "address":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("erroraddress").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("erroraddress")));
                break;
            case "city":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorcity").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorcity")));
                break;
            case "state":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorstate").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorstate")));
                break;
            case "postal code":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorpostalcode").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorpostalcode")));
                break;
            case "country":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errorcountry").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errorcountry")));
                break;
            case "mobile phone":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("errormobilephone").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("errormobilephone")));
                break;
            case "email address alias":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("erroremailalias").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("erroremailalias")));
                break;
            case "one element":
                Assert.assertTrue(basePage.errorValidator(registrationPage.registerError).toLowerCase().contains
                                (resourceBundleErrorMessages.getString("oneerror").toLowerCase()),
                        String.format(MESSAGE_DIDNT_CONTAIN, resourceBundleErrorMessages.getString("oneerror")));
                break;
            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, stringName.toUpperCase()));
        }
    }
}