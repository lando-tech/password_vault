package com.landotech;

import java.awt.Color;

public class Main {
    public static void main( String[] args ) {
        PasswordFrame mainWindow = new PasswordFrame("Java Swing PW", 2, 1);
        mainWindow.setMainLabel("Password Generator");

        PasswordPanel passwordPanel = new PasswordPanel();
        mainWindow.setPasswordPanel(passwordPanel);
        mainWindow.setPanelBorder(Color.WHITE);

        mainWindow.addSelectionSliders(0, 0);
        mainWindow.addSelectionSlider(SliderType.LETTER, new GridBagConstraints());
        mainWindow.addGenerateButton(3, 0);
        mainWindow.addPasswordField(4, 0);
        mainWindow.addHidePasswordButton(4, 1);

        mainWindow.setVisible(true);
    }
}
