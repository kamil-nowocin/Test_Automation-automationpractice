package tests.WebAPP;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import com.steps.RegistrationPageSteps;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("REGISTRATION TESTS")
@Listeners({TestNGListener_WEB.class})
public class Registration_Tests extends Hooks {

    @Issue("TAP-0013")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.BLOCKER)
    @Description("[US-333]/[1] As a user I check availability of registration page form")
    @Test(description = "[US-333]/[1] I check availability of registration page form",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(13);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeAccountCreationPageForm();
    }

    @Issue("TAP-0014")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-333]/[2] As a user I can create an account by filling up all fields")
    @Test(description = "[US-333]/[2] I can create an account by filling up all fields",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(14);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iChooseGender();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iCheckIfEmailIsAlreadyWrittenAndValid();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iChooseDateOfBirth();
        registrationPageSteps.iSignInToReceiveNewsletterAndSpecialOffers();
        registrationPageSteps.iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect();
        registrationPageSteps.iWriteCompanyName();
        registrationPageSteps.iWriteMyAddresses();
        registrationPageSteps.iChooseCountry("United States");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteAdditionalInformation();
        registrationPageSteps.iWriteHomePhone();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWelcomeMessage();
    }

    @Issue("TAP-0015")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-333]/[3] As a user I can create an account by filling up only required fields")
    @Test(description = "[US-333]/[3] I can create an account by filling up only required fields",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(15);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iWriteMyFirstName();
        registrationPageSteps.iWriteMyLastName();
        registrationPageSteps.iCheckIfEmailIsAlreadyWrittenAndValid();
        registrationPageSteps.iWritePassword();
        registrationPageSteps.iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect();
        registrationPageSteps.iWriteMyAddresses();
        registrationPageSteps.iChooseCountry("United States");
        registrationPageSteps.iWriteCityName();
        registrationPageSteps.iChooseState();
        registrationPageSteps.iWritePostalCode();
        registrationPageSteps.iWriteAdditionalInformation();
        registrationPageSteps.iWriteMobilePhone();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWelcomeMessage();
    }

    @Issue("TAP-0016")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("US-333]/[4] As a user I can't create an account without filling up fields")
    @Test(description = "US-333]/[4] I can't create an account without filling up fields",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(16);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }

    @Issue("TAP-0017")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-333]/[5] As a user I can't create an account, when one of required fields is missing")
    @Test(description = "[US-333]/[5] I can't create an account, when one of required fields is missing",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(17);
        List<List<String>> registrationDetails = Arrays.asList
                (
                        Arrays.asList("First Name", "Last Name", "Password", "Address", "City", "State", "Postal Code", "Country", "Mobile Phone"),
                        Arrays.asList("Thor", "Odinson", "#Passwd123", "", "City", "Alaska", "99503", "United States", "700-800-900")
                );
        DataTable registrationDetailsDataTable = DataTable.create(registrationDetails);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iWriteFollowingDataToRegistrationForm(registrationDetailsDataTable);
        registrationPageSteps.iCheckIfEmailIsAlreadyWrittenAndValid();
        registrationPageSteps.iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("one element");
    }

    @Issue("TAP-0018")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-333]/[6] As a user I can't create an account, when email is already in database")
    @Test(description = "[US-333]/[6] I can't create an account, when email is already in database",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(18);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddressWhichIsAlreadyInDatabase();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }

    @Issue("TAP-0019")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-333]/[7] As a user I can't create an account, when email has wrong format")
    @Test(description = "[US-333]/[7] I can't create an account, when email has wrong format",
            priority = 1, dependsOnMethods = {"test_1"})
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(19);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnInvalidEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }
}