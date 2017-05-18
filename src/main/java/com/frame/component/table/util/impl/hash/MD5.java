package com.frame.component.table.util.impl.hash;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.Type;
import com.frame.component.table.util.impl.FileHash;

/**
 * @author Daniel
 */
public class MD5 extends FileHash {

    public MD5(FileTable table, byte[] bytes) {
        super(table, bytes);
    }

    @Override
    protected Type type() {
        return Type.MD5;
    }

    @Override
    protected String getAlgorithm() {
        return "MD5";
    }
}
