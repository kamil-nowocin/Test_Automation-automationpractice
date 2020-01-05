package tests;

import com.DriverFactory;
import com.listeners.TestNGListener_API;
import com.steps.Hooks;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Backend Tests")
@Feature("HTTP Statuses")
@Listeners({TestNGListener_API.class})
public class API_Tests extends Hooks {

    private String restHomeURL() {
        return RestAssured.baseURI = "http://automationpractice.com/";
    }

    @BeforeMethod
    @Override
    public void beforeTest(ITestResult iTestResult) {
        super.beforeTest(iTestResult);
        DriverFactory.destroyDriver();
    }

    @Owner("Kamil Nowocin")
    @Test(description = "HTTP status check", priority = 0)
    @Description("As a user I would like to check availability of automationpractice.com")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("TAP-043")
    public void test_1() throws Throwable {

        //ARRANGE//
        restHomeURL();
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET);

        //ACT//
        int actualResponse = response.getStatusCode();

        //ASSERT//
        Assert.assertEquals(actualResponse, 200);
    }
}