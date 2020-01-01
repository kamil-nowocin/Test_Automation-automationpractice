package tests;

import com.listeners.TestNGListener;
import com.steps.BasePageSteps;
import com.steps.Hooks;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Regression Tests")
@Feature("REGISTRATION VALIDATORS TESTS")
@Listeners({TestNGListener.class})
public class RegistrationValidators_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to see registration error, when I don't fill first name input")
    @Description("As a user I would like to see the error message where I made a mistake in the registration page form ->\n" +
            "I would like to see registration error, when I don't fill first name input")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-020")
    @Story("NEGATIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        final BasePageSteps basePageSteps = new BasePageSteps();

        //ACT//
    }
}