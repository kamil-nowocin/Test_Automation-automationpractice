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

@Listeners({Hooks.class})
public class SearchPageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private SearchPage searchPage = new SearchPage(driver);

    @Step("I search for phrase {string}")
    @When("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) {
        searchPage.searchBoxInput.sendKeys(searchPhrase);
    }

    @Step("I click on search icon")
    @And("I click on search icon")
    public void iClickOnSearchIcon() {
        searchPage.searchBoxSubmit.click();
    }

    @Step("I can see numbers of results equals to {string}")
    @Then("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedResults) {
        //ARRANGE
        String howMuchResults = searchPage.searchResultsNumber.getText().replaceAll("[^\\d]", "");

        //ASSERT
        Assert.assertEquals(howMuchResults, expectedResults, RESULTS_ERROR + expectedResults);
    }

    @Step("I select from Dropdown Sort by {string}")
    @Then("I select from Dropdown Sort by {string}")
    public void iSelectFromDropdownSortBy(String sortBy) {
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
                throw new IllegalStateException(INPUT_ERROR);
        }
    }

    @Step("I can see that results are correctly sorted by {string}")
    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String sortedBy) {
        List<String> arrayList = new ArrayList<>();
        switch (sortedBy.toLowerCase()) {
            case "price: lowest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^0-9]", ""));
                }
                List<String> lowestPriceList = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, lowestPriceList, SORTING_ERROR);
                break;
            case "price: highest first":
                for (WebElement productPrices : searchPage.productPrices) {
                    arrayList.add(productPrices.getText().replaceAll("[^0-9]", ""));
                }
                List<String> highestPriceList = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, highestPriceList, SORTING_ERROR);
                break;
            case "product name: a to z":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> sortedNames = Ordering.natural().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, sortedNames, SORTING_ERROR);
                break;
            case "product name: z to a":
                for (WebElement productName : searchPage.productNames) {
                    arrayList.add(productName.getText());
                }
                List<String> reverseSortedNames = Ordering.natural().reverse().sortedCopy(arrayList);
                Assert.assertEquals(arrayList, reverseSortedNames, SORTING_ERROR);
                break;
            default:
                throw new IllegalStateException(INPUT_ERROR);
        }
    }
}