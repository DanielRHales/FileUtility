package com.frame.action.impl;

import com.frame.action.UIAction;
import com.frame.component.tab.FileTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniel
 */
public class RemoveTabAction extends UIAction implements ActionListener {

    private final FileTab tab;

    private RemoveTabAction(FileTab tab, AbstractButton button) {
        this.tab = tab;
        button.addActionListener(this);
    }

    public static void apply(FileTab tab, AbstractButton button) {
        new RemoveTabAction(tab, button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        removeTab(tab);
    }
}
