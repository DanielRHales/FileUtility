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
public class PrintFile extends ControlButton {

    public PrintFile(FileTable table) {
        super(table);
        setEnabled(Desktop.isDesktopSupported());
    }

    @Override
    public void process() {
        try {
            Desktop.getDesktop().print(table.getFile());
        } catch (IOException ex) {
            Logger.getLogger(OpenURIFile.class.getName()).log(Level.WARNING, String.format("Error printing file '%s'.", table.getFile().getAbsolutePath()), ex);
        }
    }

    @Override
    public ImageIcon getIcon() {
        return Resource.FRAME_ICON_LOADER.get("PrintFile_16x16").getIcon();
    }

    @Override
    public String getToolTip() {
        return "Print File";
    }
}
