package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class AccountDetailsPage extends BasePage {

    //VIEW//
    @FindBy(how = How.CSS, using = "#center_column > p")
    public WebElement myAccountDetailsDashboard;
}