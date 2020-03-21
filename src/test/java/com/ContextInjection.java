package com;

import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@ScenarioScoped
public class ContextInjection {

    /**
     * DATA SETS
     **/
    public String generatedEmail;
    public String paymentType;

    public String productName;
    public String productSize;
    public String productColor;
    public double productQuantity;
    public double productUnitPrice;
    public double finalOrderTotalPrice;
    public double finalProductTotalPrice;

    /**
     * DEFAULT
     **/
    //CUSTOMER DATA//
    public final String defaultCustomerUserName = "Thor Odinson";
    public final String defaultCustomerFirstLastName = "Thor Odinson";
    public final String defaultCustomerCompanyName = "Avengers";
    public final String defaultCustomerAddress = "Asgard";
    public final String defaultCustomerCountry = "United States";
    public final String defaultCustomerMobilePhone = "600500400";

    //NAVIGATION MENU LABELS//
    public final String yourShoppingCart = "Your shopping cart";
    public final String addresses = "Addresses";
    public final String shipping = "Shipping";
    public final String yourPaymentMethod = "Your payment method";
    public final String orderConfirmation = "Order confirmation";

    //ORDER DATA//
    public final double SHIPPING_PRICE = 2.00;
    public final double TAX_VALUE = 0;
}