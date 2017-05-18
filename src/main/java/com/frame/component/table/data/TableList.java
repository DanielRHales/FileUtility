package com.frame.component.table.data;

import com.frame.component.table.FileTable;
import com.frame.component.table.util.FileObject;
import com.frame.component.table.util.impl.*;
import com.frame.component.table.util.impl.Readable;
import com.frame.component.table.util.impl.hash.*;
import com.resource.FileOperations;
import com.util.ListExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 */
public class TableList implements ListExtension<FileObject> {
    
    private final FileTable table;
    private final byte[] bytes;

    TableList(FileTable table) {
        this.table = table;
        this.bytes = FileOperations.readFile(table.getFile());
    }

    @Override
    public List<FileObject> list() {
        return new ArrayList<FileObject>(
                Arrays.asList(
                        new CategoryObject("File Hashes"),
                        new NullObject(),
                        new CRC32(table, bytes),
                        new MD2(table, bytes),
                        new MD5(table, bytes),
                        new SHA1(table, bytes),
                        new SHA224(table, bytes),
                        new SHA256(table, bytes),
                        new SHA384(table, bytes),
                        new SHA512(table, bytes),
                        new NullObject(),
                        new CategoryObject("File Information"),
                        new NullObject(),
                        new Name(table),
                        new Path(table),
                        new Size(table),
                        new Modified(table),
                        new Directory(table),
                        new Readable(table),
                        new Writable(table),
                        new Executable(table),
                        new Hidden(table),
                        new URI(table),
                        new URL(table),
                        new HashCode(table)
                )
        );
    }
}
