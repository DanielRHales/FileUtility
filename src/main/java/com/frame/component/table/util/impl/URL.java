package com.frame.component.table.util.impl;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.Type;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class URL extends FileObject<java.net.URL> {
    public URL(FileTable table) {
        super(table);
    }

    @Override
    protected Type type() {
        return Type.FILE_URL;
    }

    @Override
    protected java.net.URL value() {
        try {
            return table.getFile().toURI().toURL();
        } catch (MalformedURLException ex) {
            Logger.getLogger(URL.class.getName()).log(Level.WARNING, "Error converting URI to URL", ex);
            return null;
        }
    }
}
