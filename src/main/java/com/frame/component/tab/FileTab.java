package com.frame.component.tab;

import com.frame.action.impl.RemoveTabAction;
import com.resource.Resource;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

/**
 * @author Daniel
 */
public class FileTab extends JPanel {

    private final File file;

    public FileTab(File file) {
        this.file = file;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setOpaque(false);
        final JLabel label = new JLabel(file.getName(), TabIconHandler.get(file), SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(0, 5, 0, 5));
        final JButton button = new JButton(Resource.FRAME_ICON_LOADER.get("Close_16x16").getIcon());
        RemoveTabAction.apply(this, button);
        add(label, "Center");
        add(button, "East");
    }

}
