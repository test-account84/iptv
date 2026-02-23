package com.amazonaws.auth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BasicAWSCredentials implements AWSCredentials {
    private final String accessKey;
    private final String secretKey;

    public BasicAWSCredentials(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        this.accessKey = str;
        this.secretKey = str2;
    }

    public String getAWSAccessKeyId() {
        return this.accessKey;
    }

    public String getAWSSecretKey() {
        return this.secretKey;
    }
}
