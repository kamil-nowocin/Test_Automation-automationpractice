package tests.POC;

import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import io.qameta.allure.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("POC Tests")
@Feature("POC Tests")
@Listeners({TestNGListener_WEB.class})
public class POC_Tests extends Hooks {

    @Step("Some POC step")
    public void testSteps(XSSFRow row) {
        System.out.println("DATA SET 1: " + row.getCell(5).toString());
        System.out.println("DATA SET 2: " + row.getCell(7).toString());
    }

    @Issue("TAP-POC")
    @TmsLink("POC-LINK")
    @Story("POC Tests")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.MINOR)
    @Description("As a developer I'd like to see working POC with .xlsx file")
    @Test(description = "As a developer I'd like to see working POC with .xlsx file",
            priority = 0)
    @Parameters({"Parameter 1", "Parameter 2", "Parameter 3"})
    public void excelTest(String Parameter1, String Parameter2, String Parameter3) throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(50);

        //ACT//
        testSteps(ExcelEnvironment.getRowData(1));

        //ASSERT//
        Assert.fail();
    }
}