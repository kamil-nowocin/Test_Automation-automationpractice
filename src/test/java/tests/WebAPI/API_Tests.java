package tests.WebAPI;


import com.testListeners.TestNGListener_API;
import com.steps.Hooks;
import com.testSettings.ExcelEnvironment;
import io.qameta.allure.*;
import io.restassured.RestAssured;
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

    @Issue("TAP/API-0001")
    @TmsLink("JIRA-000")
    @Story("HTTP STATUSES")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.BLOCKER)
    @Description("[US-XXX]/[1] As a user I would like to check availability of automationpractice.com")
    @Test(description = "[US-XXX]/[1] I would like to check availability of automationpractice.com",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(45);

        //ACT//
        given().when().get(restHomeURL()).then().assertThat().statusCode(200);
    }
}