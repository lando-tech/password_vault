package com.landotech;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class PasswordFrame extends JFrame {

    private JLabel mainLabel;
    private String windowLabel;
    private PasswordPanel passwordPanel;

    private int winHeight;
    private int winWidth;
    private final int baseWidth = 500;
    private final int baseHeight = 400;

    PasswordFrame(String windowLabel) {
        setWinLabel(windowLabel);
        setWinSize();
        addExitListener();
    }

    PasswordFrame(String windowLabel, int rows, int cols) {
        setWinLabel(windowLabel);
        setWinSize();
        setGridLayout(rows, cols);
        addExitListener();
    }

    PasswordFrame(String windowLabel, int rows, int cols, int width, int height) {
        setWinLabel(windowLabel);
        setWinSize(width, height);
        setGridLayout(rows, cols);
        addExitListener();
    }

    private void setWidth(int width) {
        this.winWidth = width;
    }

    private void setHeight(int height) {
        this.winHeight = height;
    }

    @SuppressWarnings("unused")
    private int getWinWidth() {
        return this.winWidth;
    }

    @SuppressWarnings("unused")
    private int getWinHeight() {
        return this.winHeight;
    }

    private void addExitListener() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void addPasswordPanel() {
        this.add(this.passwordPanel);
    }
    
    public void setMainLabel(String label) {
        this.mainLabel = new JLabel(label, JLabel.CENTER);
        this.add(this.mainLabel);
    }
    
    public void setPasswordPanel(PasswordPanel passwordPanel) {
        this.passwordPanel = passwordPanel;
        addPasswordPanel();
    }

    public void addLetterSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.passwordPanel.setLetterSlider(gbc, sliderLabel, toolTipText);
    }

    public void addLetterSliderLabel(GridBagConstraints gbc) {
        this.passwordPanel.setLetterSliderLabel(gbc);
    }

    public void addLetterSliderValueLabel(GridBagConstraints gbc) {
        this.passwordPanel.setLetterSliderValueLabel(gbc);
    }

    public void addSpecialCharSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.passwordPanel.setSpecialCharSlider(gbc, sliderLabel, toolTipText);
    }

    public void addSpecialCharSliderLabel(GridBagConstraints gbc) {
        this.passwordPanel.setSpecialCharSliderLabel(gbc);
    }

    public void addSpecialCharSliderValueLabel(GridBagConstraints gbc) {
        this.passwordPanel.setSpecialCharSliderValueLabel(gbc);
    }

    public void addIntSlider(GridBagConstraints gbc, String sliderLabel, String toolTipText) {
        this.passwordPanel.setIntSlider(gbc, sliderLabel, toolTipText);
    }

    public void addIntSliderLabel(GridBagConstraints gbc) {
        this.passwordPanel.setIntSliderLabel(gbc);
    }

    public void addIntSliderValueLabel(GridBagConstraints gbc) {
        this.passwordPanel.setIntSliderValueLabel(gbc);
    }

    public void addGenerateButton(GridBagConstraints gblConstraints) {
        this.passwordPanel.setGenerateButton(gblConstraints);
    }

    public void addPasswordField(GridBagConstraints gblConstraints, int startingWidth) {
        this.passwordPanel.setPasswordField(gblConstraints, startingWidth);
    }

    public void addHidePasswordButton(GridBagConstraints gblConstraints) {
        this.passwordPanel.setHideButton(gblConstraints);
    }

    public void setWinLabel(String windowLabel) {
        this.windowLabel = windowLabel;
        this.setTitle(this.windowLabel);
    }

    public void setWinSize() {
        setWidth(baseWidth);
        setHeight(baseHeight);
        this.setSize(winWidth, winHeight);
    }

    public void setWinSize(int width, int height) {
        setWidth(width);
        setHeight(height);
        this.setSize(winWidth, winHeight);
    }

    public void setGridLayout(int rows, int cols) {
        this.setLayout(new GridLayout(rows, cols));
    }

    public void setPanelBorder(Color backgroundColor, Insets insets) {
        this.passwordPanel.addEmptyBorder(backgroundColor, insets);
    }
}
