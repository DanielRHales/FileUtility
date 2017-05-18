package com.frame.component.table.util.impl.hash;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.Type;
import com.frame.component.table.util.impl.FileHash;

/**
 * @author Daniel
 */
public class CRC32 extends FileHash {

    public CRC32(FileTable table, byte[] bytes) {
        super(table, bytes);
    }

    @Override
    protected Type type() {
        return Type.CRC32;
    }

    @Override
    protected String value() {
        if (bytes != null) {
            final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
            crc.update(bytes);
            return Long.toHexString(crc.getValue());
        } else {
            return null;
        }
    }
}
