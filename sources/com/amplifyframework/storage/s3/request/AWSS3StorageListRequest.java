package com.amplifyframework.storage.s3.request;

import com.amplifyframework.storage.StorageAccessLevel;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageListRequest {
    private final StorageAccessLevel accessLevel;
    private final String path;
    private final String targetIdentityId;

    public AWSS3StorageListRequest(String str, StorageAccessLevel storageAccessLevel, String str2) {
        this.path = str;
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str2;
    }

    public StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public String getPath() {
        return this.path;
    }

    public String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
