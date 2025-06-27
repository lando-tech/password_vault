package com.landotech;

import javax.swing.JButton;

public class PasswordGenButton extends JButton {

    private String buttonLabel;

    PasswordGenButton(String label) {
        setLabel(label);
    }

    public void setLabel(String label) {
        this.buttonLabel = label;
        this.setText(this.buttonLabel);
    }

}
