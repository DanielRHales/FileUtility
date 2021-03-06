package com.resource;

import com.Main;
import com.frame.component.tab.TabIconHandler;
import com.graphics.SpriteLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * @author Daniel
 */
public class Resource {

    public static final SpriteLoader FRAME_ICON_LOADER = getLoader("/Frame/");

    public static final SpriteLoader TAB_ICON_LOADER = getLoader("/Tab/");

    @SuppressWarnings({"unused", "SameParameterValue", "WeakerAccess"})
    public static Image getResourceImage(String name, String extension, Dimension dimension) {
        return getResourceImage(String.format("%s_%dx%d", name, dimension.width, dimension.height), extension);
    }

    @SuppressWarnings("WeakerAccess")
    public static Image getResourceImage(String name, String extension) {
        return getResourceImage(String.format("%s.%s", name, extension));
    }

    @SuppressWarnings("WeakerAccess")
    public static Image getResourceImage(String name) {
        try {
            return ImageIO.read(Resource.class.getResource(String.format("/%s", name)));
        } catch (Exception ex) {
            return null;
        }
    }

    @SuppressWarnings("unused")
    public static Image getResizedImage(Image image, int width, int height) {
        BufferedImage value = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = value.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(image, 0, 0, width, height, null);
        graphics.dispose();
        return value;
    }

    @SuppressWarnings("unused")
    public static Image getResizedImage(Image image, int width, int height, int originalWidth, int originalHeight, float alpha) {
        final BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = resized.createGraphics();
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        graphics.drawImage(image, 0, 0, originalWidth, originalHeight, null);
        graphics.dispose();
        return resized;
    }

    @SuppressWarnings("unused")
    public static Image getFilteredImage(Image image, final Color color) {
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), new RGBImageFilter() {
            public final int filterRGB(int x, int y, int rgb) {
                return ((rgb | 0xFF000000) != (color.getRGB() | 0xFF000000)) ? rgb : 0x00FFFFFF & rgb;
            }
        }));
    }

    @SuppressWarnings("unused")
    public static Image getTransparentImage(BufferedImage image, float transparency) {
        BufferedImage transparentImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D) transparentImage.getGraphics();
        graphics.setComposite(AlphaComposite.SrcOver.derive(transparency));
        graphics.drawImage(image, 0, 0, null);
        return transparentImage;
    }

    private static SpriteLoader getLoader(String directory) {
        try {
            return new SpriteLoader(new DataInputStream(new GZIPInputStream(Main.class.getResourceAsStream(String.format("%sSprites.idx", directory)))), new DataInputStream(new GZIPInputStream(Main.class.getResourceAsStream(String.format("%sSprites.dat", directory)))));
        } catch (IOException ex) {
            Logger.getLogger(TabIconHandler.class.getName()).log(Level.WARNING, "Error loading Tab Icons Archive.", ex);
            return null;
        }
    }
}
