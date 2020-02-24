package tests;

import com.ExcelEnvironment;
import com.steps.Hooks;
import io.qameta.allure.Step;
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
public class EXCEL_POC_Tests extends Hooks {

    @Step
    public void testSteps(XSSFRow row) {
        System.out.println("DATA SET 1: " + row.getCell(5).toString());
        System.out.println("DATA SET 2: " + row.getCell(7).toString());

    }

    @Test(description = "As a developer I'd like to see working POC with .xlsx file")
    public void excelTest() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(1);

        //ACT//
        testSteps(ExcelEnvironment.getRowData(1));

        //ASSERT//
        Assert.fail();
    }
}
