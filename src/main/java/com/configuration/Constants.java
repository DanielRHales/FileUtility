package com.configuration;

import com.Main;
import com.frame.component.tab.TabIconHandler;
import com.graphics.SpriteLoader;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * @author Daniel
 */
public class Constants {

    public static final Dimension MINIMUM_DIMENSION = new Dimension(205, 85);
    public static final Dimension RESIZED_DIMENSION = new Dimension(515, 430);

    public static final SpriteLoader TAB_ICON_LOADER = getTabIconLoader();

    private static SpriteLoader getTabIconLoader() {
        try {
            return new SpriteLoader(new DataInputStream(new GZIPInputStream(Main.class.getResourceAsStream("/Icons/Sprites.idx"))), new DataInputStream(new GZIPInputStream(Main.class.getResourceAsStream("/Icons/Sprites.dat"))));
        } catch (IOException ex) {
            Logger.getLogger(TabIconHandler.class.getName()).log(Level.WARNING, "Error loading Tab Icons Archive.", ex);
            return null;
        }
    }
}
