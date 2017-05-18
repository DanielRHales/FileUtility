package com.frame.component.table.util.impl;

import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

/**
 * @author Daniel
 */
public class CategoryObject extends FileObject<String> {

    private final String name;

    public CategoryObject(String name) {
        super(null);
        this.name = name;
    }

    @Override
    protected Type type() {
        return Type.CATEGORY;
    }

    @Override
    protected String value() {
        return name;
    }
}
