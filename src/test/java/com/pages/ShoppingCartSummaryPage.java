package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class ShoppingCartSummaryPage extends BasePage {

    /**
     * GLOBAL
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//span[@class='navigation_page']")
    public WebElement navigationTopLabelHeader;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'Proceed to checkout')]//i[@class='icon-chevron-right right'])[2]")
    public WebElement proceedToCheckoutButton;

    @FindBy(how = How.XPATH, using = "//button[@class='button btn btn-default button-medium']//span")
    public WebElement iConfirmMyOrderButton;

    /**
     * YOUR SHOPPING CART
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//td[@class='cart_description']//p[@class='product-name']//a")
    public WebElement productName;

    @FindBy(how = How.XPATH, using = "//span[@class='price']//span[@class='price']")
    public WebElement productUnitPrice;

    @FindBy(how = How.XPATH, using = "//input[@class='cart_quantity_input form-control grey']")
    public WebElement productQuantity;

    @FindBy(how = How.XPATH, using = "//td[@class='cart_total']//span[@class='price']")
    public WebElement productTotalPrice;

    @FindBy(how = How.XPATH, using = "//span[@id='total_price']")
    public WebElement productTotalOrderPriceTAX;

    /**
     * ADDRESSES
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    public WebElement customerFirstLastName;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_company']")
    public WebElement customerCompanyName;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2']")
    public WebElement customerAddress;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
    public WebElement customerCity;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_country_name']")
    public WebElement customerCountry;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_phone_mobile']")
    public WebElement customerMobilePhone;

    @FindBy(how = How.XPATH, using = "//textarea[@name='message']")
    public WebElement orderComment;

    /**
     * SHIPPING
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//td[@class='delivery_option_radio']//input")
    public WebElement myCarrierRadioButton;

    @FindBy(how = How.XPATH, using = "//div[@class='delivery_option_price']")
    public WebElement readMyCarrierPrice;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.XPATH, using = "//input[@name='cgv']")
    public WebElement tosCheckbox;

    /**
     * YOUR PAYMENT METHOD
     **/
    @FindBy(how = How.XPATH, using = "//a[@class='bankwire']")
    public WebElement bankWirePaymentBox;

    @FindBy(how = How.XPATH, using = "//a[@class='cheque']")
    public WebElement chequePaymentBox;

    /**
     * Order confirmation
     **/
    //VIEW//
    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    public WebElement paymentByCheckSuccessful;

    @FindBy(how = How.XPATH, using = "//p[@class='cheque-indent']//strong")
    public WebElement paymentByBankWireSuccessful;
}