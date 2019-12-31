package com.steps;

import com.DriverFactory;
import com.listeners.TestNGListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class Hooks extends DriverFactory implements ITestListener {

    /**
     * For Cucumber -> Feature file
     **/
    @Before
    public void beforeScenario(Scenario scenario) {
        TestNGListener.onScenarioStart(scenario);
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) {
        TestNGListener.onScenarioFinish(scenario);
        if (scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
//            FileUtils.copyFile(scrFile, new File(currentPath + "/screenshots/" + scenario.getName()
//                    + "-" + TODAY_DATE + ".png"));
            TestNGListener.allureSaveTextLog();
            TestNGListener.allureSaveScreenshotPNG();
        }
        destroyDriver();
    }

    /**
     * For TestNG -> @Test annotation
     **/
    @BeforeMethod
    public void beforeTest() {
        startBrowser();
    }

    @AfterMethod
    public void afterTest() {
        destroyDriver();
    }
}