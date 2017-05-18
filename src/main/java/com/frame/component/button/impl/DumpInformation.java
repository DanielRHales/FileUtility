package com.frame.component.button.impl;

import com.frame.UI;
import com.frame.component.button.ControlButton;
import com.frame.component.table.FileTable;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class DumpInformation extends ControlButton {

    private final FileTable table;

    public DumpInformation(FileTable table) {
        super(table);
        this.table = table;
    }

    @Override
    public void process() {
        initialize();
    }

    @Override
    public ImageIcon getIcon() {
        return Resource.FRAME_ICON_LOADER.get("DumpInformation_16x16").getIcon();
    }

    private void initialize() {
        final File directory = getDirectory();
        if (directory != null) {
            final String name = JOptionPane.showInputDialog(UI.getInstance(), "Name The File", "File Name", JOptionPane.INFORMATION_MESSAGE);
            if (name != null && !name.trim().isEmpty()) {
                final File file = new File(directory, name);
                if (!file.exists() && !file.isDirectory()) {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(table.getArray(), new TypeToken<Object[][]>(){}.getType()));
                        writer.newLine();
                        writer.flush();
                        writer.close();
                    } catch (Exception ex) {
                        Logger.getLogger(DumpInformation.class.getName()).log(Level.WARNING, String.format("Error dumping information for file '%s' to '%s'.", table.getFile().getAbsolutePath(), file.getAbsolutePath()), ex);
                    }
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ex) {
                            Logger.getLogger(DumpInformation.class.getName()).log(Level.WARNING, String.format("Error opening file '%s'.", file.getAbsolutePath()), ex);
                        }
                    }
                }
            }
        }
    }

    private File getDirectory() {
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(String.format("%s%s", System.getenv("SystemDrive"), System.getProperty("file.separator"))));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    @Override
    public String getToolTip() {
        return "Dump File Information";
    }
}
