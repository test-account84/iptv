package com.amplifyframework.storage.s3.request;

import com.amplifyframework.storage.StorageAccessLevel;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageDownloadFileRequest {
    private final StorageAccessLevel accessLevel;
    private final String key;
    private final File local;
    private final String targetIdentityId;

    public AWSS3StorageDownloadFileRequest(String str, File file, StorageAccessLevel storageAccessLevel, String str2) {
        this.key = str;
        this.local = file;
        this.accessLevel = storageAccessLevel;
        this.targetIdentityId = str2;
    }

    public StorageAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public String getKey() {
        return this.key;
    }

    public File getLocal() {
        return this.local;
    }

    public String getTargetIdentityId() {
        return this.targetIdentityId;
    }
}
