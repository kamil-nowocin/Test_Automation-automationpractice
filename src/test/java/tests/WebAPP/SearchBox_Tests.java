package tests.WebAPP;

import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.steps.MainPageSteps;
import com.steps.SearchPageSteps;
import com.steps.hooks.WEB_Hooks;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("SEARCH BOX TESTS")
@Listeners({TestNGListener.class})
public class SearchBox_Tests extends WEB_Hooks {

    @Issue("TAP-0031")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[1] As a user I would like to use search box and be able to see results of: \"T-shirts\"")
    @Test(description = "[US-555]/[1] I would like to use search box and be able to see results of: \"T-shirts\"",
            priority = 0)
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(31);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("T-shirts");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("1");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("T-shirts");
    }

    @Issue("TAP-0032")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[2] As a user I would like to use search box and be able to see results of: \"Blouse\"")
    @Test(description = "[US-555]/[2] I would like to use search box and be able to see results of: \"Blouse\"",
            priority = 0)
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(32);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Blouse");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("1");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Blouse");
    }

    @Issue("TAP-0033")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[3] As a user I would like to use search box and be able to see results of: \"Printed Dress\"")
    @Test(description = "[US-555]/[3] I would like to use search box and be able to see results of: \"Printed Dress\"",
            priority = 0)
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(33);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
    }

    @Issue("TAP-0034")
    @TmsLink("STORY-555")
    @Story("NEGATIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[4] As a user I would like to use search box and be able to see results of: \"!@#$%^\"")
    @Test(description = "[US-555]/[4] I would like to use search box and be able to see results of: \"!@#$%^\"",
            priority = 0)
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(34);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("!@#$%^");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("0");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("!@#$%^");
    }

    @Issue("TAP-0035")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[5] As a user I would like to use search box and be able to see results sorted by: \"Product Name: Z to A\"")
    @Test(description = "[US-555]/[5] I would like to use search box and be able to see results sorted by: \"Product Name: Z to A\"",
            priority = 0)
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(35);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
        searchPageSteps.iSelectFromDropdownSortBy("Product Name: Z to A");

        //ASSERT//
        searchPageSteps.iCanSeeThatResultsAreCorrectlySortedBy("Product Name: Z to A");
    }

    @Issue("TAP-0036")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[6] As a user I would like to use search box and be able to see results sorted by: \"Product Name: A to Z\"")
    @Test(description = "[US-555]/[6] I would like to use search box and be able to see results sorted by: \"Product Name: A to Z\"",
            priority = 0)
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(36);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
        searchPageSteps.iSelectFromDropdownSortBy("Product Name: A to Z");

        //ASSERT//
        searchPageSteps.iCanSeeThatResultsAreCorrectlySortedBy("Product Name: A to Z");
    }

    @Flaky
    @Issue("TAP-0037")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[7] As a user I would like to use search box and be able to see results sorted by: \"Price: Highest first\"")
    @Test(description = "[US-555]/[7] I would like to use search box and be able to see results sorted by: \"Price: Highest first\"",
            priority = 0)
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(37);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
        searchPageSteps.iSelectFromDropdownSortBy("Price: Highest first");

        //ASSERT//
        searchPageSteps.iCanSeeThatResultsAreCorrectlySortedBy("Price: Highest first");
    }

    @Flaky
    @Issue("TAP-0038")
    @TmsLink("STORY-555")
    @Story("POSITIVE FLOW")
    @Owner("Kamil Nowocin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[US-555]/[8] As a user I would like to use search box and be able to see results sorted by: \"Price: Lowest first\"")
    @Test(description = "[US-555]/[8] I would like to use search box and be able to see results sorted by: \"Price: Lowest first\"",
            priority = 0)
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();
        final MainPageSteps mainPageSteps = new MainPageSteps();
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        excelEnvironment.saveTestResultsXLSX(38);

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
        searchPageSteps.iSelectFromDropdownSortBy("Price: Lowest first");

        //ASSERT//
        searchPageSteps.iCanSeeThatResultsAreCorrectlySortedBy("Price: Lowest first");
    }
}