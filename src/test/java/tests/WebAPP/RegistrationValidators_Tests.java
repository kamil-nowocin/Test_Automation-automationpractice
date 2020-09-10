package tests.WebAPP;

import com.buildListeners.TestNGListener;
import com.buildSettings.ContextInjection;
import com.buildSettings.ExcelEnvironment;
import com.steps.MainPageSteps;
import com.steps.RegistrationPageSteps;
import com.steps.hooks.WEB_Hooks;
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
@Listeners({TestNGListener.class})
public class RegistrationValidators_Tests extends WEB_Hooks {

    @Issue("TAP-0020")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[1] As a user I would like to see registration error, when I don't fill first name input")
    @Test(description = "[US-444]/[1] I would like to see registration error, when I don't fill first name input",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(20);

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

    @Issue("TAP-0021")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[2] As a user I would like to see registration error, when I don't fill last name input")
    @Test(description = "[US-444]/[2] I would like to see registration error, when I don't fill last name input",
            priority = 0)
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(21);

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

    @Issue("TAP-0022")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[3] As a user I would like to see registration error, when I don't fill email input")
    @Test(description = "[US-444]/[3] I would like to see registration error, when I don't fill email input",
            priority = 0)
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(22);

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

    @Issue("TAP-0023")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[4] As a user I would like to see registration error, when I don't fill password input")
    @Test(description = "[US-444]/[4] I would like to see registration error, when I don't fill password input",
            priority = 0)
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(23);

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

    @Issue("TAP-0024")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[5] As a user I would like to see registration error, when I don't fill address input")
    @Test(description = "[US-444]/[5] I would like to see registration error, when I don't fill address input",
            priority = 0)
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(24);

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

    @Issue("TAP-0025")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[6] As a user I would like to see registration error, when I don't fill city input")
    @Test(description = "[US-444]/[6] I would like to see registration error, when I don't fill city input",
            priority = 0)
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(25);

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

    @Issue("TAP-0026")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[7] As a user I would like to see registration error, when I don't fill state input")
    @Test(description = "[US-444]/[7] I would like to see registration error, when I don't fill state input",
            priority = 0)
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(26);

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

    @Issue("TAP-0027")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[8] As a user I would like to see registration error, when I don't fill postal code input")
    @Test(description = "[US-444]/[8] I would like to see registration error, when I don't fill postal code input",
            priority = 0)
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(27);

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

    @Issue("TAP-0028")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[9] As a user I would like to see registration error, when I don't fill country input")
    @Test(description = "[US-444]/[9] I would like to see registration error, when I don't fill country input",
            priority = 0)
    public void test_9() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(28);

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

    @Issue("TAP-0029")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[10] As a user I would like to see registration error, when I don't fill mobile phone input")
    @Test(description = "[US-444]/[10] I would like to see registration error, when I don't fill mobile phone input",
            priority = 0)
    public void test_10() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(29);

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

    @Issue("TAP-0030")
    @TmsLink("STORY-444")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-444]/[11] As a user I would like to see registration error, when I don't fill email alias input")
    @Test(description = "[US-444]/[11] I would like to see registration error, when I don't fill email alias input",
            priority = 0)
    public void test_11() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        excelEnvironment.saveTestResultsXLSX(30);

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