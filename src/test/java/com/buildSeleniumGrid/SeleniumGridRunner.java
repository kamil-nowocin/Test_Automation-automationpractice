package com.buildSeleniumGrid;

import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;

import java.util.concurrent.TimeUnit;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class SeleniumGridRunner {

    public static void main(String[] args) throws InterruptedException {
        GridHubConfiguration gridHubConfiguration = new GridHubConfiguration();
        gridHubConfiguration.port = 4444;
        LocalHub localHub = new LocalHub(gridHubConfiguration);
        localHub.start();

        GridNodeConfiguration gridNodeConfiguration = new GridNodeConfiguration();
        gridNodeConfiguration.port = 5555;
        LocalNode localNode = new LocalNode(gridNodeConfiguration);
        localNode.start();

        //TODO - Better configuration of start & stop
        TimeUnit.SECONDS.sleep(1000);

        localNode.stop();
        localHub.stop();
    }
}