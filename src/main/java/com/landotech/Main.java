package com.landotech;

import java.awt.GridBagConstraints;
import java.awt.Insets;


public class Main {
    public static void main( String[] args ) {
        PasswordFrame mainFrame = new PasswordFrame("Java Swing PW", 2, 1);
        PasswordPanel passwordPanel = new PasswordPanel();
        mainFrame.setPasswordPanel(passwordPanel);

        configureSliders(mainFrame);
        configureGenButton(mainFrame);
        configurePasswordField(mainFrame);
        // mainFrame.addPasswordField(4, 0);
        mainFrame.addHidePasswordButton(4, 1);

        mainFrame.setVisible(true);
    }

    public static void configureSliders(PasswordFrame mainFrame) {
        configureLetterSlider(mainFrame);
        configureSpecialCharSlider(mainFrame);
        configureIntSlider(mainFrame);
    }

    public static void configureLetterSlider(PasswordFrame mainFrame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 5, 5);
        mainFrame.addSelectionSlider(SliderType.LETTER, gbc);
    }

    public static void configureSpecialCharSlider(PasswordFrame mainFrame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 5, 5);
        mainFrame.addSelectionSlider(SliderType.SPECIAL_CHAR, gbc);
    }

    public static void configureIntSlider(PasswordFrame mainFrame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 5, 5);
        mainFrame.addSelectionSlider(SliderType.INTEGER, gbc);
    }

    public static void configureGenButton(PasswordFrame mainFrame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.insets = new Insets(4, 4, 4, 4);
        mainFrame.addGenerateButton(gbc);
    }

    public static void configurePasswordField(PasswordFrame mainFrame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.insets = new Insets(4, 4, 4, 4);
        mainFrame.addPasswordField(gbc, 20);
    }
}
