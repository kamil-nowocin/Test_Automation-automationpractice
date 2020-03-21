package tests;

import com.ContextInjection;
import com.ExcelEnvironment;
import com.listeners.TestNGListener_WEB;
import com.steps.Hooks;
import com.steps.MainPageSteps;
import com.steps.SearchPageSteps;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Epic("Web App Tests")
@Feature("SEARCHBOX TESTS")
@Listeners({TestNGListener_WEB.class})
public class SearchBox_Tests extends Hooks {

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see results of: \"T-Shirts\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see results of: \"T-Shirts\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0031")
    @Story("POSITIVE FLOW")
    public void test_1() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(31);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("T-shirts");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("1");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("T-shirts");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see results of: \"Blouse\" ")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see results of: \"Blouse\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0032")
    @Story("POSITIVE FLOW")
    public void test_2() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(32);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Blouse");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("1");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Blouse");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see results of: \"Printed Dress\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see results of: \"Printed Dress\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0033")
    @Story("POSITIVE FLOW")
    public void test_3() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(33);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("Printed Dress");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("5");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("Printed Dress");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see results of: \"UNDEFINED PRODUCT\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see results of: \"UNDEFINED PRODUCT\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0034")
    @Story("NEGATIVE FLOW")
    public void test_4() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(34);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

        //ACT//
        mainPageSteps.iOpenHomePage();
        mainPageSteps.iCanSeeAutomationpracticeComWebsite();
        searchPageSteps.iSearchForPhrase("!@#$%^");
        searchPageSteps.iClickOnSearchIcon();
        searchPageSteps.iCanSeeNumbersOfResultsEqualsTo("0");

        //ASSERT//
        searchPageSteps.iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase("!@#$%^");
    }

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see sorted results by: \"Product Name: Z to A\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see sorted results by: \"Product Name: Z to A\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0035")
    @Story("POSITIVE FLOW")
    public void test_5() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(35);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

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

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see sorted results by: \"Product Name: A to Z\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see sorted results by: \"Product Name: A to Z\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0036")
    @Story("POSITIVE FLOW")
    public void test_6() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(36);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

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
    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see sorted results by: \"Price: Highest first\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see sorted results by: \"Price: Highest first\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0037")
    @Story("POSITIVE FLOW")
    public void test_7() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(37);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

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

    @Owner("Kamil Nowocin")
    @Test(priority = 0,
            description = "I would like to use search box and be able to see sorted results by: \"Price: Lowest first\"")
    @Description("A a user I would like to see results of searching phrase ->\n" +
            "I would like to use search box and be able to see sorted results by: \"Price: Lowest first\"")
    @Severity(SeverityLevel.NORMAL)
    @Issue("TAP-0038")
    @Story("POSITIVE FLOW")
    @Flaky
    public void test_8() throws Throwable {
        //ARRANGE//
        ExcelEnvironment.saveTestResultsXLSX(38);

        final MainPageSteps mainPageSteps = new MainPageSteps(new ContextInjection());
        final SearchPageSteps searchPageSteps = new SearchPageSteps();

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