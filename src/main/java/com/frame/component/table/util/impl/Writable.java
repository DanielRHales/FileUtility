package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Writable extends FileObject<Boolean> {
    public Writable(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.WRITABLE;
    }

    @Override
    protected Boolean value() {
        return table.getFile().canWrite();
    }
}
