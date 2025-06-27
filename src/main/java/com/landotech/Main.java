package com.landotech;

public class Main {
    public static void main( String[] args ) {
        GBCHandler gbcHandler = new GBCHandler(0, 0, 5, 3);
        PasswordFrame mainFrame = new PasswordFrame("Password Vault", 2, 2);

        PasswordPanel passwordPanel = new PasswordPanel();
        mainFrame.setPasswordPanel(passwordPanel);

        PanelConfigurator panelConfigurator = new PanelConfigurator(mainFrame, gbcHandler);
        panelConfigurator.configurePasswordPanel();

        mainFrame.setVisible(true);
    }
}
