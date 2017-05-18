package com.frame.component.button.impl;

import com.frame.component.button.ControlButton;
import com.frame.component.table.FileTable;
import com.resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class OpenDesktopFile extends ControlButton {

    public OpenDesktopFile(FileTable table) {
        super(table);
        setEnabled(Desktop.isDesktopSupported());
    }

    @Override
    public void process() {
        try {
            Desktop.getDesktop().open(table.getFile());
        } catch (IOException ex) {
            Logger.getLogger(OpenDesktopFile.class.getName()).log(Level.WARNING, String.format("Error opening file on '%s' on desktop.", table.getFile().getAbsolutePath()), ex);
        }
    }

    @Override
    public ImageIcon getIcon() {
        return Resource.FRAME_ICON_LOADER.get("OpenDesktopFile_16x16").getIcon();
    }

    @Override
    public String getToolTip() {
        return "Open File on Desktop";
    }
}
