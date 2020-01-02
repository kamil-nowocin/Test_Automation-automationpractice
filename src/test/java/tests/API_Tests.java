package tests;

import com.listeners.TestNGListener;
import com.steps.Hooks;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Backend Tests")
@Feature("HTTP Statuses")
@Listeners({TestNGListener.class})
public class API_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0, description = "Check HTTP status TBA")
    @Description("As a user I would like to check how to test API")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("TAP-043")
    public void test_1() throws Throwable {
        //ARRANGE//
        //ACT//
    }
}