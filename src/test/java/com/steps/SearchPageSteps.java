package com.steps;

import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.google.common.collect.Ordering;
import com.pages.MainPage;
import com.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class SearchPageSteps extends TestEnvironment {

    private final MainPage mainPage = new MainPage().get();
    private final TestCommons testCommons = new TestCommons();
    private final SearchPage searchPage = new SearchPage().get();

    @Step("I search for phrase *{0}*")
    @When("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) throws Throwable {
        //ACT//
        testCommons.customSendKeys(mainPage.searchBoxInput, searchPhrase);
        logger.info(String.format("User search for: \"%S\"", searchPhrase));

        //ASSERT//
        Assert.assertEquals(mainPage.searchBoxInput.getAttribute("value").toLowerCase(),
                searchPhrase.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I click on search icon")
    @And("I click on search icon")
    public void iClickOnSearchIcon() throws Throwable {
        testCommons.customClick(mainPage.searchBoxSubmit);
    }

    @Step("I can see numbers of results equals to *{0}*")
    @Then("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedCountOfResults) throws Throwable {
        //ARRANGE//
        testCommons.waitForElementToBeVisible(searchPage.searchResultsNumber);
        final String actualCountOfResults = searchPage.searchResultsNumber.getText().replaceAll("[^\\d]", "");

        //ACT//
        if (expectedCountOfResults.equals("0")) {
            Assert.assertTrue(testCommons.isElementVisible(searchPage.noResultsWereFoundHeader),
                    String.format(ContextInjection.VIEW_ERROR, "No results were found header"));
        }
        logger.info(String.format("Found results: \"%S\", expected: \"%S\"", actualCountOfResults, expectedCountOfResults));

        //ASSERT//
        Assert.assertEquals(actualCountOfResults, expectedCountOfResults, String.format(ContextInjection.RESULTS_ERROR,
                actualCountOfResults, expectedCountOfResults));
    }

    @Step("I can see that every results which have been found contains phrase *{0}*")
    @And("I can see that every results which have been found contains phrase {string}")
    public void iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase(String searchPhrase) throws Throwable {
        //ARRANGE//
        String[] listOfSearchedPhrases = searchPhrase.toLowerCase().split("[\\s]");

        //ACT//
        if (!searchPage.noResultsWereFoundHeader.isDisplayed()) {
            for (WebElement productName : searchPage.productNames) {
                for (String singlePhrase : listOfSearchedPhrases) {
                    //ASSERT//
                    Assert.assertTrue(productName.getText().toLowerCase().contains(singlePhrase.toLowerCase()), ContextInjection.SEARCH_ERROR);
                }
            }
        } else {
            Assert.assertTrue(testCommons.isElementVisible(searchPage.noResultsWereFoundHeader),
                    String.format(ContextInjection.VIEW_ERROR, "No result header"));
        }
    }

    @Step("I select from Dropdown Sort by *{0}*")
    @Then("I select from Dropdown Sort by {string}")
    public void iSelectFromDropdownSortBy(String sortBy) throws Throwable {
        //ACT//
        switch (sortBy.toLowerCase()) {
            case "price: lowest first":
                testCommons.selectFromDropdownByValue("price:asc", searchPage.sortByDropdown);
                break;
            case "price: highest first":
                testCommons.selectFromDropdownByValue("price:desc", searchPage.sortByDropdown);
                break;
            case "product name: a to z":
                testCommons.selectFromDropdownByValue("name:asc", searchPage.sortByDropdown);
                break;
            case "product name: z to a":
                testCommons.selectFromDropdownByValue("name:desc", searchPage.sortByDropdown);
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, sortBy.toUpperCase()));
        }
        logger.info(String.format("Chosen sort option: \"%S\"", sortBy));

        //ASSERT//
        Assert.assertEquals(searchPage.readSortByDropdown.getText().toLowerCase(), sortBy.toLowerCase(), ContextInjection.VALUE_ERROR);
    }

    @Step("I can see that results are correctly sorted by *{0}*")
    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String sortedBy) throws Throwable {
        //ARRANGE//
        List<String> arrayList = new ArrayList<>();

        //ACT//
        logger.info(String.format("Actual sort option: \"%S\"", sortedBy));
        switch (sortedBy.toLowerCase()) {
            case "price: lowest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^$0-9.]", ""));
                }
                List<String> lowestPriceList = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, lowestPriceList, String.format(ContextInjection.SORTING_ERROR, sortedBy));
                break;
            case "price: highest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^$0-9.]", ""));
                }
                List<String> highestPriceList = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, highestPriceList, String.format(ContextInjection.SORTING_ERROR, sortedBy));
                break;
            case "product name: a to z":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> sortedNames = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, sortedNames, String.format(ContextInjection.SORTING_ERROR, sortedBy));
                break;
            case "product name: z to a":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> reverseSortedNames = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, reverseSortedNames, String.format(ContextInjection.SORTING_ERROR, sortedBy));
                break;
            default:
                throw new IllegalStateException(String.format(ContextInjection.INPUT_ERROR, sortedBy.toUpperCase()));
        }
    }
}