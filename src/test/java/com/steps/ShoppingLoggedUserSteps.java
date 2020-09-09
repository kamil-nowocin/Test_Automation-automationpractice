package com.steps;

import com.DriverFactory;
import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.google.inject.Inject;
import com.pages.MainPage;
import com.pages.ProductDetailsPage;
import com.pages.ShoppingCartSummaryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class ShoppingLoggedUserSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final TestCommons testCommons = new TestCommons();
    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage().get();
    private final ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage().get();

    private final ContextInjection contextInjection;

    @Inject
    public ShoppingLoggedUserSteps(ContextInjection contextInjection) {
        this.contextInjection = contextInjection;
    }

    @Step("I click on *{0}* button from sub menu")
    @And("I click on {string} button from sub menu")
    public void iClickOnButtonFromSubMenu(String subMenuCategory) throws Throwable {
        //ACT//
        switch (subMenuCategory.toLowerCase()) {
            case "women":
                testCommons.customClick(mainPage.subMenuWomen);
                break;
            case "dress":
                testCommons.customClick(mainPage.subMenuDresses);
                break;
            case "t-shirts":
                testCommons.customClick(mainPage.subMenuTshirts);
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, subMenuCategory.toUpperCase()));
        }
        logger.info(String.format("User clicked on: \"%S\" submenu category", subMenuCategory));

        //ASSERT//
        Assert.assertEquals(mainPage.subMenuChosenCategory.getText().replaceAll
                ("\\s+", "").toLowerCase(), subMenuCategory.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on following product *{0}*")
    @And("I click on following product {string}")
    public void iClickOnFollowingProduct(String productName) throws Throwable {
        //ARRANGE//
        contextInjection.cartProductName = productName;
        WebElement whichProductToClick = DriverFactory.getDriver().findElement(new By.ByXPath
                ("//div[@id='center_column']//a[@class='product-name' and contains(text(),'" + productName + "')]"));

        //ACT//
        testCommons.customClick(whichProductToClick);
        logger.info(String.format("User clicked on product: \"%S\"", productName));

        //ASSERT//
        Assert.assertEquals(productDetailsPage.productName.getText().toLowerCase(), productName.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose following details of my order")
    @And("I choose following details of my order")
    public void iChooseFollowingDetailsOfMyOrder(DataTable dataTable) throws Throwable {
        //ARRANGE//
        List<List<String>> data = dataTable.asLists();
        final String productQuantity = data.get(1).get(0);
        final String productSize = data.get(1).get(1);
        final String productColor = data.get(1).get(2);
        productDetailsPage.quantityInput.clear();

        //ACT//
        testCommons.customSendKeys(productDetailsPage.quantityInput, productQuantity);
        testCommons.selectFromDropdownByText(productSize, productDetailsPage.sizeDropdown);
        switch (productColor.toLowerCase()) {
            case "orange":
                testCommons.customClick(productDetailsPage.orangeColorButton);
                break;
            case "blue":
                testCommons.customClick(productDetailsPage.blueColorButton);
                break;
            case "white":
                testCommons.customClick(productDetailsPage.whiteColorButton);
                break;
            case "black":
                testCommons.customClick(productDetailsPage.blackColorButton);
                break;
            case "beige":
                testCommons.customClick(productDetailsPage.beigeColorButton);
                break;
            case "pink":
                testCommons.customClick(productDetailsPage.pinkColorButton);
                break;
            case "green":
                testCommons.customClick(productDetailsPage.greenColorButton);
                break;
            case "yellow":
                testCommons.customClick(productDetailsPage.yellowColorButton);
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, productColor.toUpperCase()));
        }
        logger.info(String.format("Chosen product details:\n > Quantity: \"%S\"\n > Size: \"%S\"\n > Color: \"%S\"",
                productQuantity, productSize, productColor));

        //INJECTIONS//
        contextInjection.productUnitPrice = Double.parseDouble(productDetailsPage.productPrice.getText().replaceAll("[^0-9.]", ""));
        contextInjection.productQuantity = Double.parseDouble(productQuantity);
        contextInjection.productSize = productSize;
        contextInjection.productColor = productColor;

        //ASSERT//
        Assert.assertEquals(productDetailsPage.readSizeDropdown.getText().toLowerCase(),
                productSize.toLowerCase(), ContextInjection.VALUE_ERROR);
        testCommons.sleep(1);//TODO
        Assert.assertEquals(productDetailsPage.readChosenColor.getAttribute("title").toLowerCase(),
                productColor.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on Add To Cart button")
    @When("I click on Add To Cart button")
    public void iClickOnAddToCartButton() throws Throwable {
        testCommons.customClick(productDetailsPage.addToCartButton);
    }

    @Step("I can see modal where I am able to see detailed data about my purchase")
    @And("I can see modal where I am able to see detailed data about my purchase")
    public void iCanSeeModalWhereIAmAbleToSeeDetailedDataAboutMyPurchase() throws Throwable {
        //ACT//
        orderCalculations();

        //ASSERT//
        Assert.assertTrue(testCommons.isElementVisible(productDetailsPage.popupPaneProductDetails),
                String.format(ContextInjection.VIEW_ERROR, "Product details popup"));
        Assert.assertTrue(testCommons.isElementVisible(productDetailsPage.popupPaneAddedSuccessfully),
                String.format(ContextInjection.VIEW_ERROR, "Product added successfully header"));

        //ASSERT - POPUP LEFT SIDE//
        Assert.assertEquals(productDetailsPage.popupPaneCartProductName.getText().toLowerCase(),
                contextInjection.cartProductName.toLowerCase(), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(Double.parseDouble(productDetailsPage.popupPaneCartProductQuantity.getText()),
                contextInjection.productQuantity, ContextInjection.VALUE_ERROR);
        Assert.assertEquals(productDetailsPage.popupPaneCartProductPrice.getText().replaceAll("[^$0-9.]", ""),
                DOLLAR_DECIMAL_FORMAT.format(contextInjection.cartProductPrice), ContextInjection.VALUE_ERROR);

        //ASSERT - POPUP RIGHT SIDE//
        Assert.assertEquals(productDetailsPage.popupPaneCartTotalProductsPrice.getText().replaceAll("[^$0-9.]", ""),
                DOLLAR_DECIMAL_FORMAT.format(contextInjection.cartTotalProductsPrice), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(productDetailsPage.popupPaneCartTotalShippingPrice.getText().replaceAll("[^$0-9.]", ""),
                DOLLAR_DECIMAL_FORMAT.format(ContextInjection.SHIPPING_PRICE), ContextInjection.VALUE_ERROR);
        Assert.assertEquals(productDetailsPage.popupPaneCartTotalPrice.getText().replaceAll("[^$0-9.]", ""),
                DOLLAR_DECIMAL_FORMAT.format(contextInjection.cartTotalPrice), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on Proceed To Checkout button (from modal)")
    @And("I click on Proceed To Checkout button \\(from modal)")
    public void iClickOnProceedToCheckoutButtonFromModal() throws Throwable {
        testCommons.customClick(productDetailsPage.proceedToCheckoutButton);
    }

    @Step("I can see Shopping-Cart *{0}* form with valid information")
    @And("I can see Shopping-Cart {string} form with valid information")
    public void iCanSeeShoppingCartFormWithValidInformation(String shoppingSummaryTab) throws Throwable {
        //ARRANGE//
        testCommons.waitForElementToBeVisible(shoppingCartSummaryPage.navigationTopLabelHeader);
        final String navigationTopLabelHeaderText = shoppingCartSummaryPage.navigationTopLabelHeader.getText();

        //ACT//
        switch (shoppingSummaryTab.toLowerCase()) {
            case "your shopping cart":
                //ASSERT//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        ContextInjection.LABEL_YOUR_SHOPPING_CART.toLowerCase(), ContextInjection.VALUE_ERROR);

//                TODO - clean assertions(proper refactor)
//                //ASSERT - PRODUCTS IN CART//
//                Assert.assertEquals(shoppingCartSummaryPage.productName.getText().toLowerCase(),
//                        contextInjection.cartProductName.toLowerCase(), VALUE_ERROR);
//                Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.productUnitPrice.getText()
//                        .replaceAll("[^0-9.]", "")), contextInjection.productUnitPrice, VALUE_ERROR);
//                Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.productQuantity.getAttribute
//                        ("value").toLowerCase()), contextInjection.cartProductQuantity, VALUE_ERROR);
//                Assert.assertEquals(shoppingCartSummaryPage.productTotalPrice.getText()
//                                .replaceAll("[^$0-9.]", ""),
//                        $decimalFormat.format(contextInjection.cartProductPrice), VALUE_ERROR);

                //ASSERT - CART SUMMARY//
                Assert.assertEquals(shoppingCartSummaryPage.totalProductsPrice.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(contextInjection.cartTotalProductsPrice), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.totalOrderShipping.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(ContextInjection.SHIPPING_PRICE), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.totalOrderPriceWithoutTax.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(contextInjection.totalOrderPriceWithoutTax), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.totalOrderTax.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(contextInjection.totalOrderTax), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.totalOrderPriceWithTax.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(contextInjection.totalOrderPriceWithTax), ContextInjection.VALUE_ERROR);
                break;
            case "addresses":
                //ASSERT//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        ContextInjection.LABEL_ADDRESSES.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.readCustomerFirstLastName.getText().toLowerCase(),
                        ContextInjection.DEFAULT_CUSTOMER_FIRST_LAST_NAME.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.readCustomerCompanyName.getText().toLowerCase(),
                        ContextInjection.DEFAULT_CUSTOMER_COMPANY_NAME.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.readCustomerAddress.getText().toLowerCase(),
                        ContextInjection.DEFAULT_CUSTOMER_ADDRESS.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.readCustomerCountry.getText().toLowerCase(),
                        ContextInjection.DEFAULT_CUSTOMER_COUNTRY.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.readCustomerMobilePhone.getText().toLowerCase(),
                        ContextInjection.DEFAULT_CUSTOMER_MOBILE_PHONE.toLowerCase(), ContextInjection.VALUE_ERROR);
                break;
            case "shipping":
                //ASSERT//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        ContextInjection.LABEL_SHIPPING.toLowerCase(), ContextInjection.VALUE_ERROR);
                break;
            case "your payment method":
                //ASSERT//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        ContextInjection.LABEL_YOUR_PAYMENT_METHOD.toLowerCase(), ContextInjection.VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.totalOrderPriceWithTax.getText().replaceAll("[^$0-9.]", ""),
                        DOLLAR_DECIMAL_FORMAT.format(contextInjection.totalOrderPriceWithTax), ContextInjection.VALUE_ERROR);
                break;
            case "order confirmation":
                //ASSERT//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        ContextInjection.LABEL_ORDER_CONFIRMATION.toLowerCase(), ContextInjection.VALUE_ERROR);
                if (contextInjection.paymentType.toLowerCase().equals("pay by check")) {
                    Assert.assertTrue(testCommons.isElementVisible(shoppingCartSummaryPage.paymentByCheckSuccessful),
                            String.format(ContextInjection.VIEW_ERROR, "Order confirmation header"));
                } else if (contextInjection.paymentType.toLowerCase().equals("pay by bank wire")) {
                    Assert.assertTrue(testCommons.isElementVisible(shoppingCartSummaryPage.paymentByBankWireSuccessful),
                            String.format(ContextInjection.VIEW_ERROR, "Order confirmation header"));
                } else {
                    Assert.fail(contextInjection.paymentType + ANSI_RED + "Something went wrong! Check your payment type." + ANSI_RESET);
                }
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, shoppingSummaryTab.toUpperCase()));
        }
    }

    @Step("I click on Proceed To Checkout button (from shopping-cart)")
    @And("I click on Proceed To Checkout button \\(from shopping-cart)")
    public void iClickOnProceedToCheckoutButtonFromShoppingCart() throws Throwable {
        testCommons.customClick(shoppingCartSummaryPage.proceedToCheckoutButton);
    }

    @Step("I write comment about my order")
    @And("I write comment about my order")
    public void iWriteCommentAboutMyOrder() throws Throwable {
        //ARRANGE//
        final String orderComment = faker.backToTheFuture().quote();

        //ACT//
        testCommons.customSendKeys(shoppingCartSummaryPage.orderCommentInput, orderComment);
        logger.info(String.format("User order comment: \"%S\"", orderComment.toUpperCase()));

        //ASSERT//
        Assert.assertEquals(shoppingCartSummaryPage.orderCommentInput.getAttribute("value").toLowerCase(),
                orderComment.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I choose shipping option *{0}*")
    @And("I choose shipping option {string}")
    public void iChooseShippingOption(String shippingOption) throws Throwable {
        //ACT//
        switch (shippingOption.toLowerCase()) {
            case "my carrier":
                if (!shoppingCartSummaryPage.myCarrierRadioButton.isSelected()) {
                    testCommons.customClick(shoppingCartSummaryPage.myCarrierRadioButton);
                }
                //ASSERT//
                Assert.assertTrue(shoppingCartSummaryPage.myCarrierRadioButton.isSelected());
                break;
            case "":
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, shippingOption.toUpperCase()));
        }
        logger.info(String.format("User chosen shipping method: \"%S\"", shippingOption.toUpperCase()));

        //ASSERT//
        Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.readMyCarrierPrice.getText()
                .replaceAll("[^0-9.]", "")), ContextInjection.SHIPPING_PRICE, ContextInjection.VALUE_ERROR);
    }

    @Step("I click on Terms of Service checkbox")
    @And("I click on Terms of Service checkbox")
    public void iClickOnTermsOfServiceCheckbox() throws Throwable {
        //ACT//
        if (!shoppingCartSummaryPage.tosCheckbox.isSelected()) {
            shoppingCartSummaryPage.tosCheckbox.click();
            logger.info("User selected Terms of Service checkbox");
        } else {
            logger.info("User didn't select Terms of Service checkbox(pre-selected)");
        }

        //ASSERT//
        Assert.assertTrue(shoppingCartSummaryPage.tosCheckbox.isSelected());
    }

    @Step("I choose payment method")
    @Then("I choose payment method")
    public void iChoosePaymentMethod(DataTable dataTable) throws Throwable {
        //ARRANGE//
        List<List<String>> data = dataTable.asLists();
        contextInjection.paymentType = data.get(1).get(0);

        //ACT//
        switch (contextInjection.paymentType.toLowerCase()) {
            case "pay by check":
                testCommons.customClick(shoppingCartSummaryPage.chequePaymentBox);
                break;
            case "pay by bank wire":
                testCommons.customClick(shoppingCartSummaryPage.bankWirePaymentBox);
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, contextInjection.paymentType.toUpperCase()));
        }
        logger.info(String.format("User chosen payment method: \"%S\"", contextInjection.paymentType));
    }

    @Step("I click on I Confirm My Order button")
    @And("I click on I Confirm My Order button")
    public void iClickOnIConfirmMyOrderButton() throws Throwable {
        testCommons.customClick(shoppingCartSummaryPage.iConfirmMyOrderButton);
    }

    private void orderCalculations() {
        //GENERAL//
        contextInjection.cartProductPrice = (contextInjection.productUnitPrice * contextInjection.productQuantity);
        contextInjection.cartTotalProductsPrice = contextInjection.cartTotalProductsPrice + contextInjection.cartProductPrice;

        //FOR POPUP//
        contextInjection.cartTotalPrice = contextInjection.cartTotalProductsPrice + ContextInjection.SHIPPING_PRICE;

        //FOR SUMMARY PAGE//
        contextInjection.totalOrderPriceWithoutTax = contextInjection.cartTotalProductsPrice + ContextInjection.SHIPPING_PRICE;
        contextInjection.totalOrderTax = contextInjection.totalOrderPriceWithoutTax * ContextInjection.TAX_VALUE;
        contextInjection.totalOrderPriceWithTax = contextInjection.totalOrderPriceWithoutTax * (1 + ContextInjection.TAX_VALUE);
    }
}