package tests;

import com.ExcelEnvironment;
import com.steps.Hooks;
import io.qameta.allure.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Ignore
@Epic("POC Tests")
@Feature("POC Tests")
//@Listeners({TestNGListener_WEB.class})
public class POC_Tests extends Hooks {

    @Step("Some POC step")
    public void testSteps(XSSFRow row) {
        System.out.println("DATA SET 1: " + row.getCell(12).toString());
        System.out.println("DATA SET 2: " + row.getCell(14).toString());
    }

    @Ignore
    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "As a developer I'd like to see working POC with .xlsx file")
    @Description("As a developer I'd like to see working POC with .xlsx file")
    @Severity(SeverityLevel.MINOR)
    @Issue("TAP-POC")
    @Story("POC Tests")
    public void excelTest() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(1);

        //ACT//
        testSteps(ExcelEnvironment.getRowData(1));

        //ASSERT//
        Assert.fail();
    }
}