package com.frame.component.table.util;

import com.frame.component.table.FileTable;
import com.util.ArrayExtension;

/**
 * @author Daniel
 */
public abstract class FileObject<T> implements ArrayExtension<T> {

    protected final FileTable table;

    protected FileObject(FileTable table) {
        this.table = table;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] array() {
        return (T[]) new Object[]{type(), value()};
    }

    protected abstract Type type();

    protected abstract T value();
}
