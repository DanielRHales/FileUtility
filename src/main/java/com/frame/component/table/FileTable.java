package com.frame.component.table;

import com.frame.component.table.data.TableArray;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

/**
 * @author Daniel
 */
public class FileTable extends JTable {

    private final File file;
    private final Object[][] array;

    public FileTable(File file) {
        this.file = file;
        this.array = new TableArray(this).array();
        initialize();
    }

    private void initialize() {
        setFont(new Font("Dialog", Font.BOLD, 12));
        setModel(new DefaultTableModel(array, new String[]{"Property", "Data"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return new boolean[]{false, false}[column];
            }
        });
        getTableHeader().setReorderingAllowed(false);
    }

    public File getFile() {
        return file;
    }

    public Object[][] getArray() {
        return array;
    }

}
