package com.frame.component.table.util.impl;

import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class NullObject extends FileObject<Object> {

    public NullObject() {
        super(null);
    }

    @Override
    protected Type type() {
        return null;
    }

    @Override
    protected Object value() {
        return null;
    }
}
