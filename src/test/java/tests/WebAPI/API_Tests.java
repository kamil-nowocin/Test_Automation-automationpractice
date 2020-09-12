package tests.WebAPI;

import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.steps.hooks.API_Hooks;
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
@Listeners({TestNGListener.class})
public class API_Tests extends API_Hooks {

    private String restHomeURL() {
        return RestAssured.baseURI = "http://automationpractice.com/";
    }

    @Issue("TAP/API-0001")
    @TmsLink("JIRA-000")
    @Story("HTTP STATUSES")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.BLOCKER)
    @Description("[API]/[1] As a user I would like to check availability of automationpractice.com")
    @Test(description = "[API]/[1] I would like to check availability of automationpractice.com",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();

        excelEnvironment.saveTestResultsXLSX(45);

        //ACT//
        given().when().get(restHomeURL()).then().assertThat().statusCode(200);
    }
}