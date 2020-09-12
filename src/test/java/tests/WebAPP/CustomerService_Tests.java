package tests.WebAPP;

import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.steps.CustomerServicePageSteps;
import com.steps.MainPageSteps;
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
@Feature("CUSTOMER SERVICE TESTS")
@Listeners({TestNGListener.class})
public class CustomerService_Tests extends WEB_Hooks {

    @Issue("TAP-0005")
    @TmsLink("STORY-222")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[1] As a user I am able to send request via contact us form, all inputs are filled up")
    @Test(description = "[US-222]/[1] I am able to send request via contact us form, all inputs are filled up",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(5);

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

    @Issue("TAP-0006")
    @TmsLink("STORY-222")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[2] As a user I am able to send request via contact us form, all required inputs are filled up")
    @Test(description = "[US-222]/[2] I am able to send request via contact us form, all required inputs are filled up",
            priority = 0)
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(6);

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

    @Issue("TAP-0007")
    @TmsLink("STORY-222")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-222]/[3] As a user I am able to send request via contact us form witch attached file")
    @Test(description = "[US-222]/[3] I am able to send request via contact us form witch attached file",
            priority = 0)
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(7);

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

    @Issue("TAP-0008")
    @TmsLink("STORY-222")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[4] As a user I am not able to send request via contact us form, email input is invalid")
    @Test(description = "[US-222]/[4] I am not able to send request via contact us form, email input is invalid",
            priority = 0)
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(8);

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

    @Issue("TAP-0009")
    @TmsLink("STORY-222")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[5] As a user I am not able to send request via contact us form, subject is missing")
    @Test(description = "[US-222]/[5] I am not able to send request via contact us form, subject is missing",
            priority = 0)
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(9);

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

    @Issue("TAP-0010")
    @TmsLink("STORY-222")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[6] As a user I am not able to send request via contact us form, email address is missing")
    @Test(description = "[US-222]/[6] I am not able to send request via contact us form, email address is missing",
            priority = 0)
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(10);

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

    @Issue("TAP-0011")
    @TmsLink("STORY-222")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[7] As a user I am not able to send request via contact us form, message input is missing")
    @Test(description = "[US-222]/[7] I am not able to send request via contact us form, message input is missing",
            priority = 0)
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(11);

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

    @Issue("TAP-0012")
    @TmsLink("STORY-222")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.NORMAL)
    @Description("[US-222]/[8] As a user I am not able to send request via contact us form, all inputs are missing")
    @Test(description = "[US-222]/[8] I am not able to send request via contact us form, all inputs are missing",
            priority = 0)
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final CustomerServicePageSteps customerServicePageSteps = new CustomerServicePageSteps();

        excelEnvironment.saveTestResultsXLSX(12);

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