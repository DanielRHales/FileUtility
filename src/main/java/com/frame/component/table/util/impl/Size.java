package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Size extends FileObject<String> {

    public Size(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.FILE_SIZE;
    }

    @Override
    protected String value() {
        return String.format("%,d Bytes", table.getFile().length());
    }
}
