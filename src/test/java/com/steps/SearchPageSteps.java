package com.steps;

import com.DriverFactory;
import com.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchPageSteps extends DriverFactory {

    private SearchPage searchPage = new SearchPage(driver);

    @When("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) {
        searchPage.searchBoxInput.sendKeys(searchPhrase);
    }

    @And("I click on search icon")
    public void iClickOnSearchIcon() {
        searchPage.searchBoxSubmit.click();
    }

    @Then("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedResults) {
        //ARRANGE
        String howMuchResults = searchPage.searchResultsNumber.getText().replaceAll("[^\\d]", "");

        //ASSERT
        Assert.assertEquals(howMuchResults, expectedResults, WRONG_RESULTS_NUMBER + expectedResults);
    }

    @Then("I select from Dropdown Sort by {string}")
    public void iSelectFromDropdownSortBy(String arg0) {
    }

    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String arg0) {
    }
}