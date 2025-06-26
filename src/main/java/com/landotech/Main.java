package com.landotech;

// import java.util.Scanner;

public class Main {
    public static void main( String[] args ) {
        // PasswordEngine passwordEngine = new PasswordEngine();
        // String password = passwordEngine.generatePassword(16);
        // System.out.println(password);
        // System.out.println(password.length());

        PasswordFrame mainWindow = new PasswordFrame("Java Swing PW", 2, 1);
        mainWindow.setMainLabel("Password Generator");

        PasswordPanel passwordPanel = new PasswordPanel();
        mainWindow.setPasswordPanel(passwordPanel);

        mainWindow.addSelectionSliders(0, 0);
        mainWindow.addGenerateButton(3, 0);
        mainWindow.addPasswordField(4, 0);
        mainWindow.addHidePasswordButton(4, 1);
        mainWindow.setVisible(true);
    }
}
