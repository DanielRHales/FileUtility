package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class Path extends FileObject<String> {

    public Path(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.FILE_PATH;
    }

    @Override
    protected String value() {
        return table.getFile().getParentFile().getAbsolutePath();
    }
}
