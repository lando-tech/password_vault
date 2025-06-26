package com.landotech;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerationHandler implements ActionListener {

    private ArrayList<PasswordSlider> sliderArray;
    private PasswordField passwordField;

    private int numChars;
    private int numSpecialChars;
    private int numInts;

    private final int standardLength = 20;

    GenerationHandler() {
        this.sliderArray = new ArrayList<>();
    }

    private void setSliderValues() {
        if (this.sliderArray.isEmpty()) {
            throw new IllegalAccessError("sliderArray cannot be empty");
        }
        for (var it : this.sliderArray) {
            if (it.getSliderType() == SliderType.LETTER) {
                this.numChars = it.getValue();
            } else if (it.getSliderType() == SliderType.SPECIAL_CHAR) {
                this.numSpecialChars = it.getValue();
            } else {
                this.numInts = it.getValue();
            }
        }
    }

    private boolean verifySliderValues() {
        if (numChars <= 0 || numSpecialChars <= 0 || numInts <= 0) {
            throw new IllegalAccessError("numChars, numSpecialChars, numInts must greater than 0");
        } else if (numChars == 1 && numSpecialChars == 1 && numInts == 1) {
            return false;
        }
        return true;
    }

    public void addSlider(PasswordSlider slider) {
        this.sliderArray.add(slider);
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public PasswordField getPasswordField() {
        return this.passwordField;
    }

    public String generateUniquePassword() {
        PasswordEngine passwordEngine = new PasswordEngine();
        return passwordEngine.generatePassword(this.numChars, this.numSpecialChars, this.numInts);
    }

    public String generateStandardPassword() {
        PasswordEngine passwordEngine = new PasswordEngine();
        return passwordEngine.generatePassword(standardLength);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        setSliderValues(); 
        if (!verifySliderValues()) {
            this.passwordField.setPasswordText(generateStandardPassword());
        } else {
            this.passwordField.setPasswordText(generateUniquePassword());
        }
        this.passwordField.refreshField();
    }
}
