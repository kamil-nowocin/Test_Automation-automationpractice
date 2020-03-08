package com.steps;

import com.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class ShoppingSteps extends DriverFactory {

    @Step("I click on {string} button from content menu")
    @And("I click on {string} button from content menu")
    public void iClickOnButtonFromContentMenu(String category) throws Throwable {
        //ARRANGE//
        //ACT//
        //ASSERT//
        //TODO
    }

    @Step("I click on following product {string}")
    @And("I click on following product {string}")
    public void iClickOnFollowingProduct(String productName) throws Throwable {
        //ARRANGE//
        //ACT//
        //ASSERT//
        //TODO
    }

    @Step("I choose following details of my order")
    @And("I choose following details of my order")
    public void iChooseFollowingDetailsOfMyOrder() throws Throwable {
        //ARRANGE//
        //ACT//
        //ASSERT//
        //TODO
    }

    @Step("I click on Add To Cart button")
    @When("I click on Add To Cart button")
    public void iClickOnAddToCartButton() throws Throwable {
        //ARRANGE//
        //ACT//
        //ASSERT//
        //TODO
    }
}