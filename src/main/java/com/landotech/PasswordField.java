package com.landotech;

import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField {

    private String passwordText;

    PasswordField(int width) {
        this.setColumns(width);
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
        this.setText(this.passwordText);
    }

    public String getPasswordText() {
        return this.passwordText;
    }

    public void refreshField() {
        if (this.getParent() != null) {
            this.getParent().revalidate();
            this.repaint();
        }
    }
}
