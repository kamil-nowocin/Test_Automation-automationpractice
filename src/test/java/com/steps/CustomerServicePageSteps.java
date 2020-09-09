package com.steps;

import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.CustomerServicePage;
import com.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.File;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class CustomerServicePageSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final TestCommons testCommons = new TestCommons();
    private final CustomerServicePage customerServicePage = new CustomerServicePage().get();

    @Step("I click on Contact Us button")
    @When("I click on Contact Us button")
    public void iClickOnContactUsButton() throws Throwable {
        testCommons.customClick(mainPage.contactUsButton);
    }

    @Step("I can see Contact Us form")
    @Then("I can see Contact Us form")
    public void iCanSeeContactUsForm() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(customerServicePage.contactUsPane),
                String.format(ContextInjection.VIEW_ERROR, "Contact Us form"));
    }

    @Step("I am on Customer Service Contact Us page form")
    @Given("I am on Customer Service Contact Us page form")
    public void iAmOnCustomerServiceContactUsPageForm() throws Throwable {
        Assert.assertTrue(testCommons.isElementVisible(customerServicePage.contactUsHeader),
                String.format(ContextInjection.VIEW_ERROR, "Customer Service Contact Us page form"));
    }

    @Step("I choose Subject Heading *{0}*")
    @When("I choose Subject Heading {string}")
    public void iChooseSubjectHeading(String subjectHeading) throws Throwable {
        //ACT//
        testCommons.selectFromDropdownByText(subjectHeading, customerServicePage.subjectHeadingDropdown);
        logger.info(String.format("Chosen subject: \"%S\"", subjectHeading));

        //ASSERT//
        Assert.assertEquals(customerServicePage.readSubjectHeading.getText().toLowerCase(),
                subjectHeading.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write an email address in contact us page")
    @And("I write an email address in contact us page")
    public void iWriteAnEmailAddressInContactUsPage() throws Throwable {
        //ARRANGE//
        final String userValidEmailAddress = mockNeat.emails().val();

        //ACT//
        testCommons.customSendKeys(customerServicePage.emailAddressInput, userValidEmailAddress);
        logger.info(String.format("User valid email: \"%S\"", userValidEmailAddress));

        //ASSERT//
        Assert.assertEquals(customerServicePage.emailAddressInput.getAttribute("value").toLowerCase(),
                userValidEmailAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write an invalid email address in contact us page")
    @And("I write an invalid email address in contact us page")
    public void iWriteAnInvalidEmailAddressInContactUsPage() throws Throwable {
        //ARRANGE//
        final String userInvalidEmailAddress = testCommons.getRandomResourceBundleValue
                (RESOURCE_BUNDLE_INVALID_EMAILS.getString("invalidEmails"));

        //ACT//
        testCommons.customSendKeys(customerServicePage.emailAddressInput, userInvalidEmailAddress);
        logger.info(String.format("User invalid email: \"%S\"", userInvalidEmailAddress));

        //ASSERT//
        Assert.assertEquals(customerServicePage.emailAddressInput.getAttribute("value").toLowerCase(),
                userInvalidEmailAddress.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write order reference")
    @And("I write order reference")
    public void iWriteOrderReference() throws Throwable {
        //ARRANGE//
        final String orderReference = testCommons.getRandomStringValue(10);

        //ACT//
        testCommons.customSendKeys(customerServicePage.orderReferenceInput, orderReference);
        logger.info(String.format("Order reference: \"%S\"", orderReference));

        //ASSERT//
        Assert.assertEquals(customerServicePage.orderReferenceInput.getAttribute("value").toLowerCase(),
                orderReference.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I write message")
    @And("I write message")
    public void iWriteMessage() throws Throwable {
        //ARRANGE//
        final String message = faker.chuckNorris().fact();

        //ACT//
        testCommons.customSendKeys(customerServicePage.messageTextArea, message);
        logger.info(String.format("Message: \"%S\"", message));

        //ASSERT//
        Assert.assertEquals(customerServicePage.messageTextArea.getAttribute("value").toLowerCase(),
                message.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose file to attach")
    @And("I choose file to attach")
    public void iChooseFileToAttach() throws Throwable {
        //ARRANGE//
        final String fileName = "testPhoto.jpg";
        String path = getCurrentPath()
                + File.separator
                + "src"
                + File.separator
                + "test"
                + File.separator
                + "resources"
                + File.separator
                + "files"
                + File.separator
                + "images"
                + File.separator;
        path += fileName;

        //ACT//
        customerServicePage.attachFileInput.sendKeys(path);
        logger.info(String.format("Uploaded file name: \"%S\"", fileName));

        //ASSERT//
        Assert.assertEquals(customerServicePage.readFileName.getText().toLowerCase(), fileName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click Send button")
    @Then("I click Send button")
    public void iClickSendButton() throws Throwable {
        testCommons.customClick(customerServicePage.sendButton);
    }

    @Step("I can see success message *{0}*")
    @And("I can see success message {string}")
    public void iCanSeeSuccessMessage(String successMessage) throws Throwable {
        Assert.assertTrue(customerServicePage.contactUsSuccessMessage.getText().toLowerCase().contains
                (successMessage.toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, successMessage.toUpperCase()));
    }

    @Step("I can see error message *{0}*")
    @And("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) throws Throwable {
        Assert.assertTrue(customerServicePage.contactUsErrorMessage.getText().toLowerCase().contains
                (errorMessage.toLowerCase()), String.format(ContextInjection.MESSAGE_DIDNT_CONTAIN, errorMessage.toUpperCase()));
    }

    @Step("I don't choose Subject Heading")
    @When("I don't choose Subject Heading")
    public void iDonTChooseSubjectHeading() throws Throwable {
    }

    @Step("I don't write an email address")
    @And("I don't write an email address")
    public void iDonTWriteAnEmailAddress() throws Throwable {
    }

    @Step("I don't write message")
    @And("I don't write message")
    public void iDonTWriteMessage() throws Throwable {
    }
}