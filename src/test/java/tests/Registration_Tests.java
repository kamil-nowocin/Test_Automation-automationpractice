package tests;

import com.listeners.TestNGListener_WEB;
import com.pages.base.BasePage;
import com.steps.BasePageSteps;
import com.steps.Hooks;
import com.steps.RegistrationPageSteps;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.*;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Regression Tests")
@Feature("REGISTRATION TESTS")
@Listeners({TestNGListener_WEB.class})
public class Registration_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I check availability of registration page form")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I am checking availability of registration page form")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("TAP-013")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeAccountCreationPageForm();
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 1, dependsOnMethods = {"test_1"},
            description = "I can create an account by filling up all fields")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can create an account by filling up all fields")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-014")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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

    @Owner("Kamil Nowocin")
    @Test(priority = 1,
            description = "I can create an account by filling up only required fields")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can create an account by filling up only required fields")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("TAP-015")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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

    @Owner("Kamil Nowocin")
    @Test(priority = 1,
            description = "I can't create an account without filling up fields")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can't create an account without filling up fields")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-016")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 1,
            description = "I can't create an account, when one of required fields is missing")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can't create an account, when one of required fields is missing")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-017")
    @Story("NEGATIVE FLOW")
    public void test_5() throws Throwable {
        //ARRANGE//
        List<List<String>> infoInTheRaw = Arrays.asList
                (
                        Arrays.asList("First Name", "Last Name", "Password", "Address", "City", "State", "Postal Code", "Country", "Mobile Phone"),
                        Arrays.asList("Thor", "Odinson", "#Passwd123", "", "City", "Alaska", "99503", "United States", "700-800-900")
                );
        DataTable dataTable = DataTable.create(infoInTheRaw);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();
        registrationPageSteps.iWriteFollowingDataToRegistrationForm(dataTable);
        registrationPageSteps.iCheckIfEmailIsAlreadyWrittenAndValid();
        registrationPageSteps.iCheckIfMyFirstLastNameAreAlreadyWrittenAndAreCorrect();
        registrationPageSteps.iWriteMyAddressAlias();
        registrationPageSteps.iClickOnRegisterButton();

        //ASSERT//
        registrationPageSteps.iCanSeeWarningMessageAboutMissingInput("one element");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 1,
            description = "I can't create an account, when email is already in database")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can't create an account, when email is already in database")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-018")
    @Story("NEGATIVE FLOW")
    public void test_6() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnEmailAddressWhichIsAlreadyInDatabase();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 1,
            description = "I can't create an account, when email has wrong format")
    @Description("As a user I would like to register into automationpractice.com ->\n" +
            "I can't create an account, when email has wrong format")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-019")
    @Story("NEGATIVE FLOW")
    public void test_7() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        registrationPageSteps.iClickOnSignInButton();
        registrationPageSteps.iCanSeeRegistrationPageForm();
        registrationPageSteps.iWriteAnInvalidEmailAddress();
        registrationPageSteps.iClickOnCreateAnAccountButton();

        //ASSERT//
        registrationPageSteps.iCanSeeRegistrationError();
    }
}