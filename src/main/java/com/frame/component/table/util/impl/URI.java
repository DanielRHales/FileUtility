package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class URI extends FileObject<java.net.URI> {

    public URI(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.FILE_URI;
    }

    @Override
    protected java.net.URI value() {
        return table.getFile().toURI();
    }
}
