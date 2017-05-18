package com.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
@SuppressWarnings("all")
public class Sprite {

    private String name;

    private byte[] bytes;

    private Image image;
    private ImageIcon icon;

    public Sprite() {
    }

    public String getName() {
        return name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public Image getImage() {
        return image;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Sprite setName(String name) {
        this.name = name;
        return this;
    }

    public Sprite setBytes(byte[] bytes) {
        this.bytes = bytes;
        try {
            this.image = ImageIO.read(new ByteArrayInputStream(this.bytes));
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.WARNING, "Error creating Sprite Image.", ex);
        }
        this.icon = new ImageIcon(image);
        return this;
    }

}
