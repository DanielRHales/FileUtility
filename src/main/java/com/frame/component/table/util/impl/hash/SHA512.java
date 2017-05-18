package com.frame.component.table.util.impl.hash;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.Type;
import com.frame.component.table.util.impl.FileHash;

/**
 * @author Daniel
 */
public class SHA512 extends FileHash {

    public SHA512(FileTable table, byte[] bytes) {
        super(table, bytes);
    }

    @Override
    protected Type type() {
        return Type.SHA512;
    }

    @Override
    protected String getAlgorithm() {
        return "SHA-512";
    }
}
