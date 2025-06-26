package com.landotech;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;

public class PasswordFrame extends JFrame {

    private JLabel mainLabel;
    private String windowLabel;
    private PasswordPanel passwordPanel;

    private int winHeight;
    private int winWidth;
    private final int baseWidth = 400;
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

    public void addSelectionSliders(int startingRow, int startingColumn) {
        this.passwordPanel.setSlider(SliderType.LETTER, startingRow++, startingColumn);
        this.passwordPanel.setSlider(SliderType.SPECIAL_CHAR, startingRow++, startingColumn);
        this.passwordPanel.setSlider(SliderType.INTEGER, startingRow, startingColumn);
    }

    public void addSelectionSlider(SliderType sliderType, GridBagConstraints gblConstraints) {
        this.passwordPanel.setSlider(sliderType, gblConstraints);
    }

    public void addGenerateButton(int row, int col) {
        this.passwordPanel.setGenerateButton(row, col);
    }

    public void addGenerateButton(GridBagConstraints gblConstraints) {
        this.passwordPanel.setGenerateButton(gblConstraints);
    }

    public void addPasswordField(int row, int col) {
        this.passwordPanel.setPasswordField(row, col);
    }

    public void addPasswordField(GridBagConstraints gblConstraints) {
        this.passwordPanel.setPasswordField(gblConstraints);
    }

    public void addHidePasswordButton(int row, int col) {
        this.passwordPanel.setHideButton(row, col);
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

    public void setPanelBorder(Color backgroundColor) {
        this.passwordPanel.addEmptyBorder(backgroundColor);
    }
}
