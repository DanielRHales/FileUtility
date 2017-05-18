package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Executable extends FileObject<Boolean> {

    public Executable(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.EXECUTABLE;
    }

    @Override
    protected Boolean value() {
        return table.getFile().canExecute();
    }
}
