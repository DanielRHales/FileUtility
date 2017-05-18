package com.frame.component.tab;

import com.graphics.Sprite;
import com.resource.Resource;
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
        if (Resource.TAB_ICON_LOADER != null) {
            final Sprite sprite = Resource.TAB_ICON_LOADER.get(name);
            if (sprite != null) {
                return sprite.getIcon();
            } else {
                return Resource.TAB_ICON_LOADER.get("_blank").getIcon();
            }
        } else {
            return null;
        }
    }

}
