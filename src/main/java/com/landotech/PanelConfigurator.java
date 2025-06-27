package com.landotech;

public class PanelConfigurator {

    private GBCHandler gbcHandler;
    private PasswordFrame mainFrame;

    PanelConfigurator(PasswordFrame mainFrame, GBCHandler gbcHandler) {
        this.mainFrame = mainFrame;
        this.gbcHandler = gbcHandler;
    }

    public void configurePasswordPanel() {
        configureLetterSlider("Letters:", "Number of lower/uppercase letters");
        configureSpecialCharSlider("Special Characters:", "Number of special characters");
        configureIntSlider("Numbers:", "Number of integers");
        configureGenerateButton();
        configurePasswordField(20);
        configureHidePasswordButton();
    }

    public void configureLetterSlider(String label, String toolTipText) {
        mainFrame.addLetterSlider(gbcHandler.nextConstraintsColumn(), label, toolTipText);
        mainFrame.addLetterSliderLabel(gbcHandler.prevConstraintsColumn()); // Add label to the left
        mainFrame.addLetterSliderValueLabel(gbcHandler.nextConstraintsColumn());
        gbcHandler.resetColumn();
    }

    public void configureSpecialCharSlider(String label, String toolTipText) {
        gbcHandler.incrementRow();
        mainFrame.addSpecialCharSlider(gbcHandler.nextConstraintsColumn(), label, toolTipText);
        mainFrame.addSpecialCharSliderLabel(gbcHandler.prevConstraintsColumn());
        mainFrame.addSpecialCharSliderValueLabel(gbcHandler.nextConstraintsColumn());
        gbcHandler.resetColumn();
    }

    public void configureIntSlider(String label, String toolTipText) {
        gbcHandler.incrementRow();
        mainFrame.addIntSlider(gbcHandler.nextConstraintsColumn(), label, toolTipText);
        mainFrame.addIntSliderLabel(gbcHandler.prevConstraintsColumn());
        mainFrame.addIntSliderValueLabel(gbcHandler.nextConstraintsColumn());
        gbcHandler.resetColumn();
    }

    public void configureGenerateButton() {
        gbcHandler.incrementRow();
        mainFrame.addGenerateButton(gbcHandler.nextConstraintsColumn());
        gbcHandler.resetColumn();
    }

    public void configurePasswordField(int startingWidth) {
        gbcHandler.incrementRow();
        mainFrame.addPasswordField(gbcHandler.nextConstraintsColumn(), startingWidth);
        gbcHandler.resetColumn();
    }

    public void configureHidePasswordButton() {
        gbcHandler.incrementColumn();
        mainFrame.addHidePasswordButton(gbcHandler.nextConstraintsColumn());
        gbcHandler.resetColumn();
    }
}
