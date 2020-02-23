package tests;

import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.BasePageSteps;
import com.steps.CustomerServicePageSteps;
import com.steps.Hooks;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Regression Tests")
@Feature("CUSTOMER SERVICE TESTS")
@Listeners({TestNGListener_WEB.class})
public class CustomerService_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I am able to send request via contact us form, all inputs are filled up")
    @Description("As a user I would like to contact with customer service support ->\n" +
            "I will send request via contact us form, all inputs are filled up")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-001")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(1);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Issue("TAP-002")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(2);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-003")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(3);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Issue("TAP-004")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(4);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Issue("TAP-005")
    @Story("NEGATIVE FLOW")
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(5);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
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
    @Issue("TAP-006")
    @Story("NEGATIVE FLOW")
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(6);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Issue("TAP-007")
    @Story("NEGATIVE FLOW")
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(7);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iChooseSubjectHeading();
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
    @Issue("TAP-008")
    @Story("NEGATIVE FLOW")
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(8);
        final BasePageSteps basePageSteps = new BasePageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        //ACT//
        basePageSteps.iOpenHomePage();
        basePageSteps.iCanSeeAutomationpracticeComWebsite();
        customerServicePageSteps.iClickOnContactUsButton();
        customerServicePageSteps.iCanSeeContactUsForm();
        customerServicePageSteps.iAmOnCustomerServiceContactUsPageForm();
        customerServicePageSteps.iClickSendButton();

        //ASSERT//
        customerServicePageSteps.iCanSeeErrorMessage("Invalid email address.");
    }
}