package com.steps;

import com.ContextInjection;
import com.DriverFactory;
import com.google.inject.Inject;
import com.pages.ProductDetailsPage;
import com.pages.ShoppingCartSummaryPage;
import com.pages.base.BasePage;
import com.pages.base.MainPage;
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

public class ShoppingLoggedUserSteps extends DriverFactory {

    private ContextInjection contextInjection;

    private BasePage basePage = new BasePage();
    private MainPage mainPage = new MainPage();
    private ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();

    @Inject
    public ShoppingLoggedUserSteps(ContextInjection contextInjection) {
        this.contextInjection = contextInjection;
    }

    @Step("I click on {0} button from sub menu")
    @And("I click on {string} button from sub menu")
    public void iClickOnButtonFromSubMenu(String category) throws Throwable {
        //ACT//
        switch (category.toLowerCase()) {
            case "women":
                mainPage.subMenuWomen.click();
                break;

            case "dress":
                mainPage.subMenuDresses.click();
                break;

            case "t-shirts":
                mainPage.subMenuTshirts.click();
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, category.toUpperCase()));
        }
        logger.info(String.format("User clicked on: %S submenu category", category));

        //ASSERT//
        Assert.assertEquals(mainPage.subMenuChosenCategory.getText().replaceAll
                ("\\s+", "").toLowerCase(), category.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on following product {0}")
    @And("I click on following product {string}")
    public void iClickOnFollowingProduct(String productName) throws Throwable {
        //ARRANGE//
        contextInjection.productName = productName;
        WebElement whichProductToClick = driver.findElement(new By.ByXPath
                ("//div[@id='center_column']//a[@class='product-name' and contains(text(),'" + productName + "')]"));

        //ACT//
        whichProductToClick.click();

        //ASSERT//
        Assert.assertEquals(productDetailsPage.productName.getText().toLowerCase(), productName.toLowerCase(), VALUE_ERROR);
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
        productDetailsPage.quantityInput.sendKeys(productQuantity);
        basePage.selectFromDropdownByText(productSize, productDetailsPage.sizeDropdown);
        switch (productColor.toLowerCase()) {
            case "orange":
                productDetailsPage.orangeColorButton.click();
                break;

            case "blue":
                productDetailsPage.blueColorButton.click();
                break;

            case "white":
                productDetailsPage.whiteColorButton.click();
                break;

            case "black":
                productDetailsPage.blackColorButton.click();
                break;

            case "beige":
                productDetailsPage.beigeColorButton.click();
                break;

            case "pink":
                productDetailsPage.pinkColorButton.click();
                break;

            case "green":
                productDetailsPage.greenColorButton.click();
                break;

            case "yellow":
                productDetailsPage.yellowColorButton.click();
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, productColor.toUpperCase()));
        }
        logger.info(String.format("Chosen product details:\n Quantity: %S\n Size: %S\n Color: %S",
                productQuantity, productSize, productColor));

        //INJECTIONS//
        contextInjection.productUnitPrice = Double.parseDouble
                (productDetailsPage.productPrice.getText().replaceAll("[^0-9.]", ""));
        contextInjection.productQuantity = Double.parseDouble(productQuantity);
        contextInjection.productSize = productSize;
        contextInjection.productColor = productColor;

        //ASSERT//
        Assert.assertEquals(productDetailsPage.readSizeDropdown.getText().toLowerCase(),
                productSize.toLowerCase(), VALUE_ERROR);
        basePage.sleep(1);//TODO
        Assert.assertEquals(productDetailsPage.readChosenColor.getAttribute("title").toLowerCase(),
                productColor.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on Add To Cart button")
    @When("I click on Add To Cart button")
    public void iClickOnAddToCartButton() throws Throwable {
        productDetailsPage.addToCartButton.click();
    }

    @Step("I can see modal where I am able to see detailed data about my purchase")
    @And("I can see modal where I am able to see detailed data about my purchase")
    public void iCanSeeModalWhereIAmAbleToSeeDetailedDataAboutMyPurchase() throws Throwable {
        //ACT//
        contextInjection.finalProductTotalPrice = (contextInjection.productUnitPrice * contextInjection.productQuantity);
        contextInjection.finalOrderTotalPrice = (contextInjection.productUnitPrice * contextInjection.productQuantity) + contextInjection.SHIPPING_PRICE;

        //ASSERT//
        Assert.assertTrue(basePage.isDisplayed(5, productDetailsPage.productDetailsPopupPane),
                String.format(VIEW_ERROR, "Product details popup"));

        Assert.assertTrue(basePage.isDisplayed(5, productDetailsPage.popupPaneAddedSuccessfully),
                String.format(VIEW_ERROR, "Product added successfully header"));

        Assert.assertEquals(productDetailsPage.popupPaneFinalProductTotalPrice.getText()
                        .replaceAll("[^$0-9.]", "").replace(".", ","),
                $decimalFormat.format(contextInjection.finalProductTotalPrice), VALUE_ERROR);

        Assert.assertEquals(productDetailsPage.popupPaneFinalOrderTotalPrice.getText()
                        .replaceAll("[^$0-9.]", "").replace(".", ","),
                $decimalFormat.format(contextInjection.finalOrderTotalPrice), VALUE_ERROR);
    }

    @Step("I click on Proceed To Checkout button \\(from modal)")
    @And("I click on Proceed To Checkout button \\(from modal)")
    public void iClickOnProceedToCheckoutButtonFromModal() throws Throwable {
        productDetailsPage.proceedToCheckoutButton.click();
    }

    @Step("I can see Shopping-Cart {0} form with valid information")
    @And("I can see Shopping-Cart {string} form with valid information")
    public void iCanSeeShoppingCartFormWithValidInformation(String shoppingSummaryTab) throws Throwable {
        //ARRANGE//
        Assert.assertTrue(basePage.isDisplayed(5, shoppingCartSummaryPage.navigationTopLabelHeader),
                String.format(VIEW_ERROR, "Navigation top label header"));

        final String navigationTopLabelHeaderText = shoppingCartSummaryPage.navigationTopLabelHeader.getText();
        //TODO - how tax is calculated in america?
        final double productTotalOrderPriceWithTax = contextInjection.finalOrderTotalPrice * contextInjection.TAX_VALUE;

        //ACT//
        switch (shoppingSummaryTab.toLowerCase()) {
            case "your shopping cart":
                //NAVIGATION LABEL//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        contextInjection.yourShoppingCart.toLowerCase(), VALUE_ERROR);

                //GENERAL//
                Assert.assertEquals(shoppingCartSummaryPage.productName.getText().toLowerCase(),
                        contextInjection.productName.toLowerCase(), VALUE_ERROR);
                Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.productUnitPrice.getText()
                        .replaceAll("[^0-9.]", "")), contextInjection.productUnitPrice, VALUE_ERROR);
                Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.productQuantity.getAttribute
                        ("value").toLowerCase()), contextInjection.productQuantity, VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.productTotalPrice.getText()
                                .replaceAll("[^$0-9.]", "").replace(".", ","),
                        $decimalFormat.format(contextInjection.finalProductTotalPrice), VALUE_ERROR);
                //TODO - how tax is calculated in america?
                //Assert.assertEquals(shoppingCartSummaryPage.productTotalOrderPriceTAX.getText()
                //              .replaceAll("[$]*[^$0-9.]", "").replace(".", ","),
                //    decimalFormat.format(productTotalOrderPriceWithTax), VALUE_ERROR);
                break;

            case "addresses":
                //NAVIGATION LABEL//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        contextInjection.addresses.toLowerCase(), VALUE_ERROR);

                //GENERAL//
                Assert.assertEquals(shoppingCartSummaryPage.customerFirstLastName.getText().toLowerCase(),
                        contextInjection.defaultCustomerFirstLastName.toLowerCase(), VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.customerCompanyName.getText().toLowerCase(),
                        contextInjection.defaultCustomerCompanyName.toLowerCase(), VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.customerAddress.getText().toLowerCase(),
                        contextInjection.defaultCustomerAddress.toLowerCase(), VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.customerCountry.getText().toLowerCase(),
                        contextInjection.defaultCustomerCountry.toLowerCase(), VALUE_ERROR);
                Assert.assertEquals(shoppingCartSummaryPage.customerMobilePhone.getText().toLowerCase(),
                        contextInjection.defaultCustomerMobilePhone.toLowerCase(), VALUE_ERROR);
                break;

            case "shipping":
                //NAVIGATION LABEL//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        contextInjection.shipping.toLowerCase(), VALUE_ERROR);
                break;

            case "your payment method":
                //NAVIGATION LABEL//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        contextInjection.yourPaymentMethod.toLowerCase(), VALUE_ERROR);
                break;

            case "order confirmation":
                //NAVIGATION LABEL//
                Assert.assertEquals(navigationTopLabelHeaderText.toLowerCase(),
                        contextInjection.orderConfirmation.toLowerCase(), VALUE_ERROR);

                //GENERAL//
                if (contextInjection.paymentType.toLowerCase().equals("pay by check")) {
                    Assert.assertTrue(basePage.isDisplayed(5, shoppingCartSummaryPage.paymentByCheckSuccessful),
                            String.format(VIEW_ERROR, "Order confirmation header"));

                } else if (contextInjection.paymentType.toLowerCase().equals("pay by bank wire")) {
                    Assert.assertTrue(basePage.isDisplayed(5, shoppingCartSummaryPage.paymentByBankWireSuccessful),
                            String.format(VIEW_ERROR, "Order confirmation header"));

                } else {
                    Assert.fail(contextInjection.paymentType + ANSI_RED + "Something went wrong! Check your payment type." + ANSI_RESET);
                }
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, shoppingSummaryTab.toUpperCase()));
        }
    }

    @Step("I click on Proceed To Checkout button \\(from shopping-cart)")
    @And("I click on Proceed To Checkout button \\(from shopping-cart)")
    public void iClickOnProceedToCheckoutButtonFromShoppingCart() throws Throwable {
        shoppingCartSummaryPage.proceedToCheckoutButton.click();
    }

    @Step("I write comment about my order")
    @And("I write comment about my order")
    public void iWriteCommentAboutMyOrder() throws Throwable {
        //ARRANGE//
        final String orderComment = faker.backToTheFuture().quote();

        //ACT//
        shoppingCartSummaryPage.orderComment.sendKeys(orderComment);
        logger.info(String.format("User comment order: %S", orderComment.toUpperCase()));

        //ASSERT//
        Assert.assertEquals(shoppingCartSummaryPage.orderComment.getAttribute("value").toLowerCase(), orderComment.toLowerCase(), VALUE_ERROR);
    }

    @Step("I choose shipping option{0}")
    @And("I choose shipping option {string}")
    public void iChooseShippingOption(String shippingOption) throws Throwable {
        //ACT//
        switch (shippingOption.toLowerCase()) {
            case "my carrier":
                if (!shoppingCartSummaryPage.myCarrierRadioButton.isSelected()) {
                    shoppingCartSummaryPage.myCarrierRadioButton.click();
                }

                //ASSERT//
                Assert.assertTrue(shoppingCartSummaryPage.myCarrierRadioButton.isSelected());
                break;

            case "":
                //TODO (when possible, probably never)
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, shippingOption.toUpperCase()));
        }
        logger.info(String.format("User chosen shipping method: %S", shippingOption.toUpperCase()));

        //ASSERT//
        Assert.assertEquals(Double.parseDouble(shoppingCartSummaryPage.readMyCarrierPrice.getText()
                .replaceAll("[^0-9.]", "")), contextInjection.SHIPPING_PRICE, VALUE_ERROR);
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
                shoppingCartSummaryPage.chequePaymentBox.click();
                break;

            case "pay by bank wire":
                shoppingCartSummaryPage.bankWirePaymentBox.click();
                break;

            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, contextInjection.paymentType.toUpperCase()));
        }
        logger.info(String.format("User chosen payment method: %S", contextInjection.paymentType));
    }

    @Step("I click on I Confirm My Order button")
    @And("I click on I Confirm My Order button")
    public void iClickOnIConfirmMyOrderButton() throws Throwable {
        shoppingCartSummaryPage.iConfirmMyOrderButton.click();
    }
}