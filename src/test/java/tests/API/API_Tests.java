package tests.API;

import com.ExcelEnvironment;
import com.listeners.TestNGListener_API;
import com.steps.Hooks;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("API Tests")
@Feature("HTTP Statuses")
@Listeners({TestNGListener_API.class})
public class API_Tests extends Hooks {

    private String restHomeURL() {
        return RestAssured.baseURI = "http://automationpractice.com/";
    }

    @Override
    @BeforeMethod(description = "Setting up Test Class")
    public void beforeTest(ITestResult iTestResult) {
        super.beforeTest(iTestResult);
        destroyDriver();
    }

    @Owner("Kamil Nowocin")
    @Test(description = "HTTP status check", priority = 0)
    @Description("As a user I would like to check availability of automationpractice.com")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("TAP-0000")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(45);

        //ACT//
        given().when().get(restHomeURL()).then().assertThat().statusCode(200);
    }
}