package com.frame.action;

import com.frame.component.button.ControlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniel
 */
public class ControlButtonAction implements ActionListener {

    private final ControlButton button;

    private ControlButtonAction(ControlButton button) {
        this.button = button;
        this.button.addActionListener(this);
    }

    public static void apply(ControlButton button) {
        new ControlButtonAction(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        button.process();
    }
}
