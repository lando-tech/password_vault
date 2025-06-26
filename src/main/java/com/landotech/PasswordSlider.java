package com.landotech;

import javax.swing.JSlider;
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
    private JLabel sliderLabel;

    private final int defaultMin = 1;
    private final int defaultMax = 20;
    private final int defaultStart = 1;

    PasswordSlider(SliderType sliderType) {
        setMinMax(defaultMin, defaultMax, defaultStart);
        setSliderType(sliderType);
        setLabel(new JLabel(), this.getValue());
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

    public JLabel getLabel() {
        return this.sliderLabel;
    }

    public void setLabel(JLabel label) {
        this.sliderLabel = label;
    }

    public void setLabel(JLabel label, String labelText) {
        this.sliderLabel = label;
        setLabelText(labelText);
    }

    public void setLabel(JLabel label, int value) {
        this.sliderLabel = label;
        setLabelText(value);
    }

    public String getLabelText() {
        return this.sliderLabel.getText();
    }

    public void setLabelText(String text) {
        this.sliderLabel.setText(text);
    }

    public void setLabelText(int value) {
        this.sliderLabel.setText(String.valueOf(value));
    }

    public void addListener() {
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource(); 
                setLabelText(source.getValue());
            } 
        });
    }
}
