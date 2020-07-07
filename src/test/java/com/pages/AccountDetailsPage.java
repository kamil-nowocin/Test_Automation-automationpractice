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

public class AccountDetailsPage extends BasePage<AccountDetailsPage> {

    //VIEW//
    @FindBy(how = How.XPATH, using = "//p[@class='info-account']")
    public WebElement myAccountDetailsDashboard;

    public AccountDetailsPage() {
        super("/index.php");
    }
}