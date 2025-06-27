package com.landotech;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PasswordPanel extends JPanel {

    private PasswordSlider letterSlider;
    private PasswordSlider specialCharSlider;
    private PasswordSlider intSlider;

    private PasswordGenButton generateButton;
    private HidePasswordButton hidePasswordButton;
    private PasswordField passwordField;
    private GenerationHandler generationHandler;

    PasswordPanel() {
        this.setLayout(getGblayout());
        this.setGenerationHandler();
    }

    private GridBagLayout getGblayout() {
        return new GridBagLayout();
    }

    private void addSliderLabel(JLabel sliderLabel, GridBagConstraints gbc) {
        this.add(sliderLabel, gbc);
    }

    private void addSlider(PasswordSlider passwordSlider, GridBagConstraints gbc) {
        this.add(passwordSlider, gbc);
        this.generationHandler.addSlider(passwordSlider);
    }

    private void addSliderToolTip(PasswordSlider slider, String toolTipText) {
        slider.setToolTipText(toolTipText);
    }

    private void addGenerateButton(PasswordGenButton passwordGenButton, GridBagConstraints gbc) {
        this.add(passwordGenButton, gbc);
    }

    private void addPasswordField(PasswordField passwordField, GridBagConstraints gbc) {
        this.add(passwordField, gbc);
        this.generationHandler.setPasswordField(this.passwordField);
    }

    private void addHidePasswordButton(HidePasswordButton hidePasswordButton, GridBagConstraints gbc) {
        this.add(hidePasswordButton, gbc);
    }

    private void setGenerationHandler() {
        this.generationHandler = new GenerationHandler();
    }

    public GenerationHandler generationHandler() {
        return this.generationHandler;
    }

    public void setGenerateButton(GridBagConstraints gbc) {
        this.generateButton = new PasswordGenButton("Generate");
        this.generateButton.addActionListener(this.generationHandler);
        addGenerateButton(generateButton, gbc);
    }

    public void setHideButton(GridBagConstraints gbc) {
        this.hidePasswordButton = new HidePasswordButton();
        this.hidePasswordButton.addField(this.passwordField);
        addHidePasswordButton(hidePasswordButton, gbc);
    }

    public void setPasswordField(GridBagConstraints gbc, int startingWidth) {
        this.passwordField = new PasswordField(startingWidth);
        addPasswordField(passwordField, gbc);
    }

    public void setLetterSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.letterSlider = new PasswordSlider(SliderType.LETTER, sliderLabel, toolTipText);
        addSlider(this.letterSlider, gbc);
        addSliderToolTip(this.letterSlider, toolTipText);
    }

    public void setLetterSliderLabel(GridBagConstraints gbc) {
        addSliderLabel(this.letterSlider.getLabel(), gbc);
    }

    public void setLetterSliderValueLabel(GridBagConstraints gbc) {
        addSliderLabel(this.letterSlider.getValueLabel(), gbc);
    }

    public void setSpecialCharSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.specialCharSlider = new PasswordSlider(SliderType.SPECIAL_CHAR, sliderLabel, toolTipText);
        addSlider(this.specialCharSlider, gbc);
        addSliderToolTip(this.specialCharSlider, toolTipText);
    }

    public void setSpecialCharSliderLabel(GridBagConstraints gbc) {
        addSliderLabel(this.specialCharSlider.getLabel(), gbc);
    }

    public void setSpecialCharSliderValueLabel(GridBagConstraints gbc) {
        addSliderLabel(this.specialCharSlider.getValueLabel(), gbc);
    }

    public void setIntSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.intSlider = new PasswordSlider(SliderType.INTEGER, sliderLabel, toolTipText);
        addSlider(this.intSlider, gbc);
        addSliderToolTip(this.intSlider, toolTipText);
    }

    public void setIntSliderLabel(GridBagConstraints gbc) {
        addSliderLabel(this.intSlider.getLabel(), gbc);
    }

    public void setIntSliderValueLabel(GridBagConstraints gbc) {
        addSliderLabel(this.intSlider.getValueLabel(), gbc);
    }

    public void addEmptyBorder(Color bgColor, Insets insets) {
        this.setBorder(new EmptyBorder(insets));
        this.setBackground(bgColor);
    }
}
