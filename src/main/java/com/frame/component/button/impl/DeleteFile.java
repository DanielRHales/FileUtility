package com.frame.component.button.impl;

import com.frame.component.button.ControlButton;
import com.frame.component.table.FileTable;
import com.resource.Resource;

import javax.swing.*;

/**
 * @author Daniel
 */
public class DeleteFile extends ControlButton {

    public DeleteFile(FileTable table) {
        super(table);
    }

    @Override
    public void process() {
        if (!table.getFile().delete()) {
            table.getFile().deleteOnExit();
        }
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon(Resource.DELETE_FILE);
    }

    @Override
    public String getToolTip() {
        return "Delete File";
    }
}
