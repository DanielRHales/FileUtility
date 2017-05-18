package com.resource;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {

    private FileOperations() {
    }

    public static byte[] readFile(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bytes = new byte[(int)file.length()];
            randomAccessFile.readFully(bytes);
            randomAccessFile.close();
            return bytes;
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.WARNING, String.format("Error reading file '%s'.", file.getAbsolutePath()), ex);
            return new byte[]{};
        }
    }

}