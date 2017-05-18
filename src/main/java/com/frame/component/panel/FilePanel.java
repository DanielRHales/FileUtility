package com.frame.component.panel;

import com.frame.component.table.FileTable;
import com.util.ScrollProperty;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel
 */
public class FilePanel extends JPanel {

    private final FileTable table;

    private final ControlPanel controlPanel;

    public FilePanel(FileTable table) {
        this.table = table;
        this.controlPanel = new ControlPanel(this.table);
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        ScrollProperty.setScrollProperty(scrollPane, 2, 0);
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

}
