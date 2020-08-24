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
    //TEST CASE RESULTS//
    public static int passedTestsAmount;
    public static int failedTestsAmount;

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
    public static final String DEFAULT_REGISTERED_EMAIL_ADDRESS =
            "asfsafas@wp.pl";
    public static final String DEFAULT_CUSTOMER_USER_NAME =
            "Thor Odinson";
    public static final String DEFAULT_CUSTOMER_FIRST_LAST_NAME =
            "Thor Odinson";
    public static final String DEFAULT_CUSTOMER_COMPANY_NAME =
            "Avengers";
    public static final String DEFAULT_CUSTOMER_ADDRESS =
            "Asgard";
    public static final String DEFAULT_CUSTOMER_COUNTRY =
            "United States";
    public static final String DEFAULT_CUSTOMER_MOBILE_PHONE =
            "600500400";

    //NAVIGATION MENU LABELS//
    public static final String LABEL_YOUR_SHOPPING_CART =
            "Your shopping cart";
    public static final String LABEL_ADDRESSES =
            "Addresses";
    public static final String LABEL_SHIPPING =
            "Shipping";
    public static final String LABEL_YOUR_PAYMENT_METHOD =
            "Your payment method";
    public static final String LABEL_ORDER_CONFIRMATION =
            "Order confirmation";

    //ORDER DATA//
    public static final double SHIPPING_PRICE = 2.00;
    public static final double TAX_VALUE = 0.04; //DIFFERENT STATES IN UNITED STATES HAVE DIFFERENT TAX VALUE

    //EXPECTED HEADERS//
    public static final String WELCOME_MESSAGE =
            "Welcome to your account. Here you can manage all of your personal information and orders.";

    //ASSERTION MESSAGES//
    public static final String PAGE_URL_DIDNT_CONTAIN =
            "Following page URL didn't contain expected URL %s.com!";
    public static final String MESSAGE_DIDNT_CONTAIN =
            "Warning message didn't contain \"%S\"!";
    public static final String PAGE_ERROR =
            "Page wasn't ready to execute tests!";
    public static final String RESULTS_ERROR =
            "Number of results which have been found didn't match expected number of results! \n Found: %S \n Expected: %S";
    public static final String SEARCH_ERROR =
            "Names of results which have been found didn't match expected names! ";
    public static final String SORTING_ERROR =
            "Results which have been found didn't match expected sorting result %S";
    public static final String VIEW_ERROR =
            "Element \"%S\" wasn't displayed!";
    public static final String INPUT_ERROR =
            "Invalid input type! \"%S\" is not supported!";
    public static final String VALUE_ERROR =
            "Value which have been found didn't match expected value!";
    public static final String _21VOID =
            "Ups, something went really bad! Even Michael Scofield couldn't have predicted that error! :)";
}