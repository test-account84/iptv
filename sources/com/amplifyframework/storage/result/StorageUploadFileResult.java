package com.amplifyframework.storage.result;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageUploadFileResult extends StorageUploadResult {
    private StorageUploadFileResult(String str) {
        super(str);
    }

    public static StorageUploadFileResult fromKey(String str) {
        Objects.requireNonNull(str);
        return new StorageUploadFileResult(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StorageUploadFileResult.class != obj.getClass()) {
            return false;
        }
        return c.a(super.getKey(), ((StorageUploadFileResult) obj).getKey());
    }

    public int hashCode() {
        return super.hashCode();
    }
}
