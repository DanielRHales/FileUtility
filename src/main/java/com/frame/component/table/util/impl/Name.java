package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Name extends FileObject<String> {

    public Name(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.FILE_NAME;
    }

    @Override
    protected String value() {
        return table.getFile().getName();
    }
}
