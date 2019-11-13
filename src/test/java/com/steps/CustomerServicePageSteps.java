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

@Listeners({Hooks.class})
public class CustomerServicePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private CustomerServicePage customerServicePage = new CustomerServicePage(driver);

    @Step("I click on Contact Us button")
    @When("I click on Contact Us button")
    public void iClickOnContactUsButton() {
        customerServicePage.contactUsButton.click();
    }

    @Step("I can see Contact Us form")
    @Then("I can see Contact Us form")
    public void iCanSeeContactUsForm() {
        Assert.assertTrue(basePage.isDisplayed(10, customerServicePage.contactUsForm));
    }

    @Step("I am on Customer Service Contact Us page form")
    @Given("I am on Customer Service Contact Us page form")
    public void iAmOnCustomerServiceContactUsPageForm() {
        Assert.assertTrue(basePage.isDisplayed(10, customerServicePage.contactUsHeader));
    }

    @Step("I choose Subject Heading")
    @When("I choose Subject Heading")
    public void iChooseSubjectHeading() {
        basePage.selectFromDropdownByIntValue(1, customerServicePage.subjectHeadingDropdown);
    }

    @Step("I write an email address in contact us page")
    @And("I write an email address in contact us page")
    public void iWriteAnEmailAddressInContactUsPage() {
        customerServicePage.emailAddressInput.sendKeys(mockNeat.emails().val());
    }

    @Step("I write order reference")
    @And("I write order reference")
    public void iWriteOrderReference() {
        customerServicePage.orderReferenceInput.sendKeys(basePage.randomString(10));
    }

    @Step("I write message")
    @And("I write message")
    public void iWriteMessage() {
        customerServicePage.messageTextArea.sendKeys(faker.chuckNorris().fact());
    }

    @Step("I click Send button")
    @Then("I click Send button")
    public void iClickSendButton() {
        customerServicePage.sendButton.click();
    }

    @Step("I choose file to attach")
    @And("I choose file to attach")
    public void iChooseFileToAttach() {
        //ARRANGE
        String fileName = "test.jpg";
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

        //ACT
        customerServicePage.attachFileInput.sendKeys(path);

        //ASSERT
        Assert.assertTrue(customerServicePage.chosenFileName.getText().contains(fileName));
    }

    @Step("I write an invalid email address in contact us page")
    @And("I write an invalid email address in contact us page")
    public void iWriteAnInvalidEmailAddressInContactUsPage() {
        customerServicePage.emailAddressInput.sendKeys(resourceBundleInvalidEmails.getString("invalid" + basePage.randomValue(6, 1)));
    }

    @Step("I can see success message {string}")
    @And("I can see success message {string}")
    public void iCanSeeSuccessMessage(String successMessage) {
        Assert.assertTrue(customerServicePage.contactUsSuccessMessage.getText().contains(successMessage),
                MESSAGE_DIDNT_CONTAIN + successMessage);
    }

    @Step("I can see error message {string}")
    @And("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) {
        Assert.assertTrue(customerServicePage.contactUsErrorMessage.getText().contains(errorMessage),
                MESSAGE_DIDNT_CONTAIN + errorMessage);
    }

    @Step("I don't choose Subject Heading")
    @When("I don't choose Subject Heading")
    public void iDonTChooseSubjectHeading() {
        ;
    }

    @Step("I don't write an email address")
    @And("I don't write an email address")
    public void iDonTWriteAnEmailAddress() {
        ;
    }

    @Step("I don't write message")
    @And("I don't write message")
    public void iDonTWriteMessage() {
        ;
    }
}