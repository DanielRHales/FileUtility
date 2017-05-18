package com.frame.component.table.util.impl.hash;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.Type;
import com.frame.component.table.util.impl.FileHash;

/**
 * @author Daniel
 */
public class SHA384 extends FileHash {

    public SHA384(FileTable table, byte[] bytes) {
        super(table, bytes);
    }

    @Override
    protected Type type() {
        return Type.SHA384;
    }

    @Override
    protected String getAlgorithm() {
        return "SHA-384";
    }
}
