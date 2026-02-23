package com.amazonaws.services.s3.internal.crypto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class MultipartUploadContext {
    private final String bucketName;
    private boolean hasFinalPartBeenSeen;
    private final String key;
    private Map materialsDescription;

    public MultipartUploadContext(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final String getKey() {
        return this.key;
    }

    public final Map getMaterialsDescription() {
        return this.materialsDescription;
    }

    public final boolean hasFinalPartBeenSeen() {
        return this.hasFinalPartBeenSeen;
    }

    public final void setHasFinalPartBeenSeen(boolean z) {
        this.hasFinalPartBeenSeen = z;
    }

    public final void setMaterialsDescription(Map map) {
        this.materialsDescription = map == null ? null : Collections.unmodifiableMap(new HashMap(map));
    }
}
