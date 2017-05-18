package com.frame.component.button.impl;

import com.frame.component.button.ControlButton;
import com.frame.component.table.FileTable;
import com.resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class OpenURIFile extends ControlButton {

    public OpenURIFile(FileTable table) {
        super(table);
        setEnabled(Desktop.isDesktopSupported());
    }

    @Override
    public void process() {
        try {
            Desktop.getDesktop().browse(table.getFile().toURI());
        } catch (Exception ex) {
            Logger.getLogger(OpenDesktopFile.class.getName()).log(Level.WARNING, String.format("Error opening file '%s' in the browser.", table.getFile().getAbsolutePath()), ex);
        }
    }

    @Override
    public ImageIcon getIcon() {
        return Resource.FRAME_ICON_LOADER.get("OpenBrowserFile_16x16").getIcon();
    }

    @Override
    public String getToolTip() {
        return "Open File in Browser";
    }
}
