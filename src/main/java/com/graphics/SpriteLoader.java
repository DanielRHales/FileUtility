package com.graphics;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class SpriteLoader {

    private final Map<String, Sprite> spriteMap = new HashMap<String, Sprite>();

    private final DataInputStream index;
    private final DataInputStream data;

    public SpriteLoader(DataInputStream index, DataInputStream data) {
        if (index == null || data == null) {
            throw new RuntimeException(String.format("One or more Stream is null -> %b : %b", index != null, data != null));
        }
        this.index = index;
        this.data = data;
        try {
            load();
        } catch (IOException ex) {
            Logger.getLogger(SpriteLoader.class.getName()).log(Level.WARNING, "Error loading Sprite Map.", ex);
        }
    }

    public Sprite get(String name) {
        return spriteMap.get(name);
    }

    private void load() throws IOException {
        int total = index.readInt();
        for (int value = 0; value < total; value++) {
            final Sprite sprite = new Sprite();
            readValues(sprite, data, index);
            spriteMap.put(sprite.getName(), sprite);
        }
    }

    private void readValues(Sprite sprite, DataInputStream dataStream, DataInputStream indexStream) throws IOException {
        do {
            int opCode = dataStream.readByte();
            if (opCode == 0) {
                return;
            }
            else if (opCode == 1) {
                sprite.setName(dataStream.readUTF());
            } else if (opCode == 2) {
                byte[] bytes = new byte[indexStream.readInt()];
                dataStream.readFully(bytes);
                sprite.setBytes(bytes);
            }
        } while (true);
    }

}
