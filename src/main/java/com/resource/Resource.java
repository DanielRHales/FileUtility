package com.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daniel
 */
public class Resource {

    public static final Image FILE = getResourceImage("File", "png", new Dimension(16, 16));

    public static final Image CLOSE = getResourceImage("Close", "png", new Dimension(16, 16));

    public static final Image DELETE_FILE = getResourceImage("DeleteFile", "png", new Dimension(16, 16));

    public static final Image DUMP_INFORMATION = getResourceImage("DumpInformation", "png", new Dimension(16, 16));

    public static final Image EDIT_FILE = getResourceImage("EditFile", "png", new Dimension(16, 16));

    public static final Image OPEN_DESKTOP_FILE = getResourceImage("OpenDesktopFile", "png", new Dimension(16, 16));

    public static final Image OPEN_BROWSER_FILE = getResourceImage("OpenBrowserFile", "png", new Dimension(16, 16));

    public static final Image PRINT_FILE = getResourceImage("PrintFile", "png", new Dimension(16, 16));

    public static final Image SEARCH_FILE = getResourceImage("SearchFile", "png", new Dimension(16, 16));

    public static ArrayList<Image> ICONS_LIST = new ArrayList<Image>(Arrays.asList(getResourceImage("Icon", "png", new Dimension(16, 16)), getResourceImage("Icon", "png", new Dimension(32, 32))));

    @SuppressWarnings({"SameParameterValue", "WeakerAccess"})
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
}
