package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Hidden extends FileObject<Boolean> {

    public Hidden(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.HIDDEN;
    }

    @Override
    protected Boolean value() {
        return table.getFile().isHidden();
    }
}
