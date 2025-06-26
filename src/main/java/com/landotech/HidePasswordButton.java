package com.landotech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HidePasswordButton extends JButton {

    private PasswordField passwordField;

    private final String openEye = "\uD83D\uDC41"; 
    private final String closedEye = "\uD83D\uDC41\u0338"; 

    HidePasswordButton() {
        this.setText(openEye);
        changeHidden();
    }

    private void changeHidden() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source.getText().equals(closedEye)) {
                    source.setText(openEye);
                    hidePassword();
                } else {
                    source.setText(closedEye);
                    unhidePassword();
                }
            }  
        });
    }

    private void hidePassword() {
        this.passwordField.setEchoChar('*');
    }

    private void unhidePassword() {
        this.passwordField.setEchoChar((char) 0);
    }

    public void addField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public PasswordField getField() {
        return this.passwordField;
    }
}
