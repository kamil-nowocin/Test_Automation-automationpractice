package tests.APP;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.CustomerServicePageSteps;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("CUSTOMER SERVICE TESTS")
@Listeners({TestNGListener_WEB.class})
public class CustomerService_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am able to send request via contact us form, all inputs are filled up")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, all inputs are filled up")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0005")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(5);


        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iWriteAnEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeSuccessMessage("Your message has been successfully sent to our team.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am able to send request via contact us form, all required inputs are filled up")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, all required inputs are filled up")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0006")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(6);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iWriteAnEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeSuccessMessage("Your message has been successfully sent to our team.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am able to send request via contact us form witch attached file")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form witch attached file")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-0007")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(7);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iWriteAnEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iChooseFileToAttach();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeSuccessMessage("Your message has been successfully sent to our team.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am not able to send request via contact us form, email input is invalid")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, email input is invalid")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0008")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(8);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iWriteAnInvalidEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iChooseFileToAttach();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("Invalid email address.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am not able to send request via contact us form, subject is missing")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, subject is missing")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0009")
    @Story("NEGATIVE FLOW")
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(9);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iDonTChooseSubjectHeading();
        customerServicePageSteps.iWriteAnEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iChooseFileToAttach();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("Please select a subject from the list provided.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am not able to send request via contact us form, email address is missing")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, email address is missing")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0010")
    @Story("NEGATIVE FLOW")
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(10);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iDonTWriteAnEmailAddress();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iChooseFileToAttach();
        customerServicePageSteps.iWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("Invalid email address.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am not able to send request via contact us form, message input is missing")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, message input is missing")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0011")
    @Story("NEGATIVE FLOW")
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(11);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading("Customer service");
        customerServicePageSteps.iWriteAnEmailAddressInContactUsPage();
        customerServicePageSteps.iWriteOrderReference();
        customerServicePageSteps.iChooseFileToAttach();
        customerServicePageSteps.iDonTWriteMessage();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("The message cannot be blank.");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am not able to send request via contact us form, all inputs are missing")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, all inputs are missing")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0012")
    @Story("NEGATIVE FLOW")
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(12);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("Invalid email address.");
    }
}