package com.steps;

import com.DriverFactory;
import com.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners({Hooks.class})
public class SearchPageSteps extends DriverFactory {

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
        Assert.assertEquals(howMuchResults, expectedResults, WRONG_RESULTS_NUMBER + expectedResults);
    }

    @Step("I select from Dropdown Sort by {string}")
    @Then("I select from Dropdown Sort by {string}")
    public void iSelectFromDropdownSortBy(String sortBy) {
        //{TODO}
    }

    @Step("I can see that results are correctly sorted by {string}")
    @And("I can see that results are correctly sorted by {string}")
    public void iCanSeeThatResultsAreCorrectlySortedBy(String sortBy) {
        //{TODO}
    }
}