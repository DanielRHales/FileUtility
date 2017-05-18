package com.frame.action.impl;

import com.frame.action.UIAction;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class DropTargetAction extends UIAction {

    private final Component component;

    private DropTargetAction(Component component) {
        this.component = component;
        initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
        component.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent event) {
                try {
                    event.acceptDrop(DnDConstants.ACTION_COPY);
                    for (File file : (List<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor)) {
                        if (file.isDirectory()) {
                            final List<File> list = new ArrayList<File>();
                            listFiles(list, file);
                            for (File child : list) {
                                addTab(child);
                            }
                            return;
                        }
                        addTab(file);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DropTargetAction.class.getName()).log(Level.WARNING, "Error dragging & dropping files.", ex);
                }
            }
        });
    }

    private void listFiles(List<File> list, File file) {
        if (file.isDirectory()) {
            final File[] files = file.listFiles();
            if (files != null) {
                final List<File> listedFiles = Arrays.asList(files);
                for (File value : listedFiles) {
                    if (value.isDirectory()) {
                        listFiles(list, value);
                    } else {
                        list.add(value);
                    }
                }
            }
        } else {
            list.add(file);
        }
    }

    public static void apply(Component component) {
        new DropTargetAction(component);
    }

}
