package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Readable extends FileObject<Boolean> {

    public Readable(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.READABLE;
    }

    @Override
    protected Boolean value() {
        return table.getFile().canRead();
    }

}
