package com.buildSettings;

import io.cucumber.guice.ScenarioScoped;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@ScenarioScoped
public class ContextInjection {

    /**
     * DATA
     **/
    //GENERAL DATA//
    public String paymentType;
    public String generatedEmail;

    //PRODUCT DATA//
    public String productSize;
    public String productColor;
    public double productQuantity;
    public double productUnitPrice;

    //PRODUCT POPUP DATA//
    public String cartProductName;
    public double cartProductPrice;
    public double cartTotalProductsPrice;
    public double cartTotalPrice;

    //ORDER DATA//
    public double totalOrderPriceWithoutTax;
    public double totalOrderTax;
    public double totalOrderPriceWithTax;

    /**
     * DEFAULT DATA
     **/
    //CUSTOMER DATA//
    public static final String DEFAULT_REGISTERED_EMAIL_ADDRESS = "asfsafas@wp.pl";
    public static final String DEFAULT_CUSTOMER_USER_NAME = "Thor Odinson";
    public static final String DEFAULT_CUSTOMER_FIRST_LAST_NAME = "Thor Odinson";
    public static final String DEFAULT_CUSTOMER_COMPANY_NAME = "Avengers";
    public static final String DEFAULT_CUSTOMER_ADDRESS = "Asgard";
    public static final String DEFAULT_CUSTOMER_COUNTRY = "United States";
    public static final String DEFAULT_CUSTOMER_MOBILE_PHONE = "600500400";

    //NAVIGATION MENU LABELS//
    public static final String LABEL_YOUR_SHOPPING_CART = "Your shopping cart";
    public static final String LABEL_ADDRESSES = "Addresses";
    public static final String LABEL_SHIPPING = "Shipping";
    public static final String LABEL_YOUR_PAYMENT_METHOD = "Your payment method";
    public static final String LABEL_ORDER_CONFIRMATION = "Order confirmation";

    //ORDER DATA//
    public static final double SHIPPING_PRICE = 2.00;
    public static final double TAX_VALUE = 0.04;
}