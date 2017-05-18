package com.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public final class StreamHash {

    public static String getStreamHash(byte[] bytes, String algorithm) {
        return getStreamHash(new ByteArrayInputStream(bytes), algorithm);
    }

    private static String getStreamHash(InputStream stream, String algorithm) {
        if (stream == null) {
            return null;
        }
        try {
            return checkStream(stream, algorithm);
        } catch (IOException ex) {
            Logger.getLogger(StreamHash.class.getName()).log(Level.WARNING, "Error getting stream", ex);
        }
        return null;
    }

    private static String checkStream(final InputStream stream, String algorithm) throws IOException {
        final byte[] bytes = getBytes(stream, algorithm);
        StringBuilder result = new StringBuilder();
        for (byte array : bytes) {
            result.append(Integer.toString((array & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    private static byte[] getBytes(final InputStream stream, String algorithm) throws IOException {
        final MessageDigest digest = getDigest(algorithm);
        if (digest != null) {
            int value;
            final byte[] buffer = new byte[128];
            while ((value = stream.read(buffer)) != -1 && value > 0) {
                digest.update(buffer, 0, value);
            }
            stream.close();
            return digest.digest();
        }
        return new byte[]{};
    }

    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(StreamHash.class.getName()).log(Level.WARNING, String.format("Error getting Digest Algorithm -> %s", algorithm), ex);
            return null;
        }
    }
}
