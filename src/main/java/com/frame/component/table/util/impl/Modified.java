package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

import java.text.SimpleDateFormat;

/**
 * @author Daniel
 */
public class Modified extends FileObject<String> {

    public Modified(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.LAST_MODIFIED;
    }

    @Override
    protected String value() {
        return new SimpleDateFormat("d/MM/y h:m:s a zzzz").format(table.getFile().lastModified());
    }
}
