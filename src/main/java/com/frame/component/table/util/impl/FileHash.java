package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.util.StreamHash;

/**
 * @author Daniel
 */
public abstract class FileHash extends FileObject<String> {

    protected final byte[] bytes;

    protected FileHash(FileTable table, byte[] bytes) {
        super(table);
        this.bytes = bytes;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected String value() {
        return table.getFile().isDirectory() ? null : StreamHash.getStreamHash(bytes, getAlgorithm());
    }

    protected String getAlgorithm() {
        return "";
    }

}
