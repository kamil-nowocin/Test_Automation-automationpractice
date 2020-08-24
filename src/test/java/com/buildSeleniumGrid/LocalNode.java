package com.buildSeleniumGrid;

import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

/**
 * Test_Automation-automationpractice
 *
 * @author kamil.nowocin
 **/

public class LocalNode {

    private final SelfRegisteringRemote selfRegisteringRemoteNode;

    public LocalNode(GridNodeConfiguration gridNodeConfiguration) {
        selfRegisteringRemoteNode = new SelfRegisteringRemote(gridNodeConfiguration);
        SeleniumServer seleniumServer = new SeleniumServer(selfRegisteringRemoteNode.getConfiguration());
        selfRegisteringRemoteNode.setRemoteServer(seleniumServer);
    }

    public void start() {
        if (selfRegisteringRemoteNode.startRemoteServer()) {
            selfRegisteringRemoteNode.sendRegistrationRequest();
        }
    }

    public void stop() {
        selfRegisteringRemoteNode.stopRemoteServer();
    }
}