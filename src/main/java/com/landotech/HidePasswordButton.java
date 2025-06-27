package com.landotech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HidePasswordButton extends JButton {

    private PasswordField passwordField;

    @SuppressWarnings("unused")
    private final String openEye = "\uD83D\uDC41"; 
    @SuppressWarnings("unused")
    private final String closedEye = "\uD83D\uDC41\u0338"; 

    @SuppressWarnings("unused")
    private final String hide = "Hide";
    @SuppressWarnings("unused")
    private final String show = "Show";

    HidePasswordButton() {
        this.setText(show);
        changeHidden();
    }

    private void changeHidden() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source.getText().equals(hide)) {
                    source.setText(show);
                    hidePassword();
                } else {
                    source.setText(hide);
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
