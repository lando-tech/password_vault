package com.landotech;

import javax.swing.JSlider;
import javax.swing.JToolTip;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

enum SliderType {
    LETTER,
    SPECIAL_CHAR,
    INTEGER
}

public class PasswordSlider extends JSlider {

    private SliderType sliderType;
    private JLabel sliderValueLabel;
    private JLabel sliderLabel;
    private JToolTip sliderToolTip;

    private final int defaultMin = 1;
    private final int defaultMax = 20;
    private final int defaultStart = 1;

    PasswordSlider(SliderType sliderType) {
        setMinMax(defaultMin, defaultMax, defaultStart);
        setSliderType(sliderType);
        setValueLabel(new JLabel(), this.getValue());
        this.addListener();
    }

    PasswordSlider(SliderType sliderType, String sliderLabel, String toolTipText) {
        setMinMax(defaultMin, defaultMax, defaultStart);
        setSliderType(sliderType);
        setValueLabel(new JLabel(), this.getValue());
        setLabel(new JLabel(), sliderLabel);
        setSliderToolTip(new JToolTip(), toolTipText);
        this.addListener();
    }

    PasswordSlider(SliderType sliderType, String sliderLabel, String toolTipText, int min, int max, int start) {
        setMinMax(min, max, start);
        setSliderType(sliderType);
        setValueLabel(new JLabel(), this.getValue());
        setLabel(new JLabel(), sliderLabel);
        setSliderToolTip(new JToolTip(), toolTipText);
        this.addListener();
    }

    public void setMinMax(int min, int max, int startingValue) {
        this.setMinimum(min);
        this.setMaximum(max);
        this.setValue(startingValue);
    }

    public SliderType getSliderType() {
        return this.sliderType;
    }

    public void setSliderType(SliderType sliderType) {
        this.sliderType = sliderType;
    }

    public JLabel getValueLabel() {
        return this.sliderValueLabel;
    }

    public void setValueLabel(JLabel label) {
        this.sliderValueLabel = label;
    }

    public void setValueLabel(JLabel label, String labelText) {
        this.sliderValueLabel = label;
        setValueLabelText(labelText);
    }

    public void setValueLabel(JLabel label, int value) {
        this.sliderValueLabel = label;
        setValueLabelText(value);
    }

    public String getValueLabelText() {
        return this.sliderValueLabel.getText();
    }

    public void setValueLabelText(String text) {
        this.sliderValueLabel.setText(text);
    }

    public void setValueLabelText(int value) {
        this.sliderValueLabel.setText(String.valueOf(value));
    }

    public void setLabel(JLabel label) {
        this.sliderLabel = label;
    }

    public void setLabel(JLabel label, String text) {
        this.sliderLabel = label;
        this.sliderLabel.setText(text);
    }

    public JLabel getLabel() {
        return this.sliderLabel;
    }

    public String getLabelText() {
        return this.sliderLabel.getText();
    }

    public void setSliderToolTip(JToolTip toolTip) {
        this.sliderToolTip = toolTip;
    }

    public void setSliderToolTip(JToolTip toolTip, String text) {
        this.sliderToolTip = toolTip;
        this.sliderToolTip.setTipText(text);
    }

    public JToolTip getSliderToolTip() {
        return this.sliderToolTip;
    }

    public String getSliderToolTipText() {
        return this.sliderToolTip.getTipText();
    }

    public void addListener() {
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource(); 
                setValueLabelText(source.getValue());
            } 
        });
    }
}
