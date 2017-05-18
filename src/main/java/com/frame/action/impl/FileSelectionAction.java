package com.frame.action.impl;

import com.frame.action.UIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Daniel
 */
public class FileSelectionAction extends UIAction implements ActionListener {

    private FileSelectionAction(AbstractButton button) {
        button.addActionListener(this);
    }

    public static void apply(AbstractButton button) {
        new FileSelectionAction(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        final File[] files = getFiles();
        if (files != null) {
            final List<File> list = Arrays.asList(files);
            Collections.sort(list, new Comparator<File>() {
                @Override
                public int compare(File a, File b) {
                    return a.getName().compareTo(b.getName());
                }
            });
            for (File file : list) {
                if (file != null) {
                    addTab(file);
                }
            }
        }
    }
}
