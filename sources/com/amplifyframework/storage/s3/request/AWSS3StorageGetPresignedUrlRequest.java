package com.amplifyframework.storage.s3.request;

import com.amplifyframework.storage.StorageAccessLevel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageGetPresignedUrlRequest {
    private final StorageAccessLevel accessLevel;
    private final int expires;
    private final String key;
    private final String targetIdentityId;

    public AWSS3StorageGetPresignedUrlRequest(String str, StorageAccessLevel storageAccessLevel, String str2, int i) {
        this.key = str;
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str2;
        this.expires = i;
    }

    public StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public int getExpires() {
        return this.expires;
    }

    public String getKey() {
        return this.key;
    }

    public String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
