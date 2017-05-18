package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class HashCode extends FileObject<Integer> {

    public HashCode(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.HASH_CODE;
    }

    @Override
    protected Integer value() {
        return table.getFile().hashCode();
    }
}
