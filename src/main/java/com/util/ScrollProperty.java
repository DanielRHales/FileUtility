package com.util;

import javax.swing.*;

/**
 * @author Daniel
 */
public class ScrollProperty {

    @SuppressWarnings("SameParameterValue")
    public static void setScrollProperty(final JScrollPane scrollPane, final int vertical, final int horizontal) {
        scrollPane.getVerticalScrollBar().setUnitIncrement(vertical);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(horizontal);
        scrollPane.getViewport().putClientProperty("EnableWindowBlit", Boolean.TRUE);
        scrollPane.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
    }

}
