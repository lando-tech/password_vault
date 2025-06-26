package com.landotech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HidePasswordButton extends JButton {

    private PasswordField passwordField;

    HidePasswordButton() {
        this.setText("Show");
        changeHidden();
    }

    private void changeHidden() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (source.getText().equals("Hide")) {
                    source.setText("Show");
                    hidePassword();
                } else {
                    source.setText("Hide");
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
