package tests;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import com.steps.RegistrationPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("REGISTRATION VALIDATORS TESTS")
@Listeners({TestNGListener_WEB.class})
public class RegistrationValidators_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill first name input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill first name input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-020")
    @Story("NEGATIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(20);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("first name");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill last name input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill last name input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-021")
    @Story("NEGATIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(21);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("last name");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill email input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill email input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-022")
    @Story("NEGATIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(22);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iClearMyEmailAddress();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("email address");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill password input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill password input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-023")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(23);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("password");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill address input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill address input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-024")
    @Story("NEGATIVE FLOW")
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(24);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("address");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill city input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill city input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-025")
    @Story("NEGATIVE FLOW")
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(25);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("city");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill state input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill state input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-026")
    @Story("NEGATIVE FLOW")
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(26);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("state");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill postal code input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill postal code input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-027")
    @Story("NEGATIVE FLOW")
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(27);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("postal code");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill country input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill country input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-028")
    @Story("NEGATIVE FLOW")
    public void test_9() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(28);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("-");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("country");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill mobile phone input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill mobile phone input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-029")
    @Story("NEGATIVE FLOW")
    public void test_10() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(29);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("mobile phone");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill email alias address input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill email alias address input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-030")
    @Story("NEGATIVE FLOW")
    public void test_11() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(30);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iWriteMyAddress();
        registrationPageSteps.iChooseCountry("United states");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iClearMyEmailAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("email address alias");
    }
}