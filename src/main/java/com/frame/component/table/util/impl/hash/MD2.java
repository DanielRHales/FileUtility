package com.frame.component.table.util.impl.hash;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.Type;
import com.frame.component.table.util.impl.FileHash;

/**
 * @author Daniel
 */
public class MD2 extends FileHash {

    public MD2(FileTable table, byte[] bytes) {
        super(table, bytes);
    }

    @Override
    protected Type type() {
        return Type.MD2;
    }

    @Override
    protected String getAlgorithm() {
        return "MD2";
    }
}
