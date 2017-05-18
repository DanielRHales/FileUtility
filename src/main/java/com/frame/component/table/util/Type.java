package com.frame.component.table.util;

import com.resource.TextUtils;

/**
 * @author Daniel
 */
public enum Type {
    CRC32,
    MD2,
    MD5,
    SHA1,
    SHA224,
    SHA256,
    SHA384,
    SHA512,
    FILE_NAME,
    FILE_PATH,
    DIRECTORY,
    FILE_SIZE,
    LAST_MODIFIED,
    READABLE,
    WRITABLE,
    EXECUTABLE,
    HIDDEN,
    FILE_URI,
    FILE_URL,
    HASH_CODE,
    CATEGORY;

    @Override
    public String toString() {
        return TextUtils.titleCase(super.toString().replace("_", " "));
    }
}
