package com.frame;

import com.configuration.Constants;
import com.frame.action.impl.DropTargetAction;
import com.frame.action.impl.FileSelectionAction;
import com.resource.Resource;

import javax.swing.*;
import java.awt.*;

/**
 * @author Daniel
 */
public class UI extends JFrame {

    private final JTabbedPane tabPane = new JTabbedPane();

    private UI() {
        initialize();
    }

    private void initialize() {
        final JPanel panel = new JPanel();
        final JButton selectFiles = new JButton();
        final JTextField copyFiles = new JTextField();
        final JPanel tabPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Utility");
        setIconImages(Resource.ICONS_LIST);
        setPreferredSize(Constants.MINIMUM_DIMENSION);
        setMinimumSize(Constants.MINIMUM_DIMENSION);

        selectFiles.setIcon(new ImageIcon(Resource.SEARCH_FILE));

        copyFiles.setEditable(false);
        copyFiles.setFont(new Font("Dialog", Font.BOLD, 12));
        copyFiles.setHorizontalAlignment(JTextField.CENTER);
        copyFiles.setText("Drag and Drop Files Here");
        copyFiles.setBorder(BorderFactory.createLineBorder(new Color(0x0), 2));
        DropTargetAction.apply(copyFiles);

        tabPane.setFont(new Font("Dialog", Font.BOLD, 12));
        tabPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

        GroupLayout tabPanelLayout = new GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(tabPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabPane));
        tabPanelLayout.setVerticalGroup(tabPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabPane));

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLayout.createSequentialGroup().addContainerGap().addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelLayout.createSequentialGroup().addComponent(selectFiles).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(copyFiles))).addContainerGap()));
        panelLayout.setVerticalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelLayout.createSequentialGroup().addContainerGap().addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(selectFiles, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(copyFiles)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(tabPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        FileSelectionAction.apply(selectFiles);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    public static UI getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void focus() {
        setVisible(true);
        toFront();
        requestFocus();
    }

    public JTabbedPane getTabPane() {
        return tabPane;
    }

    private static class InstanceHolder {
        private static final UI INSTANCE = new UI();
    }

}

