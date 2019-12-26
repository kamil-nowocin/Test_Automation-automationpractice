package com.steps;

import com.DriverFactory;
import com.google.common.collect.Ordering;
import com.pages.SearchPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

@Listeners({Hooks.class})
public class SearchPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private SearchPage searchPage = new SearchPage(driver);

    @Step("I search for phrase {0}")
    @When("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) throws Throwable {
        //ACT//
        searchPage.searchBoxInput.sendKeys(searchPhrase);

        //ASSERT//
        Assert.assertEquals(searchPage.searchBoxInput.getAttribute("value").toLowerCase(),
                searchPhrase.toLowerCase(), VALUE_ERROR);
    }

    @Step("I click on search icon")
    @And("I click on search icon")
    public void iClickOnSearchIcon() throws Throwable {
        searchPage.searchBoxSubmit.click();
    }

    @Step("I can see numbers of results equals to {0}")
    @Then("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedResults) throws Throwable {
        //ARRANGE//
        final String howManyResults = searchPage.searchResultsNumber.getText().replaceAll("[^\\d]", "");

        //ASSERT//
        Assert.assertEquals(howManyResults, expectedResults, String.format(RESULTS_ERROR, howManyResults, expectedResults));
    }

    @Step("I can see that every results which have been found contains phrase {0}")
    @And("I can see that every results which have been found contains phrase {string}")
    public void iCanSeeThatEveryResultsWhichHaveBeenFoundContainsPhrase(String searchPhrase) throws Throwable {
        //ARRANGE//
        String[] listOfSearchedPhrases = searchPhrase.toLowerCase().split("[\\s]");

        //ACT//
        if (!basePage.isDisplayed(10, searchPage.noResultsWereFoundHeader)) {
            for (WebElement productName : searchPage.productNames) {
                for (String singlePhrase : listOfSearchedPhrases) {

                    //ASSERT//
                    Assert.assertTrue(productName.getText().toLowerCase().contains(singlePhrase.toLowerCase()), SEARCH_ERROR);
                }
            }
        }
    }

    @Step("I select from Dropdown Sort by {0}")
    @Then("I select from Dropdown Sort by {string}")
    public void iSelectFromDropdownSortBy(String sortBy) throws Throwable {
        //ACT//
        switch (sortBy.toLowerCase()) {
            case "price: lowest first":
                basePage.selectFromDropdownByValue("price:asc", searchPage.dropdownSortBy);
                break;
            case "price: highest first":
                basePage.selectFromDropdownByValue("price:desc", searchPage.dropdownSortBy);
                break;
            case "product name: a to z":
                basePage.selectFromDropdownByValue("name:asc", searchPage.dropdownSortBy);
                break;
            case "product name: z to a":
                basePage.selectFromDropdownByValue("name:desc", searchPage.dropdownSortBy);
                break;
            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, sortBy.toUpperCase()));
        }
        //ASSERT//
        Assert.assertEquals(searchPage.chosenSortBy.getText().toLowerCase(), sortBy.toLowerCase(), VALUE_ERROR);
    }

    @Step("I can see that results are correctly sorted by {0}")
    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String sortedBy) throws Throwable {
        //ARRANGE//
        List<String> arrayList = new ArrayList<>();

        //ACT//
        switch (sortedBy.toLowerCase()) {
            case "price: lowest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^0-9]", ""));
                }
                List<String> lowestPriceList = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, lowestPriceList, String.format(SORTING_ERROR, sortedBy));
                break;
            case "price: highest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^0-9]", ""));
                }
                List<String> highestPriceList = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, highestPriceList, String.format(SORTING_ERROR, sortedBy));
                break;
            case "product name: a to z":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> sortedNames = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, sortedNames, String.format(SORTING_ERROR, sortedBy));
                break;
            case "product name: z to a":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> reverseSortedNames = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, reverseSortedNames, String.format(SORTING_ERROR, sortedBy));
                break;
            default:
                throw new IllegalStateException(String.format(INPUT_ERROR, sortedBy.toUpperCase()));
        }
    }
}