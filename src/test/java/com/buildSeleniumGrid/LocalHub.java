package com.buildSeleniumGrid;

import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class LocalHub {

    private static Hub hub;

    public LocalHub(GridHubConfiguration gridHubConfiguration) {
        hub = new Hub(gridHubConfiguration);
    }

    public void start() {
        hub.start();
    }

    public void stop() {
        hub.stop();
    }
}