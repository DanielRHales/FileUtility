package com.frame.action;

import com.configuration.Constants;
import com.frame.UI;
import com.frame.component.panel.FilePanel;
import com.frame.component.tab.FileTab;
import com.frame.component.table.FileTable;

import javax.swing.*;
import java.io.File;

/**
 * @author Daniel
 */
public class UIAction {

    protected File[] getFiles() {
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(String.format("%s%s", System.getenv("SystemDrive"), System.getProperty("file.separator"))));
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        return chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFiles() : null;
    }

    protected void addTab(File file) {
        final FileTable table = new FileTable(file);
        UI.getInstance().getTabPane().addTab("", new FilePanel(table));
        UI.getInstance().getTabPane().setTabComponentAt(UI.getInstance().getTabPane().getTabCount() - 1, new FileTab(file));
        UI.getInstance().getTabPane().setSelectedIndex(UI.getInstance().getTabPane().getTabCount() - 1);
        UI.getInstance().setPreferredSize(Constants.RESIZED_DIMENSION);
        UI.getInstance().setMinimumSize(Constants.RESIZED_DIMENSION);
        UI.getInstance().getTabPane().revalidate();
        UI.getInstance().getTabPane().repaint();
        UI.getInstance().validate();
        UI.getInstance().pack();
        UI.getInstance().setLocationRelativeTo(null);
    }

    protected void removeTab(FileTab tab) {
        final int index = UI.getInstance().getTabPane().indexOfTabComponent(tab);
        UI.getInstance().getTabPane().removeTabAt(index);
        if (UI.getInstance().getTabPane().getTabCount() >= 1) {
            UI.getInstance().getTabPane().setSelectedIndex(UI.getInstance().getTabPane().getTabCount() - 1);
        }
        if (UI.getInstance().getTabPane().getTabCount() == 0) {
            UI.getInstance().setPreferredSize(Constants.MINIMUM_DIMENSION);
            UI.getInstance().setMinimumSize(Constants.MINIMUM_DIMENSION);
        }
        UI.getInstance().getTabPane().revalidate();
        UI.getInstance().getTabPane().repaint();
        UI.getInstance().validate();
        UI.getInstance().pack();
        UI.getInstance().setLocationRelativeTo(null);
    }

}
