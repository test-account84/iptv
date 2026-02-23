package com.amplifyframework.storage.result;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StorageUploadResult {
    private final String key;

    public StorageUploadResult(String str) {
        this.key = str;
    }

    public static StorageUploadResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.key, ((StorageUploadResult) obj).key);
    }

    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.key;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
