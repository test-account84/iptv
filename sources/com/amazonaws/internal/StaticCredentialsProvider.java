package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StaticCredentialsProvider implements AWSCredentialsProvider {
    private final AWSCredentials credentials;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }

    public AWSCredentials getCredentials() {
        return this.credentials;
    }

    public void refresh() {
    }
}
