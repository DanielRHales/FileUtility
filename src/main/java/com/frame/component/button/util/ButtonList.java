package com.frame.component.button.util;

import com.frame.component.button.ControlButton;
import com.frame.component.button.impl.*;
import com.frame.component.table.FileTable;
import com.util.ListExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 */
public class ButtonList implements ListExtension<ControlButton> {

    private final FileTable table;

    public ButtonList(FileTable table) {
        this.table = table;
    }

    @Override
    public List<ControlButton> list() {
        return new ArrayList<ControlButton>(
                Arrays.asList(
                        new OpenDesktopFile(table),
                        new OpenURIFile(table),
                        new DumpInformation(table),
                        new PrintFile(table),
                        new EditFile(table),
                        new DeleteFile(table)
                )
        );
    }
}
