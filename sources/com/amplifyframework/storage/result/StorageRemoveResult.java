package com.amplifyframework.storage.result;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageRemoveResult {
    private final String key;

    private StorageRemoveResult(String str) {
        this.key = str;
    }

    public static StorageRemoveResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageRemoveResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StorageRemoveResult.class != obj.getClass()) {
            return false;
        }
        return c.a(this.key, ((StorageRemoveResult) obj).key);
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
