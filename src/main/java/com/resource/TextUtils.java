package com.resource;

import java.io.File;

public class TextUtils {

    public static String titleCase(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        if (source == null || source.isEmpty()) {
            return "";
        }
        int args = source.split(" ").length;
        for (String target : source.split(" ")) {
            if (target == null || target.isEmpty()) {
                continue;
            }
            stringBuilder.append(Character.toUpperCase(target.charAt(0)));
            stringBuilder.append(target.substring(1).toLowerCase());
            if (args > 1) {
                stringBuilder.append(" ");
            }
            args--;
        }
        String tag = stringBuilder.toString();
        return tag.substring(0, 1).toUpperCase() + tag.substring(1);
    }

    public static String getExtension(File file) {
        if (file != null) {
            final String path = file.getAbsolutePath();
            try {
                return path.substring(path.lastIndexOf('.') + 1).toLowerCase();
            } catch (Exception ex) {
                return "_blank";
            }
        } else {
            return "_blank";
        }
    }

}
