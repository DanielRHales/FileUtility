package com.frame.component.table.data;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.util.Array2DExtension;

import java.util.List;

/**
 * @author Daniel
 */
public class TableArray implements Array2DExtension<Object> {

    private final List<? extends FileObject> list;

    public TableArray(FileTable table) {
        list = new TableList(table).list();
    }

    @Override
    public Object[][] array() {
        return construct();
    }

    private Object[][] construct() {
        final Object[][] array = new Object[list.size()][2];
        int index = 0;
        for (FileObject object : list) {
            array[index++] = object.array();
        }
        return array;
    }
}
