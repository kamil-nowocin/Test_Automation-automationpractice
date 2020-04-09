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

public class ProductDetailsPage extends BasePage {

    //VIEW//
    @FindBy(how = How.XPATH, using = "//span[@id='our_price_display']")
    public WebElement productPrice;

    @FindBy(how = How.XPATH, using = "//h1[@itemprop='name']")
    public WebElement productName;

    //POPUP//
    @FindBy(how = How.XPATH, using = "//div[@id='layer_cart']//div[@class='clearfix']")
    public WebElement popupPaneProductDetails;

    @FindBy(how = How.XPATH, using = "//div[@id='layer_cart']//div[@class='clearfix']//i[@class='icon-ok']//parent::h2")
    public WebElement popupPaneAddedSuccessfully;

    @FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_quantity']")
    public WebElement popupPaneQuantity;

    @FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_price']")
    public WebElement popupPaneFinalProductTotalPrice;

    @FindBy(how = How.XPATH, using = "//span[@class='ajax_block_cart_total']")
    public WebElement popupPaneFinalOrderTotalPrice;

    //BUTTONS & INPUTS & DROPDOWN//
    @FindBy(how = How.ID, using = "quantity_wanted")
    public WebElement quantityInput;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-group_1']//select")
    public WebElement sizeDropdown;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-group_1']//span")
    public WebElement readSizeDropdown;

    @FindBy(how = How.XPATH, using = "//a[@title='Blue']")
    public WebElement blueColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Orange']")
    public WebElement orangeColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='White']")
    public WebElement whiteColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Black']")
    public WebElement blackColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Beige']")
    public WebElement beigeColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Pink']")
    public WebElement pinkColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Green']")
    public WebElement greenColorButton;

    @FindBy(how = How.XPATH, using = "//a[@title='Yellow']")
    public WebElement yellowColorButton;

    @FindBy(how = How.XPATH, using = "//a[@class='color_pick selected']")
    public WebElement readChosenColor;

    @FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']//span[text()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-default button button-medium']")
    public WebElement proceedToCheckoutButton;
}