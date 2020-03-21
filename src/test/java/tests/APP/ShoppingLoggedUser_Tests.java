package tests.APP;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import com.steps.RegistrationPageSteps;
import com.steps.ShoppingLoggedUserSteps;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("SHOPPING TESTS")
@Listeners({TestNGListener_WEB.class})
public class ShoppingLoggedUser_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to buy new Faded Short Sleeve T-shirts from automationpractice.com")
    @Description("(User is already successfully logged) As a user I would like to buy new clothes from automationpractice.com ->\n" +
            "I would like to buy new \"Faded Short Sleeve T-shirts\"")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-0039")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(39);
        List<List<String>> orderDetails = Arrays.asList
                (
                        Arrays.asList("Quantity", " Size", "Colour"),
                        Arrays.asList("5", "M", "Blue")
                );
        DataTable orderDetailsDataTable = DataTable.create(orderDetails);

        List<List<String>> paymentDetails = Arrays.asList
                (
                        Collections.singletonList("Payment Method"),
                        Collections.singletonList("Pay by check")
                );
        DataTable paymentDetailsDataTable = DataTable.create(paymentDetails);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final ShoppingLoggedUserSteps shoppingLoggedUserSteps = new ShoppingLoggedUserSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mainPageSteps.iAmLoggedAsCustomerUsingPassword("thor.odinson@example.com", "12345");
        registrationPageSteps.iCanSeeWelcomeMessage();
        mainPageSteps.iAmOnMyAccountDetailsPage();
        shoppingLoggedUserSteps.iClickOnButtonFromSubMenu("Women");
        shoppingLoggedUserSteps.iClickOnFollowingProduct("Faded Short Sleeve T-shirts");
        shoppingLoggedUserSteps.iChooseFollowingDetailsOfMyOrder(orderDetailsDataTable);
        shoppingLoggedUserSteps.iClickOnAddToCartButton();
        shoppingLoggedUserSteps.iCanSeeModalWhereIAmAbleToSeeDetailedDataAboutMyPurchase();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromModal();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Your shopping cart");
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Addresses");
        shoppingLoggedUserSteps.iWriteCommentAboutMyOrder();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Shipping");
        shoppingLoggedUserSteps.iChooseShippingOption("My carrier");
        shoppingLoggedUserSteps.iClickOnTermsOfServiceCheckbox();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Your payment method");
        shoppingLoggedUserSteps.iChoosePaymentMethod(paymentDetailsDataTable);
        shoppingLoggedUserSteps.iClickOnIConfirmMyOrderButton();

        //ASSERT
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Order confirmation");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to buy new Blouse from automationpractice.com")
    @Description("(User is already successfully logged) As a user I would like to buy new clothes from automationpractice.com ->\n" +
            "I would like to buy new \"Blouse\"")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("TAP-0040")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(40);
        List<List<String>> orderDetails = Arrays.asList
                (
                        Arrays.asList("Quantity", " Size", "Colour"),
                        Arrays.asList("2", "S", "Black")
                );
        DataTable orderDetailsDataTable = DataTable.create(orderDetails);

        List<List<String>> paymentDetails = Arrays.asList
                (
                        Collections.singletonList("Payment Method"),
                        Collections.singletonList("Pay by bank wire")
                );
        DataTable paymentDetailsDataTable = DataTable.create(paymentDetails);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps(new ContextInjection());
        final ShoppingLoggedUserSteps shoppingLoggedUserSteps = new ShoppingLoggedUserSteps(new ContextInjection());

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        mainPageSteps.iAmLoggedAsCustomerUsingPassword("thor.odinson@example.com", "12345");
        registrationPageSteps.iCanSeeWelcomeMessage();
        mainPageSteps.iAmOnMyAccountDetailsPage();
        shoppingLoggedUserSteps.iClickOnButtonFromSubMenu("Women");
        shoppingLoggedUserSteps.iClickOnFollowingProduct("Blouse");
        shoppingLoggedUserSteps.iChooseFollowingDetailsOfMyOrder(orderDetailsDataTable);
        shoppingLoggedUserSteps.iClickOnAddToCartButton();
        shoppingLoggedUserSteps.iCanSeeModalWhereIAmAbleToSeeDetailedDataAboutMyPurchase();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromModal();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Your shopping cart");
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Addresses");
        shoppingLoggedUserSteps.iWriteCommentAboutMyOrder();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Shipping");
        shoppingLoggedUserSteps.iChooseShippingOption("My carrier");
        shoppingLoggedUserSteps.iClickOnTermsOfServiceCheckbox();
        shoppingLoggedUserSteps.iClickOnProceedToCheckoutButtonFromShoppingCart();
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Your payment method");
        shoppingLoggedUserSteps.iChoosePaymentMethod(paymentDetailsDataTable);
        shoppingLoggedUserSteps.iClickOnIConfirmMyOrderButton();

        //ASSERT
        shoppingLoggedUserSteps.iCanSeeShoppingCartFormWithValidInformation("Order confirmation");
    }
}