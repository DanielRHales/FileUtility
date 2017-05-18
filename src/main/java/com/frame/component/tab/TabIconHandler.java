package com.frame.component.tab;

import com.configuration.Constants;
import com.graphics.Sprite;
import com.resource.TextUtils;

import javax.swing.*;
import java.io.File;

/**
 * @author Daniel
 */
public class TabIconHandler {

    private TabIconHandler() {
    }

    static ImageIcon get(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                return getTabIcon("directory");
            }
            return getTabIcon(TextUtils.getExtension(file));
        } else {
            return getTabIcon("_blank");
        }
    }

    private static ImageIcon getTabIcon(String name) {
        if (Constants.TAB_ICON_LOADER != null) {
            final Sprite sprite = Constants.TAB_ICON_LOADER.get(name);
            if (sprite != null) {
                return sprite.getIcon();
            } else {
                return Constants.TAB_ICON_LOADER.get("_blank").getIcon();
            }
        } else {
            return null;
        }
    }

}
