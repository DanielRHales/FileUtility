package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Directory extends FileObject<Boolean> {

    public Directory(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.DIRECTORY;
    }

    @Override
    protected Boolean value() {
        return table.getFile().isDirectory();
    }
}
