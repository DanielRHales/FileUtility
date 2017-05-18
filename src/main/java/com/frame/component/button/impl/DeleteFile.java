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
        return Resource.FRAME_ICON_LOADER.get("DeleteFile_16x16").getIcon();
    }

    @Override
    public String getToolTip() {
        return "Delete File";
    }
}
