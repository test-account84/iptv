package com.amplifyframework.storage.s3;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum ServerSideEncryption {
    MANAGED_KEYS("AES256"),
    KMS_KEYS("aws:kms"),
    NONE("");

    private final String name;

    ServerSideEncryption(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
