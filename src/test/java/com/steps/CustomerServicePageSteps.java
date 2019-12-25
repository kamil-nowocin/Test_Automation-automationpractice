package com.steps;

import com.DriverFactory;
import com.pages.CustomerServicePage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.File;
import java.nio.file.Paths;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Listeners({Hooks.class})
public class CustomerServicePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private CustomerServicePage customerServicePage = new CustomerServicePage(driver);

    @Step("I click on Contact Us button")
    @When("I click on Contact Us button")
    public void iClickOnContactUsButton() throws Throwable {
        customerServicePage.contactUsButton.click();
    }

    @Step("I can see Contact Us form")
    @Then("I can see Contact Us form")
    public void iCanSeeContactUsForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, customerServicePage.contactUsForm),
                String.format(VIEW_ERROR, "Contact Us form"));
    }

    @Step("I am on Customer Service Contact Us page form")
    @Given("I am on Customer Service Contact Us page form")
    public void iAmOnCustomerServiceContactUsPageForm() throws Throwable {
        Assert.assertTrue(basePage.isDisplayed(10, customerServicePage.contactUsHeader),
                String.format(VIEW_ERROR, "Customer Service Contact Us page form"));
    }

    @Step("I choose Subject Heading")
    @When("I choose Subject Heading")
    public void iChooseSubjectHeading() throws Throwable {
        //ARRANGE//
        final String subjectHeading = "Customer service";

        //ACT//
        basePage.selectFromDropdownByText(subjectHeading, customerServicePage.subjectHeadingDropdown);

        //ASSERT//
        Assert.assertEquals(customerServicePage.chosenSubjectHeadingFromDropdown.getText().toLowerCase(),
                subjectHeading.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an email address in contact us page")
    @And("I write an email address in contact us page")
    public void iWriteAnEmailAddressInContactUsPage() throws Throwable {
        //ARRANGE//
        final String userEmailAddress = mockNeat.emails().val();

        //ACT//
        customerServicePage.emailAddressInput.sendKeys(userEmailAddress);

        //ASSERT//
        Assert.assertEquals(customerServicePage.emailAddressInput.getAttribute("value").toLowerCase(),
                userEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write an invalid email address in contact us page")
    @And("I write an invalid email address in contact us page")
    public void iWriteAnInvalidEmailAddressInContactUsPage() throws Throwable {
        //ARRANGE//
        final String userEmailAddress = resourceBundleInvalidEmails.getString
                ("invalid" + basePage.randomValue(6, 1));

        //ACT//
        customerServicePage.emailAddressInput.sendKeys(userEmailAddress);

        //ARRANGE//
        Assert.assertEquals(customerServicePage.emailAddressInput.getAttribute("value").toLowerCase(),
                userEmailAddress.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write order reference")
    @And("I write order reference")
    public void iWriteOrderReference() throws Throwable {
        //ARRANGE//
        final String orderReference = basePage.randomString(10);

        //ACT//
        customerServicePage.orderReferenceInput.sendKeys(orderReference);

        //ASSERT//
        Assert.assertEquals(customerServicePage.orderReferenceInput.getAttribute("value").toLowerCase(),
                orderReference.toLowerCase(), VALUE_ERROR);
    }

    @Step("I write message")
    @And("I write message")
    public void iWriteMessage() throws Throwable {
        //ARRANGE//
        final String message = faker.chuckNorris().fact();

        //ACT//
        customerServicePage.messageTextArea.sendKeys(message);

        //ASSERT//
        Assert.assertEquals(customerServicePage.messageTextArea.getAttribute("value").toLowerCase(),
                message.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose file to attach")
    @And("I choose file to attach")
    public void iChooseFileToAttach() throws Throwable {
        //ARRANGE//
        final String fileName = "test.jpg";
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        String path = currentPath
                + File.separator
                + "src"
                + File.separator
                + "test"
                + File.separator
                + "resources"
                + File.separator;
        path += fileName;

        //ACT//
        customerServicePage.attachFileInput.sendKeys(path);

        //ASSERT//
        Assert.assertEquals(customerServicePage.chosenFileName.getText().toLowerCase(),
                fileName.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click Send button")
    @Then("I click Send button")
    public void iClickSendButton() throws Throwable {
        customerServicePage.sendButton.click();
    }


    @Step("I can see success message {0}")
    @And("I can see success message {string}")
    public void iCanSeeSuccessMessage(String successMessage) throws Throwable {
        Assert.assertTrue(customerServicePage.contactUsSuccessMessage.getText().toLowerCase().contains
                (successMessage.toLowerCase()), String.format(MESSAGE_DIDNT_CONTAIN, successMessage.toUpperCase()));
    }

    @Step("I can see error message {0}")
    @And("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) throws Throwable {
        Assert.assertTrue(customerServicePage.contactUsErrorMessage.getText().toLowerCase().contains
                (errorMessage.toLowerCase()), String.format(MESSAGE_DIDNT_CONTAIN, errorMessage.toUpperCase()));
    }

    @Step("I don't choose Subject Heading")
    @When("I don't choose Subject Heading")
    public void iDonTChooseSubjectHeading() throws Throwable {
        ;
    }

    @Step("I don't write an email address")
    @And("I don't write an email address")
    public void iDonTWriteAnEmailAddress() throws Throwable {
        ;
    }

    @Step("I don't write message")
    @And("I don't write message")
    public void iDonTWriteMessage() throws Throwable {
        ;
    }
}