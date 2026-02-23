package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {
    protected AWSCredentials awsCredentials;

    public void setCredentials(AWSCredentials aWSCredentials) {
        this.awsCredentials = aWSCredentials;
    }
}
