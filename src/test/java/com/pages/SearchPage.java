package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@class='search_query form-control ac_input']")
    public WebElement searchBoxInput;

    @FindBy(how = How.XPATH, using = "//form[@id='searchbox']//button[@type='submit']")
    public WebElement searchBoxSubmit;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    public WebElement searchResultsNumber;

    @FindBy(how = How.XPATH, using = "//select[@id='selectProductSort']")
    public WebElement dropdownSortBy;

    @FindBy(how = How.XPATH, using = "//div[@id='center_column']//p")
    public WebElement noResultsWereFoundHeader;

    @FindBy(how = How.XPATH, using = "//div[@class='right-block']//a[@class='product-name']")
    public List<WebElement> productNames;

    @FindBy(how = How.XPATH, using = "//div[@class='right-block']//div[@class='content_price']//span[@class='price product-price']")
    public List<WebElement> productPrices;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}