package com.landotech;

import javax.swing.JPanel;
// import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PasswordPanel extends JPanel {

    private PasswordSlider letterSlider;
    private PasswordSlider specialCharSlider;
    private PasswordSlider intSlider;

    private GridBagConstraints gblConstraints;
    private PasswordGenButton generateButton;
    private HidePasswordButton hidePasswordButton;
    private PasswordField passwordField;

    private GenerationHandler generationHandler;

    PasswordPanel() {
        this.setLayout(getGblayout());
        this.setGblConstraints();
        this.setGenerationHandler();
    }

    private GridBagLayout getGblayout() {
        return new GridBagLayout();
    }

    private void setGblConstraints() {
        this.gblConstraints = new GridBagConstraints();
    }

    private void setGblGridXY(int row, int col) {
        this.gblConstraints.gridx = col;
        this.gblConstraints.gridy = row;
    }

    private void addSliderLabel(JLabel sliderLabel, int row, int column) {
        setGblGridXY(row, column);
        this.add(sliderLabel, this.gblConstraints);
    }

    private void addSlider(PasswordSlider slider, int row, int col) {
        setGblGridXY(row, col);
        this.add(slider, this.gblConstraints);
        this.generationHandler.addSlider(slider);
    }

    private void addGenerateButton(PasswordGenButton passwordGenButton, int row, int col) {
        setGblGridXY(row, col);
        this.add(passwordGenButton, this.gblConstraints);
    }

    private void addPasswordField(PasswordField passwordField, int row, int col) {
        setGblGridXY(row, col);
        this.add(this.passwordField, this.gblConstraints);
        this.generationHandler.setPasswordField(this.passwordField);
    }

    private void addHidePasswordButton(HidePasswordButton hidePasswordButton, int row, int col) {
        setGblGridXY(row, col);
        this.add(hidePasswordButton, this.gblConstraints);
    }

    private void setGenerationHandler() {
        this.generationHandler = new GenerationHandler();
    }

    public GenerationHandler generationHandler() {
        return this.generationHandler;
    }

    public GridBagConstraints getGblConstraints() {
        return this.gblConstraints;
    }

    public void setGenerateButton(int row, int col) {
        this.generateButton = new PasswordGenButton("Generate");
        this.generateButton.addActionListener(this.generationHandler);
        addGenerateButton(generateButton, row, col);
    }

    public void setPasswordField(int row, int col) {
        this.passwordField = new PasswordField();
        addPasswordField(passwordField, row, col);
    }

    public void setHideButton(int row, int col) {
        this.hidePasswordButton = new HidePasswordButton();
        this.hidePasswordButton.addField(this.passwordField);
        addHidePasswordButton(hidePasswordButton, row, col);
    }

    public void setSlider(SliderType sliderType, int row, int col) {
        switch (sliderType) {
            case LETTER:
                this.letterSlider = new PasswordSlider(sliderType); 
                addSlider(this.letterSlider, row, col);
                addSliderLabel(this.letterSlider.getLabel(), row, col + 1);
                break;
            case SPECIAL_CHAR:
                this.specialCharSlider = new PasswordSlider(sliderType);
                addSlider(this.specialCharSlider, row, col);
                addSliderLabel(this.specialCharSlider.getLabel(), row, col + 1);
                break;
            case INTEGER:
                this.intSlider = new PasswordSlider(sliderType);
                addSlider(this.intSlider, row, col);
                addSliderLabel(this.intSlider.getLabel(), row, col + 1);
                break;
            default:
                throw new IllegalArgumentException("Must define slider type: ['LETTER', 'SPECIAL_CHAR', 'INTEGER']");
        }
    }
}
