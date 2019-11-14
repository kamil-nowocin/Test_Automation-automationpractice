package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//input[@class='search_query form-control ac_input']")
    public WebElement searchBoxInput;

    @FindBy(how = How.XPATH, using = "//form[@id='searchbox']//button[@type='submit']")
    public WebElement searchBoxSubmit;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    public WebElement searchResultsNumber;

    @FindBy(how = How.XPATH, using = "//select[@id='selectProductSort']")
    public WebElement dropdownSortBy;
}