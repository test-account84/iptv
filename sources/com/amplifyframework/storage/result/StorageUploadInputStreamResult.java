package com.amplifyframework.storage.result;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageUploadInputStreamResult extends StorageUploadResult {
    private StorageUploadInputStreamResult(String str) {
        super(str);
    }

    public static StorageUploadInputStreamResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadInputStreamResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StorageUploadInputStreamResult.class != obj.getClass()) {
            return false;
        }
        return c.a(super.getKey(), ((StorageUploadInputStreamResult) obj).getKey());
    }

    public int hashCode() {
        return super.hashCode();
    }
}
