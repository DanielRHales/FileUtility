package com.frame.component.panel;

import com.frame.component.button.ControlButton;
import com.frame.component.button.util.ButtonList;
import com.frame.component.table.FileTable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel
 */
class ControlPanel extends JPanel {

    private final FileTable table;

    ControlPanel(FileTable table) {
        this.table = table;
        initialize();
    }

    private void initialize() {
        setLayout(new GridBagLayout());
        for (ControlButton button : new ButtonList(table).list()) {
            add(button, new GridBagConstraints());
        }
    }

}
