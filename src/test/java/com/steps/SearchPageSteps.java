package com.steps;

import com.DriverFactory;
import com.pages.SearchPage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

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
        }
    }

    @Step("I can see that results are correctly sorted by {string}")
    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String sortedBy) {
        //{TODO}
        switch (sortedBy.toLowerCase()) {
            case "price: lowest first":

                break;
            case "price: highest first":

                break;
            case "product name: a to z":

                break;
            case "product name: z to a":

                break;
        }
    }
}