package com.frame.component.button;

import com.frame.action.ControlButtonAction;
import com.frame.component.table.FileTable;

import javax.swing.*;

/**
 * @author Daniel
 */
public abstract class ControlButton extends JButton {

    protected final FileTable table;

    protected ControlButton(FileTable table) {
        this.table = table;
        if (getIcon() != null) {
            setIcon(getIcon());
        }
        if (getToolTip() != null) {
            setToolTipText(getToolTip());
        }
        ControlButtonAction.apply(this);
    }

    public abstract void process();

    public abstract ImageIcon getIcon();

    public abstract String getToolTip();

}
