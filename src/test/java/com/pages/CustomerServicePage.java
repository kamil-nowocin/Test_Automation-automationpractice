package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerServicePage extends BasePage {

    public CustomerServicePage(final WebDriver driver) {
        super(driver);
    }

    //GENERAL
    @FindBy(how = How.ID, using = "TODO")
    private WebElement TODO;
}