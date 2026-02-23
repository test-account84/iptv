package com.amazonaws.auth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BasicSessionCredentials implements AWSSessionCredentials {
    private final String awsAccessKey;
    private final String awsSecretKey;
    private final String sessionToken;

    public BasicSessionCredentials(String str, String str2, String str3) {
        this.awsAccessKey = str;
        this.awsSecretKey = str2;
        this.sessionToken = str3;
    }

    public String getAWSAccessKeyId() {
        return this.awsAccessKey;
    }

    public String getAWSSecretKey() {
        return this.awsSecretKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }
}
